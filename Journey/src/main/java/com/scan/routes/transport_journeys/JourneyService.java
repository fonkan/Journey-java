package com.scan.routes.transport_journeys;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JourneyService {
    private final JourneyRepository journeyRepository;

    @Autowired
    public JourneyService(JourneyRepository journeyRepository) {
        this.journeyRepository = journeyRepository;
    }

    public void addJourneys() {

        deleteJourneys();

        ObjectMapper objectMapper = new ObjectMapper();

        try {

            InputStream stream = new URL(
                    "https://api.sl.se/api2/LineData.json?model=JourneyPattern&key=6bbed515228f4bbb85160762a5d80ce5")
                    .openStream();

            JsonNode jsonString = objectMapper.readTree(stream).get("ResponseData").get("Result");

            Integer dataCount = 0;
            if (!jsonString.isEmpty()) {
                List journeys = new ArrayList();
                Journey journey;

                String StringData;
                Integer IntData;

                for (JsonNode routes : jsonString) {
                    journey = new Journey();

                    dataCount++;

                    IntData = routes.get("LineNumber").asInt();
                    if (IntData != 0)
                        journey.setLineNumber(IntData);

                    IntData = routes.get("DirectionCode").asInt();
                    if (IntData != 0)
                        journey.setDirectionCode(IntData);

                    IntData = routes.get("JourneyPatternPointNumber").asInt();
                    if (IntData != 0)
                        journey.setJourneyPatternPointNumber(IntData);

                    StringData = routes.get("LastModifiedUtcDateTime").asText();
                    if (StringData != null)
                        journey.setLastModifiedUtcDateTime(StringData);

                    StringData = routes.get("ExistsFromDate").asText();
                    if (StringData != null)
                        journey.setExistsFromDate(StringData);

                    journeys.add(journey);

                }
                journeyRepository.saveAll(journeys);
                System.out.println(dataCount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addNewJourney(Journey Journey) {
        Optional<Journey> JourneyById = journeyRepository.findById(Journey.getId());
        if (JourneyById.isPresent()) {
            throw new IllegalStateException("id taken");
        }
        journeyRepository.save(Journey);
    }

    public void deleteJourney(Long JourneyId) {
        // JourneyRepository.findById(JourneyId);
        boolean exists = journeyRepository.existsById(JourneyId);
        if (!exists) {
            throw new IllegalStateException(JourneyId + " Does not exist");
        }
        journeyRepository.deleteById(JourneyId);
    }

    public void deleteJourneys() {

        journeyRepository.deleteAll();
    }

    public void updateJourney(Long JourneyId,
            Integer journeyPatternPointNumber) {
        Journey Journey = journeyRepository.findById(JourneyId)
                .orElseThrow(() -> new IllegalStateException(JourneyId + " Does not exist"));

        if (journeyPatternPointNumber != null) {

            Journey.setJourneyPatternPointNumber(journeyPatternPointNumber);
        }
    }
}

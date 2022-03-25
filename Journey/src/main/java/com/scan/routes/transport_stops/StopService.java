package com.scan.routes.transport_stops;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StopService {
    private final StopRepository StopRepository;

    @Autowired
    public StopService(StopRepository StopRepository) {
        this.StopRepository = StopRepository;
    }

    public void addNewStop(Stop Stop) {
        Optional<Stop> StopById = StopRepository.findById(Stop.getId());
        if (StopById.isPresent()) {
            throw new IllegalStateException("id taken");
        }
        StopRepository.save(Stop);
    }

    public void addStops() {

        deleteStops();

        ObjectMapper objectMapper = new ObjectMapper();

        try {

            InputStream stream = new URL(
                    "https://api.sl.se/api2/LineData.json?model=StopPoint&key=6bbed515228f4bbb85160762a5d80ce5")
                    .openStream();

            JsonNode jsonString = objectMapper.readTree(stream).get("ResponseData").get("Result");

            Integer dataCount = 0;
            if (!jsonString.isEmpty()) {
                List stops = new ArrayList();
                Stop stop;

                String StringData;
                byte[] byteData;
                Integer IntData;

                for (JsonNode routes : jsonString) {
                    stop = new Stop();

                    dataCount++;

                    IntData = routes.get("StopPointNumber").asInt();
                    if (IntData != 0)
                        stop.setStopPointNumber(IntData);

                    IntData = routes.get("StopAreaNumber").asInt();
                    if (IntData != 0)
                        stop.setStopAreaNumber(IntData);

                    byteData = routes.get("StopPointName").asText().getBytes(StandardCharsets.UTF_8);
                    stop.setStopPointName(new String(byteData, StandardCharsets.UTF_8));

                    StringData = routes.get("StopAreaTypeCode").asText();
                    if (StringData != null)
                        stop.setStopAreaTypeCode(StringData);

                    StringData = routes.get("ZoneShortName").asText();
                    if (StringData != null)
                        stop.setZoneShortName(StringData);

                    StringData = routes.get("LocationNorthingCoordinate").asText();
                    if (StringData != null)
                        stop.setLocationNorthingCoordinate(StringData);

                    StringData = routes.get("LocationEastingCoordinate").asText();
                    if (StringData != null)
                        stop.setLocationEastingCoordinate(StringData);

                    StringData = routes.get("LastModifiedUtcDateTime").asText();
                    if (StringData != null)
                        stop.setLastModifiedUtcDateTime(StringData);

                    StringData = routes.get("ExistsFromDate").asText();
                    if (StringData != null)
                        stop.setExistsFromDate(StringData);

                    stops.add(stop);

                }

                StopRepository.saveAll(stops);

                System.out.println(dataCount);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStop(Long StopId) {
        boolean exists = StopRepository.existsById(StopId);
        if (!exists) {
            throw new IllegalStateException(StopId + " Does not exist");
        }
        StopRepository.deleteById(StopId);
    }

    public void deleteStops() {

        StopRepository.deleteAll();
    }

    public void updateStop(Long StopId,
            String stopPointName) {
        Stop Stop = StopRepository.findById(StopId)
                .orElseThrow(() -> new IllegalStateException(StopId + " Does not exist"));

        if (stopPointName != null) {

            Stop.setStopPointName(stopPointName);
        }
    }
}

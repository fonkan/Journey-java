package com.scan.routes.transport_area_name;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class AreaService {
    private final AreaRepository areaRepository;

    @Autowired
    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public void addAreas() {

        deleteAreas();

        ObjectMapper objectMapper = new ObjectMapper();

        try {

            InputStream stream = new URL(
                    "https://api.sl.se/api2/LineData.json?model=Site&key=6bbed515228f4bbb85160762a5d80ce5")
                    .openStream();

            JsonNode jsonString = objectMapper.readTree(stream).get("ResponseData").get("Result");

            Integer dataCount = 0;
            if (!jsonString.isEmpty()) {
                List areas = new ArrayList();
                Area area;

                String StringData;
                byte[] byteData;
                Integer IntData;

                for (JsonNode routes : jsonString) {
                    area = new Area();

                    dataCount++;

                    IntData = routes.get("SiteId").asInt();
                    if (IntData != 0)
                        area.setSiteId(IntData);

                    IntData = routes.get("StopAreaNumber").asInt();
                    if (IntData != 0)
                        area.setStopAreaNumber(IntData);

                    StringData = routes.get("SiteName").asText();
                    if (StringData != null)
                        area.setSiteName(StringData);

                    StringData = routes.get("LastModifiedUtcDateTime").asText();
                    if (StringData != null)
                        area.setLastModifiedUtcDateTime(StringData);

                    StringData = routes.get("ExistsFromDate").asText();
                    if (StringData != null)
                        area.setExistsFromDate(StringData);

                    areas.add(area);

                }
                areaRepository.saveAll(areas);
                System.out.println(dataCount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteArea(Long AreaId) {
        boolean exists = areaRepository.existsById(AreaId);
        if (!exists) {
            throw new IllegalStateException(AreaId + " Does not exist");
        }
        areaRepository.deleteById(AreaId);
    }

    public void deleteAreas() {

        areaRepository.deleteAll();
    }
}

package com.scan.routes.transport_vehicles;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.io.File;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    public static String explode(Collection list, String delimiter) {

        StringBuffer buffer = new StringBuffer("");
        Iterator itr = list.iterator();

        while (itr.hasNext()) {
            buffer.append(itr.next());
            if (itr.hasNext()) {
                buffer.append(delimiter == null ? "," : delimiter);
            }
        }
        return buffer.toString();
    }

    public void addNewVehicle(Vehicle vehicle) {
        Optional<Vehicle> vehicleById = vehicleRepository.findById(vehicle.getId());
        if (vehicleById.isPresent()) {
            throw new IllegalStateException("id taken");
        }
        vehicleRepository.save(vehicle);
    }

    public void addVehicles() {

        deleteVehicles();

        ObjectMapper objectMapper = new ObjectMapper();

        try {

            File stream = new File(
                    "/home/FT/PROJECTS/Journey/src/main/java/com/scan/routes/shared/test_fetch/Line.json");

            JsonNode jsonString = objectMapper.readTree(stream).get("ResponseData").get("Result");

            Integer dataCount = 0;

            if (!jsonString.isEmpty()) {
                List vehicles = new ArrayList();
                Vehicle vehicle;
                String StringData;
                byte[] byteData;
                Integer IntData;
                Locale like = new Locale("sv", "SE");
                for (JsonNode routes : jsonString) {
                    vehicle = new Vehicle();
                    StringData = routes.get("DefaultTransportModeCode").asText();

                    if (StringData.toLowerCase().contains("bus")) {
                        dataCount++;

                        vehicle.setDefaultTransportModeCode(StringData);

                        IntData = routes.get("LineNumber").asInt();
                        if (IntData != 0)
                            vehicle.setLineNumber(IntData);

                        IntData = routes.get("LineDesignation").asInt();
                        if (IntData != 0)
                            vehicle.setLineDesignation(IntData);

                        vehicle.setInsertDate(LocalDateTime.now());

                        StringData = routes.get("DefaultTransportMode").asText();
                        if (StringData != null)
                            vehicle.setDefaultTransportMode(StringData);

                        StringData = routes.get("LastModifiedUtcDateTime").asText();
                        if (StringData != null)
                            vehicle.setLastModifiedUtcDateTime(StringData);

                        StringData = routes.get("ExistsFromDate").asText();
                        if (StringData != null)
                            vehicle.setExistsFromDate(StringData);

                        vehicles.add(vehicle);
                    }
                }
                vehicleRepository.saveAll(vehicles);
                System.out.println(dataCount);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteVehicle(Long vehicleId) {
        boolean exists = vehicleRepository.existsById(vehicleId);
        if (!exists) {
            throw new IllegalStateException(vehicleId + " Does not exist");
        }
        vehicleRepository.deleteById(vehicleId);
    }

    public void deleteVehicles() {

        vehicleRepository.deleteAll();
    }

    @Transactional
    public void updateVehicle(Long vehicleId,
            String defaultTransportMode,
            String defaultTransportModeCode) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new IllegalStateException(vehicleId + " Does not exist"));

        if (defaultTransportMode != null &&
                defaultTransportMode.length() > 0 &&
                !Objects.equals(vehicle.getDefaultTransportMode(), defaultTransportMode)) {

            vehicle.setDefaultTransportMode(defaultTransportMode);
        }

        if (defaultTransportModeCode != null &&
                defaultTransportModeCode.length() > 0 &&
                !Objects.equals(vehicle.getDefaultTransportModeCode(), defaultTransportModeCode)) {

            vehicle.setDefaultTransportModeCode(defaultTransportModeCode);
        }
    }
}

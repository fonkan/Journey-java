package com.scan.routes.transport_vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/handle/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    @CrossOrigin
    public List<Vehicle> getVehicles() {
        return vehicleService.getVehicles();
    }

    @GetMapping(path = "/refresh")
    public void addNewVehicles() {
        vehicleService.addVehicles();
    }

    @PostMapping
    public void registerNewVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.addNewVehicle(vehicle);
    }

    @DeleteMapping(path = "{vehicleId}")
    public void deleteVehicle(@PathVariable("vehicleId") Long vehicleId) {
        vehicleService.deleteVehicle(vehicleId);
    }

    @DeleteMapping(path = "/all")
    public void deleteVehicles() {
        vehicleService.deleteVehicles();
    }

    @PutMapping(path = "{vehicleId}")
    public void updateVehicle(
            @PathVariable("vehicleId") Long vehicleId,
            @RequestParam(required = false) String defaultTransportMode,
            @RequestParam(required = false) String defaultTransportModeCode) {
        vehicleService.updateVehicle(vehicleId, defaultTransportMode, defaultTransportModeCode);
    }
}

package com.scan.routes.transport_stops;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/handle/stop")
public class StopController {

    private final StopService StopService;

    @Autowired
    public StopController(StopService StopService) {
        this.StopService = StopService;
    }

    @GetMapping(path = "/refresh")
    public void addStops() {
        StopService.addStops();
    }

    @PostMapping
    public void registerNewStop(@RequestBody Stop Stop) {
        StopService.addNewStop(Stop);
    }

    @DeleteMapping(path = "{StopId}")
    public void deleteStop(@PathVariable("StopId") Long StopId) {
        StopService.deleteStop(StopId);
    }

    @DeleteMapping(path = "/all")
    public void deleteStops() {
        StopService.deleteStops();
    }

    @PutMapping(path = "{StopId}")
    public void updateStop(
            @PathVariable("StopId") Long StopId,
            @RequestParam(required = false) String stopPointName) {
        StopService.updateStop(StopId, stopPointName);
    }
}
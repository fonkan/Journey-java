package com.scan.routes.transport_journeys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/handle/journey")
public class JourneyController {

    private final JourneyService JourneyService;

    @Autowired
    public JourneyController(JourneyService JourneyService) {
        this.JourneyService = JourneyService;
    }

    @GetMapping(path = "/refresh")
    public void registerJourneys() {
        JourneyService.addJourneys();
    }

    @PostMapping
    public void registerNewJourney(@RequestBody Journey Journey) {
        JourneyService.addNewJourney(Journey);
    }

    @DeleteMapping(path = "{JourneyId}")
    public void deleteJourney(@PathVariable("JourneyId") Long JourneyId) {
        JourneyService.deleteJourney(JourneyId);
    }

    @DeleteMapping(path = "/all")
    public void deleteJourneys() {
        JourneyService.deleteJourneys();
    }

    @PutMapping(path = "{JourneyId}")
    public void updateJourney(
            @PathVariable("JourneyId") Long JourneyId,
            @RequestParam(required = false) Integer journeyPatternPointNumber) {
        JourneyService.updateJourney(JourneyId, journeyPatternPointNumber);
    }
}
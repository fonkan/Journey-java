package com.scan.routes.bus_lines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/")
public class BusLineController {

    private final BusLineService BusLineService;

    @Autowired
    public BusLineController(BusLineService BusLineService) {
        this.BusLineService = BusLineService;
    }

    @CrossOrigin
    @GetMapping(path = "get/stops")
    public List getBusStops(@RequestParam("line_number") Integer lnNr) {

        return BusLineService.getBusStops(lnNr);
    }

    @CrossOrigin
    @GetMapping(path = "get/journeys")
    public List getBusLine() {
        return BusLineService.getBusLine();
    }

    @DeleteMapping(path = "journeys/delete")
    public void deleteBusLines() {
        BusLineService.deleteBusLines();
    }

}
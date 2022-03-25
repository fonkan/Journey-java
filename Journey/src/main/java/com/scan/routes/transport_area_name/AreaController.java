package com.scan.routes.transport_area_name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/handle/area")
public class AreaController {

    private final AreaService AreaService;

    @Autowired
    public AreaController(AreaService AreaService) {
        this.AreaService = AreaService;
    }

    @GetMapping(path = "/refresh")
    public void registerAreas() {
        AreaService.addAreas();
    }

    @DeleteMapping(path = "{AreaId}")
    public void deleteArea(@PathVariable("AreaId") Long AreaId) {
        AreaService.deleteArea(AreaId);
    }

    @DeleteMapping(path = "/all")
    public void deleteAreas() {
        AreaService.deleteAreas();
    }
}
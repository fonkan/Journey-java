package com.scan.routes.shared;

import com.scan.routes.bus_lines.BusLineService;
import com.scan.routes.transport_area_name.AreaService;
import com.scan.routes.transport_journeys.JourneyService;
import com.scan.routes.transport_stops.StopService;
import com.scan.routes.transport_vehicles.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ImportDataService implements CommandLineRunner {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private JourneyService journeyService;

    @Autowired
    private StopService stopService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private BusLineService busLineService;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Start importing data from API");
        vehicleService.addVehicles();
        journeyService.addJourneys();
        stopService.addStops();
        areaService.addAreas();
        System.out.println("Import finished...");
        // busLineService.insertBusLines();
    }

}
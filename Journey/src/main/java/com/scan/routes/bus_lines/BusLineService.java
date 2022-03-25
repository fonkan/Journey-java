package com.scan.routes.bus_lines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;

@Service
public class BusLineService {
    private final BusLineRepository busLineRepository;

    @Autowired
    public BusLineService(BusLineRepository busLineRepository) {

        this.busLineRepository = busLineRepository;
    }

    public List getBusStops(Integer lnNr) {

        return busLineRepository.findAllBusStops(lnNr);
    }

    public List getBusLine() {

        return busLineRepository.findAllBusRouts();
    }

    public void insertBusLines() {

        try {
            String myDriver = "org.h2.Driver";
            String myUrl = "jdbc:h2:mem:testdb";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "sa", "password");

            // TODO :: GONNA INSERT THR RESULTSET FROM SUBQUERY AT STARTUP IN THE busLine
            // TABLE SO WE DON'T NEED TO RUN IT IN THE REPOSITORY FROM FRONTEND.

            String query = " SELECT v.id, v.line_number, v.default_transport_mode, v.default_transport_mode_code ";
            // query += " ( SELECT COUNT(1) as in_c FROM journey as j1 ";
            // query += " LEFT JOIN stop as s1 ON J1.journey_pattern_point_number =
            // s1.stop_point_number ";
            // query += " WHERE j1.line_number = v.line_number ) as line_designation ";
            query += " FROM vehicle as v WHERE v.line_number > 0 ";
            // query += " ORDER BY line_designation DESC";
            query += " LIMIT 10 ";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                int line_number = rs.getInt("line_number");
                String default_transport_mode = rs.getString("default_transport_mode");
                String default_transport_mode_code = rs.getString("default_transport_mode_code");
                // Date exists_from_date = rs.getDate("exists_from_date");

                System.out.format("%s, %s, %s, %s\n", id, line_number,
                        default_transport_mode, default_transport_mode_code);
            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void deleteBusLines() {

        busLineRepository.deleteAll();
    }
}
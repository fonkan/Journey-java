package com.scan.routes.bus_lines;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusLineRepository extends JpaRepository<BusLine, Long> {
    @Query(value = "" +
            " SELECT v.line_number as lineNumber" +
            ", ( SELECT COUNT(DISTINCT(s1.stop_area_number)) as in_c " +
            " FROM journey as j1 " +
            "  LEFT JOIN stop as s1 " +
            "     ON J1.journey_pattern_point_number = s1.stop_point_number " +
            " WHERE j1.line_number = v.line_number ) as LineDesignation " +
            ", v.default_transport_mode as DefaultTransportMode " +
            "   FROM vehicle as v " +
            " WHERE v.line_number > 0 " +
            " ORDER BY LineDesignation DESC  " +
            " LIMIT 10 " +
            "", nativeQuery = true)
    List findAllBusRouts();

    @Query(value = "" +
            " SELECT v.line_number " +
            ", s.stop_point_name, a.site_name " +
            " FROM vehicle as v " +
            "  LEFT JOIN journey as j " +
            "     ON v.line_number = j.line_number " +
            "  LEFT JOIN stop as s " +
            "     ON J.journey_pattern_point_number = s.stop_point_number " +
            "  LEFT JOIN area as a " +
            "     ON s.stop_area_number = a.stop_area_number " +
            "  WHERE v.line_number = :lnNr order by stop_point_name " +
            "", nativeQuery = true)
    List findAllBusStops(@Param("lnNr") Integer lnNr);
}
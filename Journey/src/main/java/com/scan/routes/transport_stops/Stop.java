package com.scan.routes.transport_stops;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table
public class Stop {

    private @Id @GeneratedValue Long Id;
    @JsonProperty("lineNumber")
    private Integer StopPointNumber;
    private Integer StopAreaNumber;
    private String StopPointName;
    private String StopAreaTypeCode;
    private String ZoneShortName;
    private String LocationNorthingCoordinate;
    private String LocationEastingCoordinate;
    private String LastModifiedUtcDateTime;
    private String ExistsFromDate;

    public Stop() {
    }

    public Stop(Long id, Integer stopPointNumber, Integer stopAreaNumber, String stopPointName, String stopAreaTypeCode,
            String zoneShortName, String locationNorthingCoordinate, String locationEastingCoordinate,
            String lastModifiedUtcDateTime, String existsFromDate) {
        Id = id;
        StopPointNumber = stopPointNumber;
        StopAreaNumber = stopAreaNumber;
        StopPointName = stopPointName;
        StopAreaTypeCode = stopAreaTypeCode;
        ZoneShortName = zoneShortName;
        LocationNorthingCoordinate = locationNorthingCoordinate;
        LocationEastingCoordinate = locationEastingCoordinate;
        LastModifiedUtcDateTime = lastModifiedUtcDateTime;
        ExistsFromDate = existsFromDate;
    }

    public Stop(Integer stopPointNumber, Integer stopAreaNumber, String stopPointName, String stopAreaTypeCode,
            String zoneShortName, String locationNorthingCoordinate, String locationEastingCoordinate,
            String lastModifiedUtcDateTime, String existsFromDate) {
        StopPointNumber = stopPointNumber;
        StopAreaNumber = stopAreaNumber;
        StopPointName = stopPointName;
        StopAreaTypeCode = stopAreaTypeCode;
        ZoneShortName = zoneShortName;
        LocationNorthingCoordinate = locationNorthingCoordinate;
        LocationEastingCoordinate = locationEastingCoordinate;
        LastModifiedUtcDateTime = lastModifiedUtcDateTime;
        ExistsFromDate = existsFromDate;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getStopPointNumber() {
        return StopPointNumber;
    }

    public void setStopPointNumber(Integer stopPointNumber) {
        StopPointNumber = stopPointNumber;
    }

    public Integer getStopAreaNumber() {
        return StopAreaNumber;
    }

    public void setStopAreaNumber(Integer stopAreaNumber) {
        StopAreaNumber = stopAreaNumber;
    }

    public String getStopPointName() {
        return StopPointName;
    }

    public void setStopPointName(String stopPointName) {
        StopPointName = stopPointName;
    }

    public String getStopAreaTypeCode() {
        return StopAreaTypeCode;
    }

    public void setStopAreaTypeCode(String stopAreaTypeCode) {
        StopAreaTypeCode = stopAreaTypeCode;
    }

    public String getZoneShortName() {
        return ZoneShortName;
    }

    public void setZoneShortName(String zoneShortName) {
        ZoneShortName = zoneShortName;
    }

    public String getLocationNorthingCoordinate() {
        return LocationNorthingCoordinate;
    }

    public void setLocationNorthingCoordinate(String locationNorthingCoordinate) {
        LocationNorthingCoordinate = locationNorthingCoordinate;
    }

    public String getLocationEastingCoordinate() {
        return LocationEastingCoordinate;
    }

    public void setLocationEastingCoordinate(String locationEastingCoordinate) {
        LocationEastingCoordinate = locationEastingCoordinate;
    }

    public String getLastModifiedUtcDateTime() {
        return LastModifiedUtcDateTime;
    }

    public void setLastModifiedUtcDateTime(String lastModifiedUtcDateTime) {
        LastModifiedUtcDateTime = lastModifiedUtcDateTime;
    }

    public String getExistsFromDate() {
        return ExistsFromDate;
    }

    public void setExistsFromDate(String existsFromDate) {
        ExistsFromDate = existsFromDate;
    }

    @Override
    public String toString() {
        return "Stop{" +
                "Id=" + Id +
                ", StopPointNumber=" + StopPointNumber +
                ", StopAreaNumber=" + StopAreaNumber +
                ", StopPointName='" + StopPointName + '\'' +
                ", StopAreaTypeCode='" + StopAreaTypeCode + '\'' +
                ", ZoneShortName='" + ZoneShortName + '\'' +
                ", LocationNorthingCoordinate='" + LocationNorthingCoordinate + '\'' +
                ", LocationEastingCoordinate='" + LocationEastingCoordinate + '\'' +
                ", LastModifiedUtcDateTime='" + LastModifiedUtcDateTime + '\'' +
                ", ExistsFromDate='" + ExistsFromDate + '\'' +
                '}';
    }
}
package com.scan.routes.bus_lines;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

@Entity
@Table
public class BusLine {

    private @Id @GeneratedValue Long Id;
    private LocalDateTime InsertDate;
    @JsonProperty("lineNumber")
    private Integer LineNumber;
    private Integer LineDesignation;
    private String DefaultTransportMode;
    private String DefaultTransportModeCode;
    private String LastModifiedUtcDateTime;
    private String ExistsFromDate;

    private Integer BusLinePatternPointNumber;

    public BusLine() {
    }

    public BusLine(Long id, LocalDateTime insertDate, Integer lineNumber, Integer lineDesignation,
            String defaultTransportMode, String defaultTransportModeCode, String lastModifiedUtcDateTime,
            String existsFromDate, Integer busLinePatternPointNumber) {
        Id = id;
        InsertDate = insertDate;
        LineNumber = lineNumber;
        LineDesignation = lineDesignation;
        DefaultTransportMode = defaultTransportMode;
        DefaultTransportModeCode = defaultTransportModeCode;
        LastModifiedUtcDateTime = lastModifiedUtcDateTime;
        ExistsFromDate = existsFromDate;
        BusLinePatternPointNumber = busLinePatternPointNumber;
    }

    public BusLine(LocalDateTime insertDate, Integer lineNumber, Integer lineDesignation, String defaultTransportMode,
            String defaultTransportModeCode, String lastModifiedUtcDateTime, String existsFromDate,
            Integer busLinePatternPointNumber) {
        InsertDate = insertDate;
        LineNumber = lineNumber;
        LineDesignation = lineDesignation;
        DefaultTransportMode = defaultTransportMode;
        DefaultTransportModeCode = defaultTransportModeCode;
        LastModifiedUtcDateTime = lastModifiedUtcDateTime;
        ExistsFromDate = existsFromDate;
        BusLinePatternPointNumber = busLinePatternPointNumber;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public LocalDateTime getInsertDate() {
        return InsertDate;
    }

    public void setInsertDate(LocalDateTime insertDate) {
        InsertDate = insertDate;
    }

    public Integer getLineNumber() {
        return LineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        LineNumber = lineNumber;
    }

    public Integer getLineDesignation() {
        return LineDesignation;
    }

    public void setLineDesignation(Integer lineDesignation) {
        LineDesignation = lineDesignation;
    }

    public String getDefaultTransportMode() {
        return DefaultTransportMode;
    }

    public void setDefaultTransportMode(String defaultTransportMode) {
        DefaultTransportMode = defaultTransportMode;
    }

    public String getDefaultTransportModeCode() {
        return DefaultTransportModeCode;
    }

    public void setDefaultTransportModeCode(String defaultTransportModeCode) {
        DefaultTransportModeCode = defaultTransportModeCode;
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

    public Integer getBusLinePatternPointNumber() {
        return BusLinePatternPointNumber;
    }

    public void setBusLinePatternPointNumber(Integer busLinePatternPointNumber) {
        BusLinePatternPointNumber = busLinePatternPointNumber;
    }

    @Override
    public String toString() {
        return "BusLine{" +
                "Id=" + Id +
                ", InsertDate=" + InsertDate +
                ", LineNumber=" + LineNumber +
                ", LineDesignation=" + LineDesignation +
                ", DefaultTransportMode='" + DefaultTransportMode + '\'' +
                ", DefaultTransportModeCode='" + DefaultTransportModeCode + '\'' +
                ", LastModifiedUtcDateTime='" + LastModifiedUtcDateTime + '\'' +
                ", ExistsFromDate='" + ExistsFromDate + '\'' +
                ", BusLinePatternPointNumber=" + BusLinePatternPointNumber +
                '}';
    }
}
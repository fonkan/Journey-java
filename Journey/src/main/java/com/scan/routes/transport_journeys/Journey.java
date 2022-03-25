package com.scan.routes.transport_journeys;

import javax.persistence.*;

@Entity
@Table
public class Journey {

    private @Id @GeneratedValue Long Id;
    private Integer LineNumber;
    private Integer DirectionCode;
    private Integer JourneyPatternPointNumber;
    private String LastModifiedUtcDateTime;
    private String ExistsFromDate;

    public Journey() {
    }

    public Journey(Long id, Integer lineNumber, Integer directionCode, Integer journeyPatternPointNumber,
            String lastModifiedUtcDateTime, String existsFromDate) {
        Id = id;
        LineNumber = lineNumber;
        DirectionCode = directionCode;
        JourneyPatternPointNumber = journeyPatternPointNumber;
        LastModifiedUtcDateTime = lastModifiedUtcDateTime;
        ExistsFromDate = existsFromDate;
    }

    public Journey(Integer lineNumber, Integer directionCode, Integer journeyPatternPointNumber,
            String lastModifiedUtcDateTime, String existsFromDate) {
        LineNumber = lineNumber;
        DirectionCode = directionCode;
        JourneyPatternPointNumber = journeyPatternPointNumber;
        LastModifiedUtcDateTime = lastModifiedUtcDateTime;
        ExistsFromDate = existsFromDate;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getLineNumber() {
        return LineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        LineNumber = lineNumber;
    }

    public Integer getDirectionCode() {
        return DirectionCode;
    }

    public void setDirectionCode(Integer directionCode) {
        DirectionCode = directionCode;
    }

    public Integer getJourneyPatternPointNumber() {
        return JourneyPatternPointNumber;
    }

    public void setJourneyPatternPointNumber(Integer journeyPatternPointNumber) {
        JourneyPatternPointNumber = journeyPatternPointNumber;
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
        return "Journey{" +
                "Id=" + Id +
                ", LineNumber=" + LineNumber +
                ", DirectionCode=" + DirectionCode +
                ", JourneyPatternPointNumber=" + JourneyPatternPointNumber +
                ", LastModifiedUtcDateTime='" + LastModifiedUtcDateTime + '\'' +
                ", ExistsFromDate='" + ExistsFromDate + '\'' +
                '}';
    }
}

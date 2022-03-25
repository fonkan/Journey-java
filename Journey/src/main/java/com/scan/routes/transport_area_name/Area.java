package com.scan.routes.transport_area_name;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Area {

    private @Id @GeneratedValue Long Id;
    @JsonProperty("StopAreaNumber")
    private Integer SiteId;
    private Integer StopAreaNumber;
    private String SiteName;
    private String LastModifiedUtcDateTime;
    private String ExistsFromDate;

    public Area() {
    }

    public Area(Long id, Integer siteId, Integer stopAreaNumber, String siteName, String lastModifiedUtcDateTime, String existsFromDate) {
        Id = id;
        SiteId = siteId;
        StopAreaNumber = stopAreaNumber;
        SiteName = siteName;
        LastModifiedUtcDateTime = lastModifiedUtcDateTime;
        ExistsFromDate = existsFromDate;
    }

    public Area(Integer siteId, Integer stopAreaNumber, String siteName, String lastModifiedUtcDateTime, String existsFromDate) {
        SiteId = siteId;
        StopAreaNumber = stopAreaNumber;
        SiteName = siteName;
        LastModifiedUtcDateTime = lastModifiedUtcDateTime;
        ExistsFromDate = existsFromDate;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getSiteId() {
        return SiteId;
    }

    public void setSiteId(Integer siteId) {
        SiteId = siteId;
    }

    public Integer getStopAreaNumber() {
        return StopAreaNumber;
    }

    public void setStopAreaNumber(Integer stopAreaNumber) {
        StopAreaNumber = stopAreaNumber;
    }

    public String getSiteName() {
        return SiteName;
    }

    public void setSiteName(String siteName) {
        SiteName = siteName;
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
        return "Area{" +
                "Id=" + Id +
                ", SiteId=" + SiteId +
                ", StopAreaNumber=" + StopAreaNumber +
                ", SiteName='" + SiteName + '\'' +
                ", LastModifiedUtcDateTime='" + LastModifiedUtcDateTime + '\'' +
                ", ExistsFromDate='" + ExistsFromDate + '\'' +
                '}';
    }
}
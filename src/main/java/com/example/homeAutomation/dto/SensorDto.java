package com.example.homeAutomation.dto;

import java.io.Serializable;
import java.util.Date;

public class SensorDto implements Serializable {

    private Long id;
    private String reference;
    private String value;
    private String description;
    private Long timestamp;
    private Long deviceId;

    public SensorDto(Long id, String reference, String value, String description, Long timestamp, Long deviceId) {
        this.id = id;
        this.reference = reference;
        this.value = value;
        this.description = description;
        this.timestamp = timestamp;
        this.deviceId = deviceId;
    }

    public SensorDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }
}

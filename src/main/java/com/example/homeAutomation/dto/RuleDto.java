package com.example.homeAutomation.dto;

import java.io.Serializable;

public class RuleDto implements Serializable {

    private Long id;
    private String name;
    private String description;
    private Long versionTimestamp;
    private Long userId;
    private Long sensorId;
    private Long actuatorId;

    public RuleDto(Long id, String name, String description, Long versionTimestamp, Long userId, Long sensorId, Long actuatorId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.versionTimestamp = versionTimestamp;
        this.userId = userId;
        this.sensorId = sensorId;
        this.actuatorId = actuatorId;
    }

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }

    public Long getActuatorId() {
        return actuatorId;
    }

    public void setActuatorId(Long actuatorId) {
        this.actuatorId = actuatorId;
    }

    public RuleDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getVersionTimestamp() {
        return versionTimestamp;
    }

    public void setVersionTimestamp(Long versionTimestamp) {
        this.versionTimestamp = versionTimestamp;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}



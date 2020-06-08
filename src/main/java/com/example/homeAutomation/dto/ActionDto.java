package com.example.homeAutomation.dto;

import java.io.Serializable;

public class ActionDto implements Serializable {

    private Long id;
    private String name;
    private String description;
    private String action;
    private Long actuatorId;
    private Long versionTimestamp;

    public ActionDto() {
    }

    public ActionDto(Long id, String name, String description, String action, Long actuatorId, Long versionTimestamp) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.action = action;
        this.actuatorId = actuatorId;
        this.versionTimestamp = versionTimestamp;
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getActuatorId() {
        return actuatorId;
    }

    public void setActuatorId(Long actuatorId) {
        this.actuatorId = actuatorId;
    }

    public Long getVersionTimestamp() {
        return versionTimestamp;
    }

    public void setVersionTimestamp(Long versionTimestamp) {
        this.versionTimestamp = versionTimestamp;
    }
}

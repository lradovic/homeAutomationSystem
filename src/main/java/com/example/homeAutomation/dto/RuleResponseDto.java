package com.example.homeAutomation.dto;

import com.example.homeAutomation.model.Actuator;
import com.example.homeAutomation.model.Sensor;
import com.example.homeAutomation.model.User;

import java.io.Serializable;

public class RuleResponseDto implements Serializable {

    private Long id;
    private String name;
    private String description;
    private Long versionTimestamp;
    private User user;
    private Actuator actuator;
    private Sensor sensor;

    public RuleResponseDto(Long id, String name, String description, Long versionTimestamp, User user, Actuator actuator, Sensor sensor) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.versionTimestamp = versionTimestamp;
        this.user = user;
        this.actuator = actuator;
        this.sensor = sensor;
    }

    public RuleResponseDto() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Actuator getActuator() {
        return actuator;
    }

    public void setActuator(Actuator actuator) {
        this.actuator = actuator;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}

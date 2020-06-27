package com.example.homeAutomation.dto;

import com.example.homeAutomation.model.Actuator;
import com.example.homeAutomation.model.Sensor;
import com.example.homeAutomation.model.User;

import java.io.Serializable;

public class RuleResponseDto implements Serializable {

    private Long id;
    private String name;
    private String description;
    private String value;
    private String ruleRelation;
    private String valueActuator;
    private Long versionTimestamp;
    private User user;
    private Actuator actuator;
    private Sensor sensor;

    public RuleResponseDto(Long id, String name, String description, String value, String ruleRelation, String valueActuator, Long versionTimestamp, User user, Actuator actuator, Sensor sensor) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
        this.ruleRelation = ruleRelation;
        this.valueActuator = valueActuator;
        this.versionTimestamp = versionTimestamp;
        this.user = user;
        this.actuator = actuator;
        this.sensor = sensor;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRuleRelation() {
        return ruleRelation;
    }

    public void setRuleRelation(String ruleRelation) {
        this.ruleRelation = ruleRelation;
    }

    public String getValueActuator() {
        return valueActuator;
    }

    public void setValueActuator(String valueActuator) {
        this.valueActuator = valueActuator;
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

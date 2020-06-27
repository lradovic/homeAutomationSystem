package com.example.homeAutomation.dto;

import java.io.Serializable;

public class RuleDto implements Serializable {

    private Long id;
    private String name;
    private String description;
    private String value;
    private String ruleRelation;
    private String valueActuator;
    private Long versionTimestamp;
    private Long userId;
    private Long sensorId;
    private Long actuatorId;

    public RuleDto(Long id, String name, String description, String value, String ruleRelation, String valueActuator, Long versionTimestamp, Long userId, Long sensorId, Long actuatorId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
        this.ruleRelation = ruleRelation;
        this.valueActuator = valueActuator;
        this.versionTimestamp = versionTimestamp;
        this.userId = userId;
        this.sensorId = sensorId;
        this.actuatorId = actuatorId;
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



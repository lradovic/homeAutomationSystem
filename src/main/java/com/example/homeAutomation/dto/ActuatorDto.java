package com.example.homeAutomation.dto;

import com.example.homeAutomation.model.Device;

import javax.persistence.ManyToOne;
import java.io.Serializable;

public class ActuatorDto implements Serializable {

    private Long id;
    private String reference;
    private String value;
    private String description;
    private Long deviceId;

    public ActuatorDto(Long id, String reference, String value, String description, Long deviceId) {
        this.id = id;
        this.reference = reference;
        this.value = value;
        this.description = description;
        this.deviceId = deviceId;
    }

    public ActuatorDto() {
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

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }
}

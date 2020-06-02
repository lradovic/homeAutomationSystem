package com.example.homeAutomation.dto;

import java.io.Serializable;

public class DeviceDto implements Serializable {

    private Long id;
    private String name;
    private String description;
    private Long versionTimestamp;
    private Long userId;

    public DeviceDto(Long id, String name, String description, Long versionTimestamp, Long userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.versionTimestamp = versionTimestamp;
        this.userId = userId;
    }

    public DeviceDto() {
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

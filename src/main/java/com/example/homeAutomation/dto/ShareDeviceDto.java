package com.example.homeAutomation.dto;

import java.io.Serializable;

public class ShareDeviceDto implements Serializable {
    private Long deviceId;
    private String userEmail;

    public ShareDeviceDto() {
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}

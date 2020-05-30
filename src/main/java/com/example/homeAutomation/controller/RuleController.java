package com.example.homeAutomation.controller;

import com.example.homeAutomation.model.Rule;
import com.example.homeAutomation.service.ActuatorService;
import com.example.homeAutomation.service.DeviceService;
import com.example.homeAutomation.service.RuleService;
import com.example.homeAutomation.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.management.OperatingSystemMXBean;
import java.util.Optional;

@Controller
@CrossOrigin
@RequestMapping("/rules")
public class RuleController {

    private final ActuatorService actuatorService;

    private final DeviceService deviceService;

    private final SensorService sensorService;

    private final RuleService ruleService;


    @Autowired
    public RuleController(ActuatorService actuatorService, DeviceService deviceService, SensorService sensorService, RuleService ruleService) {
        this.actuatorService = actuatorService;
        this.deviceService = deviceService;
        this.sensorService = sensorService;
        this.ruleService = ruleService;
    }

    public void proba()
    {

    }
}
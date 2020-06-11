package com.example.homeAutomation.controller;

import com.example.homeAutomation.dto.RuleDto;
import com.example.homeAutomation.dto.RuleResponseDto;
import com.example.homeAutomation.dto.SensorDto;
import com.example.homeAutomation.model.Rule;
import com.example.homeAutomation.model.Sensor;
import com.example.homeAutomation.service.ActuatorService;
import com.example.homeAutomation.service.DeviceService;
import com.example.homeAutomation.service.RuleService;
import com.example.homeAutomation.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/user/{id}")
    @ResponseBody
    public List<RuleResponseDto> getRulesByUserId(@PathVariable Long id) {
        return ruleService.getAllByUserId(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Rule> readAll() {
        return ruleService.readAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Rule read(@PathVariable("id") Long id) {
        return ruleService.read(id).orElseThrow(IllegalArgumentException::new);
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long create(RuleDto data) {
        return ruleService.create(data);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, RuleDto data) {
        ruleService.update(id,data);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {

        sensorService.delete(id);
    }
}
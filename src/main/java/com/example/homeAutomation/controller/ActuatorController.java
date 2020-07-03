package com.example.homeAutomation.controller;

import com.example.homeAutomation.dto.ActuatorDto;
import com.example.homeAutomation.model.Actuator;
import com.example.homeAutomation.model.Device;
import com.example.homeAutomation.service.ActuatorService;
import com.example.homeAutomation.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/actuators")
class ActuatorController {

    private final ActuatorService actuatorService;

    private final DeviceService deviceService;

    @Autowired
    public ActuatorController(ActuatorService actuatorService, DeviceService deviceService) {
        this.actuatorService = actuatorService;
        this.deviceService = deviceService;
    }

    @GetMapping(value = "/devices/{id}")
    @ResponseBody
    public List<Actuator> getActuatorsByDeviceId(@PathVariable Long id) {
        return actuatorService.getAllByDeviceId(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Actuator> readAll() {
        return actuatorService.readAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Actuator read(@PathVariable("id") Long id) {
        return actuatorService.read(id).orElseThrow(IllegalArgumentException::new);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long create( ActuatorDto data) {
        return actuatorService.create(data);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, ActuatorDto data) {
        actuatorService.update(id, data);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        actuatorService.delete(id);
    }

    @RequestMapping(value = "/shake/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Actuator generate(@PathVariable("id") Long id) {
        return actuatorService.shake(id);
    }
}

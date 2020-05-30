package com.example.homeAutomation.controller;

import com.example.homeAutomation.model.Actuator;
import com.example.homeAutomation.model.Device;
import com.example.homeAutomation.service.ActuatorService;
import com.example.homeAutomation.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/devices/{deviceId}/actuators")
class ActuatorController {

    private final ActuatorService actuatorService;

    private final DeviceService deviceService;

    @Autowired
    public ActuatorController(ActuatorService actuatorService, DeviceService deviceService) {
        this.actuatorService = actuatorService;
        this.deviceService = deviceService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Actuator> readAll(@PathVariable("deviceId") Long deviceId) {
        return actuatorService.readAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Actuator read(@PathVariable("deviceId") Long deviceId, @PathVariable("id") Long id) {
        return actuatorService.read(id).orElseThrow(IllegalArgumentException::new);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void create(@PathVariable("deviceId") Long deviceId, @RequestBody Actuator data) {
        final Device device = deviceService.read(deviceId).orElseThrow(IllegalArgumentException::new);

        actuatorService.create(data, device);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("deviceId") Long deviceId, @PathVariable( "id" ) Long id, @RequestBody Actuator data) {
        final Device device = deviceService.read(deviceId).orElseThrow(IllegalArgumentException::new);

        actuatorService.update(id, data);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("deviceId") Long deviceId, @PathVariable("id") Long id) {
        final Device device = deviceService.read(deviceId).orElseThrow(IllegalArgumentException::new);

        actuatorService.delete(id, device);
    }
}
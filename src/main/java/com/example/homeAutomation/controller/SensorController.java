package com.example.homeAutomation.controller;

import com.example.homeAutomation.model.Device;
import com.example.homeAutomation.model.Sensor;
import com.example.homeAutomation.service.DeviceService;
import com.example.homeAutomation.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/devices/{deviceId}/sensors")
class SensorController {

    @Autowired
    private SensorService sensorService;

    @Autowired
    private DeviceService deviceService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Sensor> readAll(@PathVariable("deviceId") Long deviceId) {
        return sensorService.readAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Sensor read(@PathVariable("deviceId") Long deviceId, @PathVariable("id") Long id) {
        return sensorService.read(id).orElseThrow(IllegalArgumentException::new);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void create(@PathVariable("deviceId") Long deviceId, @RequestBody Sensor data) {
        final Device device = deviceService.read(deviceId).orElseThrow(IllegalArgumentException::new);

        sensorService.create(data, device);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("deviceId") Long deviceId, @PathVariable( "id" ) Long id, @RequestBody Sensor data) {
        final Device device = deviceService.read(deviceId).orElseThrow(IllegalArgumentException::new);

        sensorService.update(id, data);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("deviceId") Long deviceId, @PathVariable("id") Long id) {
        final Device device = deviceService.read(deviceId).orElseThrow(IllegalArgumentException::new);

        sensorService.delete(id, device);
    }
}
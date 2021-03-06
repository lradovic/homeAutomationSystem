package com.example.homeAutomation.controller;

import com.example.homeAutomation.dto.SensorDto;
import com.example.homeAutomation.model.Actuator;
import com.example.homeAutomation.model.Device;
import com.example.homeAutomation.model.Sensor;
import com.example.homeAutomation.service.DeviceService;
import com.example.homeAutomation.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/sensors")
class SensorController {

    @Autowired
    private SensorService sensorService;

    @Autowired
    private DeviceService deviceService;

    @GetMapping(value = "/devices/{id}")
    @ResponseBody
    public List<Sensor> getSensorsByDeviceId(@PathVariable Long id) {
        return sensorService.getAllByDeviceId(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Sensor> readAll() {
        return sensorService.readAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Sensor read(@PathVariable("id") Long id) {
        return sensorService.read(id).orElseThrow(IllegalArgumentException::new);
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long create(SensorDto data) {
        return sensorService.create(data);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, SensorDto data) {
        sensorService.update(id,data);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {

        sensorService.delete(id);
    }

    @RequestMapping(value = "/generate",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void generate() {
        sensorService.generateData();
    }
}

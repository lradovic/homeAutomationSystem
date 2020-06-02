package com.example.homeAutomation.controller;

import com.example.homeAutomation.dto.DeviceDto;
import com.example.homeAutomation.model.Device;
import com.example.homeAutomation.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/devices")
class DeviceController {

    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Device> readAll() {
        return deviceService.readAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Device read(@PathVariable("id") long id) {
        return deviceService.read(id).orElseThrow(IllegalArgumentException::new);
    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void create(DeviceDto data) {
        deviceService.create(data);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Long id, @RequestBody Device data) {
        deviceService.update(id, data);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        deviceService.delete(id);
    }

    @RequestMapping(value = "/{id}/sync", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void sync(@PathVariable("id") Long id) {
    }

}

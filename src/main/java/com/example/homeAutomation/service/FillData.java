package com.example.homeAutomation.service;

import com.example.homeAutomation.model.Actuator;
import com.example.homeAutomation.model.Device;
import com.example.homeAutomation.model.Sensor;
import com.example.homeAutomation.model.User;
import com.example.homeAutomation.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FillData {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    ActuatorRepository actuatorRepository;

    @Autowired
    SensorRepository sensorRepository;

    @Autowired
    RuleRepository ruleRepository;

    @Autowired
    ActionRepository actionRepository;

    public void init() {
        if(userRepository.findAll().isEmpty()) {
            User user = new User();
            user.setFirstName("Rix");
            user.setLastName("Ziks");
            user.setEmail("a@a");
            user.setPassword("test");
            user.setVersionTimestamp(System.currentTimeMillis());
            userRepository.saveAndFlush(user);
        }


        if(actuatorRepository.findAll().isEmpty()) {
            Actuator actuator = new Actuator();
            actuator.setReference("Act 1");
            actuator.setDescription("Opis aktuatora 1");
            actuator.setValue("5564");
            actuator.setVersionTimestamp(System.currentTimeMillis());
            actuatorRepository.saveAndFlush(actuator);
        }

        if(sensorRepository.findAll().isEmpty()) {
            Sensor sensor = new Sensor();
            sensor.setReference("Sensor 1");
            sensor.setDescription("Opis senzora 1");
            sensor.setValue("65C");
            sensor.setVersionTimestamp(System.currentTimeMillis());
            sensorRepository.saveAndFlush(sensor);
        }

        if(deviceRepository.findAll().isEmpty()) {

            User user = userRepository.findByEmail("a@a");
            Sensor sensor = sensorRepository.findByReference("Sensor 1");
            Actuator actuator = actuatorRepository.findByReference("Act 1");

            Device device = new Device();
            device.setName("Roletna x5");
            device.setDescription("Opis 1");

            device.getSensors().add(sensor);
            sensor.setDevice(device);
            device.getActuators().add(actuator);
            actuator.setDevice(device);
            device.getUsers().add(user);
            user.getDevices().add(device);

            device.setVersionTimestamp(System.currentTimeMillis());
            deviceRepository.saveAndFlush(device);
        }

    }
}

package com.example.homeAutomation.service;

import com.example.homeAutomation.model.*;
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

            User user1 = new User();
            user1.setFirstName("Kk");
            user1.setLastName("jklsdfjklfsd");
            user1.setEmail("b@b");
            user1.setPassword("test");
            user1.setVersionTimestamp(System.currentTimeMillis());
            userRepository.saveAndFlush(user1);
        }

        if(actionRepository.findAll().isEmpty()) {
            Action action = new Action();
            action.setName("Action eins");
            action.setAction("OFF");
            action.setVersionTimestamp(System.currentTimeMillis());
            action.setDescription("Blabla");
            actionRepository.saveAndFlush(action);
        }


        if(actuatorRepository.findAll().isEmpty()) {
            Action action = actionRepository.findById(1L).get();
            Actuator actuator = new Actuator();
            actuator.setReference("Act 1");
            actuator.setDescription("Opis aktuatora 1");
            actuator.setValue("OFF");
            actuator.setVersionTimestamp(System.currentTimeMillis());
            actuator.getActions().add(action);
            action.setActuator(actuator);
            actuatorRepository.saveAndFlush(actuator);
        }



        if(sensorRepository.findAll().isEmpty()) {
            Sensor sensor = new Sensor();
            sensor.setReference("Sensor 1");
            sensor.setDescription("Opis senzora 1");
            sensor.setValue("65");
            sensor.setTimestamp(System.currentTimeMillis());
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
            device.setVersionTimestamp(1592532270580L);
            deviceRepository.saveAndFlush(device);

            Device device1 = new Device();
            device1.setName("Radijator x5");
            device1.setDescription("Opis 44");
            device1.getUsers().add(user);
            user.getDevices().add(device1);

            device1.setVersionTimestamp(1592432270580L);
            deviceRepository.saveAndFlush(device1);
        }

    }
}

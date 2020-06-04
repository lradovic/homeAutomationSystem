package com.example.homeAutomation.service;

import com.example.homeAutomation.dto.ActuatorDto;
import com.example.homeAutomation.model.Actuator;
import com.example.homeAutomation.model.Device;
import com.example.homeAutomation.model.User;
import com.example.homeAutomation.repository.ActuatorRepository;
import com.example.homeAutomation.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActuatorService {

    private final ActuatorRepository actuatorRepository;
    private final DeviceRepository deviceRepository;


    @Autowired
    public ActuatorService(ActuatorRepository actuatorRepository, DeviceRepository deviceRepository) {
        this.actuatorRepository = actuatorRepository;
        this.deviceRepository = deviceRepository;
    }

    public List<Actuator> readAll() {
        return actuatorRepository.findAll();
    }

    public Optional<Actuator> read(long id) {
        return actuatorRepository.findById(id);
    }

    public void create(ActuatorDto data) {
        Actuator actuator = new Actuator();

        actuator.setReference(data.getReference());
        actuator.setDescription(data.getDescription());
        Device device = deviceRepository.findById(data.getDeviceId()).get();

        actuator.setDevice(device);
        actuator.setValue(data.getValue());

        actuatorRepository.save(actuator);
    }

    public void update(long id, ActuatorDto data) {
        final Actuator actuator = actuatorRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        actuator.setReference(data.getReference());
        actuator.setDescription(data.getDescription());

        Device device = deviceRepository.findById(data.getDeviceId()).get();

        actuator.setDevice(device);


        actuator.setValue(data.getValue());

        actuatorRepository.save(actuator);
    }

    public void delete(long id) {
        final Actuator actuator = actuatorRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        actuatorRepository.delete(actuator);
    }
}

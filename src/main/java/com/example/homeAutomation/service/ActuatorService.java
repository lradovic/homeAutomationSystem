package com.example.homeAutomation.service;

import com.example.homeAutomation.model.Actuator;
import com.example.homeAutomation.model.Device;
import com.example.homeAutomation.repository.ActuatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActuatorService {

    private final ActuatorRepository actuatorRepository;

    @Autowired
    public ActuatorService(ActuatorRepository actuatorRepository) {
        this.actuatorRepository = actuatorRepository;
    }

    public List<Actuator> readAll() {
        return actuatorRepository.findAll();
    }

    public Optional<Actuator> read(long id) {
        return actuatorRepository.findById(id);
    }

    public void create(Actuator data, Device device) {
        data.setDevice(device);

        actuatorRepository.save(data);
    }

    public void update(long id, Actuator data) {
        final Actuator actuator = actuatorRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        actuator.setReference(data.getReference());
        actuator.setDescription(data.getDescription());
        actuator.setDevice(data.getDevice());


        actuator.setValue(data.getValue());

        actuatorRepository.save(actuator);
    }

    public void delete(long id, Device device) {
        final Actuator actuator = actuatorRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        actuatorRepository.delete(actuator);
    }
}

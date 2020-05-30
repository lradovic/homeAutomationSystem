package com.example.homeAutomation.service;

import com.example.homeAutomation.model.Device;
import com.example.homeAutomation.model.Sensor;
import com.example.homeAutomation.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorService {

    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public List<Sensor> readAll() {
        return sensorRepository.findAll();
    }

    public Optional<Sensor> read(long id) {
        return sensorRepository.findById(id);
    }

    public void create(Sensor data, Device device) {
        data.setDevice(device);

        sensorRepository.save(data);
    }

    public void update(long id, Sensor data) {
        final Sensor sensor = sensorRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        sensor.setDescription(data.getDescription());
        sensor.setDevice(data.getDevice());
        sensor.setReference(data.getReference());
        sensor.setTimestamp(data.getTimestamp());
        sensor.setValue(data.getValue());

        sensorRepository.save(sensor);
    }

    public void delete(long id, Device device) {
        final Sensor sensor = sensorRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        sensorRepository.delete(sensor);
    }
}

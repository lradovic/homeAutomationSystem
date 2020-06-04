package com.example.homeAutomation.service;

import com.example.homeAutomation.dto.SensorDto;
import com.example.homeAutomation.model.Device;
import com.example.homeAutomation.model.Sensor;
import com.example.homeAutomation.repository.DeviceRepository;
import com.example.homeAutomation.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SensorService {

    private final SensorRepository sensorRepository;
    private final DeviceRepository deviceRepository;


    @Autowired
    public SensorService(SensorRepository sensorRepository, DeviceRepository deviceRepository) {
        this.sensorRepository = sensorRepository;
        this.deviceRepository = deviceRepository;
    }

    public List<Sensor> readAll() {
        return sensorRepository.findAll();
    }

    public Optional<Sensor> read(long id) {
        return sensorRepository.findById(id);
    }

    public void create(SensorDto data) {

        Sensor sensor = new Sensor();

        sensor.setDescription(data.getDescription());
        Device device = deviceRepository.findById(data.getDeviceId()).get();
        sensor.setDevice(device);
        sensor.setReference(data.getReference());
        Date d =  new Date(data.getTimestamp());
        sensor.setTimestamp(d);
        sensor.setValue(data.getValue());


        sensorRepository.save(sensor);
    }

    public void update(long id, SensorDto data) {
        final Sensor sensor = sensorRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        sensor.setDescription(data.getDescription());
        Device device = deviceRepository.findById(data.getDeviceId()).get();
        sensor.setDevice(device);
        sensor.setReference(data.getReference());
        Date d =  new Date(data.getTimestamp());
        sensor.setTimestamp(d);
        sensor.setValue(data.getValue());

        sensorRepository.save(sensor);
    }

    public void delete(long id) {
        final Sensor sensor = sensorRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        sensorRepository.delete(sensor);
    }
}

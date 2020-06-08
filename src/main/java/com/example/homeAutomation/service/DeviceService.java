package com.example.homeAutomation.service;

import com.example.homeAutomation.dto.DeviceDto;
import com.example.homeAutomation.model.Device;
import com.example.homeAutomation.model.User;
import com.example.homeAutomation.repository.ActuatorRepository;
import com.example.homeAutomation.repository.DeviceRepository;
import com.example.homeAutomation.repository.SensorRepository;
import com.example.homeAutomation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    private final SensorRepository sensorRepository;

    //private final SensorDataRepository sensorDataRepository;

    private final ActuatorRepository actuatorRepository;

    private final UserRepository userRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository,
                         SensorRepository sensorRepository,
                         ActuatorRepository actuatorRepository, UserRepository userRepository) {
        this.deviceRepository = deviceRepository;
        this.sensorRepository = sensorRepository;
        this.actuatorRepository = actuatorRepository;
        this.userRepository = userRepository;
    }

    public List<Device> readAll() {
        return deviceRepository.findAll();
    }

    public List<Device> getAllByUserId(Long id) {
        User user = userRepository.findById(id).get();
        return user.getDevices();
    }

    public Optional<Device> read(long id) {
        return deviceRepository.findById(id);
    }

    public Long create(DeviceDto data) {

        Device device = new Device();
        device.setId(data.getId());
        device.setName(data.getName());
        device.setDescription(data.getDescription());
        device.setVersionTimestamp(data.getVersionTimestamp());

        User user = userRepository.findById(data.getUserId()).get();
        user.getDevices().add(device);
        device.getUsers().add(user);

        return deviceRepository.saveAndFlush(device).getId();
    }

    public void update(long id, DeviceDto data) {
        final Device device = deviceRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        device.setName(data.getName());
        device.setDescription(data.getDescription());
        device.setVersionTimestamp(data.getVersionTimestamp());
        deviceRepository.saveAndFlush(device);
    }

    public void delete(long id) {
        final Device device = deviceRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        deviceRepository.delete(device);
    }

   /* private void generateSensorData(Sensor sensor) {
        final SensorData data = new SensorData();
        data.setDevice(sensor.getDevice());
        data.setSensor(sensor);
        data.setTimestamp(ZonedDateTime.now().withNano(0));
        data.setValue(String.valueOf(new Random().nextInt(100)));

        sensorDataRepository.save(data);
    }*/

}

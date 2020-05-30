package com.example.homeAutomation.service;

import com.example.homeAutomation.model.Device;
import com.example.homeAutomation.repository.ActuatorRepository;
import com.example.homeAutomation.repository.DeviceRepository;
import com.example.homeAutomation.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    private final SensorRepository sensorRepository;

    //private final SensorDataRepository sensorDataRepository;

    private final ActuatorRepository actuatorRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository,
                         SensorRepository sensorRepository,
                         ActuatorRepository actuatorRepository) {
        this.deviceRepository = deviceRepository;
        this.sensorRepository = sensorRepository;
        this.actuatorRepository = actuatorRepository;
    }

    public List<Device> readAll() {
        return deviceRepository.findAll();
    }

    public Optional<Device> read(long id) {
        return deviceRepository.findById(id);
    }

    public void create(Device data) {
        deviceRepository.save(data);
    }

    public void update(long id, Device data) {
        final Device device = deviceRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        device.setName(data.getName());

        deviceRepository.save(device);
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

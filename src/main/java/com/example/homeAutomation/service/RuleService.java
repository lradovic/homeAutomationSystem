package com.example.homeAutomation.service;

import com.example.homeAutomation.model.Device;
import com.example.homeAutomation.model.Rule;
import com.example.homeAutomation.repository.ActuatorRepository;
import com.example.homeAutomation.repository.DeviceRepository;
import com.example.homeAutomation.repository.RuleRepository;
import com.example.homeAutomation.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RuleService {

    private final RuleRepository ruleRepository;

    private final SensorRepository sensorRepository;

    private final ActuatorRepository actuatorRepository;

    @Autowired
    public RuleService(RuleRepository ruleRepository,
                         SensorRepository sensorRepository,
                         ActuatorRepository actuatorRepository) {
        this.ruleRepository = ruleRepository;
        this.sensorRepository = sensorRepository;
        this.actuatorRepository = actuatorRepository;
    }

    public List<Rule> readAll() {
        return ruleRepository.findAll();
    }

    public Optional<Rule> read(long id) {
        return ruleRepository.findById(id);
    }

    public void create(Rule data) {
        ruleRepository.save(data);
    }

    public void update(long id, Rule data) {
        final Rule rule = ruleRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        rule.setName(data.getName());
        rule.setActuators(data.getActuators());
        rule.setDescription(data.getDescription());
        rule.setSensors(data.getSensors());

        ruleRepository.save(rule);
    }

    public void delete(long id) {
        final Rule rule = ruleRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        ruleRepository.delete(rule);
    }


}

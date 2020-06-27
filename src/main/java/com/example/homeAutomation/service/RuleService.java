package com.example.homeAutomation.service;

import com.example.homeAutomation.dto.RuleDto;
import com.example.homeAutomation.dto.RuleResponseDto;
import com.example.homeAutomation.model.*;
import com.example.homeAutomation.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RuleService {

    private final RuleRepository ruleRepository;

    private final SensorRepository sensorRepository;

    private final ActuatorRepository actuatorRepository;

    private final UserRepository userRepository;


    @Autowired
    public RuleService(RuleRepository ruleRepository,
                         SensorRepository sensorRepository,
                         ActuatorRepository actuatorRepository, UserRepository userRepository) {
        this.ruleRepository = ruleRepository;
        this.sensorRepository = sensorRepository;
        this.actuatorRepository = actuatorRepository;
        this.userRepository = userRepository;
    }

    public List<Rule> readAll() {
        return ruleRepository.findAll();
    }

    public Optional<Rule> read(long id) {
        return ruleRepository.findById(id);
    }

    public Long create(RuleDto data) {
        Rule rule = new Rule();

        rule.setDescription(data.getDescription());
        rule.setName(data.getName());
        rule.setValue(data.getValue());
        rule.setValueActuator(data.getValueActuator());
        rule.setRuleRelation(data.getRuleRelation());
        User user = userRepository.findById(data.getUserId()).get();
        rule.setUser(user);
        rule.setVersionTimestamp(data.getVersionTimestamp());
        Sensor sensor = sensorRepository.findById(data.getSensorId()).get();
        List<Sensor> sensors = new ArrayList<>();
        sensors.add(sensor);
        rule.setSensors(sensors);

        Actuator actuator = actuatorRepository.findById(data.getActuatorId()).get();
        List<Actuator> actuators = new ArrayList<>();
        actuators.add(actuator);
        rule.setActuators(actuators);


       return ruleRepository.save(rule).getId();
    }

    public void update(long id, RuleDto data) {
        final Rule rule = ruleRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        rule.setDescription(data.getDescription());
        rule.setName(data.getName());
        rule.setValue(data.getValue());
        rule.setValueActuator(data.getValueActuator());
        rule.setRuleRelation(data.getRuleRelation());
        User user = userRepository.findById(data.getUserId()).get();
        rule.setUser(user);
        rule.setVersionTimestamp(data.getVersionTimestamp());
        Sensor sensor = sensorRepository.findById(data.getSensorId()).get();
        List<Sensor> sensors = new ArrayList<>();
        sensors.add(sensor);
        rule.setSensors(sensors);

        Actuator actuator = actuatorRepository.findById(data.getActuatorId()).get();
        List<Actuator> actuators = new ArrayList<>();
        actuators.add(actuator);
        rule.setActuators(actuators);


        ruleRepository.save(rule);
    }

    public void delete(long id) {
        final Rule rule = ruleRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        ruleRepository.delete(rule);
    }

    public List<RuleResponseDto> getAllByUserId(Long id) {
        User user = userRepository.findById(id).get();

        List<RuleResponseDto> ruleResponseDtos = new ArrayList<>();

        List<Rule> rules = user.getRules();

        for(Rule r : rules)
        {
            RuleResponseDto ruleResponseDto = new RuleResponseDto();

            ruleResponseDto.setActuator(r.getActuators().get(0));
            ruleResponseDto.setSensor(r.getSensors().get(0));
            ruleResponseDto.setDescription(r.getDescription());
            ruleResponseDto.setName(r.getName());
            ruleResponseDto.setId(r.getId());
            ruleResponseDto.setUser(user);
            ruleResponseDto.setVersionTimestamp(r.getVersionTimestamp());
            ruleResponseDto.setValue(r.getValue());
            ruleResponseDto.setValueActuator(r.getValueActuator());
            ruleResponseDto.setRuleRelation(r.getRuleRelation());

            ruleResponseDtos.add(ruleResponseDto);

        }


        return ruleResponseDtos;
    }


}

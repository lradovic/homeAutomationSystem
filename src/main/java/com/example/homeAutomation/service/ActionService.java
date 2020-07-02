package com.example.homeAutomation.service;

import com.example.homeAutomation.dto.ActionDto;
import com.example.homeAutomation.model.Action;
import com.example.homeAutomation.model.Actuator;
import com.example.homeAutomation.model.Device;
import com.example.homeAutomation.repository.ActionRepository;
import com.example.homeAutomation.repository.ActuatorRepository;
import com.example.homeAutomation.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionService {

    @Autowired
    ActionRepository actionRepository;

    @Autowired
    ActuatorRepository actuatorRepository;

    @Autowired
    DeviceRepository deviceRepository;

    public List<Action> getAllByActuatorId(Long id) {
        Actuator actuator = actuatorRepository.findById(id).get();
        return actuator.getActions();
    }

    public Long create(ActionDto actionDto) {
        Action action = new Action();
        action.setName(actionDto.getName());
        action.setDescription(actionDto.getDescription());
        action.setVersionTimestamp(actionDto.getVersionTimestamp());
        action.setAction(actionDto.getAction());

        Actuator actuator = actuatorRepository.findById(actionDto.getActuatorId()).get();
        action.setActuator(actuator);

        return actionRepository.saveAndFlush(action).getId();

    }

    public void updateAction(Long id, ActionDto actionDto) {
        Action action = actionRepository.findById(id).get();
        action.setName(actionDto.getName());
        action.setDescription(actionDto.getDescription());
        action.setVersionTimestamp(actionDto.getVersionTimestamp());
        //action.setAction(actionDto.getAction());

        Actuator actuator = actuatorRepository.findById(actionDto.getActuatorId()).get();
        action.setActuator(actuator);
        actionRepository.saveAndFlush(action);

    }

    public void deleteAction(Long id) {
        Action action = actionRepository.findById(id).get();
        actionRepository.delete(action);
    }
}

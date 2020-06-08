package com.example.homeAutomation.controller;

import com.example.homeAutomation.dto.ActionDto;
import com.example.homeAutomation.model.Action;
import com.example.homeAutomation.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/actions")
public class ActionController {

    @Autowired
    ActionService actionService;

    @GetMapping(value = "/actuators/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Action> getActionsByActuatorId(@PathVariable Long id) {
        return actionService.getAllByActuatorId(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long createAction(ActionDto actionDto) {
        return actionService.create(actionDto);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updateAction(@PathVariable Long id, ActionDto actionDto) {
        actionService.updateAction(id, actionDto);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAction(@PathVariable Long id) {
        actionService.deleteAction(id);
    }

}

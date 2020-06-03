package com.example.homeAutomation;

import com.example.homeAutomation.model.Actuator;
import com.example.homeAutomation.model.Device;
import com.example.homeAutomation.model.Sensor;
import com.example.homeAutomation.model.User;
import com.example.homeAutomation.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class HomeAutomationApplication {

	@Autowired
	UserRepository userRepository;

	@Autowired
	DeviceRepository deviceRepository;

	@Autowired
	ActuatorRepository actuatorRepository;

	@Autowired
	SensorRepository sensorRepository;

	@Autowired
	RuleRepository ruleRepository;

	@Autowired
	ActionRepository actionRepository;

	public static void main(String[] args) {
	SpringApplication.run(HomeAutomationApplication.class, args);

	}

}

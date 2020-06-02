package com.example.homeAutomation;

import com.example.homeAutomation.model.User;
import com.example.homeAutomation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class HomeAutomationApplication {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(HomeAutomationApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void init() {
		if(userRepository.findAll().isEmpty()) {
			User user = new User("Rix", "Ziks", "nomonom@nom.com", "test", null, null);
			userRepository.save(user);
		}

	}

}

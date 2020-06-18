package com.example.homeAutomation.service;

import com.example.homeAutomation.dto.LoginDto;
import com.example.homeAutomation.dto.UserDto;
import com.example.homeAutomation.model.Device;
import com.example.homeAutomation.model.Sensor;
import com.example.homeAutomation.model.User;
import com.example.homeAutomation.repository.SensorRepository;
import com.example.homeAutomation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> readAll() {
        return userRepository.findAll();
    }

    public Optional<User> read(long id) {
        return userRepository.findById(id);
    }

    public User login(LoginDto data) {
        User user = userRepository.findByEmailAndPassword(data.getEmail(), data.getPassword());
        if(user != null) {
            return user;
        }
        return null;
    }

    public boolean register(UserDto data) {

        User user = new User();
        user.setEmail(data.getEmail());
        user.setFirstName(data.getFirstName());
        user.setLastName(data.getLastName());
        user.setPassword(data.getPassword());
        userRepository.save(user);


        return true;
    }

    public void create(User data) {
        userRepository.save(data);
    }

    public void update(long id, User data) {
        final User user = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        user.setDevices(data.getDevices());
        user.setEmail(data.getEmail());
        user.setFirstName(data.getFirstName());
        user.setRules(data.getRules());
        user.setLastName(data.getLastName());
        user.setPassword(data.getPassword());

        userRepository.save(user);
    }

    public void delete(long id) {
        final User sensor = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        userRepository.delete(sensor);
    }

    public void updateUser(UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).get();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setVersionTimestamp(System.currentTimeMillis());
        userRepository.saveAndFlush(user);
    }
}

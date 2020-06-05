package com.example.homeAutomation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "device")
    @JsonIgnore
    private List<Sensor> sensors = new ArrayList<>();
    @OneToMany(mappedBy = "device")
    @JsonIgnore
    private List<Actuator> actuators = new ArrayList<>();

    @ManyToMany
    @JsonIgnore
    private List<User> users = new ArrayList<>();
    private Long versionTimestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public List<Actuator> getActuators() {
        return actuators;
    }

    public void setActuators(List<Actuator> actuators) {
        this.actuators = actuators;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Long getVersionTimestamp() {
        return versionTimestamp;
    }

    public void setVersionTimestamp(Long versionTimestamp) {
        this.versionTimestamp = versionTimestamp;
    }

    public Device() {
    }

    public Device(String name, String description, List<Sensor> sensors, List<Actuator> actuators, List<User> users, Long versionTimestamp) {
        this.name = name;
        this.description = description;
        this.sensors = sensors;
        this.actuators = actuators;
        this.users = users;
        this.versionTimestamp = versionTimestamp;
    }
}

package com.example.homeAutomation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String action;
    @ManyToOne
    @JsonIgnore
    private Actuator actuator;
    private Long versionTimestamp;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getVersionTimestamp() {
        return versionTimestamp;
    }

    public void setVersionTimestamp(Long versionTimestamp) {
        this.versionTimestamp = versionTimestamp;
    }

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

    public Actuator getActuator() {
        return actuator;
    }

    public void setActuator(Actuator actuator) {
        this.actuator = actuator;
    }
}

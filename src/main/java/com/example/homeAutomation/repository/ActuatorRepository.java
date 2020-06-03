package com.example.homeAutomation.repository;

import com.example.homeAutomation.model.Actuator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActuatorRepository extends JpaRepository<Actuator,Long> {
    Actuator findByReference(String reference);

}


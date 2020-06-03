package com.example.homeAutomation.repository;

import com.example.homeAutomation.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor,Long> {

    Sensor findByReference(String reference);

}


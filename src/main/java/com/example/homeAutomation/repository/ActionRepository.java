package com.example.homeAutomation.repository;

import com.example.homeAutomation.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends JpaRepository<Action,Long> {
}

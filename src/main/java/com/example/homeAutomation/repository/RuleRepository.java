package com.example.homeAutomation.repository;

import com.example.homeAutomation.model.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface RuleRepository extends JpaRepository<Rule,Long> {
}

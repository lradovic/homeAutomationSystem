package com.example.homeAutomation;

import com.example.homeAutomation.service.FillData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    @Autowired
    FillData fillData;

    @Override
    public void run(String... args) throws Exception {
        fillData.init();
    }
}

package com.example.oibmbbonuslogic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class OibMbBonusLogicApplication {

    public static void main(String[] args) {
        SpringApplication.run(OibMbBonusLogicApplication.class, args);
    }

    @GetMapping("/hello")
    public String getHelloWorldString(){
        return "First Try for GitHub Action!!!";
    }
}

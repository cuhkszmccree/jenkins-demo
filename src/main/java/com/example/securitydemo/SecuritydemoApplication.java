package com.example.securitydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecuritydemoApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SecuritydemoApplication.class);
        System.out.println(springApplication.getWebApplicationType());
        SpringApplication.run(SecuritydemoApplication.class, args);
    }

}

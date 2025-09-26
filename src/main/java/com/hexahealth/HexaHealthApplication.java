package com.hexahealth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class HexaHealthApplication {

    public static void main(String[] args) {
        SpringApplication.run(HexaHealthApplication.class, args);
    }

}

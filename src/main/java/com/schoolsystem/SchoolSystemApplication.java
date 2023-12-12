package com.schoolsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.schoolsystem.*"})
public class SchoolSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolSystemApplication.class, args);
    }

}

package com.example.ems.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:employee.xml")
public class AppConfig {
}

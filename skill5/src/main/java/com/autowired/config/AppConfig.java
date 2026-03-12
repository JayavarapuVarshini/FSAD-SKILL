package com.autowired.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Task 5b – Java-based Spring configuration.
 * @Configuration  – marks this as a Spring config class.
 * @ComponentScan  – tells Spring to scan for @Component beans.
 */
@Configuration
@ComponentScan(basePackages = "com.autowired.model")
public class AppConfig {
    // No explicit bean definitions needed –
    // Spring auto-wires Certification into Student via @Autowired.
}

package com.spring.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Task 4b – Java-based Spring configuration class.
 * @Configuration  – marks this as a Spring config class (replaces XML).
 * @ComponentScan  – tells Spring where to scan for @Component beans.
 */
@Configuration
@ComponentScan(basePackages = "com.spring.annotation")
public class AppConfig {
    // No explicit bean declarations needed;
    // Spring auto-detects @Component classes in the scanned package.
}

package com.autowired.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Task 1 – Certification POJO
 * Task 3 – @Component enables Spring IoC detection
 */
@Component
public class Certification {

    @Value("1")
    private int id;

    @Value("AWS Certified Developer")
    private String name;

    @Value("2024-08-15")
    private String dateOfCompletion;

    // Default constructor (required by Spring)
    public Certification() {}

    // All-args constructor
    public Certification(int id, String name, String dateOfCompletion) {
        this.id               = id;
        this.name             = name;
        this.dateOfCompletion = dateOfCompletion;
    }

    // Getters & Setters
    public int    getId()               { return id; }
    public void   setId(int id)         { this.id = id; }

    public String getName()             { return name; }
    public void   setName(String name)  { this.name = name; }

    public String getDateOfCompletion()                    { return dateOfCompletion; }
    public void   setDateOfCompletion(String dateOfCompletion) { this.dateOfCompletion = dateOfCompletion; }

    @Override
    public String toString() {
        return "Certification [id=" + id
                + ", name=" + name
                + ", dateOfCompletion=" + dateOfCompletion + "]";
    }
}

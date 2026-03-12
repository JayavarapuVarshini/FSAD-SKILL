package com.autowired.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Task 2 – Student POJO with a Certification object
 * Task 3 – @Component enables Spring IoC detection
 * Task 4 – @Autowired demonstrated three ways:
 *           (a) Field injection   – certByField
 *           (b) Constructor injection – certByConstructor
 *           (c) Setter injection  – certBySetter
 */
@Component
public class Student {

    @Value("101")
    private int id;

    @Value("John Doe")
    private String name;

    @Value("Male")
    private String gender;

    // ── (a) Field Injection ───────────────────────────────────────────────────
    @Autowired
    private Certification certByField;

    // ── (b) Constructor Injection ─────────────────────────────────────────────
    private Certification certByConstructor;

    @Autowired
    public Student(Certification certification) {
        this.certByConstructor = certification;
    }

    // ── (c) Setter Injection ──────────────────────────────────────────────────
    private Certification certBySetter;

    @Autowired
    public void setCertBySetter(Certification certification) {
        this.certBySetter = certification;
    }

    // Remaining getters
    public int           getId()                  { return id; }
    public String        getName()                { return name; }
    public String        getGender()              { return gender; }
    public Certification getCertByField()         { return certByField; }
    public Certification getCertByConstructor()   { return certByConstructor; }
    public Certification getCertBySetter()        { return certBySetter; }

    @Override
    public String toString() {
        return "Student [id=" + id
                + ", name="   + name
                + ", gender=" + gender
                + ", certification=" + certByField + "]";
    }
}

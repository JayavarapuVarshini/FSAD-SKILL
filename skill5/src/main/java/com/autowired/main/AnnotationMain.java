package com.autowired.main;

import com.autowired.config.AppConfig;
import com.autowired.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Task 5b – Load Spring IoC container via Java-based (@Configuration) config.
 * Task 6  – Load the container.
 * Task 7  – Retrieve Student bean and print all details including Certification.
 */
public class AnnotationMain {

    public static void main(String[] args) {

        System.out.println("====================================================");
        System.out.println("  Spring @Autowired Demo – Annotation Configuration ");
        System.out.println("====================================================\n");

        // Load IoC container using Java config class
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve Student bean – Certification is auto-injected by Spring
        Student student = context.getBean(Student.class);

        System.out.println(">> Student Details:");
        System.out.println("   ID     : " + student.getId());
        System.out.println("   Name   : " + student.getName());
        System.out.println("   Gender : " + student.getGender());

        System.out.println("\n>> Certification (Field Injection):");
        System.out.println("   " + student.getCertByField());

        System.out.println("\n>> Certification (Constructor Injection):");
        System.out.println("   " + student.getCertByConstructor());

        System.out.println("\n>> Certification (Setter Injection):");
        System.out.println("   " + student.getCertBySetter());

        System.out.println("\n✔ Annotation-based @Autowired demo completed.");
        ((AnnotationConfigApplicationContext) context).close();
    }
}

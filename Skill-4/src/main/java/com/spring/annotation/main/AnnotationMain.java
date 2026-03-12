package com.spring.annotation.main;

import com.spring.annotation.config.AppConfig;
import com.spring.annotation.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Task 4b – Main class to load the Annotation-based Spring IoC container.
 * Task 6  – Load IoC container.
 * Task 7  – Retrieve the Student bean and print injected values.
 */
public class AnnotationMain {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("  Spring DI – Annotation Configuration Demo  ");
        System.out.println("==============================================\n");

        // Load Spring IoC container using Java-based config
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the bean registered by @Component("studentBean")
        Student student = context.getBean("studentBean", Student.class);

        System.out.println(">> Annotation-based Injection (@Value on fields & setters):");
        System.out.println("   " + student);

        System.out.println("\n  Field Breakdown:");
        System.out.println("   Student ID : " + student.getStudentId());
        System.out.println("   Name       : " + student.getName());
        System.out.println("   Course     : " + student.getCourse());
        System.out.println("   Year       : " + student.getYear());

        System.out.println("\n✔ Annotation-based DI completed successfully.");

        ((AnnotationConfigApplicationContext) context).close();
    }
}

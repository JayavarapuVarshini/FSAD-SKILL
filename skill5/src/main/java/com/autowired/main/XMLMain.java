package com.autowired.main;

import com.autowired.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Task 5a – Load Spring IoC container via XML configuration.
 * Task 6  – Load the container.
 * Task 7  – Retrieve Student bean and print all details.
 */
public class XMLMain {

    public static void main(String[] args) {

        System.out.println("================================================");
        System.out.println("  Spring @Autowired Demo – XML Configuration    ");
        System.out.println("================================================\n");

        // Load IoC container from XML
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve Student bean (autowired with Certification)
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

        System.out.println("\n✔ XML-based @Autowired demo completed.");
        ((ClassPathXmlApplicationContext) context).close();
    }
}

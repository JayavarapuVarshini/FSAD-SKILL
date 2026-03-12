package com.spring.xml.main;

import com.spring.xml.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Task 4a – Main class to load the XML-based Spring IoC container.
 * Task 6 – Load container and Task 7 – Retrieve & print injected values.
 */
public class XMLMain {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("  Spring DI – XML Configuration Demo   ");
        System.out.println("========================================\n");

        // Load the Spring IoC container from the XML config
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // ── Constructor Injection bean ────────────────────────────────────────
        Student s1 = (Student) context.getBean("studentConstructor");
        System.out.println(">> Constructor Injection:");
        System.out.println("   " + s1);

        System.out.println();

        // ── Setter Injection bean (course & year overridden via setters) ──────
        Student s2 = (Student) context.getBean("studentSetter");
        System.out.println(">> Setter Injection (course & year overridden):");
        System.out.println("   " + s2);

        System.out.println("\n✔ XML-based DI completed successfully.");

        // Close context
        ((ClassPathXmlApplicationContext) context).close();
    }
}

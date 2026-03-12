package com.spring.annotation.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * POJO for Annotation-based Dependency Injection.
 * @Component makes Spring auto-detect and register this class as a bean.
 * @Value injects literal values directly into fields.
 */
@Component("studentBean")
public class Student {

    @Value("201")
    private int studentId;

    @Value("Carol Williams")
    private String name;

    private String course;
    private int year;

    // ─── Task 2: All-args constructor ─────────────────────────────────────────
    public Student() {}   // required for component scanning + setter injection

    public Student(int studentId, String name, String course, int year) {
        this.studentId = studentId;
        this.name      = name;
        this.course    = course;
        this.year      = year;
    }

    // ─── Task 3: Setter methods with @Value for course and year ───────────────
    @Value("Data Science")
    public void setCourse(String course) {
        this.course = course;
    }

    @Value("4")
    public void setYear(int year) {
        this.year = year;
    }

    // Getters
    public int    getStudentId() { return studentId; }
    public String getName()      { return name;      }
    public String getCourse()    { return course;    }
    public int    getYear()      { return year;      }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId
                + ", name="    + name
                + ", course="  + course
                + ", year="    + year + "]";
    }
}

package com.spring.xml.model;

/**
 * POJO class for XML-based Dependency Injection (Constructor + Setter).
 */
public class Student {

    private int studentId;
    private String name;
    private String course;
    private int year;

    // ─── Task 2: Constructor that accepts all fields ──────────────────────────
    public Student(int studentId, String name, String course, int year) {
        this.studentId = studentId;
        this.name      = name;
        this.course    = course;
        this.year      = year;
    }

    // ─── Task 3: Setter methods for course and year ───────────────────────────
    public void setCourse(String course) {
        this.course = course;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Remaining getters
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

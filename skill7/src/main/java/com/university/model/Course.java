package com.university.model;

/**
 * Task 1 – Course entity with courseId, title, duration, fee.
 */
public class Course {

    private int    courseId;
    private String title;
    private int    duration;   // in weeks
    private double fee;

    public Course() {}

    public Course(int courseId, String title, int duration, double fee) {
        this.courseId = courseId;
        this.title    = title;
        this.duration = duration;
        this.fee      = fee;
    }

    public int    getCourseId()             { return courseId; }
    public void   setCourseId(int courseId) { this.courseId = courseId; }

    public String getTitle()                { return title; }
    public void   setTitle(String title)    { this.title = title; }

    public int    getDuration()               { return duration; }
    public void   setDuration(int duration)   { this.duration = duration; }

    public double getFee()                  { return fee; }
    public void   setFee(double fee)        { this.fee = fee; }

    @Override
    public String toString() {
        return "Course [courseId=" + courseId + ", title=" + title
                + ", duration=" + duration + " weeks, fee=" + fee + "]";
    }
}

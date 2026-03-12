package com.university.service;

import com.university.model.Course;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Task 2 – Service layer performing full CRUD operations on an in-memory store.
 */
@Service
public class CourseService {

    // In-memory data store
    private Map<Integer, Course> courseMap = new HashMap<>();

    // Pre-load some sample courses
    public CourseService() {
        courseMap.put(1, new Course(1, "Java Programming",    12, 15000.00));
        courseMap.put(2, new Course(2, "Spring Boot",         8,  12000.00));
        courseMap.put(3, new Course(3, "Data Structures",     10, 10000.00));
        courseMap.put(4, new Course(4, "Machine Learning",    16, 20000.00));
    }

    // ── CREATE ────────────────────────────────────────────────────────────────
    public Course addCourse(Course course) {
        if (courseMap.containsKey(course.getCourseId())) {
            return null;    // signals duplicate ID to controller
        }
        courseMap.put(course.getCourseId(), course);
        return course;
    }

    // ── READ ALL ──────────────────────────────────────────────────────────────
    public List<Course> getAllCourses() {
        return new ArrayList<>(courseMap.values());
    }

    // ── READ BY ID ────────────────────────────────────────────────────────────
    public Course getCourseById(int id) {
        return courseMap.get(id);
    }

    // ── UPDATE ────────────────────────────────────────────────────────────────
    public Course updateCourse(int id, Course updated) {
        if (!courseMap.containsKey(id)) return null;
        updated.setCourseId(id);
        courseMap.put(id, updated);
        return updated;
    }

    // ── DELETE ────────────────────────────────────────────────────────────────
    public boolean deleteCourse(int id) {
        if (!courseMap.containsKey(id)) return false;
        courseMap.remove(id);
        return true;
    }

    // ── SEARCH BY TITLE (Task 5) ──────────────────────────────────────────────
    public List<Course> searchByTitle(String title) {
        List<Course> result = new ArrayList<>();
        for (Course c : courseMap.values()) {
            if (c.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(c);
            }
        }
        return result;
    }
}

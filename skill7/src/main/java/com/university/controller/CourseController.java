package com.university.controller;

import com.university.model.Course;
import com.university.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Task 3 – REST endpoints using @PostMapping, @PutMapping, @DeleteMapping, @GetMapping
 * Task 4 – ResponseEntity returning success/error messages + HTTP status codes
 * Task 5 – Search endpoint /courses/search/{title}
 */
@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // ── GET /courses – Retrieve all courses ───────────────────────────────────
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        if (courses.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
        return ResponseEntity.ok(courses);                          // 200 OK
    }

    // ── GET /courses/{id} – Retrieve course by ID ─────────────────────────────
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable int id) {
        Course course = courseService.getCourseById(id);
        if (course == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)      // 404
                    .body("Error: Course not found with ID: " + id);
        }
        return ResponseEntity.ok(course);                           // 200 OK
    }

    // ── POST /courses – Add a new course ──────────────────────────────────────
    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        if (course.getTitle() == null || course.getTitle().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)    // 400
                    .body("Error: Course title must not be empty.");
        }
        Course saved = courseService.addCourse(course);
        if (saved == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)    // 400
                    .body("Error: Course with ID " + course.getCourseId() + " already exists.");
        }
        return ResponseEntity.status(HttpStatus.CREATED)            // 201 CREATED
                .body(saved);
    }

    // ── PUT /courses/{id} – Update existing course ────────────────────────────
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id,
                                          @RequestBody Course course) {
        if (course.getTitle() == null || course.getTitle().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)    // 400
                    .body("Error: Course title must not be empty.");
        }
        Course updated = courseService.updateCourse(id, course);
        if (updated == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)      // 404
                    .body("Error: Cannot update. Course not found with ID: " + id);
        }
        return ResponseEntity.ok(updated);                          // 200 OK
    }

    // ── DELETE /courses/{id} – Delete a course ────────────────────────────────
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id) {
        boolean deleted = courseService.deleteCourse(id);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)      // 404
                    .body("Error: Cannot delete. Course not found with ID: " + id);
        }
        return ResponseEntity.ok("Course with ID " + id + " deleted successfully."); // 200
    }

    // ── GET /courses/search/{title} – Search by title (Task 5) ───────────────
    @GetMapping("/search/{title}")
    public ResponseEntity<?> searchByTitle(@PathVariable String title) {
        List<Course> results = courseService.searchByTitle(title);
        if (results.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)      // 404
                    .body("No courses found matching title: " + title);
        }
        return ResponseEntity.ok(results);                          // 200 OK
    }
}

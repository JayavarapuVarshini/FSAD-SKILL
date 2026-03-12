package com.library.controller;

import com.library.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Task 1  – LibraryController
 * Tasks 2-10 – All endpoints implemented below.
 */
@RestController
public class LibraryController {

    // In-memory book list used by Task 9 & 10
    private List<Book> bookStore = new ArrayList<>();

    // Pre-loaded sample book titles (used by Task 5)
    private List<String> bookTitles = List.of(
            "Clean Code",
            "The Pragmatic Programmer",
            "Design Patterns",
            "Effective Java",
            "Head First Java"
    );

    // ── Task 2: GET /welcome ──────────────────────────────────────────────────
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Online Library System!";
    }

    // ── Task 3: GET /count – total number of books ────────────────────────────
    @GetMapping("/count")
    public int count() {
        return bookTitles.size();   // returns 5
    }

    // ── Task 4: GET /price – sample book price as double ─────────────────────
    @GetMapping("/price")
    public double price() {
        return 499.99;
    }

    // ── Task 5: GET /books – list of book titles ──────────────────────────────
    @GetMapping("/books")
    public List<String> getBooks() {
        return bookTitles;
    }

    // ── Task 6: GET /books/{id} – book details using @PathVariable ────────────
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        if (id < 1 || id > bookTitles.size()) {
            return "Book not found for ID: " + id;
        }
        return "Book ID: " + id + " | Title: " + bookTitles.get(id - 1);
    }

    // ── Task 7: GET /search?title=xxx – request parameter ────────────────────
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book with title: \"" + title + "\"";
    }

    // ── Task 8: GET /author/{name} – formatted author message ────────────────
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Books written by author: " + name;
    }

    // ── Task 9: POST /addbook – accept Book JSON and store in list ────────────
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookStore.add(book);
        return "Book added successfully: " + book.getTitle();
    }

    // ── Task 10: GET /viewbooks – return all added Book objects ───────────────
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookStore;
    }
}

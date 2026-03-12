# Spring MVC Web Request Handling – Skill 6

## Project Structure
```
skill6/
├── pom.xml
└── src/main/
    ├── java/com/library/
    │   ├── LibraryApplication.java          ← Spring Boot entry point
    │   ├── model/Book.java                  ← Book POJO (Task 9, 10)
    │   └── controller/LibraryController.java ← All 10 tasks
    └── resources/
        └── application.properties
```

## Import into Eclipse
1. **File → Import → Maven → Existing Maven Projects**
2. Browse to extracted `skill6` folder → **Finish**
3. Maven downloads Spring Boot dependencies automatically

## Run
- Right-click `LibraryApplication.java` → **Run As → Java Application**
- Server starts at: `http://localhost:8080`

## API Endpoints

| Task | Method | URL | Description |
|------|--------|-----|-------------|
| 2  | GET  | `/welcome`           | Returns welcome message |
| 3  | GET  | `/count`             | Returns total book count (int) |
| 4  | GET  | `/price`             | Returns sample book price (double) |
| 5  | GET  | `/books`             | Returns list of book titles |
| 6  | GET  | `/books/{id}`        | Returns book details by ID (@PathVariable) |
| 7  | GET  | `/search?title=xxx`  | Search by title (@RequestParam) |
| 8  | GET  | `/author/{name}`     | Returns message with author name |
| 9  | POST | `/addbook`           | Accepts Book JSON, stores in memory |
| 10 | GET  | `/viewbooks`         | Returns all added Book objects |

## Test with Browser / Postman

### GET requests (open in browser):
```
http://localhost:8080/welcome
http://localhost:8080/count
http://localhost:8080/price
http://localhost:8080/books
http://localhost:8080/books/1
http://localhost:8080/search?title=CleanCode
http://localhost:8080/author/RobertMartin
http://localhost:8080/viewbooks
```

### POST /addbook (use Postman):
```
POST http://localhost:8080/addbook
Content-Type: application/json

{
  "id": 1,
  "title": "Spring in Action",
  "author": "Craig Walls",
  "price": 599.99
}
```

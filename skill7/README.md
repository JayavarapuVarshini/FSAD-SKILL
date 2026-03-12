# REST API CRUD with ResponseEntity – Skill 7

## Project Structure
```
skill7/
├── pom.xml
└── src/main/java/com/university/
    ├── CourseApplication.java          ← Spring Boot entry point
    ├── model/Course.java               ← Task 1: Entity
    ├── service/CourseService.java      ← Task 2: Service layer (in-memory CRUD)
    └── controller/CourseController.java ← Task 3,4,5: REST endpoints
```

## Import into Eclipse
1. **File → Import → Maven → Existing Maven Projects**
2. Browse to `skill7` folder → **Finish**

## Run
Right-click `CourseApplication.java` → **Run As → Java Application**
Server: `http://localhost:8080`

---

## API Endpoints & Postman Tests

### GET /courses — All courses (200 OK)
```
GET http://localhost:8080/courses
```

### GET /courses/{id} — By ID
```
GET http://localhost:8080/courses/1       → 200 OK
GET http://localhost:8080/courses/99      → 404 NOT FOUND
```

### POST /courses — Add course (201 CREATED)
```
POST http://localhost:8080/courses
Content-Type: application/json

{
  "courseId": 5,
  "title": "Web Development",
  "duration": 10,
  "fee": 18000.00
}
```
Invalid (missing title) → 400 BAD_REQUEST
Duplicate ID           → 400 BAD_REQUEST

### PUT /courses/{id} — Update course
```
PUT http://localhost:8080/courses/1
Content-Type: application/json

{
  "title": "Advanced Java",
  "duration": 14,
  "fee": 17000.00
}
```
Valid   → 200 OK
Missing → 404 NOT FOUND

### DELETE /courses/{id} — Delete course
```
DELETE http://localhost:8080/courses/2    → 200 OK
DELETE http://localhost:8080/courses/99   → 404 NOT FOUND
```

### GET /courses/search/{title} — Search by title (Task 5)
```
GET http://localhost:8080/courses/search/java    → matches "Java Programming"
GET http://localhost:8080/courses/search/spring  → matches "Spring Boot"
GET http://localhost:8080/courses/search/xyz     → 404 NOT FOUND
```

---

## HTTP Status Codes Used
| Code | Meaning       | When used |
|------|---------------|-----------|
| 200  | OK            | Successful GET, PUT, DELETE |
| 201  | CREATED       | Successful POST |
| 400  | BAD_REQUEST   | Invalid input / duplicate ID |
| 404  | NOT_FOUND     | Resource doesn't exist |

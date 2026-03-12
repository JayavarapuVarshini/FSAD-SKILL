# Spring DI – Skill 4: Constructor & Setter Injection

## Project Structure
```
SpringDI/
├── pom.xml
└── src/main/
    ├── java/com/spring/
    │   ├── xml/
    │   │   ├── model/Student.java          ← POJO (Task 1,2,3)
    │   │   └── main/XMLMain.java           ← XML container runner (Task 4a,6,7)
    │   └── annotation/
    │       ├── model/Student.java          ← @Component POJO (Task 4b)
    │       ├── config/AppConfig.java       ← @Configuration class (Task 5)
    │       └── main/AnnotationMain.java    ← Annotation runner (Task 6,7)
    └── resources/
        └── applicationContext.xml         ← XML bean config (Task 4a,5)
```

## Import into Eclipse
1. **File → Import → Maven → Existing Maven Projects**
2. Browse to the extracted `SpringDI` folder → **Finish**
3. Maven auto-downloads Spring 6

## Run
### XML Configuration
- Right-click `XMLMain.java` → **Run As → Java Application**
- Shows **Constructor Injection** (all 4 fields) and **Setter Injection** (course & year overridden)

### Annotation Configuration
- Right-click `AnnotationMain.java` → **Run As → Java Application**
- Shows `@Component` + `@Value` field & setter injection

## Tasks Covered
| Task | Details |
|------|---------|
| 1    | `Student` POJO with studentId, name, course, year |
| 2    | All-args constructor |
| 3    | Setter methods for `course` and `year` |
| 4a   | XML config – Constructor + Setter beans |
| 4b   | Annotation config – `@Component`, `@Value` |
| 5    | `applicationContext.xml` + `AppConfig.java` |
| 6    | `ClassPathXmlApplicationContext` & `AnnotationConfigApplicationContext` |
| 7    | Retrieve beans and print all injected values |

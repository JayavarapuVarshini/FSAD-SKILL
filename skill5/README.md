# Spring Autowiring Demo – Skill 5

## Project Structure
```
skill5/
├── pom.xml
└── src/main/
    ├── java/com/autowired/
    │   ├── model/
    │   │   ├── Certification.java   ← Task 1, 3
    │   │   └── Student.java         ← Task 2, 3, 4 (field + constructor + setter @Autowired)
    │   ├── config/
    │   │   └── AppConfig.java       ← Task 5b (@Configuration + @ComponentScan)
    │   └── main/
    │       ├── XMLMain.java         ← Task 5a, 6, 7 (XML IoC)
    │       └── AnnotationMain.java  ← Task 5b, 6, 7 (Annotation IoC)
    └── resources/
        └── applicationContext.xml  ← Task 5a (XML config)
```

## Import into Eclipse
1. **File → Import → Maven → Existing Maven Projects**
2. Browse to the extracted `skill5` folder → **Finish**

## Run
| Main Class | Loads via |
|------------|-----------|
| `XMLMain.java` | `ClassPathXmlApplicationContext` |
| `AnnotationMain.java` | `AnnotationConfigApplicationContext` |

Both print Student + Certification details showing all 3 @Autowired modes.

## Tasks Covered
| Task | Detail |
|------|--------|
| 1 | `Certification` class with id, name, dateOfCompletion |
| 2 | `Student` class with id, name, gender, Certification |
| 3 | Both classes annotated with `@Component` |
| 4 | `@Autowired` on field, constructor, and setter |
| 5a | XML config with `<context:component-scan>` |
| 5b | `AppConfig.java` with `@Configuration` + `@ComponentScan` |
| 6 | IoC container loaded via ApplicationContext |
| 7 | Student bean retrieved and all values printed |

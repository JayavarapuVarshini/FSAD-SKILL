# Hibernate HQL - Skill 3: Sorting, Pagination & Aggregates

## Prerequisites
- Eclipse IDE (with Maven support)
- Java 17+
- MySQL Server running locally
- Maven

## Project Structure
```
HibernateHQL/
├── pom.xml
└── src/main/
    ├── java/com/hql/
    │   ├── entity/Product.java        ← JPA Entity
    │   ├── util/HibernateUtil.java    ← Session factory helper
    │   └── main/HQLDemo.java         ← All HQL task demos
    └── resources/
        └── hibernate.cfg.xml         ← DB configuration
```

## Setup Steps

### 1. Create MySQL Database
```sql
CREATE DATABASE hibernatedb;
```

### 2. Update DB credentials in `hibernate.cfg.xml`
```xml
<property name="hibernate.connection.username">root</property>
<property name="hibernate.connection.password">YOUR_PASSWORD</property>
```

### 3. Import into Eclipse
1. **File → Import → Maven → Existing Maven Projects**
2. Browse to the extracted `HibernateHQL` folder
3. Click **Finish**
4. Eclipse will auto-download all dependencies via Maven

### 4. Run the Project
- Right-click `HQLDemo.java` → **Run As → Java Application**
- Hibernate will auto-create the `products` table (`hbm2ddl.auto=update`)

## Tasks Covered
| Task | Description |
|------|-------------|
| 2    | Insert 8 Product records |
| 3a   | Sort by price ASC |
| 3b   | Sort by price DESC |
| 4    | Sort by quantity DESC |
| 5a   | Pagination – first 3 |
| 5b   | Pagination – next 3 |
| 6a   | COUNT total products |
| 6b   | COUNT where quantity > 0 |
| 6c   | COUNT grouped by description |
| 6d   | MIN and MAX price |
| 7    | GROUP BY description |
| 8    | WHERE price BETWEEN range |
| 9a   | LIKE – starts with letter |
| 9b   | LIKE – ends with letters |
| 9c   | LIKE – contains substring |
| 9d   | LIKE – exact character length |

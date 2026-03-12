# HibernateInventory — Retail Inventory CRUD with Hibernate

This project demonstrates basic CRUD operations using Hibernate (JPA) with a `Product` entity.

Setup
1. Create the database in MySQL:

   - Run the SQL in `sql/create_database.sql` or execute in MySQL Workbench/CLI.

2. Update the database password in `src/main/resources/hibernate.cfg.xml` (replace `YOUR_PASSWORD`).

3. Build and run from your IDE, or use Maven:

```bash
mvn compile
# Run via IDE by executing com.inventory.main.App
```

What is included
- `Product` entity with notes about switching ID generation strategies (AUTO / IDENTITY / SEQUENCE).
- `ProductDAO` with `save`, `get`, `update`, `delete`, and `listAll`.
- `HibernateUtil` to obtain a `SessionFactory` from `hibernate.cfg.xml`.
- `App` demonstrates inserting multiple products, retrieving, updating and deleting.

Notes
- Replace the DB password in `hibernate.cfg.xml` before running.
- To observe ID generation differences, edit `Product` and swap the `@GeneratedValue` strategy as commented.

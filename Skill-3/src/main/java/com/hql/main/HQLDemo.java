package com.hql.main;

import com.hql.entity.Product;
import com.hql.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HQLDemo {

    // ─── TASK 2: Insert 5–8 Product records ──────────────────────────────────
    public static void insertProducts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(new Product("Laptop",      75000.00, 10, "Electronics"));
        session.persist(new Product("Mouse",        500.00,  50, "Electronics"));
        session.persist(new Product("Keyboard",    1200.00,  30, "Electronics"));
        session.persist(new Product("Monitor",    15000.00,   8, "Electronics"));
        session.persist(new Product("Desk Chair",  8000.00,  15, "Furniture"));
        session.persist(new Product("Notebook",     120.00, 200, "Stationery"));
        session.persist(new Product("Pen",           20.00,   0, "Stationery"));
        session.persist(new Product("USB Hub",     1500.00,  25, "Electronics"));

        tx.commit();
        session.close();
        System.out.println("✔ Products inserted successfully.\n");
    }

    // ─── TASK 3a: Sort by price ASCENDING ────────────────────────────────────
    public static void sortByPriceAsc() {
        System.out.println("=== Task 3a: Products sorted by price (ASC) ===");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> query = session.createQuery(
                "FROM Product p ORDER BY p.price ASC", Product.class);
        List<Product> list = query.list();
        list.forEach(System.out::println);
        session.close();
        System.out.println();
    }

    // ─── TASK 3b: Sort by price DESCENDING ───────────────────────────────────
    public static void sortByPriceDesc() {
        System.out.println("=== Task 3b: Products sorted by price (DESC) ===");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> query = session.createQuery(
                "FROM Product p ORDER BY p.price DESC", Product.class);
        List<Product> list = query.list();
        list.forEach(System.out::println);
        session.close();
        System.out.println();
    }

    // ─── TASK 4: Sort by quantity (highest first) ────────────────────────────
    public static void sortByQuantityDesc() {
        System.out.println("=== Task 4: Products sorted by quantity (DESC) ===");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> query = session.createQuery(
                "FROM Product p ORDER BY p.quantity DESC", Product.class);
        List<Product> list = query.list();
        list.forEach(System.out::println);
        session.close();
        System.out.println();
    }

    // ─── TASK 5a: Pagination – first 3 products ──────────────────────────────
    public static void paginationFirst3() {
        System.out.println("=== Task 5a: Pagination – First 3 products ===");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> query = session.createQuery("FROM Product", Product.class);
        query.setFirstResult(0);
        query.setMaxResults(3);
        query.list().forEach(System.out::println);
        session.close();
        System.out.println();
    }

    // ─── TASK 5b: Pagination – next 3 products ───────────────────────────────
    public static void paginationNext3() {
        System.out.println("=== Task 5b: Pagination – Next 3 products ===");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> query = session.createQuery("FROM Product", Product.class);
        query.setFirstResult(3);
        query.setMaxResults(3);
        query.list().forEach(System.out::println);
        session.close();
        System.out.println();
    }

    // ─── TASK 6a: Count total products ───────────────────────────────────────
    public static void countTotalProducts() {
        System.out.println("=== Task 6a: Count total products ===");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Long count = (Long) session.createQuery("SELECT COUNT(p) FROM Product p").uniqueResult();
        System.out.println("Total Products: " + count);
        session.close();
        System.out.println();
    }

    // ─── TASK 6b: Count products where quantity > 0 ──────────────────────────
    public static void countProductsWithStock() {
        System.out.println("=== Task 6b: Count products where quantity > 0 ===");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Long count = (Long) session.createQuery(
                "SELECT COUNT(p) FROM Product p WHERE p.quantity > 0").uniqueResult();
        System.out.println("Products in Stock: " + count);
        session.close();
        System.out.println();
    }

    // ─── TASK 6c: Count products grouped by description ──────────────────────
    public static void countGroupedByDescription() {
        System.out.println("=== Task 6c: Products grouped by description ===");
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Object[]> results = session.createQuery(
                "SELECT p.description, COUNT(p) FROM Product p GROUP BY p.description",
                Object[].class).list();
        for (Object[] row : results) {
            System.out.println("Category: " + row[0] + " | Count: " + row[1]);
        }
        session.close();
        System.out.println();
    }

    // ─── TASK 6d: Min and Max price ──────────────────────────────────────────
    public static void minMaxPrice() {
        System.out.println("=== Task 6d: Minimum and Maximum price ===");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Object[] result = (Object[]) session.createQuery(
                "SELECT MIN(p.price), MAX(p.price) FROM Product p").uniqueResult();
        System.out.println("Min Price: " + result[0]);
        System.out.println("Max Price: " + result[1]);
        session.close();
        System.out.println();
    }

    // ─── TASK 7: GROUP BY description ────────────────────────────────────────
    public static void groupByDescription() {
        System.out.println("=== Task 7: GROUP BY description ===");
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Object[]> results = session.createQuery(
                "SELECT p.description, COUNT(p), AVG(p.price) FROM Product p GROUP BY p.description",
                Object[].class).list();
        for (Object[] row : results) {
            System.out.printf("Description: %-15s | Count: %s | Avg Price: %.2f%n",
                    row[0], row[1], row[2]);
        }
        session.close();
        System.out.println();
    }

    // ─── TASK 8: WHERE – price range filter ──────────────────────────────────
    public static void filterByPriceRange(double min, double max) {
        System.out.println("=== Task 8: Products WHERE price BETWEEN " + min + " AND " + max + " ===");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> query = session.createQuery(
                "FROM Product p WHERE p.price BETWEEN :min AND :max", Product.class);
        query.setParameter("min", min);
        query.setParameter("max", max);
        query.list().forEach(System.out::println);
        session.close();
        System.out.println();
    }

    // ─── TASK 9a: LIKE – name starts with certain letters ────────────────────
    public static void likeStartsWith(String prefix) {
        System.out.println("=== Task 9a: Names starting with '" + prefix + "' ===");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> query = session.createQuery(
                "FROM Product p WHERE p.name LIKE :pattern", Product.class);
        query.setParameter("pattern", prefix + "%");
        query.list().forEach(System.out::println);
        session.close();
        System.out.println();
    }

    // ─── TASK 9b: LIKE – name ends with certain letters ──────────────────────
    public static void likeEndsWith(String suffix) {
        System.out.println("=== Task 9b: Names ending with '" + suffix + "' ===");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> query = session.createQuery(
                "FROM Product p WHERE p.name LIKE :pattern", Product.class);
        query.setParameter("pattern", "%" + suffix);
        query.list().forEach(System.out::println);
        session.close();
        System.out.println();
    }

    // ─── TASK 9c: LIKE – name contains a substring ───────────────────────────
    public static void likeContains(String substring) {
        System.out.println("=== Task 9c: Names containing '" + substring + "' ===");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> query = session.createQuery(
                "FROM Product p WHERE p.name LIKE :pattern", Product.class);
        query.setParameter("pattern", "%" + substring + "%");
        query.list().forEach(System.out::println);
        session.close();
        System.out.println();
    }

    // ─── TASK 9d: LIKE – names with exact character length ───────────────────
    public static void likeExactLength(int length) {
        System.out.println("=== Task 9d: Names with exact length " + length + " ===");
        // Each '_' matches exactly one character
        String pattern = "_".repeat(length);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> query = session.createQuery(
                "FROM Product p WHERE p.name LIKE :pattern", Product.class);
        query.setParameter("pattern", pattern);
        query.list().forEach(System.out::println);
        session.close();
        System.out.println();
    }

    // ─── MAIN ─────────────────────────────────────────────────────────────────
    public static void main(String[] args) {

        // Task 2 – Insert records
        insertProducts();

        // Task 3 – Sort by price
        sortByPriceAsc();
        sortByPriceDesc();

        // Task 4 – Sort by quantity
        sortByQuantityDesc();

        // Task 5 – Pagination
        paginationFirst3();
        paginationNext3();

        // Task 6 – Aggregates
        countTotalProducts();
        countProductsWithStock();
        countGroupedByDescription();
        minMaxPrice();

        // Task 7 – GROUP BY
        groupByDescription();

        // Task 8 – WHERE price range
        filterByPriceRange(500, 10000);

        // Task 9 – LIKE queries
        likeStartsWith("L");
        likeEndsWith("e");
        likeContains("o");
        likeExactLength(3);

        HibernateUtil.shutdown();
        System.out.println("✔ All HQL tasks completed.");
    }
}

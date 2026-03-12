package com.inventory.main;

import com.inventory.dao.ProductDAO;
import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();

        System.out.println("=== Inserting products ===");
        Product p1 = new Product("Laptop", "Gaming Laptop", 75000, 10);
        Product p2 = new Product("Mouse", "Wireless Mouse", 1200, 50);
        Product p3 = new Product("Keyboard", "Mechanical Keyboard", 3500, 20);

        dao.saveProduct(p1);
        dao.saveProduct(p2);
        dao.saveProduct(p3);

        System.out.println("=== All products after insert ===");
        List<Product> all = dao.listAll();
        all.forEach(System.out::println);

        System.out.println("=== Retrieve product with id 1 ===");
        Product prod = dao.getProduct(1);
        System.out.println(prod);

        System.out.println("=== Update product id 1 price and quantity ===");
        dao.updateProduct(1, 72000.0, 8);
        System.out.println(dao.getProduct(1));

        System.out.println("=== Delete product id 2 ===");
        dao.deleteProduct(2);

        System.out.println("=== All products after delete ===");
        dao.listAll().forEach(System.out::println);

        HibernateUtil.shutdown();
    }
}

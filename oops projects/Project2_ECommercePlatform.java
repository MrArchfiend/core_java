/*
 E-Commerce Platform (simplified)
 - Abstract Product, concrete Electronics/Clothing/Groceries
 - Interface Taxable
 - Demonstrates encapsulation and polymorphism
*/
import java.util.*;

public class Project2_ECommercePlatform {
    public static abstract class Product {
        private String productId;
        private String name;
        private double price;

        public Product(String productId, String name, double price) {
            this.productId = productId;
            this.name = name;
            setPrice(price);
        }

        public String getProductId() { return productId; }
        public String getName() { return name; }
        public double getPrice() { return price; }
        public void setPrice(double price) {
            if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
            this.price = price;
        }

        public abstract double calculateDiscount();

        public String toString() {
            return String.format("%s (%s) - %.2f", name, productId, price);
        }
    }

    public interface Taxable {
        double calculateTax();
        String getTaxDetails();
    }

    public static class Electronics extends Product implements Taxable {
        public Electronics(String id, String name, double price) { super(id, name, price); }

        @Override
        public double calculateDiscount() { return getPrice() * 0.10; }

        @Override
        public double calculateTax() { return getPrice() * 0.18; }

        @Override
        public String getTaxDetails() { return "Electronics tax: 18%"; }
    }

    public static class Clothing extends Product implements Taxable {
        public Clothing(String id, String name, double price) { super(id, name, price); }

        @Override
        public double calculateDiscount() { return getPrice() * 0.15; }

        @Override
        public double calculateTax() { return getPrice() * 0.05; }

        @Override
        public String getTaxDetails() { return "Clothing tax: 5%"; }
    }

    public static class Groceries extends Product {
        public Groceries(String id, String name, double price) { super(id, name, price); }

        @Override
        public double calculateDiscount() { return getPrice() * 0.02; } // small discount
    }

    // Method to compute final price (price + tax - discount)
    public static void printFinalPrices(List<Product> products) {
        for (Product p : products) {
            double price = p.getPrice();
            double discount = p.calculateDiscount();
            double tax = (p instanceof Taxable) ? ((Taxable)p).calculateTax() : 0.0;
            double finalPrice = price + tax - discount;
            System.out.println(p + " | Tax: " + tax + " | Discount: " + discount + " | Final: " + finalPrice);
        }
    }

    public static void main(String[] args) {
        List<Product> catalog = Arrays.asList(
            new Electronics("E100","Smartphone",30000),
            new Clothing("C200","Jacket",2500),
            new Groceries("G300","Rice(5kg)",2200)
        );

        printFinalPrices(catalog);
    }
}

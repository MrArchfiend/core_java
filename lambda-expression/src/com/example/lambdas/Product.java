package com.example.lambdas;

public class Product {
    public String name;
    public double price;
    public double rating;
    public double discount; // percent

    public Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return String.format("%s{price=%.2f, rating=%.1f, discount=%.0f%%}", name, price, rating, discount);
    }
}

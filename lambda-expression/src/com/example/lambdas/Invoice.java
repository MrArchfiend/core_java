package com.example.lambdas;

public class Invoice {
    public String id;
    public double amount;

    public Invoice(String id) {
        this.id = id;
        // for demo, generate amount from id length
        this.amount = id.length() * 10.0;
    }

    @Override
    public String toString() {
        return String.format("Invoice{id=%s,amount=%.2f}", id, amount);
    }
}

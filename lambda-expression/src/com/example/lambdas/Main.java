package com.example.lambdas;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Smart Home Lighting Automation (lambdas) ---");
        smartHomeDemo();

        System.out.println("\n--- Custom Sorting in E-Commerce (lambda comparators) ---");
        customSortingDemo();

        System.out.println("\n--- Notification Filtering (Predicate lambdas) ---");
        notificationFilteringDemo();

        System.out.println("\n--- Method References Demo ---");
        methodReferencesDemo();
    }

    // 1. Smart Home Lighting Automation
    interface LightBehavior {
        void activate();
    }

    static void smartHomeDemo() {
        // Define behaviors with lambdas
        LightBehavior motionDetected = () -> {
            System.out.println("Motion detected: Turning on full brightness and warm color.");
        };

        LightBehavior nightTime = () -> {
            System.out.println("Night time: Dimming lights to 20% and cool color.");
        };

        LightBehavior voiceCommand = () -> {
            System.out.println("Voice command: Executing user-selected scene (reading).");
        };

        // Simulate triggers
        List<LightBehavior> triggers = Arrays.asList(motionDetected, nightTime, voiceCommand);
        triggers.forEach(LightBehavior::activate);
    }

    // 2. Custom Sorting in E-Commerce
    static void customSortingDemo() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 950.0, 4.5, 10));
        products.add(new Product("Headphones", 120.0, 4.8, 30));
        products.add(new Product("Smartphone", 700.0, 4.4, 5));
        products.add(new Product("Monitor", 200.0, 4.6, 15));

        System.out.println("Original: " + products);

        // Sort by price ascending
        products.sort(Comparator.comparingDouble(p -> p.price));
        System.out.println("Sorted by price: " + products);

        // Sort by rating descending
        products.sort((a,b) -> Double.compare(b.rating, a.rating));
        System.out.println("Sorted by rating (desc): " + products);

        // Sort by discount descending using Comparator.comparing with lambda
        products.sort(Comparator.comparingDouble((Product p) -> p.discount).reversed());
        System.out.println("Sorted by discount (desc): " + products);
    }

    // 3. Notification Filtering
    static void notificationFilteringDemo() {
        List<Alert> alerts = Arrays.asList(
            new Alert("Temp spike in ICU", "CRITICAL", 9),
            new Alert("New appointment scheduled", "INFO", 2),
            new Alert("Battery low on device", "WARNING", 5),
            new Alert("Routine check completed", "INFO", 1)
        );

        // Create predicates based on user preference (demonstration)
        Predicate<Alert> showOnlyCritical = a -> "CRITICAL".equals(a.type);
        Predicate<Alert> severityAboveFive = a -> a.severity >= 5;

        System.out.println("All alerts: " + alerts);
        System.out.println("Critical alerts: " + alerts.stream().filter(showOnlyCritical).collect(Collectors.toList()));
        System.out.println("Severity >= 5: " + alerts.stream().filter(severityAboveFive).collect(Collectors.toList()));
    }

    // Method References
    static void methodReferencesDemo() {
        // 1. Patient ID printing using method reference
        List<String> patientIds = Arrays.asList("P001","P002","P003");
        System.out.println("Patient IDs:");
        patientIds.forEach(System.out::println); // method reference to println

        // 2. Name uppercasing using String::toUpperCase
        List<String> names = Arrays.asList("alice","bob","charlie");
        List<String> upper = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("Uppercase names: " + upper);

        // 3. Invoice object creation using constructor reference
        List<String> txIds = Arrays.asList("INV1001","INV1002","INV1003");
        List<Invoice> invoices = txIds.stream().map(Invoice::new).collect(Collectors.toList());
        System.out.println("Created invoices: " + invoices);
    }
}

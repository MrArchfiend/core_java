/*
 Vehicle Rental System
 - Abstract Vehicle, subclasses Car/Bike/Truck
 - Interface Insurable
 - Demonstrates encapsulation and polymorphism
*/
import java.util.*;

public class Project3_VehicleRentalSystem {
    public static abstract class Vehicle {
        private String vehicleNumber;
        private String type;
        private double rentalRate;

        public Vehicle(String vehicleNumber, String type, double rentalRate) {
            this.vehicleNumber = vehicleNumber;
            this.type = type;
            this.rentalRate = rentalRate;
        }

        public String getVehicleNumber() { return vehicleNumber; }
        public String getType() { return type; }
        public double getRentalRate() { return rentalRate; }

        public void setRentalRate(double rate) {
            if (rate < 0) throw new IllegalArgumentException("Invalid rate");
            this.rentalRate = rate;
        }

        public abstract double calculateRentalCost(int days);
    }

    public interface Insurable {
        double calculateInsurance();
        String getInsuranceDetails();
    }

    public static class Car extends Vehicle implements Insurable {
        public Car(String num, double rate) { super(num,"Car",rate); }

        @Override
        public double calculateRentalCost(int days) { return getRentalRate() * days; }

        @Override
        public double calculateInsurance() { return 1500.0; }

        @Override
        public String getInsuranceDetails() { return "Car insurance fixed: 1500"; }
    }

    public static class Bike extends Vehicle implements Insurable {
        public Bike(String num, double rate) { super(num,"Bike",rate); }

        @Override
        public double calculateRentalCost(int days) { return getRentalRate() * days * 0.6; }

        @Override
        public double calculateInsurance() { return 500.0; }

        @Override
        public String getInsuranceDetails() { return "Bike insurance fixed: 500"; }
    }

    public static class Truck extends Vehicle {
        public Truck(String num, double rate) { super(num,"Truck",rate); }

        @Override
        public double calculateRentalCost(int days) { return getRentalRate() * days * 1.5; }
    }

    public static void main(String[] args) {
        List<Vehicle> fleet = Arrays.asList(
            new Car("KA01AB1234", 2500),
            new Bike("KA02XY987", 800),
            new Truck("KA03TR555", 4000)
        );

        for (Vehicle v : fleet) {
            int days = 3;
            double rental = v.calculateRentalCost(days);
            double insurance = (v instanceof Insurable) ? ((Insurable)v).calculateInsurance() : 0.0;
            System.out.println(v.getType() + " " + v.getVehicleNumber() + " | Rental for " + days + " days: " + rental + " | Insurance: " + insurance);
            if (v instanceof Insurable) System.out.println(((Insurable)v).getInsuranceDetails());
        }
    }
}

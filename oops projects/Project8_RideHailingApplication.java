/*
 Ride-Hailing Application (simplified)
 - Abstract Vehicle with subclasses Car/Bike/Auto
 - Interface GPS
*/
import java.util.*;

public class Project8_RideHailingApplication {
    public static abstract class Vehicle {
        private String vehicleId;
        private String driverName;
        private double ratePerKm;

        public Vehicle(String vehicleId, String driverName, double ratePerKm) {
            this.vehicleId = vehicleId;
            this.driverName = driverName;
            this.ratePerKm = ratePerKm;
        }

        public String getVehicleId() { return vehicleId; }
        public String getDriverName() { return driverName; }
        public double getRatePerKm() { return ratePerKm; }

        public void setRatePerKm(double rate) {
            if (rate < 0) throw new IllegalArgumentException("Rate negative");
            this.ratePerKm = rate;
        }

        public abstract double calculateFare(double distance);

        public String getVehicleDetails() {
            return String.format("%s (%s) Driver: %s", vehicleId, this.getClass().getSimpleName(), driverName);
        }
    }

    public interface GPS {
        String getCurrentLocation();
        void updateLocation(String newLocation);
    }

    public static class Car extends Vehicle implements GPS {
        private String location = "Unknown";
        public Car(String id, String driver, double rate) { super(id, driver, rate); }

        @Override
        public double calculateFare(double distance) { return getRatePerKm() * distance; }

        @Override
        public String getCurrentLocation() { return location; }

        @Override
        public void updateLocation(String newLocation) { this.location = newLocation; }
    }

    public static class Bike extends Vehicle implements GPS {
        private String location = "Unknown";
        public Bike(String id, String driver, double rate) { super(id, driver, rate); }

        @Override
        public double calculateFare(double distance) { return getRatePerKm() * distance * 0.6; }

        @Override
        public String getCurrentLocation() { return location; }

        @Override
        public void updateLocation(String newLocation) { this.location = newLocation; }
    }

    public static class Auto extends Vehicle implements GPS {
        private String location = "Unknown";
        public Auto(String id, String driver, double rate) { super(id, driver, rate); }

        @Override
        public double calculateFare(double distance) { return getRatePerKm() * distance * 0.8; }

        @Override
        public String getCurrentLocation() { return location; }

        @Override
        public void updateLocation(String newLocation) { this.location = newLocation; }
    }

    public static void main(String[] args) {
        List<Vehicle> pool = Arrays.asList(
            new Car("V100","Amit",15),
            new Bike("V200","Ritu",8),
            new Auto("V300","Sunil",10)
        );

        double distance = 12.5;
        for (Vehicle v : pool) {
            System.out.println(v.getVehicleDetails() + " | Fare for " + distance + " km: " + v.calculateFare(distance));
            if (v instanceof GPS) {
                ((GPS)v).updateLocation("MG Road");
                System.out.println("Location: " + ((GPS)v).getCurrentLocation());
            }
        }
    }
}

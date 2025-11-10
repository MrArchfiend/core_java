/*
 Employee Management System
 - Abstract class Employee
 - Subclasses: FullTimeEmployee, PartTimeEmployee
 - Interface: Department
 - Demonstrates encapsulation, polymorphism
*/
import java.util.*;

public class Project1_EmployeeManagement {
    // Abstract Employee
    public static abstract class Employee {
        private String employeeId;
        private String name;
        private double baseSalary;

        public Employee(String employeeId, String name, double baseSalary) {
            this.employeeId = employeeId;
            this.name = name;
            this.baseSalary = baseSalary;
        }

        public String getEmployeeId() { return employeeId; }
        public String getName() { return name; }
        public double getBaseSalary() { return baseSalary; }

        public void setName(String name) {
            if (name == null || name.isBlank()) throw new IllegalArgumentException("Invalid name");
            this.name = name;
        }

        public void setBaseSalary(double baseSalary) {
            if (baseSalary < 0) throw new IllegalArgumentException("Salary cannot be negative");
            this.baseSalary = baseSalary;
        }

        public abstract double calculateSalary();

        public void displayDetails() {
            System.out.println("ID: " + employeeId + ", Name: " + name + ", Salary: " + calculateSalary());
        }
    }

    // Full-time employee
    public static class FullTimeEmployee extends Employee {
        private double fixedSalary;

        public FullTimeEmployee(String id, String name, double baseSalary, double fixedSalary) {
            super(id, name, baseSalary);
            this.fixedSalary = fixedSalary;
        }

        public double getFixedSalary() { return fixedSalary; }
        public void setFixedSalary(double fixedSalary) {
            if (fixedSalary < 0) throw new IllegalArgumentException("Invalid fixed salary");
            this.fixedSalary = fixedSalary;
        }

        @Override
        public double calculateSalary() {
            return getBaseSalary() + fixedSalary;
        }
    }

    // Part-time employee (paid by hours)
    public static class PartTimeEmployee extends Employee {
        private double hourlyRate;
        private int hoursWorked;

        public PartTimeEmployee(String id, String name, double baseSalary, double hourlyRate, int hoursWorked) {
            super(id, name, baseSalary);
            this.hourlyRate = hourlyRate;
            this.hoursWorked = hoursWorked;
        }

        public double getHourlyRate() { return hourlyRate; }
        public int getHoursWorked() { return hoursWorked; }

        public void setHoursWorked(int hours) {
            if (hours < 0) throw new IllegalArgumentException("Hours can't be negative");
            this.hoursWorked = hours;
        }

        @Override
        public double calculateSalary() {
            return getBaseSalary() + hourlyRate * hoursWorked;
        }
    }

    // Department interface
    public interface Department {
        void assignDepartment(String deptName);
        String getDepartmentDetails();
    }

    // Demo usage
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        FullTimeEmployee f1 = new FullTimeEmployee("FT100","Asha",10000,5000);
        PartTimeEmployee p1 = new PartTimeEmployee("PT200","Ravi",2000,150,40);

        employees.add(f1);
        employees.add(p1);

        // Polymorphism: using Employee reference
        for (Employee e : employees) {
            e.displayDetails();
        }

        // Department example via anonymous class
        Department hr = new Department() {
            private String name;
            public void assignDepartment(String deptName) { this.name = deptName; }
            public String getDepartmentDetails() { return "Dept: " + name; }
        };
        hr.assignDepartment("Human Resources");
        System.out.println(hr.getDepartmentDetails());
    }
}

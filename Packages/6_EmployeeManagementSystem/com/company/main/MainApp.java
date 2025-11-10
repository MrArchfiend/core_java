package com.company.main;
import com.company.hr.Employee;
import com.company.payroll.Payroll;
public class MainApp {
    public static void main(String[] args) {
        Employee e = new Employee(101, "Ravi", "HR", 50000);
        Payroll p = new Payroll();
        p.calculateBonus(e);
        System.out.println("Employee: " + e.getName() + ", New Salary: " + e.getSalary());
    }
}
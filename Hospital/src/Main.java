package com.hospital;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Patient Patient = new Patient("P1", "John Doe", 35, "9876543210");

        Doctor Doctor = new Doctor("D1", "Dr. Smith", "Cardiology");

        Appointment appointment = new Appointment("A1", Patient, Doctor, new Date());

        IReportGenerator report = new ReportGenerator(Patient);
        report.generateReport();

        IReportGenerator data = new AppointmentReport(appointment);
        data.generateReport();
    }
}
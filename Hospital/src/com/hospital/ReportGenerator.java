package com.hospital;

public class ReportGenerator implements IReportGenerator {
    private Patient Patient;

    public ReportGenerator(Patient Patient) {
        this.Patient = Patient;
    }

    @Override
    public void generateReport() {
        System.out.println("----- Patient Report -----");
        System.out.println("ID: " + Patient.getPatientId());
        System.out.println("Name: " + Patient.getName());
        System.out.println("Age: " + Patient.getAge());
        System.out.println("Contact: " + Patient.getContactNumber());
    }
}

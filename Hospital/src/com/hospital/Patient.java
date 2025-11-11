package com.hospital;

public class Patient {
    private String patientId;
    private String name;
    private int age;
    private String contactNumber;

    public Patient(String patientId, String name, int age, String contactNumber) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    @Override
    public String toString() {
        return patientId + " " + name + " " + age + " " + contactNumber;
    }
}
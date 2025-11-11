package com.hospital;

public class Doctor {
    private String doctorID;
    private String name;
    private String specialisation;

    public Doctor(String doctorID, String name, String specialisation) {
        this.doctorID = doctorID;
        this.name = name;
        this.specialisation = specialisation;
    }

    public String getName() {
        return name;
    }
    public String getSpecialisation() {
        return specialisation;
    }

    @Override
    public String toString() {
        return doctorID + " " + name + " " + specialisation;
    }
}

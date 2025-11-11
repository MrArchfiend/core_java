package com.hospital;

import java.util.Date;

public class Appointment {
    private String appointmentID;
    private Doctor Doctor;
    private Patient Patient;
    private Date appointmentDate;

    public Appointment(String appointmentID, Doctor Doctor, Patient Patient, Date appointmentDate) {
        this.appointmentID = appointmentID;
        this.Doctor = Doctor;
        this.Patient = Patient;
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public String toString() {
        return appointmentID + " " + Doctor + " " + Patient + " " + appointmentDate;
    }
}

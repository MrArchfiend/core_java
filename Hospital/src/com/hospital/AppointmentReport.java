package com.hospital;

public class AppointmentReport implements IReportGenerator {

    private Appointment appointment;

    public AppointmentReport(Appointment appointment) {
        this.appointment = appointment;
    }

    @Override
    public void generateReport() {
        System.out.println(appointment.toString());
    }
}

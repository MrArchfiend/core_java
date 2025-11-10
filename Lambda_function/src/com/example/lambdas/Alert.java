package com.example.lambdas;

public class Alert {
    public String message;
    public String type; // e.g., "CRITICAL", "INFO", "WARNING"
    public int severity; // 1-10

    public Alert(String message, String type, int severity) {
        this.message = message;
        this.type = type;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return String.format("Alert[type=%s,severity=%d,message=%s]", type, severity, message);
    }
}

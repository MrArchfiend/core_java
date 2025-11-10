/*
 Hospital Patient Management
 - Abstract Patient; subclasses InPatient and OutPatient
 - Interface MedicalRecord
*/
import java.util.*;

public class Project7_HospitalPatientManagement {
    public static abstract class Patient {
        private String patientId;
        private String name;
        private int age;

        public Patient(String patientId, String name, int age) {
            this.patientId = patientId;
            this.name = name;
            this.age = age;
        }

        public String getPatientId() { return patientId; }
        public String getName() { return name; }
        public int getAge() { return age; }

        public String getPatientDetails() {
            return patientId + " - " + name + " (" + age + ")";
        }

        public abstract double calculateBill();
    }

    public interface MedicalRecord {
        void addRecord(String record);
        List<String> viewRecords();
    }

    public static class InPatient extends Patient implements MedicalRecord {
        private int daysAdmitted;
        private double perDayRate;
        private List<String> records = new ArrayList<>();

        public InPatient(String id, String name, int age, int days, double perDayRate) {
            super(id,name,age);
            this.daysAdmitted = days;
            this.perDayRate = perDayRate;
        }

        @Override
        public double calculateBill() {
            return daysAdmitted * perDayRate + 2000; // fixed treatment fees
        }

        @Override
        public void addRecord(String record) { records.add(record); }

        @Override
        public List<String> viewRecords() { return Collections.unmodifiableList(records); }
    }

    public static class OutPatient extends Patient implements MedicalRecord {
        private double consultationFee;
        private List<String> records = new ArrayList<>();

        public OutPatient(String id, String name, int age, double consultationFee) {
            super(id,name,age);
            this.consultationFee = consultationFee;
        }

        @Override
        public double calculateBill() { return consultationFee; }

        @Override
        public void addRecord(String record) { records.add(record); }

        @Override
        public List<String> viewRecords() { return Collections.unmodifiableList(records); }
    }

    public static void main(String[] args) {
        List<Patient> patients = Arrays.asList(
            new InPatient("P100","Sita",30,5,2500),
            new OutPatient("P200","Kumar",40,500)
        );

        for (Patient p : patients) {
            System.out.println(p.getPatientDetails() + " | Bill: " + p.calculateBill());
            if (p instanceof MedicalRecord) {
                ((MedicalRecord)p).addRecord("Initial checkup notes");
                System.out.println("Records: " + ((MedicalRecord)p).viewRecords());
            }
        }
    }
}

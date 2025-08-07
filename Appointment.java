package PatientProgram;

import java.time.LocalDateTime;

public class Appointment {
    private Patient patient;
    private LocalDateTime dateTime;

    //
    public Appointment() {}

    // constructor
    public Appointment(Patient patient, LocalDateTime dateTime) {
        this.patient = patient;
        this.dateTime = dateTime;
    }

    // Getters and Setters
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

        @Override
    public String toString() {
        String patientStr= (patient == null) ? "No Patient" : patient.toString();
        return "Appointment [Patient= "+ patientStr +", Time= "+dateTime+" ]";	
    }
}
        


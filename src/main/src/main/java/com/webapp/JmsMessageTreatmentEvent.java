package com.webapp;


//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
//import com.webapp.TreatmentType;
import org.primefaces.shaded.json.JSONObject;



import java.time.LocalDateTime;

public class JmsMessageTreatmentEvent {
    private TreatmentType type;
    //  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    // private LocalDateTime treatmentTime;
    private String patientName;
    private String patientSurname;
    private double dose;
    private String status;
    private String cancelReason;

    private String name;

    public JmsMessageTreatmentEvent() {
    }

    public JmsMessageTreatmentEvent(String patientName, String patientSurname, TreatmentType type,
                                    double dose, String status, String cancelReason, String name) {
        this.patientName = patientName;
        this.patientSurname = patientSurname;
        this.type = type;
        //    this.treatmentTime = treatmentTime;
        this.dose = dose;
        this.status = status;
        this.cancelReason = cancelReason;
        this.name = name;
    }

    public TreatmentType getType() {
        return type;
    }

    public void setType(TreatmentType type) {
        this.type = type;
    }

//    public LocalDateTime getTreatmentTime() {
//        return treatmentTime;
//    }
//
//    public void setTreatmentTime(LocalDateTime treatmentTime) {
//        this.treatmentTime = treatmentTime;
//    }

    public double getDose() {
        return dose;
    }

    public void setDose(double dose) {
        this.dose = dose;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }
}
package ru.vlsu.lab5.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Record {
    private int idRecord;
    private Date date;
    private String doctor;
    private Integer patientId;
    private Patient patientByPatientId;

    @Id
    @Column(name = "id_record")
    public int getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(int idRecord) {
        this.idRecord = idRecord;
    }

    @Basic
    @Column(name = "Date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "Doctor")
    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    @Basic
    @Column(name = "patient_id")
    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return idRecord == record.idRecord &&
                Objects.equals(date, record.date) &&
                Objects.equals(doctor, record.doctor) &&
                Objects.equals(patientId, record.patientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRecord, date, doctor, patientId);
    }

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id_patient")
    public Patient getPatientByPatientId() {
        return patientByPatientId;
    }

    public void setPatientByPatientId(Patient patientByPatientId) {
        this.patientByPatientId = patientByPatientId;
    }
}

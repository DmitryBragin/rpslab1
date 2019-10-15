package ru.vlsu.lab5.entity;

import ru.vlsu.lab5.listener.UserListener;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@EntityListeners(UserListener.class)
public class Patient {
    private int idPatient;
    private String surname;
    private String name;
    private String patronymic;
    private Integer phoneNumber;
    private Collection<Record> recordsByIdPatient;

    @Id
    @Column(name = "id_patient")
    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    @Basic
    @Column(name = "Surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Patronymic")
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Basic
    @Column(name = "Phone_number")
    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return idPatient == patient.idPatient &&
                Objects.equals(surname, patient.surname) &&
                Objects.equals(name, patient.name) &&
                Objects.equals(patronymic, patient.patronymic) &&
                Objects.equals(phoneNumber, patient.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPatient, surname, name, patronymic, phoneNumber);
    }

    @OneToMany(mappedBy = "patientByPatientId")
    public Collection<Record> getRecordsByIdPatient() {
        return recordsByIdPatient;
    }

    public void setRecordsByIdPatient(Collection<Record> recordsByIdPatient) {
        this.recordsByIdPatient = recordsByIdPatient;
    }
}

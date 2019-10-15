package ru.vlsu.lab5.bean;

public class Patient {
    public Patient(int id_patient, String surname, String name, String patronymic, int phone_number) {
        this.id_patient = id_patient;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.phone_number = phone_number;
    }

    private int id_patient;
    private String surname;
    private String name;
    private String patronymic;
    private int phone_number;

    @Override
    public String toString(){
        return String.valueOf(id_patient + " " + surname + " " + name + " " + patronymic + " " + phone_number);
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

}

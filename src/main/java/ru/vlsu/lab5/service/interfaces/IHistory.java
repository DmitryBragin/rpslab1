package ru.vlsu.lab5.service.interfaces;

import ru.vlsu.lab5.bean.Patient;

import javax.ejb.Remote;
import java.util.ArrayList;

@Remote
public interface IHistory {
    ArrayList<Patient> getHistory();
    void addHistory(Patient patient);
}
package ru.vlsu.lab5.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import ru.vlsu.lab5.bean.Patient;
import ru.vlsu.lab5.service.interfaces.IHistory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import java.util.ArrayList;

@Scope(value= WebApplicationContext.SCOPE_SESSION)
@Stateful
@Component
public class History implements IHistory {
    private static ArrayList<Patient> history;

    @Override
    public ArrayList<Patient> getHistory() {
        return history;
    }

    @Override
    public void addHistory(Patient patient) {
        history.add(patient);
    }

    @PostConstruct
    public void initHistory() {
        history = new ArrayList<>();
        System.out.println("History initialized !");
    }
    @PreDestroy
    public void preDestroyHistory(){
        history = null;
        System.out.println("History destroyed");
    }
}


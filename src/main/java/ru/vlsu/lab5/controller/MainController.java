package ru.vlsu.lab5.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import ru.vlsu.lab5.bean.Patient;
import ru.vlsu.lab5.service.MainService;

import java.util.ArrayList;


@Controller
@Scope(value= WebApplicationContext.SCOPE_SESSION)
public class MainController {

    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/")
    public String getIndex(@RequestParam(name="text",required = false,defaultValue = "")String text, Model model) {
        ArrayList<Patient> patients = mainService.getAllPatients();
        model.addAttribute("patients", patients);
        model.addAttribute("history",mainService.getHistory());
        model.addAttribute("text",text);
        model.addAttribute("message",mainService.getMessage());
        return "index";
    }

    /*@GetMapping(value = "/add")
    public String getAdd() {
        return "add";
    }*/

    /*@PostMapping(value = "/add")
    public ModelAndView postAdd(Patient patient) {
        String text = (mainService.createPatient(patient)) ? "Success" : "Fail";
        return new ModelAndView("redirect:/?text=" + text);
    }*/


   /* @GetMapping(value = "/up/{id}")
    public String getUpdate(@PathVariable(value = "id")int id,Model model){
        Patient patient = mainService.getPatientById(id);
        model.addAttribute("patient",patient);
        return "update";
    }

    @PostMapping(value = "up/{id}")
    public ModelAndView postUpdate(@PathVariable(value = "id")int id,Patient patient){
        patient.setId_patient(id);
        mainService.updatePatient(patient);
        return new ModelAndView("redirect:/");
    }*/

}

/*
@Controller
public class MainController {

    @RequestMapping("/")
    public ModelAndView helloWorld() throws SQLException {
        PatientDAO pdao = new PatientDAO();
        ArrayList list = pdao.getAll();
        return new ModelAndView("index", "PatientsList", list);
    }

    @RequestMapping(value ="/add", method = RequestMethod.POST)
    public ModelAndView helloWorld1(Patient patient) throws SQLException {
        PatientDAO pdao = new PatientDAO();
        pdao.create(patient.getId_patient(),patient.getSurname(),patient.getName(),patient.getPatronymic(),patient.getPhone_number());
        return new ModelAndView("add");
    }

    @RequestMapping(value ="/add", method = RequestMethod.GET)
    public ModelAndView helloWorld1() throws SQLException {
        return new ModelAndView("add");
    }
}
*/


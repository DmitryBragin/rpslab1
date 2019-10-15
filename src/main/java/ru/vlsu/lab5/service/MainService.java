package ru.vlsu.lab5.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import ru.vlsu.lab5.bean.Patient;
import ru.vlsu.lab5.service.interfaces.IConnect;
import ru.vlsu.lab5.service.interfaces.IHistory;
import ru.vlsu.lab5.service.interfaces.ISingle;

import javax.ejb.EJB;
import javax.persistence.*;
import java.sql.*;
import java.util.ArrayList;

@Service
@Scope(value= WebApplicationContext.SCOPE_SESSION)
public class MainService {
    @EJB
    private IHistory iHistory;
    @EJB
    private ISingle iSingle;

    @PersistenceContext
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    EntityManager em=factory.createEntityManager();

    public ArrayList<Patient> getAllPatients() {
        ArrayList<Patient> result;
        Query query = em.createQuery("select a from Patient a ");
        result = (ArrayList<Patient>)query.getResultList();
        return result;
    }

    /*public Patient getPatientById(int id) {
        Query query = em.createQuery("select a from Patient a where a.idPatient=:id")
        .setParameter("id", id);
        return (Patient)query.getSingleResult();
    }

    public void updatePatient(Patient patient) {
        Query query = em.createQuery("update Patient a set a.surname = ?1, a.name=?2, a.patronymic=?3, a.phoneNumber=?4 where a.idPatient=?5");

    }*/

    public ArrayList<Patient> getHistory() {
        return iHistory.getHistory();
    }

    public String getMessage() {
        return iSingle.getMessage();
    }

    /*@EJB
    private IConnect iConnect;
    @EJB
    private IHistory iHistory;
    @EJB
    private ISingle iSingle;

    public ArrayList<Patient> getAllPatients() {
        ArrayList<Patient> result = new ArrayList<>();
        try {
            Connection conn = iConnect.getConnect();
            Statement statement = conn.createStatement();
            String sql = " select * from lab2.Patient;";

            ResultSet rs = statement.executeQuery(sql);
            iConnect.closeConnect(conn);
            while (rs.next()) {
                result.add(new Patient(rs.getInt(1), rs.getString(2), rs.getString(3),  rs.getString(4), rs.getInt(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Patient getPatientById(int id) {
        Patient patient = null;
        try {
            Connection conn = iConnect.getConnect();
            PreparedStatement statement = conn.prepareStatement("select * from lab2.Patient where id_patient=?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            iConnect.closeConnect(conn);
            while (rs.next())
                patient = new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }

    public boolean createPatient(Patient patient) {
        boolean flag = false;
        try {
            Connection conn = iConnect.getConnect();
            PreparedStatement statement = conn.prepareStatement("insert into lab2.Patient values(?,?,?,?,?)");
            int i = 1;
            statement.setInt(i++, patient.getId_patient());
            statement.setString(i++, patient.getSurname());
            statement.setString(i++, patient.getName());
            statement.setString(i++, patient.getPatronymic());
            statement.setInt(i, patient.getPhone_number());
            flag = (statement.executeUpdate() > 0);
            iConnect.closeConnect(conn);
            iHistory.addHistory(patient);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public void updatePatient(Patient patient) {
        try {
            Connection conn = iConnect.getConnect();
            PreparedStatement statement = conn.prepareStatement("update lab2.Patient set Surname = ?, Name=?, Patronymic=?, Phone_number=? where id_patient=?");
            int i = 1;
            statement.setString(i++, patient.getSurname());
            statement.setString(i++, patient.getName());
            statement.setString(i++, patient.getPatronymic());
            statement.setInt(i++, patient.getPhone_number());
            statement.setInt(i, patient.getId_patient());
            statement.executeUpdate();
            iConnect.closeConnect(conn);
            iHistory.addHistory(patient);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Patient> getHistory() {
        return iHistory.getHistory();
    }

    public String getMessage() {
        return iSingle.getMessage();
    }*/
}

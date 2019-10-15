package ru.vlsu.lab5.dao;

import ru.vlsu.lab5.bean.Patient;

import java.sql.*;
import java.util.ArrayList;

public class PatientDAO {
/*
    Connection connection;

    public PatientDAO() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab2", "root", "020332");
    }

    public String create(int id, String surname, String name, String patronymic, int phone)throws SQLException{
        try {
            PreparedStatement preparedstat = connection.prepareStatement("insert into Patient values (?,?,?,?,?)");
            preparedstat.setInt(1, id);
            preparedstat.setString(2, surname);
            preparedstat.setString(3, name);
            preparedstat.setString(4, patronymic);
            preparedstat.setInt(5, phone);
            preparedstat.executeUpdate();
            return "Create successful";
        }
        catch (SQLException ex) {
            return "Duplicate entry" + id + " for key 'PRIMARY'";
        }
    }

    public ArrayList<Patient> getAll() throws SQLException{
        String sql = "select * from Patient";
        ArrayList<Patient> list = new ArrayList<Patient>();
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setId_patient(rs.getInt("id_patient"));
                patient.setSurname(rs.getString("surname"));
                patient.setName(rs.getString("name"));
                patient.setPatronymic(rs.getString("patronymic"));
                patient.setPhone_number(rs.getInt("phone_number"));
                list.add(patient);
            }
        }
        return list;
    }
*/
}

package com.Library_management;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmpruntsDAO {
    private DBConnection dbConnection;

   public EmpruntsDAO() {

    }

    public EmpruntsDAO(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }


    // gerer les emprunts
    public List<Emprunts> getAllEmprunts() throws SQLException {
        Connection conn = dbConnection.getConnection();

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM emprunts");
        List<Emprunts> list = new ArrayList<Emprunts>();
        return list;
    }


    public void addEmprunts(Emprunts emprunts) throws SQLException {
        String sql = "INSERT INTO EMPRUNTS ( id_book, id_member, date_emprunt, date_retourprevue, date_retoureffective) VALUES (?,?,?,?,?)";
        try (PreparedStatement  statement = dbConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, emprunts.getId_book());
            statement.setInt(2, emprunts.getId_member());
            statement.setDate(3, Date.valueOf(emprunts.getDate_emprunt()));
            statement.setDate(4, Date.valueOf(emprunts.getDateRetourPrevue()));
            statement.setDate(5, Date.valueOf(emprunts.getDateRetourEffective()));
            // Executer la requete et gerer les eventuelles exceptions

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Emprunts not inserted");
            }

        }
    }

}
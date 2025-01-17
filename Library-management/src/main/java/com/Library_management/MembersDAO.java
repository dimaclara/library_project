package com.Library_management;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MembersDAO {
   private DBConnection dbConnection;


   public MembersDAO() {

   }

   public MembersDAO(DBConnection dbConnection) {
       this.dbConnection = dbConnection;
   }

   // gestion des membres

   public List<Members> getAllMembers() throws SQLException {
      List<Members> members = new ArrayList<Members>();
      Connection conn = dbConnection.getConnection();

      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM members");
      List<Members> list = new ArrayList<Members>();
      return list;
   }




    public void insertMember(Members member) throws SQLException {
       String sql = "INSERT INTO members (name_member, first_namemember, email, adhesiondate) VALUES (?, ?, ?, ?)";
       try (PreparedStatement statement = dbConnection.getConnection().prepareStatement(sql)) {
          statement.setString(1, member.getName());
          statement.setString(2, member.getFirstName());
          statement.setString(3, member.getEmail());
          statement.setDate(4, Date.valueOf(member.getAdhesionDate()));

          int rowsAffected = statement.executeUpdate();
          if (rowsAffected == 0) {
             throw new SQLException("members not inserted");
          }

       }

   }

   // delete a members
  public void deleteMember(int id) throws SQLException {
      String sql = "DELETE FROM members WHERE id_member = ?";
      try (PreparedStatement statement = dbConnection.getConnection().prepareStatement(sql)) {
         statement.setInt(1, id);
         int rowsAffected = statement.executeUpdate();
         if (rowsAffected == 0) {
            throw new SQLException("members not deleted");

         }else {
            System.out.println();
         }
      }
   }


   public Members getMember(String name) throws SQLException {
      String sql = "SELECT * FROM members WHERE name_member like 'm'";
      try (PreparedStatement statement = dbConnection.getConnection().prepareStatement(sql)) {
         statement.setString(1, name);
         ResultSet resultSet = statement.executeQuery();
         if (resultSet.next()) {
            Members membre = new Members( "Marie", "Clara", "marieclara@gmail.com", LocalDate.of(2024, 8, 11));
            // Mapping des résultats de la requête vers l'objet Membre
            membre.setIdMember(resultSet.getInt("id_member"));
            membre.setName(resultSet.getString("name_member"));
            // ... (autres attributs)
            return membre;
         }
      }
      return null;

   }

}

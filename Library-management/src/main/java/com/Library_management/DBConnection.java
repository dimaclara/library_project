package com.Library_management;

import java.sql.*;
import java.sql.SQLException;
import java.util.List;

public class DBConnection {


    private static Connection con;

    DBConnection() {}


        public static  Connection getConnection() throws SQLException{
            if(con == null || con.isClosed()) {
                // chargement du Driver

                try {
                    Class.forName("org.postgresql.Driver");

                    System.out.println("Connected to database");


                }catch (ClassNotFoundException e){
                   throw new SQLException(e.getMessage());
                }
                // etablir la connection

                con = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/library",
                        "postgres",
                        "#Michel2015.");

            }
            return con;
        }


    }




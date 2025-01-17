package com.Library_management;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Members {
    private int idMember;
    private String name;
    private String firstName;
    private String email;
    private LocalDate adhesionDate;

    // constructeur de la Classe Members

    public Members( String name, String firstName, String email, LocalDate adhesionDate){

        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.adhesionDate = adhesionDate;


    }


    // getters et setters du  IdMembers

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    // getter et setters du name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // getters and setters du firstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // getters et setters du email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // getters and setters
    public LocalDate getAdhesionDate() {
        return adhesionDate;
    }
    public void setAdhesionDate(LocalDate adhesionDate) {
        this.adhesionDate = adhesionDate;

    }

    // Liste statique pour stocker tous les membres (à remplacer par une base de données)
    private static List<Members> members = new ArrayList<>();
    //private static int dernierId = 0;

    // creation de la methode inscrire les membres

    public static void inscrireNouveauMembre(Members member) {
        members.add(member);
        System.out.println("Membre inscrit avec succès : " + member.name + " " + member.firstName);
    }


}



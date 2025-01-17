package com.Library_management;

import java.time.LocalDate;

public class Emprunts {

    private int id_emprunt;
    private int id_book;
    private int id_member;
    private LocalDate date_emprunt;
    private LocalDate dateRetourPrevue;
    private LocalDate dateRetourEffective;

    // contructeurs

    public Emprunts(int id_emprunt, int id_book, int id_member,LocalDate date_emprunt, LocalDate dateRetourPrevue, LocalDate dateRetourEffective){
        this.id_emprunt = id_emprunt;
        this.id_book = id_book;
        this.id_member = id_member;
        this.date_emprunt = date_emprunt;
        this.dateRetourPrevue = dateRetourPrevue;

        this.dateRetourEffective = dateRetourEffective;
    }

    public Emprunts() {

    }

    // define a setters and getters

    public int getId_emprunt() {
        return id_emprunt;
    }

    public void setId_emprunt(int id_emprunt) {
        this.id_emprunt = id_emprunt;
    }

    public int getId_book() {
        return id_book;
    }
    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public int getId_member() {
        return id_member;
    }
    public void setId_member(int id_member) {
        this.id_member = id_member;
    }


    public LocalDate getDate_emprunt() {
        return date_emprunt;
    }
    public void setDate_emprunt(LocalDate date_emprunt) {
        this.date_emprunt = date_emprunt;

    }

    public LocalDate getDateRetourPrevue() {
        return dateRetourPrevue;
    }


    public void setDateRetourPrevue(LocalDate dateRetourPrevue) {
        this.dateRetourPrevue = dateRetourPrevue;
    }

    public LocalDate getDateRetourEffective() {
        return dateRetourEffective;
    }

    public void setDateRetourEffective(LocalDate dateRetourEffective) {

        this.dateRetourEffective = dateRetourEffective;
    }





}

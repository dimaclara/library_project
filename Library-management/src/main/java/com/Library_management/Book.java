package com.Library_management;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

 @Getter
 @Setter
 @ToString
 /*@AllArgsConstructor*/

public class Book  {
    private String title, author, categorie;
    private int id,numberExemplaire;

        // contructeur Book

     public Book(){

     }

     public Book( String title,String author, String categorie, int numberExemplaire) {

         this.title = title;
         this.author = author;
         this.categorie = categorie;
         this.numberExemplaire = numberExemplaire;
     }

     // Getter pour le titre


     public int getId() {
         return id;
     }
     public void setId(int id) {
         this.id = id;
     }

     public String getTitle() {
         return title;
     }
      public void setTitle(String title) {
         this.title = title;
      }

     // getter pour l'author
     public String getAuthor() {
         return author;
     }

     public void setAuthor(String author) {
         this.author = author;
     }
    //
     public String getCategorie() {
         return categorie;
     }

     public void setCategorie(String categorie) {
         this.categorie = categorie;
     }

     public int getNumberExemplaire() {
         return numberExemplaire;
     }

     public void setNumberExemplaire(int numberExemplaire) {
         this.numberExemplaire = numberExemplaire;
     }

     @Override
     public String toString(){
         return "Title : " + title + ",Author :" + author  + ",Year :"  + numberExemplaire ;
     }
 }







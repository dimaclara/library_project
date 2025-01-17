package com.Library_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import  java.util.Scanner;



@SpringBootApplication
public class LibraryManagementApplication {

	public static void main(String[] args) throws SQLException {
		DBConnection dbConnection = new DBConnection();
		EmpruntsDAO empruntsDAO = new EmpruntsDAO(dbConnection);

		Book book = new Book();
		BookDAO bookDAO = new BookDAO(dbConnection);
		MembersDAO membersDAO = new MembersDAO(dbConnection);



		// creation d'un nouvel emprunt
		Emprunts emprunts = new Emprunts(4, 3, 2, LocalDate.of(2024, 11, 2), LocalDate.of(2024, 11, 12), LocalDate.of(2024, 11, 27));
		emprunts.setId_member(1);
		emprunts.setId_book(2);
		emprunts.setDate_emprunt(emprunts.getDate_emprunt());
		emprunts.setDateRetourPrevue(emprunts.getDateRetourPrevue());


		// creation d'une intance de EmpruntDAo

		EmpruntsDAO empruntsDAO1 = new EmpruntsDAO(dbConnection);

		// ajouter l'emprunt a la base
		empruntsDAO1.addEmprunts(emprunts);


		Scanner sc = new Scanner(System.in);
		int choixUtilisateur = -1;
		while (choixUtilisateur != 10) {
			System.out.println("Bienvenue dans le système de gestion de bibliothèque !");
			System.out.println("1. Ajouter un livre");
			System.out.println("2. Rechercher un livre par titre ");
			System.out.println("3. rechercher tous les livres diponibles ");
			System.out.println("4. Inscrire un membre");
			System.out.println("5.supprimer un membre");
			System.out.println("6. Rechercher un membre par nom ");
			System.out.println("7. enregistrer un emprunt");
			System.out.println("8. gerer le retour d'un emprunt");
			System.out.println("9. calculer les penalités en cas de retard");
			System.out.println("10. Quitter");


			try {
				System.out.println("Faite votre choix : ");
				choixUtilisateur = Integer.parseInt(sc.nextLine());

				switch (choixUtilisateur) {
					case 1:
						System.out.println("Entrez le titre : ");
						String title = sc.nextLine();
						System.out.println("Entrez l'auteur : ");
						String author = sc.nextLine();
						System.out.println("Entrez le genre : ");
						String categorie = sc.nextLine();
						System.out.println(" Entrez le nombre d'exemplaires : ");
						int numberexemplaire = Integer.parseInt(sc.nextLine());
						Book books = new Book(title,author,categorie,numberexemplaire);
						try{
							 bookDAO.AddBook(books);

								System.out.println("book added successfully");


						}catch (SQLException e){
							System.out.println("book not added successfully");

						}

						break;
						case 2:
							System.out.println("Entrez le titre  du livre a rechercher: ");
							String titleOfBook = sc.nextLine();
							System.out.println("Entrez l'auteur : ");
							String authorOfBook = sc.nextLine();
							//
							try {
								  bookDAO.SearchTitle(book);

									System.out.println("Book restaure.");
							}catch (SQLException e) {
								System.out.println("Livres t :");
							}
							break;

					   case 3:

						System.out.println("la liste de tous les livres disponible: ");
						   List<Book> allBooks = bookDAO.displayAllBook();
						   if (allBooks.isEmpty()) {
							   System.out.println("Aucun livre trouvé dans la base de données.");
						   } else {
							   for (Book book1 : allBooks) {
								   System.out.println("   Titre : " + book1.getTitle());
								   System.out.println("   Auteur : " + book1.getAuthor());
								   System.out.println("   Catégorie : " + book1.getCategorie());
								   System.out.println("   Nombre d'exemplaires : " + book1.getNumberExemplaire());
								   System.out.println();
							   }

						   }


						 /*try {
							 bookDAO.displayAllBook();
						 }catch (SQLException e){
							 	System.out.println("Livres t :");
						 }*/

						break;

					  case 4:
						System.out.println("bienvenu dans le menu d'ajout des membres ");
						System.out.println("Entrer le nom du membre");
						String name_member = sc.nextLine();
						System.out.println("Entrez le firstName du membre : ");
						String first_namemember = sc.nextLine();
						System.out.println("Entrez l'email du membre : ");
						String email = sc.nextLine();
						System.out.println("Entrez la date d'adhesion du membre : ");
						try{
							LocalDate adhesiondate = LocalDate.parse(sc.nextLine());
							Members members = new Members(name_member,first_namemember,email, adhesiondate);

							// appel a la fonction d'insertion
							try{
								membersDAO.insertMember(members);
								System.out.println("Member added successfully");
							}catch (SQLException e){
								System.out.println("Error while adding member");
							}

						}catch (DateTimeParseException e) {
							System.out.println("Format de date incorrect. Veuillez utiliser le format AAAA-MM-JJ.");
						}

						break;


					case 5:
						System.out.println("menu suppression d'un membre...");
						System.out.println("Entrer l'Id du membre a supprimé");
						int id = Integer.parseInt(sc.nextLine());
						try {
							membersDAO.deleteMember(id);
							System.out.println("membre deleted successfully");
						}catch (SQLException e){
							System.out.println("Error while deleting member");
						}





						break;

					case 6:
						System.out.println("Au revoir !");
						return;


					default:
						System.out.println("choix invalide");

				}

			} catch (Exception e) {

				System.out.println(" Veuillez entrer un nombre.");
				sc.next(); // Effacer l'entrée non valide
			}


		}

		sc.close();


	}
}
















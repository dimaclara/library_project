package com.Library_management;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private DBConnection dbConnection;

    public BookDAO(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public List<Book> getAllEmprunts() throws SQLException {
        Connection conn = dbConnection.getConnection();

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM book");
        List<Book> list = new ArrayList<Book>();
        return list;
    }


    // recuperer livre par son ID
    Book getBookById(int id) throws SQLException {

        String sql = "SELECT * FROM books WHERE id = 3";
        try (PreparedStatement statement = dbConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));

                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // inserer des livres

    public void AddBook(Book book) throws SQLException {
        String sql = "INSERT INTO book (title, author,categorie, numberexemplaire) VALUES (?,?,?,?)";
        try (PreparedStatement statement = dbConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getCategorie());
            statement.setInt(4, book.getNumberExemplaire());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
 // methode de recherche un livre par titre
    public void SearchTitle(Book book) throws SQLException {
        String sql = "SELECT * FROM book WHERE title LIKE ?";
        try (PreparedStatement statement = dbConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, "%" + book.getTitle() + "%");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                ResultSet resultSet1 = statement.executeQuery();
                List<Book> books = new ArrayList<>();

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    // methode d'affichage de tous les livres
    /*Connection conn = dbConnection.getConnection();

      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM members");
      List<Members> list = new ArrayList<Members>();
      return list;*/

    public  List<Book>  displayAllBook() throws SQLException {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM book";

        try (PreparedStatement statement = dbConnection.getConnection().prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setCategorie(resultSet.getString("categorie"));
                book.setNumberExemplaire(resultSet.getInt("numberexemplaire"));
                list.add(book);

            }

        }catch (SQLException e){
            e.printStackTrace();
        }




        return list;
    }


    // faire une mise a jour des livres
     void updateBook(Book book) throws SQLException {
        String sql = "UPDATE books SET title = ?, author = ? WHERE id = ?";
        try (PreparedStatement statement = dbConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getId());
            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

     }


     // delete the book are not present in library
     void deleteBook(Book book) throws SQLException {
        String sql = "DELETE FROM books WHERE id = ?";
        try (PreparedStatement statement = dbConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, book.getId());
            statement.executeUpdate();

        }


     }

}

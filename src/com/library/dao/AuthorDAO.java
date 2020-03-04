package com.library.dao;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

import com.library.model.Author;

public class AuthorDAO {

  private Connection connection;

  // constructor
  // read props from file
  // connect to db
  public AuthorDAO() throws Exception {
    Class.forName("com.mysql.jdbc.Driver");

    // get db properties
    Properties props = new Properties();
    props.load(new FileInputStream("connection.properties"));

    String username = props.getProperty("username");
    String password = props.getProperty("password");
    String dbUrl = props.getProperty("dbUrl");

    // connect to the db
    connection = DriverManager.getConnection(dbUrl, username, password);

    System.out.println("DB Connected Successfully to " + dbUrl);
  }

  // get all authors from database
  public ArrayList<Author> getAllAuthors() throws Exception {
    ArrayList<Author> authors = new ArrayList<>();
    Statement stm = null;
    ResultSet res = null;

    try {
      stm = connection.createStatement();
      res = stm.executeQuery("SELECT * from authors");

      while (res.next()) {
        Author tempAuthor = convertRowToAuthor(res);
        authors.add(tempAuthor);
      }
      return authors;
    } finally {
      close(stm, res);
    }
  }

  // convert result set to Author
  private Author convertRowToAuthor(ResultSet res) throws SQLException {
    String id = res.getString("authorId");
    String firstName = res.getString("firstName");
    String lastName = res.getString("lastName");

    Author tempAuthor = new Author(id, lastName, firstName);
    return tempAuthor;
  }

  // close connection
  private static void close(Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException {

    if (myRs != null) {
      myRs.close();
    }

    if (myStmt != null) {

    }

    if (myConn != null) {
      myConn.close();
    }
  }

  private void close(Statement myStmt, ResultSet myRs) throws SQLException {
    close(null, myStmt, myRs);
  }

  public static void main(String[] args) throws Exception {

    AuthorDAO dao = new AuthorDAO();
    System.out.println(dao.getAllAuthors());
  }
}
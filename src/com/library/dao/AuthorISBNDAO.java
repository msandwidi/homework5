package com.library.dao;

import com.library.model.Author;
import com.library.model.AuthorISBN;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class AuthorISBNDAO {

  private Connection connection;

  // constructor
  // read props from file
  // connect to db
  public AuthorISBNDAO() throws Exception {
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

  // get all author isbns from database
  public ArrayList<AuthorISBN> getAllAuthorISBNs() throws Exception {
    ArrayList<AuthorISBN> isbns = new ArrayList<>();
    Statement stm = null;
    ResultSet res = null;

    try {
      stm = connection.createStatement();
      res = stm.executeQuery("SELECT * from authorisbns");

      while (res.next()) {
        AuthorISBN temp = convertRowToAuthorISBN(res);
        isbns.add(temp);
      }
      return isbns;
    } finally {
      close(stm, res);
    }
  }

  // convert result set to AuthorISBN
  private AuthorISBN convertRowToAuthorISBN(ResultSet res) throws SQLException {
    String authorId = res.getString("authorId");
    String isbn = res.getString("isbn");

    AuthorISBN temp = new AuthorISBN(authorId, isbn);
    return temp;
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

    AuthorISBNDAO dao = new AuthorISBNDAO();
    System.out.println(dao.getAllAuthorISBNs());
  }
}
package com.library.dao;

import com.library.model.Author;
import com.library.model.Title;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class TitleDAO {

  private Connection connection;

  // constructor
  // read props from file
  // connect to db
  public TitleDAO() throws Exception {
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

  // get all titles from database
  public ArrayList<Title> getAllTitles() throws Exception {
    ArrayList<Title> titles = new ArrayList<>();
    Statement stm = null;
    ResultSet res = null;

    try {
      stm = connection.createStatement();
      res = stm.executeQuery("SELECT * from titles");

      while (res.next()) {
        Title temp = convertRowToTitle(res);
        titles.add(temp);
      }
      return titles;
    } finally {
      close(stm, res);
    }
  }

  // convert result set to Author
  private Title convertRowToTitle(ResultSet res) throws SQLException {
    String isbn = res.getString("isbn");
    String title = res.getString("title");
    String editionNumber = res.getString("editionnumber");
    String copyRight = res.getString("copyright");

    Title temp = new Title(isbn, title, editionNumber, copyRight);
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

    TitleDAO dao = new TitleDAO();
    System.out.println(dao.getAllTitles());
  }
}
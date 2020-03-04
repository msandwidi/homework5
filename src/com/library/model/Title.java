package com.library.model;

public class Title {
  private String ISBN;
  private String title;
  private String editionNumber;
  private String copyRight;

  public Title(String ISBN, String title, String editionNumber, String copyRight) {
    this.ISBN = ISBN;
    this.title = title;
    this.editionNumber = editionNumber;
    this.copyRight = copyRight;
  }

  //get title ISBN
  public String getISBN() {
    return this.ISBN;
  }

  //get title title
  public String getTitle() {
    return this.title;
  }

  //get title edition number
  public String getEditionNumber() {
    return this.editionNumber;
  }

  //get title copyright
  public String getCopyRight() {
    return this.copyRight;
  }

}
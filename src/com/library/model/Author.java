package com.library.model;

public class Author {
  private String authorId;
  private String firstName;
  private String lastName;

  public Author(String authorId, String firstName, String lastName) {
    this.authorId = authorId;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  //get author id
  public String getAuthorId() {
    return this.authorId;
  }

  //get first name of the autor
  public String getFirstName() {
    return this.firstName;
  }

  //get last name of the author
  public String getLastName() {
    return this.lastName;
  }

  //get full name of the author
  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }
}
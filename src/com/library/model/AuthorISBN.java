package com.library.model;

public class AuthorISBN {
  private String authorId;
  private String ISBN;

  public AuthorISBN(String authorId, String ISBN) {
    this.authorId = authorId;
    this.ISBN = ISBN;
  }

  //get author id
  public String getAuthorId(){
    return this.authorId;
  }

  // get ISBN
  public String getISBN() {
    return this.ISBN;
  }
}
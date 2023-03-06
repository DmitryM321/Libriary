package com.skypro.libriary.entity;

//@Entity
//@Table(name = "book", schema = "public")
public class Book {
    private String bookTitle;
    private String bookAuthor;
    private Integer bookYear;
    private String isbn;
    public Book() {
    }
    public Book(String bookTitle, String bookAuthor, int bookYear, String isbn) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
        this.isbn = isbn;
    }
    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookYear() {
        return bookYear;
    }

    public void setBookYear(Integer bookYear) {
        this.bookYear = bookYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


}

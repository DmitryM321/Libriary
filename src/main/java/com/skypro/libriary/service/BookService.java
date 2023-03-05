package com.skypro.libriary.service;

import com.skypro.libriary.entity.Book;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface BookService {
    void addBook(Book Book);
    void updateBook(Book Book);
    void deleteBook(String isbn);
    List<Book> getBooks();
    Book getBookByIsbn(String isbn);
}

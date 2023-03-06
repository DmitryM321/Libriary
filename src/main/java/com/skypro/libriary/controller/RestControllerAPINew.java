package com.skypro.libriary.controller;

import com.skypro.libriary.entity.Book;
import com.skypro.libriary.service.BookService;
import com.skypro.libriary.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/skypro")  // поменять??
public class RestControllerAPINew {
    private BookService bookService;
    public RestControllerAPINew(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/api/book")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }
    @PostMapping("/api/book")
    public Book addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return book;
    }
    @PutMapping("/api/book")
    public Book updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
        return book;
    }
    @DeleteMapping("/api/book")
    public String deleteBook(@RequestParam String isbn) {
        bookService.deleteBook(isbn);
        return "Book with isbn " + isbn + " was terminated";
    }
}

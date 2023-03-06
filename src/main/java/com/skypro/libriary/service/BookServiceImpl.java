package com.skypro.libriary.service;

import com.skypro.libriary.dao.BookDAO;
import com.skypro.libriary.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;
    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
    @Override
    @Transactional
    public void addBook(Book book) {
        validateBook(book);
        bookDAO.addBook(book);
    }
    @Override
    @Transactional
    public void updateBook(Book book) {
        Book updatedBook = this.bookDAO.getBookByIsbn(book.getIsbn());
        updatedBook.setBookTitle(book.getBookTitle());
        updatedBook.setBookAuthor(book.getBookAuthor());
        updatedBook.setBookYear(book.getBookYear());
        validateBook(updatedBook);
        bookDAO.updateBook(updatedBook);
    }
    @Override
    @Transactional
    public void deleteBook(String isbn) {
        Book book = bookDAO.getBookByIsbn(isbn);
        bookDAO.deleteBook(isbn);
    }
    @Override
    @Transactional
    public List<Book> getBooks() {
        return bookDAO.getBooks();
    }
    @Override
    @Transactional
    public Book getBookByIsbn(String isbn) {
        Book book = bookDAO.getBookByIsbn(isbn);
        return book;
    }
    private boolean validateBook(Book book) {
        String isbn = book.getIsbn();
        String cleandedIsbn = isbn.replaceAll("[\\-\\s]", "");
        if (cleandedIsbn.length() != 13 && !cleandedIsbn.matches("[0-9]+")) {
            throw new RuntimeException("Wrong isbn");
        }
        int sum = 0;
        for (int i = 0; i < cleandedIsbn.length(); i++) {
            int digit = Character.getNumericValue(cleandedIsbn.charAt(i));
            sum += (i % 2 == 0) ? digit : digit * 3;
        }
        int checkDigit = 10 - (sum % 10);
        return checkDigit == Character.getNumericValue(cleandedIsbn.charAt(cleandedIsbn.length()-1));

//
//        if(isbn.length == 10) {
//            for(int i = 0; i < 10; i++) {
//                sum += i * isbn[i]; //asuming this is 0..9, not '0'..'9'
//            }
//            if(isbn[9] == sum % 11) return true;
//        } else if(isbn.length == 13) {
//            for(int i = 0; i < 12; i++) {
//                if(i % 2 == 0) {
//                    sum += isbn[i]; //asuming this is 0..9, not '0'..'9'
//                } else {
//                    sum += isbn[i] * 3;
//                }
//            }
//            if(isbn[12] == 10 - (sum % 10)) return true;
//        }
//        return false;
    }

}


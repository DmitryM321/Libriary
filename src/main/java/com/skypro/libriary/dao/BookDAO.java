package com.skypro.libriary.dao;

import com.skypro.libriary.entity.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository
public class BookDAO {

    private JdbcTemplate jdbcTemplate;

    public BookDAO(@Lazy JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    public void addBook(Book book) {
        jdbcTemplate.update("INSERT INTO books VALUES (?, ?, ?, ?)",
                book.getBookTitle(), book.getBookAuthor(), book.getBookYear(), book.getIsbn());
    }
    public void updateBook(Book book) {
        jdbcTemplate.update("UPDATE books SET title = ?, author = ?, year = ? WHERE isbn = ?",
                book.getBookTitle(), book.getBookAuthor(), book.getBookYear(), book.getIsbn());
    }
    public void deleteBook(String isbn) {
        jdbcTemplate.update("DELETE FROM books WHERE isbn = ?", isbn);
    }
    public List<Book> getBooks() {
        return jdbcTemplate.query("SELECT * FROM books", new BeanPropertyRowMapper<>(Book.class));
    }
    public Book getBookByIsbn(String isbn) {
        return jdbcTemplate.query("SELECT * FROM books WHERE isbn = ?",
                new Object[]{isbn},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }
}

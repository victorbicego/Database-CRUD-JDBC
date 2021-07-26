package com.victorbicego.databasecrud;

import com.victorbicego.databasecrud.mapper.BookRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksRepo {

    public BooksRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final JdbcTemplate jdbcTemplate;

    void initTable() {
        jdbcTemplate.execute(
                "CREATE TABLE IF NOT EXISTS books (" +
                        "id INT NOT NULL AUTO_INCREMENT," +
                        "title VARCHAR(30)," +
                        "author VARCHAR(30)," +
                        "pages INT," +
                        "PRIMARY KEY (id))"
        );
    }

    // CREATE
    void insertBook(Book book) {
        jdbcTemplate.update("INSERT INTO books(title, author, pages) VALUES (?,?,?)",
                book.getTitle(), book.getAuthor(), book.getPages());
    }

    // READ
    List<Book> findAll() {
        return jdbcTemplate.query("SELECT * FROM books", new BookRowMapper());
    }

    // READ
    Book findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM books WHERE id = ?", new BookRowMapper(), id);
    }

    // UPDATE
    void update(Book book) {
        jdbcTemplate.update("UPDATE books SET title = ?, author = ?, pages = ? WHERE id = ?",
                book.getTitle(), book.getAuthor(), book.getPages(), book.getId());
    }

    void deleteById(int id) {
        jdbcTemplate.update("DELETE FROM books WHERE id = ?", id);
    }

}

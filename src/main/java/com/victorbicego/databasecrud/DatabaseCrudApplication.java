package com.victorbicego.databasecrud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseCrudApplication implements CommandLineRunner {

    public DatabaseCrudApplication(BooksRepo booksRepo) {
        this.booksRepo = booksRepo;
    }

    BooksRepo booksRepo;

    public static void main(String[] args) {
        SpringApplication.run(DatabaseCrudApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Initialize Schema if it is necessary
        booksRepo.initTable();

        Book book1 = new Book("Clean Code", "Robert C. Martin", 464);
        Book book2 = new Book("Design Patterns", "Gang of Four", 395);
        Book book3 = new Book("The Pragmatic Programmer", "Thomas David", 460);
        Book book4 = new Book("Refactoring", "Martin Fowler", 448);

        // CREATE
        booksRepo.insertBook(book1);
        booksRepo.insertBook(book2);
        booksRepo.insertBook(book3);
        booksRepo.insertBook(book4);

        // READ
        System.out.println("List with all my books: ");
        for (Book book : booksRepo.findAll()) {
            System.out.println(book);
        }

        System.out.println("--------------------");

        // READ
        Book bookToChange = booksRepo.findById(3);

        // UPDATE
        bookToChange.setAuthor("Thomas David & Hunt Andrew");
        booksRepo.update(bookToChange);

        // READ
        System.out.println("List with all my books: ");
        for (Book book : booksRepo.findAll()) {
            System.out.println(book);
        }

        System.out.println("--------------------");

        // DELETE
        booksRepo.deleteById(1);

        // READ
        System.out.println("List with all my books: ");
        for (Book book : booksRepo.findAll()) {
            System.out.println(book);
        }

    }
}

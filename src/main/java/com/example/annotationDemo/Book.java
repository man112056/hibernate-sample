package com.example.annotationDemo;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "library_books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_title", length = 100, nullable = false)
    private String title;

    @Column(name = "book_author", length = 50)
    private String author;

    @Temporal(TemporalType.DATE)
    private Date publishedDate;

    @Lob
    private String description;

    // Constructors, Getters, and Setters
    public Book() {}

    public Book(String title, String author, Date publishedDate, String description) {
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    

    // Getters and Setters omitted for brevity
}
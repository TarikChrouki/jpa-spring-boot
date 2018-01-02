package com.chrouki.jpaspringboot.model;


import javax.persistence.*;

/**
 * @author Tarik Chrouki on 19/12/17.
 */
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String author;

    protected Book() {
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

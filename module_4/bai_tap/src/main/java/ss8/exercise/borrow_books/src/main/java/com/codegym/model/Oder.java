package com.codegym.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Oder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Date borrowedDate;
    // "list" bắt từ List<Oder> ở class Book
    @ManyToMany(mappedBy = "list", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Book> books;

    public Oder() {
    }

    public Oder(int id, String name, Date borrowedDate, List<Book> books) {
        this.id = id;
        this.name = name;
        this.borrowedDate = borrowedDate;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

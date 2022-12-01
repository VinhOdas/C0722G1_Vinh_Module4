package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int amount;
    private String nameBook;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "book_order",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "oder_id", referencedColumnName = "id"))
    private List<Oder> list;

    public Book() {
    }

    public Book(int id, int amount, String nameBook, List<Oder> list) {
        this.id = id;
        this.amount = amount;
        this.nameBook = nameBook;
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public List<Oder> getList() {
        return list;
    }

    public void setList(List<Oder> list) {
        this.list = list;
    }
}

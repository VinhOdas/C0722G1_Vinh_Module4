package com.vinhodas.dto;

import com.vinhodas.model.Category;

import java.time.LocalDate;

public class BlogDto {
    private Integer id;
    private String name;
    private String author;
    private LocalDate datePublished;
    private String content;
    private Category category;

    public BlogDto() {
    }

    public BlogDto(Integer id, String name, String author, LocalDate datePublished, String content, Category category) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.datePublished = datePublished;
        this.content = content;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(LocalDate datePublished) {
        this.datePublished = datePublished;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

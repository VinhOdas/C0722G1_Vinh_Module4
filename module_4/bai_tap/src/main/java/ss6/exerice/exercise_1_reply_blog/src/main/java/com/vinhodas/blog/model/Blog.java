package com.vinhodas.blog.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String content;
    private String image;
    private Date date;
    private int deleteStatus;
    @ManyToOne
    private Category category;

    public Blog(int id, String name, String content, String image, Date date, int deleteStatus, Category category) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.image = image;
        this.date = date;
        this.deleteStatus = deleteStatus;
        this.category = category;
    }

    public Blog(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog() {
    }

    public Blog(int id, String name, String content, String image, Date date) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.image = image;
        this.date = date;
    }

    public Blog(int id, String name, String content, String image, Date date, int deleteStatus) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.image = image;
        this.date = date;
        this.deleteStatus = deleteStatus;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}


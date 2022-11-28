package com.vinhodas.blog.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int deleteStatus;
    @OneToMany(mappedBy = "category")
    private Set<Blog> blogSet;

    public Set<Blog> getBlogSet() {
        return blogSet;
    }

    public Category(Set<Blog> blogSet) {
        this.blogSet = blogSet;
    }

    public Category(int id, String name, int deleteStatus) {
        this.id = id;
        this.name = name;
        this.deleteStatus = deleteStatus;
    }

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }


    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
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
}

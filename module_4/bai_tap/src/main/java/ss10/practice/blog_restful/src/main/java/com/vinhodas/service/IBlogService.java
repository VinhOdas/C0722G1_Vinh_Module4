package com.vinhodas.service;

import com.vinhodas.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {


    List<Blog> findAll();

    void save(Blog blog);

    Optional<Blog> findById(Integer id);

    List<Blog> findbyName(String searchName);
}

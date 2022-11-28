package com.example.excercise2.service;

import com.example.excercise2.model.Category;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> getListCategory();


    void save(Category category);

    Category findById(int id);

    void remove(int id);
}

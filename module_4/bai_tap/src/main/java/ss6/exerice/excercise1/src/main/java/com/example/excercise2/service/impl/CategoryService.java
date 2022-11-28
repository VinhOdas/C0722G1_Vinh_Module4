package com.example.excercise2.service.impl;

import com.example.excercise2.model.Category;
import com.example.excercise2.repository.CategoryRepository;
import com.example.excercise2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getListCategory() {
        return categoryRepository.getListCategory();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        categoryRepository.deleteCategory(id);
    }
}

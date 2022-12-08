package com.vinhodas.blog.service.impl;

import com.vinhodas.blog.repository.ICategoryRepository;
import com.vinhodas.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
}

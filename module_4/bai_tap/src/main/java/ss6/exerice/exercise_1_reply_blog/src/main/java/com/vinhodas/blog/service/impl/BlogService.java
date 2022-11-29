package com.vinhodas.blog.service.impl;

import com.vinhodas.blog.model.Blog;
import com.vinhodas.blog.repository.IBlogRepository;
import com.vinhodas.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@Service
public class BlogService implements IBlogService {
    @Autowired
   private   IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll((org.springframework.data.domain.Pageable) pageable);
    }
}

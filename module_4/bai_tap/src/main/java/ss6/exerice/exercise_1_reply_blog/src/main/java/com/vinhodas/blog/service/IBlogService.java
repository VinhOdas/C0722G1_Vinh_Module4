package com.vinhodas.blog.service;

import com.vinhodas.blog.model.Blog;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);
}

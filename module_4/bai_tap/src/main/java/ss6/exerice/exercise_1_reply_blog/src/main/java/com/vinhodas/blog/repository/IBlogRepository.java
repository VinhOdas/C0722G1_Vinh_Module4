package com.vinhodas.blog.repository;

import com.vinhodas.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByNameContainingOOrderByDateDesc(Pageable pageable);
}

package com.vinhodas.blog.repository;

import com.vinhodas.blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

}

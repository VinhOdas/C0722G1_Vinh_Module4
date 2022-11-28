package com.example.excercise2.repository;

import com.example.excercise2.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = "select * from Category where delete_status = 0", nativeQuery = true)
    List<Category> getListCategory();

    @Modifying
    @Transactional
    @Query(value = "update category set delete_status = 1  where id = :keyword", nativeQuery = true)
    void deleteCategory(@Param("keyword") int id);
}

package com.vinhodas.repository;

import com.vinhodas.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    List<Blog> findAll(  );
        @Modifying
    @Transactional
    @Query(value = "SELECT * FROM blog  where name like %:keyword%", nativeQuery = true)
    List<Blog> findByName(@Param("keyword") String searchName);
}

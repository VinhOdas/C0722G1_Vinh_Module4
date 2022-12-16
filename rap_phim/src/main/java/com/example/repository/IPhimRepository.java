package com.example.repository;

import com.example.model.Phim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhimRepository extends JpaRepository<Phim, Integer> {
}

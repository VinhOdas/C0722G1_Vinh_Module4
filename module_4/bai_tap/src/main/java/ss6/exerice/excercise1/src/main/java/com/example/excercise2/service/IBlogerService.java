package com.example.excercise2.service;


import com.example.excercise2.model.Bloger;
import com.example.excercise2.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogerService {
    Page<Bloger> findAll(Pageable pageable);

    Bloger findById(int id);

    void save(Bloger bloger);

    void remove(Bloger bloger);

    Page<Bloger> findByName(String nameSearch, Pageable pageable);

}

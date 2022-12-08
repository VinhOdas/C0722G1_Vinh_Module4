package com.example.excercise2.service.impl;


import com.example.excercise2.model.Bloger;
import com.example.excercise2.model.Category;
import com.example.excercise2.repository.BlogerRepository;

import com.example.excercise2.service.IBlogerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogerServiceIplm implements IBlogerService {

    @Autowired
    private BlogerRepository blogerRepository;

    @Override
    public Page<Bloger> findAll(Pageable pageable) {
        return blogerRepository.findAll(pageable);
    }

    @Override
    public Bloger findById(int id) {
        return blogerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Bloger bloger) {
        blogerRepository.save(bloger);
    }

    @Override
    public void remove(Bloger bloger) {
        blogerRepository.delete(bloger);
    }

    @Override
    public Page<Bloger> findByName(String nameSearch, Pageable pageable) {
        return blogerRepository.findAllByNameContainingOrderByDateDesc(nameSearch, pageable);
    }


}

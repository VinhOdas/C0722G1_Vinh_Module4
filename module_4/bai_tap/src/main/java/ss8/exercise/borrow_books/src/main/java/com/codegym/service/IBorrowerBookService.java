package com.codegym.service;

import com.codegym.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBorrowerBookService {
    List<Book> findAllBook();

    Optional<Book> findById(Integer id);


    void save(Book book);
}

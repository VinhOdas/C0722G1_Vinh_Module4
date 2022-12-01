package com.codegym.service.impl;

import com.codegym.model.Book;
import com.codegym.repository.IBorrowerBookRepository;
import com.codegym.service.IBorrowerBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowerBookService implements IBorrowerBookService {
    @Autowired
    IBorrowerBookRepository borrowerBookRepository;

    @Override
    public List<Book> findAllBook() {
        return borrowerBookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return borrowerBookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        borrowerBookRepository.save(book);
    }


}

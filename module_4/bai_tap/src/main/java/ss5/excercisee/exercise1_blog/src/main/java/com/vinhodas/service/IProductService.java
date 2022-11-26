package com.vinhodas.service;

import com.vinhodas.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll( );

    Optional<Product> findById(Integer id);


    void remove(Integer id);

    void add(Product product);



    void edit(Product product);

    List<Product> search(String nameSearch);
}

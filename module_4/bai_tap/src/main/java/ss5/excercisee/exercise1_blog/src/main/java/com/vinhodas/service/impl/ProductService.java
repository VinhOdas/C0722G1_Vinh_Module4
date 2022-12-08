package com.vinhodas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vinhodas.model.Product;
import com.vinhodas.repository.IProductRepository;
import com.vinhodas.service.IProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }


    @Override
    public void remove(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public void add(Product product) {
        productRepository.save(product);
    }


    @Override
    public void edit(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> search(String nameSearch) {
        return null;
    }

//    @Override
//    public List<Product> search(String nameSearch) {
//        return productRepository.search(nameSearch);
//    }
}

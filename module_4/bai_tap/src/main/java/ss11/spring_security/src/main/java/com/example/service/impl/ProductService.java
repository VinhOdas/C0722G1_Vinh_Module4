package com.example.service.impl;

import com.example.model.Product;
import com.example.repository.IProductRepo;
import com.example.service.IProductSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

@Service
public class ProductService implements IProductSerivice {
    @Autowired
    IProductRepo productRepo;
    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }
}

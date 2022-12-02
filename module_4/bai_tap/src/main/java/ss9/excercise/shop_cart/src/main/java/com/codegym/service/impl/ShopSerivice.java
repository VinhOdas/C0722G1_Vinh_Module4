package com.codegym.service.impl;

import com.codegym.model.Shop;
import com.codegym.repository.IShopRepository;
import com.codegym.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopSerivice implements IShopService {
    @Autowired
    IShopRepository shopRepository;

    @Override
    public Optional<Shop> findById(Integer idShop) {
        return shopRepository.findById(idShop);
    }

    @Override
    public List<Shop> findAll() {
        return shopRepository.findAll();
    }
}

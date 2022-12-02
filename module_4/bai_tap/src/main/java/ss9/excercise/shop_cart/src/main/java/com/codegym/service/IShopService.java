package com.codegym.service;

import com.codegym.model.Shop;

import java.util.List;
import java.util.Optional;

public interface IShopService {
    Optional<Shop> findById(Integer idShop);

    List<Shop> findAll();
}

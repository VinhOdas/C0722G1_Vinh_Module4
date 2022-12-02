package com.codegym.repository;

import com.codegym.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IShopRepository extends JpaRepository<Shop, Integer> {

    Optional<Shop> findById(Integer idShop);
}

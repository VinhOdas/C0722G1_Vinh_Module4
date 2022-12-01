package com.codegym.service;

import com.codegym.model.Oder;

import java.util.List;

public interface IOderService {
    void save(Oder oder);

    List<Oder> findAllOder();
}

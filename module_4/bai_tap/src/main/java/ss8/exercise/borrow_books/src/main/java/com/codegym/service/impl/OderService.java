package com.codegym.service.impl;

import com.codegym.model.Oder;
import com.codegym.repository.IOderRepository;
import com.codegym.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OderService implements IOderService {
    @Autowired
    IOderRepository oderRepository;

    @Override
    public void save(Oder oder) {
        oderRepository.save(oder);
    }

    @Override
    public List<Oder> findAllOder() {
        return oderRepository.findAll();
    }
}

package com.example.service.impl;

import com.example.model.Phim;
import com.example.model.SuatChieu;
import com.example.repository.IPhimRepository;
import com.example.repository.ISuatChieuRepository;
import com.example.service.IRapPhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RapPhimService implements IRapPhimService {
    @Autowired
    ISuatChieuRepository suatChieuRepository;
    @Autowired
    IPhimRepository phimRepository;

    @Override
    public List<SuatChieu> findAllSuatChieu() {
        return suatChieuRepository.findAll();
    }

    @Override
    public List<Phim> findAllPhim() {
        return phimRepository.findAll();
    }

    @Override
    public void save(SuatChieu suatChieu) {
        suatChieuRepository.save(suatChieu);
    }
}

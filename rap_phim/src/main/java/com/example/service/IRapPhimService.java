package com.example.service;

import com.example.model.Phim;
import com.example.model.SuatChieu;

import java.util.List;

public interface IRapPhimService {
    List<SuatChieu> findAllSuatChieu();

    List<Phim> findAllPhim();

    void save(SuatChieu suatChieu);
}

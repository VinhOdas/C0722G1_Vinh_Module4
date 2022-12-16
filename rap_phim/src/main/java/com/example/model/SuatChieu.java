package com.example.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SuatChieu {
    @Id
    private String id;
    private String ngayChieu;
    private Integer soLuongVe;
    @Column(columnDefinition = "int default 1")
    private int status = 1;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "ma_phim", referencedColumnName = "id")
    private Phim phim;

    public SuatChieu() {
    }

    public SuatChieu(String id, String ngayChieu, Integer soLuongVe, int status, Phim phim) {
        this.id = id;
        this.ngayChieu = ngayChieu;
        this.soLuongVe = soLuongVe;
        this.status = status;
        this.phim = phim;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(String ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public Integer getSoLuongVe() {
        return soLuongVe;
    }

    public void setSoLuongVe(Integer soLuongVe) {
        this.soLuongVe = soLuongVe;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Phim getPhim() {
        return phim;
    }

    public void setPhim(Phim phim) {
        this.phim = phim;
    }

}

package com.example.dto;

import com.example.model.Phim;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class SuatChieuDto implements Validator {

    @NotBlank(message = "id không được để trống")
    @Pattern(regexp = "[C][I]-[0-9]{4}",
            message = "?")
    @Column(unique = true)
    private String id;
    @NotBlank(message = " không được để trống")
    private String ngayChieu;
    private Integer soLuongVe;
    private Integer status = 1;
    private Phim phim;

    public SuatChieuDto() {
    }

    public SuatChieuDto(  String id, String ngayChieu, Integer soLuongVe, Integer status, Phim phim) {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Phim getPhim() {
        return phim;
    }

    public void setPhim(Phim phim) {
        this.phim = phim;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SuatChieuDto suatChieuDto =(SuatChieuDto) target;
    }
}

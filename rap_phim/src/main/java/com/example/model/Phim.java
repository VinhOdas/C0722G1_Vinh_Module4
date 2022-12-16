package com.example.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Phim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(columnDefinition = "int default 1")
    private int status = 1;
    @OneToMany(mappedBy = "phim")
    Set<SuatChieu> suatChieus;

    public Phim() {
    }

    public Phim(Integer id, String name, int status, Set<SuatChieu> suatChieus) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.suatChieus = suatChieus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<SuatChieu> getSuatChieus() {
        return suatChieus;
    }

    public void setSuatChieus(Set<SuatChieu> suatChieus) {
        this.suatChieus = suatChieus;
    }
}

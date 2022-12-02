package com.codegym.dto;

import java.util.Objects;

public class ShopDTO {
    private Integer id;
    private String name;
    private String image;
    private double price;
    private String description;

    public ShopDTO() {
    }

    public ShopDTO(int id, String name, String image, double price, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopDTO shopDTO = (ShopDTO) o;
        return id == shopDTO.id &&
                Double.compare(shopDTO.price, price) == 0 &&
                Objects.equals(name, shopDTO.name) &&
                Objects.equals(image, shopDTO.image) &&
                Objects.equals(description, shopDTO.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, image, price, description);
    }
}

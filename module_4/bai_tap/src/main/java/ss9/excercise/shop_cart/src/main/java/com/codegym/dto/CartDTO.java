package com.codegym.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDTO {
    private Map<ShopDTO, Integer> shopDTOMap = new HashMap<>();

    public CartDTO() {
    }

    public CartDTO(Map<ShopDTO, Integer> shopDTOMap) {
        this.shopDTOMap = shopDTOMap;
    }

    public Map<ShopDTO, Integer> getShopDTOMap() {
        return shopDTOMap;
    }

    public void setShopDTOMap(Map<ShopDTO, Integer> shopDTOMap) {
        this.shopDTOMap = shopDTOMap;
    }
    public void adđShop(ShopDTO shopDTO){

        if (shopDTOMap.containsKey(shopDTO)){
            Integer currentValue = shopDTOMap.get(shopDTO);
            shopDTOMap.replace(shopDTO, currentValue + 1);
        }
        else {
            shopDTOMap.put(shopDTO, 1);
        }

    }
}

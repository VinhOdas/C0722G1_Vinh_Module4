package com.codegym.controller;

import com.codegym.dto.CartDTO;
import com.codegym.dto.ShopDTO;
import com.codegym.model.Shop;
import com.codegym.service.IShopService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ShopController {

    @ModelAttribute("cart")
    public CartDTO initCart() {
        return new CartDTO();
    }


    @GetMapping("")
    public String showListShop(Model model, @CookieValue(value = "idShop", defaultValue = "-1") Integer idShop) {
        List<Shop> shopList = null;
        if (idShop != -1) {
            model.addAttribute("historyShop", shopService.findById(idShop));
        }
        shopList = shopService.findAll();
        model.addAttribute("shopList", shopList);


        return "shop/list";
    }

    @Autowired
    IShopService shopService;


    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Integer id, @SessionAttribute("cart") CartDTO cartDTO) {
        Optional<Shop> shop = shopService.findById(id);
        ShopDTO shopDTO = new ShopDTO();
        BeanUtils.copyProperties(shop.get(), shopDTO);
        cartDTO.adđShop(shopDTO);

        return "cart/list";
    }


}

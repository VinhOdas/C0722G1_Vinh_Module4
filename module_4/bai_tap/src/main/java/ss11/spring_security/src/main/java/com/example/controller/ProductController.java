package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductSerivice productSerivice;
    @GetMapping("")
    String listProduct(Model model){
        List<Product> productList = productSerivice.findAll();
        model.addAttribute("productList",productList);
        return "list";
    }
}

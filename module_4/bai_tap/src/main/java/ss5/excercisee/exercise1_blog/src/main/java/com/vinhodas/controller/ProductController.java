package com.vinhodas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.vinhodas.model.Product;
import com.vinhodas.service.IProductService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("")
    String showList(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "product/list";
    }

    @GetMapping("/edit")
    String showFormEdit(@RequestParam("id") Integer id, Model model) {
        Optional<Product> product = productService.findById(id);
        model.addAttribute("productEdit", product.get());
        return "product/edit";
    }

    @PostMapping("/edit")
    String edit(Product product, RedirectAttributes redirectAttributes) {
        productService.edit(product);
        return "redirect:/product";

    }

    @GetMapping("/delete")
    String deleteProduct(@RequestParam Integer idDelete, Model model, RedirectAttributes redirectAttributes) {
        productService.remove(idDelete);
        redirectAttributes.addFlashAttribute("mess", "Xoa thanh cong!");
        return "redirect:/product";
    }

    @GetMapping("/add")
    String showListAdd(Model model) {
        model.addAttribute("product", new Product());
        return "product/add";
    }

    @PostMapping("/add")
    String add(Product product,
               RedirectAttributes redirectAttributes) {
        productService.add(product);
        redirectAttributes.addFlashAttribute("mess", "Th??m m???i th??nh c??ng");
        return "redirect:/product";

    }

    @GetMapping("/search")
    String search(@RequestParam("nameSearch") String nameSearch, Model model) {

        List<Product> productList = productService.search(nameSearch);
        model.addAttribute("productList", productList);
        model.addAttribute("nameSearch", nameSearch);
        return "product/list";
    }

}

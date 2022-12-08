package com.codegym.controller;

import com.codegym.dto.CartDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {

    public ModelAndView showCart(@SessionAttribute("cart") CartDTO cartDTO) {
        return new ModelAndView("cart/list", "cart", cartDTO);
    }

}

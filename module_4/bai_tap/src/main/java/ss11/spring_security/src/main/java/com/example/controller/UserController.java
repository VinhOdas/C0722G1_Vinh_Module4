package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/login")
    String loginPage(Model model){
        return "loginUser";
    }
    @GetMapping("/page")
    String showWelcome(){
        return "/page";
    }

}

package com.vinhodas.blog.controller;

import com.vinhodas.blog.model.Blog;
import com.vinhodas.blog.service.IBlogService;
import com.vinhodas.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;

@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @RequestMapping("/blog")
    @GetMapping("list")
    String listBlog(@RequestParam(defaultValue = "") String search, @PageableDefault(page = 0, size = 5)
            Pageable pageable, ModelMap modelMap) {
        Page<Blog> blogPage = blogService.findAll(pageable);
        modelMap.addAttribute("blogPage", blogPage);

        return "blog/list";
    }


}

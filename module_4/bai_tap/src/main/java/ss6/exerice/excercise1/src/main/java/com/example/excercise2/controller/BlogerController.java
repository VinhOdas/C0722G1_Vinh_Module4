package com.example.excercise2.controller;

import com.example.excercise2.model.Bloger;
import com.example.excercise2.model.Category;
import com.example.excercise2.service.IBlogerService;
import com.example.excercise2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.sql.Date;


@Controller
@RequestMapping("/bloger")
public class BlogerController {

    @Autowired
    private IBlogerService blogerService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Bloger());
        modelAndView.addObject("categoryList", categoryService.getListCategory());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView createBlog(@ModelAttribute("blog") Bloger bloger) {
        Date date = new Date(System.currentTimeMillis());
        bloger.setDate(date);
        blogerService.save(bloger);
        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("blog", bloger);
        modelAndView.addObject("categoryList", categoryService.getListCategory());
        modelAndView.addObject("message", "Blog created successfully");
        return modelAndView;
    }

    @GetMapping(value = "/list")
    public ModelAndView showBlogList(@PageableDefault(value = 3) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("blog/index");
        modelAndView.addObject("categoryList", categoryService.getListCategory());
        modelAndView.addObject("blogs", blogerService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showUpdateForm(@PathVariable int id) {
        Bloger bloger = blogerService.findById(id);
        if (bloger != null) {
            ModelAndView modelAndView = new ModelAndView("blog/edit");
            modelAndView.addObject("blog", bloger);
            modelAndView.addObject("categoryList", categoryService.getListCategory());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView update(@ModelAttribute("blog") Bloger bloger) {
        blogerService.save(bloger);
        ModelAndView modelAndView = new ModelAndView("blog/edit");
        modelAndView.addObject("blog", bloger);
        modelAndView.addObject("message", "Updated blog successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        Bloger bloger = blogerService.findById(id);
        if (bloger != null) {
            ModelAndView modelAndView = new ModelAndView("blog/delete");
            modelAndView.addObject("blog", bloger);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-blog")
    public String delete(@ModelAttribute("blog") Bloger bloger) {
        blogerService.remove(bloger);
        return "redirect:blogers";
    }

    @GetMapping("/view-blog/{id}")
    public ModelAndView view(@PathVariable int id) {
        Bloger bloger = blogerService.findById(id);

        if (bloger != null) {
            ModelAndView modelAndView = new ModelAndView("blog/view");
            modelAndView.addObject("blog", bloger);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @GetMapping("search")
    public ModelAndView search(@RequestParam String nameSearch, @PageableDefault(value = 3) Pageable pageable) {
        Page<Bloger> blogers = blogerService.findByName(nameSearch, pageable);
        ModelAndView modelAndView = new ModelAndView("blog/index");
        modelAndView.addObject("blogs", blogers);
        modelAndView.addObject("nameSearch", nameSearch);
        return modelAndView;
    }
    @GetMapping("category")
    public ModelAndView showCategoryList() {
        ModelAndView modelAndView = new ModelAndView("category/listCategory");
        modelAndView.addObject("categorys", categoryService.getListCategory());
        return modelAndView;
    }
    @GetMapping("/create-category")
    public ModelAndView showCreateFormCategory() {
        ModelAndView modelAndView = new ModelAndView("/category/createCategory");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create-category")
    public ModelAndView createCategory(@ModelAttribute("category") Category category) {
        category.setDeleteStatus(0);
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("category/createCategory");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "Category created successfully");
        return modelAndView;
    }
    @GetMapping("/delete-category/{id}")
    public ModelAndView showDeleteFormCategory(@PathVariable int id) {
        Category category = categoryService.findById(id);
        if (category != null) {
            ModelAndView modelAndView = new ModelAndView("category/deleteCategory");
            modelAndView.addObject("category", category);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }
    @PostMapping("/delete-category")
    public String deleteCategory(@ModelAttribute("category") Category category) {
        categoryService.remove(category.getId());
        return "redirect:category";
    }
    @GetMapping("/edit-category/{id}")
    public ModelAndView showEditFormCategory(@PathVariable int id) {
        Category category = categoryService.findById(id);
        if (category != null) {
            ModelAndView modelAndView = new ModelAndView("category/editCategory");
            modelAndView.addObject("category", category);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }
    @PostMapping("/edit-category")
    public ModelAndView editCategory(@ModelAttribute("category") Category category) {
        category.setDeleteStatus(0);
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("category/editCategory");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "Category created successfully");
        return modelAndView;
    }
}

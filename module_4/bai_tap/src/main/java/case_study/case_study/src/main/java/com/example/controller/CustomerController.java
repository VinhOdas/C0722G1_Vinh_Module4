package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.model.Customer;
import com.example.model.CustomerType;
import com.example.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @ModelAttribute("customerTypes")
    public List<CustomerType> getListCustomerTypes() {
        return customerService.findAllCustomerType();
    }

    @GetMapping
    String showList(
            @RequestParam(value = "searchName", defaultValue = "") String searchName,
            @PageableDefault(page = 0, value = 2) Pageable pageable,
            Model model) {
        Page<Customer> customerList = customerService.search(searchName, pageable);
        model.addAttribute("customerList", customerList);
        model.addAttribute("searchName", searchName);
        return "customer/list";
    }

    @GetMapping("/add")
    String showAdd(Model model) {
        model.addAttribute("customerList", new CustomerDto());
        return "customer/add";
    }

    @PostMapping("/add")
    String addDto(@Validated @ModelAttribute("customerList") CustomerDto customerDto,
                  BindingResult bindingResult,
                  Model model) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getErrorCount());
            model.addAttribute("customerList", customerDto);
            model.addAttribute("message", "Add new not success!");
            return "customer/add";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        model.addAttribute("customerList", customerDto);
        model.addAttribute("message", "Add new Successful!");
        return "redirect:/customer";
    }
    @GetMapping("/edit/{id}")
    String showFormEdit(@PathVariable int id, Model model){
        Optional<Customer> customer = customerService.findCustomerById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer.get(),customerDto);
        model.addAttribute("customerDto",customerDto);
        return "customer/edit";
    }
    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("customer/edit");
            modelAndView.addObject("customerDto", customerDto);
            return modelAndView;
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("customerDto", customerDto);
        modelAndView.addObject("message", "Customer edited successfully");
        return modelAndView;
    }


}

package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.model.Customer;
import com.example.model.CustomerType;
import com.example.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @ModelAttribute("customerTypes")
    public List<CustomerType> getListCustomerTypes() {
        return customerService.findAllCustomerType();
    }
    @GetMapping("/customer")
    String showList(
                    @RequestParam(value = "searchName",defaultValue = "") String searchName,
                    @PageableDefault(value = 1) Pageable pageable,
                    Model model){
        Page<Customer> customerList = customerService.search(searchName,pageable);
        model.addAttribute("customerList",customerList);
        return "customer/list";
    }
    @GetMapping("/add")
    String showAdd(Model model){
        model.addAttribute("customerList",new CustomerDto());
        return "customer/add";
    }
    @PostMapping("/add")
    String addDto(@Validated @ModelAttribute("customerList") CustomerDto customerDto,
                  BindingResult bindingResult,
                  Model model){
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getErrorCount());
            model.addAttribute("customerList",customerDto);
            model.addAttribute("message", "Add new not success!");
            return "customer/add";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customerService.save(customer);
        model.addAttribute("customerList",customerDto);
        model.addAttribute("message", "Add new Successful!");
         return "redirect:/customer";
    }



}

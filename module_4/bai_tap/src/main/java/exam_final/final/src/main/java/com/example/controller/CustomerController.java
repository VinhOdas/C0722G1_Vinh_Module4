package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @ModelAttribute("customerTypes")
    public List<CustomerType> getListCustomerTypes() {
        return customerService.findAllCustomerType();
    }
    @GetMapping("")
    public ModelAndView showCustomers(@RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                                      @RequestParam(value = "email", defaultValue = "") String email,
                                      @RequestParam(value = "customerType", defaultValue = "") String customerType,
                                      @PageableDefault(value = 4) Pageable pageable) {
        Page<Customer> customers = customerService.findByNameAndEmailAndCustomerType(nameSearch, email, customerType, pageable);
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customerList", customers);
        modelAndView.addObject("nameSearch", nameSearch);
        modelAndView.addObject("email", email);
        modelAndView.addObject("customerType",customerType);
        return modelAndView;
    }
//    @GetMapping
//    String showList(
//            @RequestParam(value = "searchName", defaultValue = "") String searchName,
//            @PageableDefault(page = 0, value = 6) Pageable pageable,
//            Model model) {
//        Page<Customer> customerList = customerService.search(searchName, pageable);
//        model.addAttribute("customerList", customerList);
//        model.addAttribute("searchName", searchName);
//        return "customer/list";
//    }

    @GetMapping("/add")
    String showAdd(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/add";
    }

    @PostMapping("/add")
    public ModelAndView acceptCreateCustomer(@Validated @ModelAttribute CustomerDto customerDto,
                                             BindingResult bindingResult) {
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("customer/add");
            return modelAndView;
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            ModelAndView modelAndView = new ModelAndView("redirect:/customer");
            modelAndView.addObject("customerDto", customerDto);
            modelAndView.addObject("message", "New customer created successfully");
            return modelAndView;
        }
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editCustomer(@PathVariable int id){
        Optional<Customer> optionalCustomer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        if(!optionalCustomer.isPresent()){
            modelAndView.addObject("message", "Customer not found");
            return modelAndView;
        }
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(optionalCustomer.get(), customerDto);
        List<CustomerType> customerTypeList = customerService.findAllCustomerType();
        modelAndView.addObject("customerDto", customerDto);
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView accepEditCustomer(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("customer/edit");
            return modelAndView;
        } else{
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto,customer);
            customerService.save(customer);
            ModelAndView modelAndView = new ModelAndView("customer/edit");
            modelAndView.addObject("customerDto", customerDto);
            modelAndView.addObject("message", "Customer edited successfully");
            return modelAndView;
        }
    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam(value = "idDelete") int id, RedirectAttributes redirectAttributes){
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("message","Delete customer successfully!");
        return "redirect:/customer";
    }




}

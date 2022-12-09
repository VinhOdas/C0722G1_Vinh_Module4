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

    @GetMapping
    String showList(
            @RequestParam(value = "searchName", defaultValue = "") String searchName,
            @PageableDefault(page = 0, value = 6) Pageable pageable,
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
    String delete(Integer id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer == null) {
            model.addAttribute("message", "Xóa thất bại, không tìm thấy sản phẩm trong danh sách!");
        } else {
            this.customerService.remove(id);
            model.addAttribute("message", "Xóa sản phẩm thành công!");
        }
        return "redirect:/customer";
    }




}

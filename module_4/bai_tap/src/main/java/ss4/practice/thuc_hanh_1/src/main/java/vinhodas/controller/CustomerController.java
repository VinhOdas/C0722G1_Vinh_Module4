package vinhodas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vinhodas.model.Customer;
import vinhodas.service.ICustomerService;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @GetMapping("")
    String showList(Model model){
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customerList",customerList);
        return "customer/list";

    }
    @GetMapping("/edit")
    String showFormEdit(){

    }
}

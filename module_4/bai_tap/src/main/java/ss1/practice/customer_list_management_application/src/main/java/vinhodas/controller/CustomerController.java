package vinhodas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vinhodas.model.Customer;
import vinhodas.service.ICustomerSerice;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    ICustomerSerice customerSerice;

    @RequestMapping("/customers")
    public String showList(Model model) {
        List<Customer> customerList = customerSerice.findAll();
        model.addAttribute("customerList", customerList);
        return "customer/list";
    }

    @RequestMapping(value = "edit")
    public String showFormEdit(Model model) {

        Customer customer = customerSerice.findById();
        List<Customer> customerList = customerSerice.edit();
        return "customer/edit";
    }

}

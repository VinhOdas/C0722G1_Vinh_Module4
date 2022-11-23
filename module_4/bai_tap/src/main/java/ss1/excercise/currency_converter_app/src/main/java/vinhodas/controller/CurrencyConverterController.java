package vinhodas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vinhodas.service.ICurrencyConverterService;

@Controller
public class CurrencyConverterController {
    @Autowired
    ICurrencyConverterService service;
    @GetMapping("")
    public String Curency(){
        return "list";
    }
    @PostMapping
    public ModelAndView change(Model model ,@RequestParam String usd, String rate) {
//        model.addAttribute("usd",usd);
        model.addAttribute("saveUsd",usd);
////        model.addAttribute("rate",rate);
        model.addAttribute("saveRate",rate);
        return new ModelAndView("list", "vnd", service.change(usd, rate));
    }
}

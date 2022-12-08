package vinhodas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vinhodas.service.impl.CalculatorService;

@Controller
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/")
    public String formCal() {
        return "calculator";
    }

    @PostMapping("/calculator")
    public String calculatorNumber(@RequestParam double a,
                                   @RequestParam double b,
                                   @RequestParam String submit,
                                   Model model) {
        double result = calculatorService.addition(a, b, submit);
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("submit", submit);
        model.addAttribute("result", result);
        return "calculator";
    }
}

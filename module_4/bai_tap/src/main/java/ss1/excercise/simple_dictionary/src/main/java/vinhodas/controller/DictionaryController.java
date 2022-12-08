package vinhodas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vinhodas.service.IDictionaryService;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @Autowired
    IDictionaryService dictionaryService;

    @RequestMapping("")
    @PostMapping
    public String showDictionary(Model model, String swap) {
        Map<String, String> stringMap = dictionaryService.translate();
        model.addAttribute("swap", swap);
        model.addAttribute("saveSwap", swap);
        model.addAttribute("translate", stringMap);

        return "list";
    }

}

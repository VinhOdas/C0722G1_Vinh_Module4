package vinhodas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vinhodas.model.Language;
import vinhodas.service.ILanguageService;

import java.util.Arrays;
import java.util.List;

@Controller
public class LanguageController {
    @Autowired
    ILanguageService languageService;
    @GetMapping("/home")
    String showList(Model model){
        List<Language> languageList = languageService.findAll();
        model.addAttribute("languageList",languageList);


        return "language";
    }

    @GetMapping("/edit")
    String showFormEditLanguage(@RequestParam("id") Integer idLanguage, Model model){
        Language language = languageService.findById(idLanguage);
        List<String> stringLanguage = Arrays.asList("Language", "Vietnamese", "Japanese","Chinese");
        List<String> pageSize = Arrays.asList("10","15","20","25");
         model.addAttribute("language",language);
        model.addAttribute("stringLanguage",stringLanguage);
        model.addAttribute("pageSize",pageSize);

        return "edit";
    }
    @PostMapping("/edit")
    String edit(Language language, Integer id, RedirectAttributes redirectAttributes){
        languageService.edit(id, language);

           return "redirect:/home";
    }
}

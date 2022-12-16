package com.example.controller;

import com.example.dto.SuatChieuDto;
import com.example.model.Phim;
import com.example.model.SuatChieu;
import com.example.service.IRapPhimService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping
public class RapPhimController {
    @Autowired
    IRapPhimService rapPhimService;
    @ModelAttribute("phimList")
    public List<Phim> getListPhim() {
        return rapPhimService.findAllPhim();
    }
    @GetMapping
 public String showList(Model model){
        List<SuatChieu> suatChieuList = rapPhimService.findAllSuatChieu();
        List<Phim> phimList = rapPhimService.findAllPhim();
        model.addAttribute("suatChieuList",suatChieuList);
        model.addAttribute("phimList",phimList);
        return "rap_phim/list";
    }
    @GetMapping("/add")
    String addPhim(Model model){
//        List<Phim> phimList = rapPhimService.findAllPhim();
//        model.addAttribute("phimList",phimList);
//        model.addAttribute("phims",new Phim());
        model.addAttribute("suatChieuDto",new SuatChieuDto());

        return "rap_phim/add";
    }
    @PostMapping("/add")
    public ModelAndView acceptAdd(@Validated @ModelAttribute SuatChieuDto suatChieuDto, BindingResult bindingResult){
        new SuatChieuDto().validate(suatChieuDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("rap_phim/add");
            return modelAndView;

        }else {
            SuatChieu suatChieu = new SuatChieu();
            BeanUtils.copyProperties(suatChieuDto,suatChieu);
            rapPhimService.save(suatChieu);
            ModelAndView modelAndView = new ModelAndView("redirect:/");
            modelAndView.addObject("suatChieuDto",suatChieuDto);
//            modelAndView.addObject("phimList",rapPhimService.findAllPhim());
//            modelAndView.addObject("phims",new Phim());
            return modelAndView;
        }

    }
}

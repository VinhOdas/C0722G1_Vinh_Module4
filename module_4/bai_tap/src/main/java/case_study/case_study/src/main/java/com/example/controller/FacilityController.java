package com.example.controller;



import com.example.dto.FacilityDto;
import com.example.model.facility.Facility;
import com.example.model.facility.FacilityType;
import com.example.model.facility.RentType;
import com.example.service.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/facilities")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;

    @ModelAttribute("RentTypeList")
    List<RentType> getRentTypes(){
        return facilityService.findAllRentType();
    }
    @ModelAttribute("facilityTypeList")
    List<FacilityType> getFacilityTypes(){
        return facilityService.findAllFacilityType();
    }
    @GetMapping("")
    public ModelAndView showFacilities(@RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                                       @RequestParam(value = "facilityType", defaultValue = "") String facilityType,
                                       @PageableDefault(value = 3) Pageable pageable) {
        Page<Facility> facilities = facilityService.findAllByNameAndType(nameSearch, facilityType, pageable);

        ModelAndView modelAndView = new ModelAndView("facility/list");
        modelAndView.addObject("facilities", facilities);
        modelAndView.addObject("nameSearch", nameSearch);
        modelAndView.addObject("facilityType", facilityType);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("facility/create");
        modelAndView.addObject("facilityDto", new FacilityDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute @Validated FacilityDto facilityDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("facility/create");
            bindingResult.getErrorCount();
            modelAndView.addObject("facilityTypeId", facilityDto.getFacilityType().getId());
            modelAndView.addObject("facilityDto", facilityDto);
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("facility/create");
        modelAndView.addObject("facilityTypeId", facilityDto.getFacilityType().getId());
        modelAndView.addObject("facilityDto", facilityDto);
        modelAndView.addObject("message", "Add new Successful");
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.save(facility);
        return modelAndView;
    }
    @GetMapping("/edit/{id}/{facilityTypeId}")
    public ModelAndView showFormUpdate(@PathVariable(value = "id") int id,
                                       @PathVariable(value = "facilityTypeId") int facilityTypeId){
        Optional<Facility> optionalFacility = facilityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("facility/edit");
        if(!optionalFacility.isPresent()){
            modelAndView.addObject("message", "Facility is not found");
            return modelAndView;
        }
        FacilityDto facilityDto = new FacilityDto();
        BeanUtils.copyProperties(optionalFacility.get(),facilityDto);
        modelAndView.addObject("facilityDto", facilityDto);
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute @Validated FacilityDto facilityDto, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("facility/edit");
            modelAndView.addObject("facilityDto", facilityDto);
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("facility/edit");
        modelAndView.addObject("facilityDTO", facilityDto);
        modelAndView.addObject("message", "Edit Successful");
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.save(facility);
        return modelAndView;
    }
    @GetMapping("/delete")
    public String deleteFacility(@RequestParam(value = "idDelete") int id, RedirectAttributes redirectAttributes) {
        facilityService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete facility successfully!");
        return "redirect:/facilities";
    }
}
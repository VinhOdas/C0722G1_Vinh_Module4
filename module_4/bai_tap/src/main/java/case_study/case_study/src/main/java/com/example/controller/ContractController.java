package com.example.controller;

import com.example.dto.ContractDetailDto;
import com.example.dto.ContractDto;
import com.example.dto.IContractDto;
import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import com.example.repository.employee.IEmployeeRepository;
import com.example.service.*;
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

@Controller
@RequestMapping("/contracts")
public class ContractController {
    @Autowired
    private IContractSerivice contractSerivice;
    @Autowired
    private IContractDetailService contractDetailService;
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping
    public ModelAndView showContracts(@PageableDefault(value = 4) Pageable pageable) {
        Page<IContractDto> contractDtos = contractSerivice.getListContract(pageable);
        ModelAndView modelAndView = new ModelAndView("contract/list");
        modelAndView.addObject("contractList", contractDtos);
        modelAndView.addObject("attachFacilityList", contractSerivice.findAllAttachFacility());
        modelAndView.addObject("contractDetailList", contractDetailService.findAll());
        modelAndView.addObject("facilityList", facilityService.findAll());
        modelAndView.addObject("customerList", customerService.findAll());
        modelAndView.addObject("employeeList", employeeService.findAll());
        modelAndView.addObject("contractDto", new ContractDto());
        modelAndView.addObject("contractDetailDto", new ContractDetailDto());

        return modelAndView;
    }

    @GetMapping("/add")
    public String getBackList() {
        return "redirect:/contracts";
    }

    @PostMapping("/add")
    public String addContract(@ModelAttribute @Validated ContractDto contractDto,
                              BindingResult bindingResult,
                              Model model, @PageableDefault(value = 3) Pageable pageable,
                              RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()){
        model.addAttribute("contractList", contractSerivice.getListContract(pageable));
        model.addAttribute("attachFacilityList", contractSerivice.findAllAttachFacility());
        model.addAttribute("contractDetailList", contractDetailService.findAll());
        model.addAttribute("facilityList", facilityService.findAll());
        model.addAttribute("employeeList", employeeService.findAll());
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("contractDetailDto", new ContractDetailDto());
        return "contract/list";
    }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        contractSerivice.save(contract);
        redirectAttributes.addFlashAttribute("message","Thêm mới hợp đồng thành công");
    return "redirect:/contracts";

}



}

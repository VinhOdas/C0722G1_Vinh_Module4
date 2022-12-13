package com.example.controller;

import com.example.dto.ContractDetailDto;
import com.example.dto.ContractDto;
import com.example.dto.IContractDto;
import com.example.model.contract.ContractDetail;
import com.example.repository.employee.IEmployeeRepository;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView showContracts(@PageableDefault(value = 4)Pageable pageable){
      Page<IContractDto> contractDtos = contractSerivice.getListContract(pageable);
      ModelAndView modelAndView = new ModelAndView("contract/list");
      modelAndView.addObject("contractList",contractDtos);
      modelAndView.addObject("attachFacilityList", contractSerivice.findAllAttachFacility());
      modelAndView.addObject("contractDetailList",contractDetailService.findAll());
      modelAndView.addObject("facilityList",facilityService.findAll());
      modelAndView.addObject("customerList",customerService.findAll());
      modelAndView.addObject("employeeList",employeeService.findAll());
      modelAndView.addObject("contractDto", new ContractDto());
      modelAndView.addObject("contractDetailDto", new ContractDetailDto());

      return modelAndView;
  }



}

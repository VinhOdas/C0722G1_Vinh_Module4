package com.example.dto;

import com.example.model.contract.ContractDetail;
import com.example.model.customer.Customer;
import com.example.model.employee.Employee;
import com.example.model.facility.Facility;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class ContractDto   {
    private Integer id;
    private String name;
    private String startDate;
    private String endDate;
    private String deposit;
    private int status = 1;
    private Set<ContractDetail> contractDetails;
    @NotNull(message = "Vui lòng chọn")
    private Employee employee;
    @NotNull(message = "Vui lòng chọn")
    private Customer customer;
    @NotNull(message = "Vui lòng chọn")
    private Facility facility;

    public ContractDto() {
    }

    public ContractDto(Integer id, String name, String startDate, String endDate, String deposit, int status, Set<ContractDetail> contractDetails, @NotNull(message = "Vui lòng chọn") Employee employee, @NotNull(message = "Vui lòng chọn") Customer customer, @NotNull(message = "Vui lòng chọn") Facility facility) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.status = status;
        this.contractDetails = contractDetails;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDeposit() {
        return deposit;
    }



    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}

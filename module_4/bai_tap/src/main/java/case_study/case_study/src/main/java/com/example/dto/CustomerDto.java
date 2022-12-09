package com.example.dto;

import com.example.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

public class CustomerDto implements Validator {
    private int id;
    @NotBlank(message = "not empty")
    private String name;
    @NotBlank(message = "not empty")
    private String dateOfBirth;

    private int gender;

    @NotBlank(message = "not empty")
    private String idCard;
    @NotBlank(message = "not empty")
    private String phoneNumber;
    @NotBlank(message = "not empty")
    private String email;
    @NotBlank(message = "not empty")
    private String address;
    private int deleteStatus = 1;
    private CustomerType customerTypeId;

    public CustomerDto() {
    }

    public CustomerDto(int id, @NotBlank(message = "not empty") String name, @NotBlank(message = "not empty") String dateOfBirth, int gender, @NotBlank(message = "not empty") String idCard, @NotBlank(message = "not empty") String phoneNumber, @NotBlank(message = "not empty") String email, @NotBlank(message = "not empty") String address, int deleteStatus, CustomerType customerTypeId) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.deleteStatus = deleteStatus;
        this.customerTypeId = customerTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public CustomerType getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(CustomerType customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        // cấu hình validate
        CustomerDto customerDto = (CustomerDto) target;

    }
}

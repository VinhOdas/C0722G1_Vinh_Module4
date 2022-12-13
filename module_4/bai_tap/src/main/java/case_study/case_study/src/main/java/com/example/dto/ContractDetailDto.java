package com.example.dto;

import com.example.model.contract.AttachFacility;
import com.example.model.contract.Contract;

public class ContractDetailDto {
    private Integer id;
    private Integer quantity;
    private int status = 1;
    private AttachFacility attachFacility;
    private Contract contract;

    public ContractDetailDto() {
    }

    public ContractDetailDto(Integer id, Integer quantity, int status, AttachFacility attachFacility, Contract contract) {
        this.id = id;
        this.quantity = quantity;
        this.status = status;
        this.attachFacility = attachFacility;
        this.contract = contract;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}

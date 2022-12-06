package com.roi.rentalcar.dto;

import lombok.Data;

import java.util.List;

@Data
public class RentalDTO {
    private Long rentalId;
    private String name;
    private String internetDomain;
    private String contactAddress;


    private List<BranchDTO> branches;


    List<CustomerDTO> customers;
}

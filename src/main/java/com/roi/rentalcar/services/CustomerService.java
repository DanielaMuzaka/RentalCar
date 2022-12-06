package com.roi.rentalcar.services;

import com.roi.rentalcar.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO getById(Long id);
    List<CustomerDTO> getAll();
    CustomerDTO create(CustomerDTO customerDTO);
    CustomerDTO update(CustomerDTO customerDTO);
    String delete(Long id);
}

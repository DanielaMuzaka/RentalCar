package com.roi.rentalcar.services;

import com.roi.rentalcar.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO getById(Long id);

    List<EmployeeDTO> getAll();

    EmployeeDTO create(EmployeeDTO employeeDTO);
    EmployeeDTO update(EmployeeDTO employeeDTO);
    String delete(Long id);


}

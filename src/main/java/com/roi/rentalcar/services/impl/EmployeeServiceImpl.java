package com.roi.rentalcar.services.impl;

import com.roi.rentalcar.database.entities.Employee;
import com.roi.rentalcar.database.repositories.EmployeeRepo;
import com.roi.rentalcar.dto.EmployeeDTO;
import com.roi.rentalcar.mappers.EmployeeMapper;
import com.roi.rentalcar.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public EmployeeDTO getById(Long id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() ->
                new RuntimeException("Employee with this id " + id + "does not exists."));
        return employeeMapper.toDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAll() {
        return employeeMapper.toDTOList(employeeRepo.findAll());
    }

    @Override
    public EmployeeDTO create(EmployeeDTO employeeDTO) {
        if (employeeDTO.getEmployeeId() != null) throw new RuntimeException("Id must not be null");
        Employee employee = employeeMapper.toEntity(employeeDTO);
        employeeRepo.save(employee);
        return employeeMapper.toDTO(employee);
    }

    @Override
    public EmployeeDTO update(EmployeeDTO employeeDTO) {
        if (employeeDTO.getEmployeeId() == null) throw new RuntimeException("Id must not be null");
        Employee employee = employeeRepo.findById(employeeDTO.getEmployeeId()).orElseThrow(() ->
                new RuntimeException("Employee with this id " + employeeDTO.getEmployeeId() + "does not exist"));
       employee.setName(employeeDTO.getName());
       employeeRepo.save(employee);
        return employeeMapper.toDTO(employee);
    }

    @Override
    public String delete(Long id) {
        try {
            if (employeeRepo.findById(id).isEmpty())
                throw new RuntimeException("Employee with thid id" + id + "does not exists");
            employeeRepo.deleteById(id);
            return "Employee with the id " + id + "has been deleted";
        } catch (Exception e) {
            return "Something went wrong.Please contact administrator";
        }

    }
}

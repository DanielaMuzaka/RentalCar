package com.roi.rentalcar.mappers;

import com.roi.rentalcar.database.entities.Employee;
import com.roi.rentalcar.dto.EmployeeDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapper implements BaseMapper<Employee, EmployeeDTO>{
    @Override
    public EmployeeDTO toDTO(Employee employee) {
       if(employee==null) return null;
       EmployeeDTO employeeDTO = new EmployeeDTO();
       employeeDTO.setEmployeeId(employee.getEmployeeId());
       employeeDTO.setName(employee.getName());
       return employeeDTO;
    }

    @Override
    public Employee toEntity(EmployeeDTO employeeDTO) {
        if(employeeDTO==null) return null;
        Employee employee = new Employee();
        employee.setEmployeeId(employee.getEmployeeId());
        employee.setName(employee.getName());
        return employee;
    }

    @Override
    public List<EmployeeDTO> toDTOList(List<Employee> e) {
        if(e==null) return null;
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for(Employee employee : e){
            employeeDTOList.add(toDTO(employee));
        }
        return employeeDTOList;
    }

    @Override
    public List<Employee> toEntityList(List<EmployeeDTO> d) {
        if(d==null) return null;
        List<Employee> employeeList = new ArrayList<>();
        for(EmployeeDTO employeeDTO : d){
            employeeList.add(toEntity(employeeDTO));
        }
        return employeeList;
    }
}

package com.roi.rentalcar.Controllers;
import com.roi.rentalcar.dto.EmployeeDTO;
import com.roi.rentalcar.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public EmployeeDTO getById(@RequestParam Long id) {
        return employeeService.getById(id);
    }

    @GetMapping("/all")
    public List<EmployeeDTO> getAll() {
        return employeeService.getAll();
    }

    @PostMapping
    public EmployeeDTO create(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.create(employeeDTO);
    }

    @PutMapping
    public EmployeeDTO update(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.update(employeeDTO);
    }

    @DeleteMapping("/employee/{id}")
    public String delete(@PathVariable Long id) {
        return employeeService.delete(id);
    }
}

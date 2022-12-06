package com.roi.rentalcar.Controllers;

import com.roi.rentalcar.dto.CustomerDTO;
import com.roi.rentalcar.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public CustomerDTO getById(@RequestParam Long id){
        return customerService.getById(id);
    }
    @GetMapping("/all")
    public List<CustomerDTO> getAll(){
        return customerService.getAll();
    }

    @PostMapping
    public CustomerDTO create(@RequestBody CustomerDTO customerDTO){
        return customerService.create(customerDTO);
    }
    @PutMapping
    public CustomerDTO update(@RequestBody CustomerDTO customerDTO){
        return customerService.update(customerDTO);
    }
    @DeleteMapping("/customer/{id}")
    public String delete(@PathVariable Long id){
        return customerService.delete(id);
    }

}

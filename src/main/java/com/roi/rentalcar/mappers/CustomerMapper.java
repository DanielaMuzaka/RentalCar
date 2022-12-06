package com.roi.rentalcar.mappers;

import com.roi.rentalcar.database.entities.Customer;
import com.roi.rentalcar.dto.CustomerDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper implements BaseMapper<Customer, CustomerDTO>{
    @Override
    public CustomerDTO toDTO(Customer customer) {
        if(customer==null) return null;
        CustomerDTO customerDTO=new CustomerDTO();
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setName(customer.getName());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setEmail(customer.getEmail());
        return customerDTO;
    }

    @Override
    public Customer toEntity(CustomerDTO customerDTO) {
       if(customerDTO==null) return null;
       Customer customer = new Customer();
       customer.setCustomerId(customerDTO.getCustomerId());
       customer.setName(customerDTO.getName());
       customer.setEmail(customerDTO.getEmail());
       customer.setAddress(customerDTO.getAddress());
       return customer;
    }

    @Override
    public List<CustomerDTO> toDTOList(List<Customer> e) {
        if(e==null) return null;
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for(Customer customer : e){
            customerDTOList.add(toDTO(customer));
        }
        return customerDTOList;
    }

    @Override
    public List<Customer> toEntityList(List<CustomerDTO> d) {
        if(d==null) return null;
        List<Customer> customerList = new ArrayList<>();
        for(CustomerDTO customerDTO  : d) {
            customerList.add(toEntity(customerDTO));
        }
        return customerList;
    }
}

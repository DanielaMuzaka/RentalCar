package com.roi.rentalcar.services.impl;
import com.roi.rentalcar.database.entities.Customer;
import com.roi.rentalcar.database.repositories.CustomerRepo;
import com.roi.rentalcar.dto.CustomerDTO;
import com.roi.rentalcar.mappers.CustomerMapper;
import com.roi.rentalcar.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public CustomerDTO getById(Long id) {
        Customer customer=customerRepo.findById(id).orElseThrow(()->new RuntimeException("Customer with id " + id + "does not exist"));
return customerMapper.toDTO(customer);
    }

    @Override
    public List<CustomerDTO> getAll() {
        return customerMapper.toDTOList(customerRepo.findAll());

    }


    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        if (customerDTO.getCustomerId()!=null) throw new RuntimeException("Id must be null");
        Customer customer =customerMapper.toEntity(customerDTO);
        customerRepo.save(customer);
        return customerMapper.toDTO(customer);
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO) {
        if (customerDTO.getCustomerId()==null) throw new RuntimeException("Id must not be null");
        Customer customer = customerRepo.findById(customerDTO.getCustomerId()).
                orElseThrow(()->new RuntimeException("Customer with id " + customerDTO.getCustomerId() + "does not exists"));
        customer.setName(customerDTO.getName());
        customer.setAddress(customerDTO.getAddress());
        customer.setEmail(customerDTO.getEmail());
        customerRepo.save(customer);
        return customerMapper.toDTO(customer);
    }

    @Override
    public String delete(Long id) {
        try {
            if (customerRepo.findById(id).isEmpty())
                throw new RuntimeException("Customer with this id" + id + "does not exist");
            customerRepo.deleteById(id);
            return "Customer with this id " + id + "has been deleted.";
        } catch (Exception e){
            return "Something went wrong.Please contact administrator.";
        }
    }
}

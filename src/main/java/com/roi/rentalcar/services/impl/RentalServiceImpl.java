package com.roi.rentalcar.services.impl;

import com.roi.rentalcar.database.entities.Rental;
import com.roi.rentalcar.database.repositories.RentalRepo;
import com.roi.rentalcar.dto.RentalDTO;
import com.roi.rentalcar.mappers.RentalMapper;
import com.roi.rentalcar.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalServiceImpl implements RentalService {
    @Autowired
    private RentalMapper rentalMapper;
    @Autowired
    private RentalRepo rentalRepo;

    @Override
    public RentalDTO getById(Long id) {
        Rental rental = rentalRepo.findById(id).orElseThrow(() ->
                new RuntimeException("The rental with this id" + id + "does not exist"));
        return rentalMapper.toDTO(rental);
    }

    @Override
    public List<RentalDTO> getAll() {
        return rentalMapper.toDTOList(rentalRepo.findAll());
    }

    @Override
    public RentalDTO update(RentalDTO rentalDTO) {
        if (rentalDTO.getRentalId() == null) throw new RuntimeException("Id must not be null");
        Rental rental = rentalRepo.findById(rentalDTO.getRentalId()).orElseThrow(() ->
                new RuntimeException("Rental with this id" + rentalDTO.getRentalId() + "does not exist"));
        if (!rental.getName().toUpperCase().equals(rentalDTO.getName()) ||
                rental.getInternetDomain().toUpperCase().equals(rentalDTO.getInternetDomain().toUpperCase())) {
            rental.setName(rentalDTO.getName());
            rental.setInternetDomain(rentalDTO.getInternetDomain());
            rental.setContactAddress(rentalDTO.getContactAddress());
        }
        rentalRepo.save(rental);
        return rentalMapper.toDTO(rental);
    }

    @Override
    public RentalDTO create(RentalDTO rentalDTO) {
        if (rentalDTO.getRentalId() != null) throw new RuntimeException("Id must be null");
        Rental rental = rentalMapper.toEntity(rentalDTO);
        rentalRepo.save(rental);
        return rentalMapper.toDTO(rental);
    }

    @Override
    public String delete(Long id) {
        try {
            if (rentalRepo.findById(id).isEmpty())
                throw new RuntimeException("The rental with this id " + id + " does not exists");
            rentalRepo.deleteById(id);
            return "The rental with this id " + id + "has been deleted";
        } catch (Exception e) {
            return "Something went wrong.Please contact administrator.";
        }

    }
}

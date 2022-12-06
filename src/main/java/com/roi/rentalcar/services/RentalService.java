package com.roi.rentalcar.services;

import com.roi.rentalcar.dto.RentalDTO;

import java.util.List;

public interface RentalService {
    RentalDTO getById(Long id);
    List<RentalDTO> getAll();
    RentalDTO update(RentalDTO rentalDTO);
    RentalDTO create(RentalDTO rentalDTO);
    String delete(Long id);

}

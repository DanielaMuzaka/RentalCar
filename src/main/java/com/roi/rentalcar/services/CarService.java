package com.roi.rentalcar.services;

import com.roi.rentalcar.dto.CarDTO;

import java.util.List;

public interface CarService {
    CarDTO getById(Long id);
    List<CarDTO> getAll();
    CarDTO create(CarDTO carDTO);
    CarDTO update(CarDTO carDTO);
    String deleteCarDTO(Long id);
}

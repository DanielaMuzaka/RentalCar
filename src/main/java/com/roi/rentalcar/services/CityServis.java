package com.roi.rentalcar.services;

import com.roi.rentalcar.database.repositories.CityRepo;
import com.roi.rentalcar.dto.CityDTO;

import java.util.List;

public interface CityServis {
    CityDTO getById(String id);
    List<CityDTO> getAll();
    CityDTO create(CityDTO cityDTO);
    CityDTO update(CityDTO cityDTO);
    String delete(String id);
}

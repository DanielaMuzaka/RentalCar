package com.roi.rentalcar.services;

import com.roi.rentalcar.dto.UnavailableStatusDTO;

import java.util.List;

public interface UnavailableStatusService {
    UnavailableStatusDTO getById(Long id);
    List<UnavailableStatusDTO> getAll();
    UnavailableStatusDTO update(UnavailableStatusDTO unavailableStatusDTO);
    UnavailableStatusDTO save(UnavailableStatusDTO unavailableStatusDTO);
    String delete(Long id);
}

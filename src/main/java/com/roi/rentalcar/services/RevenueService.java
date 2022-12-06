package com.roi.rentalcar.services;

import com.roi.rentalcar.dto.RevenueDTO;

import java.util.List;

public interface RevenueService {
    RevenueDTO getById(Long id);
    List<RevenueDTO> getAll();
    RevenueDTO update(RevenueDTO revenueDTO);
    RevenueDTO save(RevenueDTO revenueDTO);
    String delete(Long id);

}

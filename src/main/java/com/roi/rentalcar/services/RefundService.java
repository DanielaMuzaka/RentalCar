package com.roi.rentalcar.services;

import com.roi.rentalcar.dto.RefundDTO;

import java.util.List;

public interface RefundService {
    RefundDTO getById(Long id);
    List<RefundDTO> getAll();
    RefundDTO create(RefundDTO refundDTO);
    RefundDTO update(RefundDTO refundDTO);
    String delete(Long id);
}

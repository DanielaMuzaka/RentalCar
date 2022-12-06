package com.roi.rentalcar.services;

import com.roi.rentalcar.database.entities.Branch;
import com.roi.rentalcar.dto.BranchDTO;

import java.util.List;

public interface BranchService {
    BranchDTO getByID(Long id);
    List<BranchDTO> getAll();
    BranchDTO create(BranchDTO branchDTO);

    BranchDTO update(BranchDTO branchDTO);
    String deleteByBranchId(Long id);

}

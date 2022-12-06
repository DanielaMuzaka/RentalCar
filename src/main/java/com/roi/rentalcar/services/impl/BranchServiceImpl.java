package com.roi.rentalcar.services.impl;

import com.roi.rentalcar.database.entities.Branch;
import com.roi.rentalcar.database.entities.Car;
import com.roi.rentalcar.database.repositories.BranchRepo;
import com.roi.rentalcar.dto.BranchDTO;
import com.roi.rentalcar.mappers.BranchMapper;
import com.roi.rentalcar.mappers.CarMapper;
import com.roi.rentalcar.services.BranchService;
import com.roi.rentalcar.static_data.CarStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImpl implements BranchService {
    @Autowired
    private BranchMapper branchMapper;
    @Autowired
    private CarMapper carMapper;
    @Autowired
    private BranchRepo branchRepo;

    @Override
    public BranchDTO getByID(Long id) {
        Optional<Branch> optionalBranch = branchRepo.findById(id);
        if (optionalBranch.isPresent()) {
            Branch branch = optionalBranch.get();
            BranchDTO branchDTO = branchMapper.toDTO(branch);
            if (branch.getCars() != null && !branch.getCars().isEmpty()) {
                int available = 0;
                for (Car car : branch.getCars()) {
                    if (car.getCarStatus().equals(CarStatus.AVAILABLE))
                        available++;
                }
                if (available < 3)
                    branchDTO.setWarning("Warning! Lees than 2 cars are available today");
            }
            branchDTO.setWarning("Warning,less than 2 cars are available today");
            return branchDTO;
        } else throw new RuntimeException("Branch with this id" + id.toString() + "does not exist.");
    }

    @Override
    public BranchDTO create(BranchDTO branchDTO) {
        if (branchRepo.existsBranchByName(branchDTO.getName())) {
            throw new RuntimeException("Branch with name : " + branchDTO.getName() + "alredy exists.");
        }
        Branch branch = branchMapper.toEntity(branchDTO);
        branch = branchRepo.save(branch);
        return branchMapper.toDTO(branch);
    }

    @Override
    public List<BranchDTO> getAll() {
        List<Branch> branches = branchRepo.findAll();
        return branchMapper.toDTOList(branches);
    }

    @Override
    public BranchDTO update(BranchDTO branchDTO) {
        if (branchDTO.getBranchId() == null) throw new RuntimeException("id must not be null");
        Branch branch = branchRepo.findById(branchDTO.getBranchId())
                .orElseThrow(()->new RuntimeException("Branch with id " + branchDTO.getBranchId() + "does not exists"));
        if (!branch.getName().toUpperCase().equals(branchDTO.getName().toUpperCase()) &&
                branchRepo.existsBranchByNameIgnoreCase(branchDTO.getName()))
            throw new RuntimeException("Branch with name " + branchDTO.getName() + "alredy exists");
       branch.setName(branchDTO.getName());
        branchRepo.save(branch);
        return branchMapper.toDTO(branch);
    }

    @Override
    public String deleteByBranchId(Long id) {
        try {
            if (branchRepo.findById(id).isEmpty())
                return "Branch with " + id + "does not exist";
            branchRepo.deleteById(id);
            return "Branch with id " + id + "has been deleted";
        } catch (Exception e) {
            return "something went wrong.Please contact administrator.";
        }
    }
}


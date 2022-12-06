package com.roi.rentalcar.mappers;

import com.roi.rentalcar.database.entities.Branch;
import com.roi.rentalcar.dto.BranchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BranchMapper implements BaseMapper<Branch, BranchDTO> {
    @Autowired
    @Lazy
    private CarMapper carMapper;

    @Override
    public BranchDTO toDTO(Branch branch) {
        BranchDTO branchDTO = new BranchDTO();
        branchDTO.setBranchId(branch.getBranchId());
        branchDTO.setName(branch.getName());
        return branchDTO;
    }

    @Override
    public Branch toEntity(BranchDTO branchDTO) {
        if(branchDTO==null) return null;
        Branch branch= new Branch();
        branch.setBranchId(branchDTO.getBranchId());
        branch.setName(branchDTO.getName());
        return branch;
    }

    @Override
    public List<BranchDTO> toDTOList(List<Branch> e) {
        if(e==null)return null;
        BranchDTO branchDTO = new BranchDTO();
        List<BranchDTO> branchDTOList = new ArrayList<>();
        for(Branch branch : e){
            branchDTOList.add(toDTO(branch));
        }
        return branchDTOList;
    }

    @Override
    public List<Branch> toEntityList(List<BranchDTO> d) {
        if(d==null) return null;
        List<Branch> branchList = new ArrayList<>();
        for(BranchDTO branchDTO : d){
            branchList.add(toEntity(branchDTO));
        }
        return branchList;
    }
}

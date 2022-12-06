package com.roi.rentalcar.mappers;

import com.roi.rentalcar.database.entities.Revenue;
import com.roi.rentalcar.dto.RevenueDTO;

import java.util.ArrayList;
import java.util.List;

public class RevenueMapper implements BaseMapper<Revenue, RevenueDTO>{
    @Override
    public RevenueDTO toDTO(Revenue revenue) {
        if (revenue==null) return null;
        RevenueDTO revenueDTO = new RevenueDTO();
        revenueDTO.setRevenueId(revenue.getRevenueId());
        revenueDTO.setMonth(revenue.getMonth());
        revenueDTO.setAmount(revenue.getAmount());
        return revenueDTO;
    }

    @Override
    public Revenue toEntity(RevenueDTO revenueDTO) {
        if (revenueDTO==null) return null;
        Revenue revenue = new Revenue();
        revenue.setRevenueId(revenueDTO.getRevenueId());
        revenue.setAmount(revenueDTO.getAmount());
        revenue.setMonth(revenue.getMonth());
        return revenue;
    }

    @Override
    public List<RevenueDTO> toDTOList(List<Revenue> e) {
        if (e==null) return null;
        List<RevenueDTO> revenueDTOList = new ArrayList<>();
        for (Revenue revenue : e){
            revenueDTOList.add(toDTO(revenue));
        }
        return revenueDTOList;
    }

    @Override
    public List<Revenue> toEntityList(List<RevenueDTO> d) {
        if (d==null) return null;
        List<Revenue> revenueList = new ArrayList<>();
        for (RevenueDTO revenueDTO : d){
            revenueList.add(toEntity(revenueDTO));
        }
        return revenueList;
    }
}

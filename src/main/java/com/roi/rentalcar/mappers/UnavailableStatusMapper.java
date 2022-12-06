package com.roi.rentalcar.mappers;

import com.roi.rentalcar.database.entities.UnavailableStatus;
import com.roi.rentalcar.dto.UnavailableStatusDTO;

import java.util.ArrayList;
import java.util.List;

public class UnavailableStatusMapper implements BaseMapper<UnavailableStatus, UnavailableStatusDTO>{
    @Override
    public UnavailableStatusDTO toDTO(UnavailableStatus unavailableStatus) {
        if (unavailableStatus==null) return null;
        UnavailableStatusDTO unavailableStatusDTO = new UnavailableStatusDTO();
        unavailableStatusDTO.setStatusId(unavailableStatus.getStatusId());
        unavailableStatusDTO.setDate(unavailableStatus.getDate());
        return unavailableStatusDTO;
    }

    @Override
    public UnavailableStatus toEntity(UnavailableStatusDTO unavailableStatusDTO) {
        if (unavailableStatusDTO==null) return null;
        UnavailableStatus unavailableStatus  = new UnavailableStatus();
        unavailableStatus.setStatusId(unavailableStatusDTO.getStatusId());
        unavailableStatus.setDate(unavailableStatusDTO.getDate());
        return unavailableStatus;
    }

    @Override
    public List<UnavailableStatusDTO> toDTOList(List<UnavailableStatus> e) {
        if (e==null) return null;
        List<UnavailableStatusDTO> unavailableStatusDTOList = new ArrayList<>();
        for (UnavailableStatus unavailableStatus : e){
            unavailableStatusDTOList.add(toDTO(unavailableStatus));
        }
        return unavailableStatusDTOList;
    }

    @Override
    public List<UnavailableStatus> toEntityList(List<UnavailableStatusDTO> d) {
        if (d==null) return null;
        List<UnavailableStatus> unavailableStatusList = new ArrayList<>();
        for (UnavailableStatusDTO unavailableStatusDTO : d){
            unavailableStatusList.add(toEntity(unavailableStatusDTO));
        }
        return unavailableStatusList;
    }
}

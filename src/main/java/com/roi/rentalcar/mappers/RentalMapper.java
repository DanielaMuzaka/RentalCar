package com.roi.rentalcar.mappers;

import com.roi.rentalcar.database.entities.Rental;
import com.roi.rentalcar.dto.RentalDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RentalMapper implements BaseMapper<Rental, RentalDTO>{
    @Override
    public RentalDTO toDTO(Rental rental) {
        if(rental==null) return null;
        RentalDTO rentalDTO = new RentalDTO();
        rentalDTO.setRentalId(rental.getRentalId());
        rentalDTO.setName(rental.getName());
        rentalDTO.setInternetDomain(rental.getContactAddress());
        rentalDTO.setInternetDomain(rentalDTO.getInternetDomain());
        return rentalDTO;
    }

    @Override
    public Rental toEntity(RentalDTO rentalDTO) {
        if(rentalDTO==null) return null;
        Rental rental = new Rental();
        rental.setRentalId(rentalDTO.getRentalId());
        rental.setName(rentalDTO.getName());
        rental.setInternetDomain(rentalDTO.getInternetDomain());
        rental.setContactAddress(rental.getContactAddress());
        return rental;
    }

    @Override
    public List<RentalDTO> toDTOList(List<Rental> e) {
        if(e==null) return null;
        List<RentalDTO> rentalDTOList = new ArrayList<>();
        for(Rental rental : e){
            rentalDTOList.add(toDTO(rental));
        }
        return rentalDTOList;
    }

    @Override
    public List<Rental> toEntityList(List<RentalDTO> d) {
        if(d==null) return null;
        List<Rental> rentalList = new ArrayList<>();
        for(RentalDTO rentalDTO : d){
            rentalList.add(toEntity(rentalDTO));
        }
        return rentalList;
    }
}

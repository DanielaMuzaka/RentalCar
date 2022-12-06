package com.roi.rentalcar.services.impl;

import com.roi.rentalcar.database.entities.City;
import com.roi.rentalcar.database.repositories.CityRepo;
import com.roi.rentalcar.dto.CityDTO;
import com.roi.rentalcar.mappers.CityMapper;
import com.roi.rentalcar.services.CityServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityServis {
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private CityRepo cityRepo;

    @Override
    public CityDTO getById(String id) {
        City city = cityRepo.findById(id).orElseThrow(() ->
                new RuntimeException("the car with thid id" + id + "does not exist."));
        return cityMapper.toDTO(city);
    }

    @Override
    public List<CityDTO> getAll() {
        return cityMapper.toDTOList(cityRepo.findAll());
    }

    @Override
    public CityDTO create(CityDTO cityDTO) {
       if(cityDTO.getName()!=null) throw new RuntimeException("Id must be null");
        City city = cityMapper.toEntity(cityDTO);
        cityRepo.save(city);
        return cityMapper.toDTO(city);
    }

    @Override
    public CityDTO update(CityDTO cityDTO) {
        if(cityDTO.getName()==null)throw new RuntimeException("Id must not be null.");
        City city=cityRepo.findById(cityDTO.getName()).orElseThrow(()->
                new RuntimeException("The city with this name " + cityDTO.getName() + "does not exist"));

        cityRepo.save(city);
        return cityMapper.toDTO(city);
    }

    @Override
    public String delete(String id) {
        try {
           if( cityRepo.findById(id).isEmpty()) throw new RuntimeException("City does not exist");
            cityRepo.deleteById(id);
           return "The city has been deleted";
        } catch (Exception e){
            return " Something went wrong.Please contact administrator.";
        }
    }
}

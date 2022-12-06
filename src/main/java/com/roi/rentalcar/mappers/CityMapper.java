package com.roi.rentalcar.mappers;

import com.roi.rentalcar.database.entities.City;
import com.roi.rentalcar.dto.CityDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CityMapper implements BaseMapper<City, CityDTO>{
    @Override
    public CityDTO toDTO(City city) {
      if(city==null)  return null;
      CityDTO cityDTO = new CityDTO();
      cityDTO.setName(city.getName());
      return cityDTO;
    }

    @Override
    public City toEntity(CityDTO cityDTO) {
        if(cityDTO==null) return null;
        City city = new City();
        city.setName(cityDTO.getName());
        return city;
    }

    @Override
    public List<CityDTO> toDTOList(List<City> e) {
        if(e==null) return null;
        List<CityDTO> cityDTOList = new ArrayList<>();
        for (City city : e){
            cityDTOList.add(toDTO(city));
        }
        return cityDTOList;
    }

    @Override
    public List<City> toEntityList(List<CityDTO> d) {
        if(d==null) return null;
        List<City> cityList = new ArrayList<>();
        for(CityDTO cityDTO : d){
            cityList.add(toEntity(cityDTO));
        }
        return cityList;
    }
}

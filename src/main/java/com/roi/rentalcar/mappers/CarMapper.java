package com.roi.rentalcar.mappers;

import com.roi.rentalcar.database.entities.Car;
import com.roi.rentalcar.dto.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CarMapper implements BaseMapper<Car, CarDTO>{
    @Autowired
    @Lazy
    private BranchMapper branchMapper;

    @Override
    public CarDTO toDTO(Car car) {
        if(car==null) return null;
        CarDTO carDTO = new CarDTO();
        carDTO.setCarId(car.getCarId());
        carDTO.setBrand(car.getBrand());
        carDTO.setColor(car.getColor());
        carDTO.setBodyType(car.getBodyType());
        carDTO.setMilage(car.getMilage());
        carDTO.setYear(car.getYear());
        carDTO.setCarStatus(car.getCarStatus());
        carDTO.setAmount(car.getAmount());
        return carDTO;
    }

    @Override
    public Car toEntity(CarDTO carDTO) {
        if(carDTO==null) return null;
        Car car = new Car();
        car.setCarId(carDTO.getCarId());
        car.setBrand(car.getBrand());
        car.setColor(car.getColor());
        car.setCarStatus(carDTO.getCarStatus());
        car.setMilage(carDTO.getMilage());
        car.setBodyType(carDTO.getBodyType());
        return car;

    }

    @Override
    public List<CarDTO> toDTOList(List<Car> e) {
        CarDTO carDTO= new CarDTO();
    List<CarDTO> carDTOList= new ArrayList<>();
    for(Car car : e){
        carDTO = toDTO(car);
        carDTOList.add(carDTO);
    }
   return carDTOList;
    }


    @Override
    public List<Car> toEntityList(List<CarDTO> d) {
        if(d==null) return null;
        List<Car> cars = new ArrayList<>();
        for(CarDTO carDTO : d ){
           cars.add(toEntity(carDTO));
        }
        return cars;
    }
}

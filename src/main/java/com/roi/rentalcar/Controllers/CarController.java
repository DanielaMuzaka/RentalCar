package com.roi.rentalcar.Controllers;

import com.roi.rentalcar.dto.CarDTO;
import com.roi.rentalcar.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/all")
    public List<CarDTO> getAll(){
        return carService.getAll();
    }

    @GetMapping
    public CarDTO getById(@RequestParam Long id){
        return carService.getById(id);
    }

    @PostMapping
    public CarDTO create(@RequestBody CarDTO carDTO){
        return carService.create(carDTO);
    }

    @PutMapping
    public CarDTO updateCar(@RequestBody CarDTO carDTO){
        return carService.update(carDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Long carId){
        return carService.deleteCarDTO(carId);
    }
}

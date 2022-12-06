package com.roi.rentalcar.Controllers;

import com.roi.rentalcar.dto.CityDTO;
import com.roi.rentalcar.services.CityServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityServis cityServis;

    @GetMapping("/all")
    public List<CityDTO> getAll(){
        return cityServis.getAll();
    }
    @GetMapping
    public CityDTO getById(@RequestParam String id){
        return cityServis.getById(id);
    }

    @PostMapping
    public CityDTO create(@RequestBody CityDTO cityDTO){
        return cityServis.create(cityDTO);
    }

    @PutMapping
    public CityDTO update(@RequestBody CityDTO cityDTO){
        return cityServis.update(cityDTO);
    }

    @DeleteMapping("/city/{id}")
    public String delete(@PathVariable String id){
        return cityServis.delete(id);
    }
}

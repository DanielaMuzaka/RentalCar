package com.roi.rentalcar.Controllers;

import com.roi.rentalcar.dto.RentalDTO;
import com.roi.rentalcar.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental")
public class RentalController {
    @Autowired
    private RentalService rentalService;
    @GetMapping
    public RentalDTO getById(@RequestParam Long id){
        return rentalService.getById(id);
    }
    @GetMapping("/all")
    public List<RentalDTO> getAll(){
        return rentalService.getAll();
    }
    @PostMapping
    public RentalDTO create(@RequestBody RentalDTO rentalDTO){
        return rentalService.create(rentalDTO);
    }
    @DeleteMapping("/rental/{id}")
    public String delete(@PathVariable Long id){
        return rentalService.delete(id);
    }
}

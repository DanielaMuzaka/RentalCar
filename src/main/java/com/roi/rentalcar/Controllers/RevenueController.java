package com.roi.rentalcar.Controllers;

import com.roi.rentalcar.dto.RentalDTO;
import com.roi.rentalcar.dto.RevenueDTO;
import com.roi.rentalcar.services.RentalService;
import com.roi.rentalcar.services.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/revenue")
public class RevenueController {
    @Autowired
    private RevenueService revenueService ;
    @GetMapping
    public RevenueDTO getById(@RequestParam Long id){
        return revenueService.getById(id);
    }
    @GetMapping("/all")
    public List<RevenueDTO> getAll(){
        return revenueService.getAll();
    }
    @PostMapping
    public RevenueDTO create(@RequestBody RevenueDTO revenueDTO ){
        return revenueService.save(revenueDTO);
    }
    @DeleteMapping("/rental/{id}")
    public String delete(@PathVariable Long id){
        return revenueService.delete(id);
    }
}

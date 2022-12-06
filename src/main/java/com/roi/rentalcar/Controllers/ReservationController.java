package com.roi.rentalcar.Controllers;

import com.roi.rentalcar.dto.RentalDTO;
import com.roi.rentalcar.dto.ReservationDTO;
import com.roi.rentalcar.services.RentalService;
import com.roi.rentalcar.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @GetMapping
    public ReservationDTO getById(@RequestParam Long id){
        return reservationService.getById(id);
    }
    @GetMapping("/all")
    public List<ReservationDTO> getAll(){
        return reservationService.getAll();
    }
    @PostMapping
    public ReservationDTO create(@RequestBody ReservationDTO reservationDTO){
        return reservationService.create(reservationDTO);
    }
    @DeleteMapping("/rental/{id}")
    public String delete(@PathVariable Long id){
        return reservationService.delete(id);
    }
}

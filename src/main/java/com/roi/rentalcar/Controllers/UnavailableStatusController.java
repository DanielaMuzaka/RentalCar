package com.roi.rentalcar.Controllers;

import com.roi.rentalcar.dto.UnavailableStatusDTO;
import com.roi.rentalcar.services.UnavailableStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unavailabestatus")

public class UnavailableStatusController {
    @Autowired
    private UnavailableStatusService unavailableStatusService;

    @GetMapping
    public UnavailableStatusDTO getById(@RequestParam Long id) {
        return unavailableStatusService.getById(id);
    }

    @GetMapping("/all")
    public List<UnavailableStatusDTO> getAll() {
        return unavailableStatusService.getAll();
    }

    @PostMapping
    public UnavailableStatusDTO create(@RequestBody UnavailableStatusDTO unavailableStatusDTO) {
        return unavailableStatusService.save(unavailableStatusDTO);
    }

    @DeleteMapping("/rental/{id}")
    public String delete(@PathVariable Long id) {
        return unavailableStatusService.delete(id);
    }
}

package com.roi.rentalcar.Controllers;

import com.roi.rentalcar.dto.RefundDTO;
import com.roi.rentalcar.services.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/refund")
public class RefundController {
    @Autowired
    private RefundService refundService;

    @GetMapping
    public RefundDTO getById(@RequestParam Long id){
        return refundService.getById(id);
    }
    @GetMapping("/all")
    public List<RefundDTO> getAll(){
        return refundService.getAll();
    }
    @PostMapping
    public RefundDTO create(@RequestBody RefundDTO refundDTO){
        return refundService.create(refundDTO);
    }

    @DeleteMapping("/refund/{id}")
    public String delete(@PathVariable Long id){
        return refundService.delete(id);
    }

}

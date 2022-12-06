package com.roi.rentalcar.Controllers;

import com.roi.rentalcar.database.entities.Branch;
import com.roi.rentalcar.dto.BranchDTO;
import com.roi.rentalcar.services.BranchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchController {
  private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

 @GetMapping("/all")
    public List<BranchDTO> getAll(){return branchService.getAll();
    }
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        return branchService.deleteByBranchId(id);
    }

    @PutMapping("/")
    public BranchDTO updateBranch(@RequestBody BranchDTO branchDTO){

        return branchService.update(branchDTO);
    }
 @GetMapping
    public BranchDTO getById(@RequestParam Long id){
        return branchService.getByID(id);
 }
 @PostMapping
    public BranchDTO create(@RequestBody BranchDTO branchDTO){
        return branchService.create(branchDTO);
 }

}

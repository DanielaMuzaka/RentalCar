package com.roi.rentalcar.dto;

import com.roi.rentalcar.static_data.Posittion;
import lombok.Data;

@Data
public class EmployeeDTO {
    private Long employeeId;
    private String name;

    private Posittion posittion;


    private BranchDTO branch;
}

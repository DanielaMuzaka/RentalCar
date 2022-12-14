package com.roi.rentalcar.dto;

import com.roi.rentalcar.static_data.Status;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UnavailableStatusDTO {
    private Long statusId;
    private Status status;
    private LocalDate date;
}

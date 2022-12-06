package com.roi.rentalcar.dto;

import com.roi.rentalcar.static_data.CarStatus;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class CarDTO {
    private Long carId;
    private String brand;
    private String bodyType;
    private Integer year;
    private String color;
    private Double milage;
    private Double amount;
    @Enumerated(value = EnumType.STRING)
    private CarStatus carStatus;

    private UnavailableStatusDTO status;

    private ReservationDTO reservation;

    private BranchDTO branch;
}

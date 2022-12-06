package com.roi.rentalcar.services;

import com.roi.rentalcar.dto.ReservationDTO;

import java.util.List;

public interface ReservationService {
    ReservationDTO getById(Long id);
    List<ReservationDTO> getAll();
    ReservationDTO update(ReservationDTO reservationDTO);
    ReservationDTO create(ReservationDTO reservationDTO);
    String delete(Long id);
    String cancelReservation(Long id);
}

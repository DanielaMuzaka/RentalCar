package com.roi.rentalcar.mappers;

import com.roi.rentalcar.database.entities.Reservation;
import com.roi.rentalcar.dto.ReservationDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReservationMapper implements BaseMapper<Reservation, ReservationDTO>{
    @Override
    public ReservationDTO toDTO(Reservation reservation) {
        if( reservation==null) return null;
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setReservationId(reservationDTO.getReservationId());
        reservationDTO.setReservationBooking(reservationDTO.getReservationBooking());
        reservationDTO.setReservationEnd(reservationDTO.getReservationEnd());
        reservationDTO.setAmount(reservationDTO.getAmount());
        reservationDTO.setReservationStart(reservationDTO.getReservationStart());
        return reservationDTO;
    }

    @Override
    public Reservation toEntity(ReservationDTO reservationDTO) {
        if(reservationDTO==null) return null;
        Reservation reservation = new Reservation();
        reservation.setReservationId(reservationDTO.getReservationId());
        reservation.setReservationBooking(reservationDTO.getReservationBooking());
        reservation.setReservationStart(reservationDTO.getReservationStart());
        reservation.setReservationEnd(reservationDTO.getReservationEnd());
        reservation.setAmount(reservationDTO.getAmount());
        return reservation;
    }

    @Override
    public List<ReservationDTO> toDTOList(List<Reservation> e) {
        if(e==null) return null;
        List<ReservationDTO> reservationDTOList = new ArrayList<>();
        for (Reservation reservation : e){
            reservationDTOList.add(toDTO(reservation));
        }
        return reservationDTOList;
    }

    @Override
    public List<Reservation> toEntityList(List<ReservationDTO> d) {
        if (d==null) return null;
        List<Reservation> reservationList = new ArrayList<>();
        for (ReservationDTO reservationDTO : d){
            reservationList.add(toEntity(reservationDTO));
        }
        return reservationList;
    }
}

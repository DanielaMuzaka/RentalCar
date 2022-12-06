package com.roi.rentalcar.services.impl;

import com.roi.rentalcar.database.entities.Car;
import com.roi.rentalcar.database.entities.Refund;
import com.roi.rentalcar.database.entities.Reservation;
import com.roi.rentalcar.database.repositories.CarRepo;
import com.roi.rentalcar.database.repositories.RefundRepo;
import com.roi.rentalcar.database.repositories.ReservationRepo;
import com.roi.rentalcar.dto.CarDTO;
import com.roi.rentalcar.dto.ReservationDTO;
import com.roi.rentalcar.mappers.CarMapper;
import com.roi.rentalcar.mappers.ReservationMapper;
import com.roi.rentalcar.services.ReservationService;
import com.roi.rentalcar.static_data.CarStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepo reservationRepo;
    @Autowired
    private ReservationMapper reservationMapper;
    @Autowired
    private RefundRepo refundRepo;

    @Autowired
    private CarRepo carRepo;
    @Autowired
    private CarMapper carMapper;


    @Override
    public ReservationDTO getById(Long id) {
        Reservation reservation = reservationRepo.findById(id).orElseThrow(() ->
                new RuntimeException("the reservation with this id" + id + "does not exist"));
        return reservationMapper.toDTO(reservation);
    }

    @Override
    public List<ReservationDTO> getAll() {
        return reservationMapper.toDTOList(reservationRepo.findAll());
    }

    @Override
    public ReservationDTO update(ReservationDTO reservationDTO) {
        return null;
    }

    @Override
    public ReservationDTO create(ReservationDTO reservationDTO) {
        if (reservationDTO.getReservationId() != null) throw new RuntimeException("Id must be null");
         else{
            Reservation reservation = reservationMapper.toEntity(reservationDTO);
            reservation.setReservationBooking(LocalDate.now());
            List<Car> cars = carMapper.toEntityList(reservationDTO.getCars());
            reservation.setAmount(getAmmount(reservationDTO));
            reservation = reservationRepo.save(reservation);
            for (Car car : cars) {
                car.setReservation(reservation);
                carRepo.save(car);
            }
            ReservationDTO reservationDTO1 = reservationMapper.toDTO(reservation);
            reservationDTO.setCars(reservationDTO.getCars());
            return reservationDTO1;
        }
    }


    @Override
    public String delete(Long id) {
        try {
            if (reservationRepo.findById(id).isEmpty())
                throw new RuntimeException("the reservation with this id" + id + "does not exist");
            reservationRepo.deleteById(id);
            return "Reservation with the id " + id + "has been deleted";
        } catch (Exception e) {
            return "Something went wrong.Please contact administrator";
        }
    }

    @Override
    public String cancelReservation(Long id) {
        Reservation reservation = reservationRepo.findById(id).orElseThrow(() ->
                new RuntimeException("Rezervimi nuk ekziston."));
        if (reservation.getReservationStart().isAfter(LocalDate.now().plusDays(2))) {
            Refund refund = new Refund();
            refund.setReservation(reservation);
            refund.setRefund(reservation.getAmount() * 0.8);
            refund.setSurcharge(reservation.getAmount() * 0.2);
            refundRepo.save(refund);
            List<Car> cars = reservation.getCars();
            for (Car car : cars) {
                car.setCarStatus(CarStatus.AVAILABLE);
                car.setReservation(null);
                carRepo.save(car);
            }
            return "Reservation has been canceled";
        } else {
            return "Reservation must be canceled only 2 days before starting";
        }

    }

    private Double getAmmount(ReservationDTO reservation) {
        Double ammount = 0.0;
        Long days = ChronoUnit.DAYS.between(reservation.getReservationStart(), reservation.getReservationEnd());
        for (CarDTO carDto : reservation.getCars()) {
            ammount = carDto.getAmount() * days;
            if (!reservation.getBookingbranch().getBranchId().equals(reservation.getReturnbrench().getBranchId()))
                ammount = ammount + (ammount * 0.1);
        }
        return ammount;
    }

}

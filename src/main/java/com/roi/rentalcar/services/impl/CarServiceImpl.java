package com.roi.rentalcar.services.impl;

import com.roi.rentalcar.database.entities.Car;
import com.roi.rentalcar.database.entities.Reservation;
import com.roi.rentalcar.database.repositories.CarRepo;
import com.roi.rentalcar.database.repositories.ReservationRepo;
import com.roi.rentalcar.dto.CarDTO;
import com.roi.rentalcar.dto.ReservationDTO;
import com.roi.rentalcar.mappers.CarMapper;
import com.roi.rentalcar.services.CarService;
import com.roi.rentalcar.static_data.CarStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepo carRepo;
    @Autowired
    CarMapper carMapper;
    @Autowired
    ReservationRepo reservationRepo;

    @Override
    public CarDTO getById(Long id) {
        Car car = carRepo.findById(id).orElseThrow(() ->
                new RuntimeException("Car with this id " + id + " does not exist"));
        return carMapper.toDTO(car);
    }

    @Override
    public List<CarDTO> getAll() {
        return carMapper.toDTOList(carRepo.findAll());
    }

    @Override
    public CarDTO create(CarDTO carDTO) {
        if (carRepo.existsCarByCarId(carDTO.getCarId())) {
            throw new RuntimeException("The car with this id " + carDTO.getCarId() + "alredy exists");
        }
        Car car = carMapper.toEntity(carDTO);
        carRepo.save(car);
        return carMapper.toDTO(car);
    }

    @Override
    public CarDTO update(CarDTO carDTO) {
        if (carDTO.getCarId() == null) throw new RuntimeException("Id must not be null");
        Car car = carRepo.findById(carDTO.getCarId()).orElseThrow(() ->
                new RuntimeException("The car with this id" + carDTO.getCarId() + " does not exist"));
        car.setCarId(carDTO.getCarId());
        car.setBrand(carDTO.getBrand());
        car.setColor(carDTO.getColor());
        car.setMilage(carDTO.getMilage());
        car.setAmount(carDTO.getAmount());
        carRepo.save(car);
        return carMapper.toDTO(car);
    }

    @Override
    public String deleteCarDTO(Long id) {
        try {
            if (carRepo.findById(id).isEmpty())
                throw new RuntimeException("the car with this id " + id + "does not exist.");
            carRepo.deleteById(id);
            return "The car has been deleted";
        } catch (Exception e) {
            return "Something went wrong.Please contact administrator";
        }
    }

    private void changeCarStatus() {
        List<Car> cars = carRepo.findAll();
        for (Car car : cars) {
            if (car.getReservation() != null) {
                Reservation reservation = car.getReservation();
                if (reservation.getReservationEnd().isBefore(LocalDate.now()) &&
                        car.getCarStatus().equals(CarStatus.BOOKED)) {
                    car.setCarStatus(CarStatus.AVAILABLE);
                    car.setBranch(reservation.getReturnbrench());
                    carRepo.save(car);
                }
            }
        }
    }

    private List<CarDTO> findCars(LocalDate starDate, LocalDate endDate) {
        List<CarDTO> caravailable = new ArrayList<>();
        List<Car> cars = carRepo.findAll();
        for (Car car : cars) {
            if (car.getReservation() == null ||
                    car.getReservation().getReservationEnd().isBefore(starDate) ||
                    car.getReservation().getReservationStart().isAfter(starDate)) {
                caravailable.add(carMapper.toDTO(car));
            }
        }
        return caravailable;
    }

    private Double totalAmount() {
        double amount = 0;
        long daysBetween = 0;
        List<Car> carList = carRepo.findAll();
        for (Car car : carList) {
            if (car.getReservation() != null) {
                daysBetween = ChronoUnit.DAYS.between(car.getReservation().getReservationStart(),
                        car.getReservation().getReservationEnd());
                amount = daysBetween * car.getAmount();

                if (car.getReservation().getBookingbranch() != car.getReservation().getReturnbrench()) {
                    amount = amount + (0.1 * amount);
                }
            }
        }
        return amount;
    }



}
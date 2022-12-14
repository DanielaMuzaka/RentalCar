package com.roi.rentalcar.database.repositories;

import com.roi.rentalcar.database.entities.Car;
import com.roi.rentalcar.static_data.CarStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends JpaRepository<Car,Long> {
    boolean existsCarByCarId(Long id);
   Car findCarByCarId(Long id);

   @Query("from Car car where car.carStatus <> :status")
    List<Car> getAllByStatusNot(CarStatus status);

}

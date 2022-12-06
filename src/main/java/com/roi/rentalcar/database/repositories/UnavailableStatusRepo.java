package com.roi.rentalcar.database.repositories;

import com.roi.rentalcar.database.entities.UnavailableStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnavailableStatusRepo extends JpaRepository<UnavailableStatus,Long> {
}


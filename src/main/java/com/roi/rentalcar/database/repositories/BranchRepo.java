package com.roi.rentalcar.database.repositories;

import com.roi.rentalcar.database.entities.Branch;
import com.roi.rentalcar.database.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepo extends JpaRepository<Branch, Long> {
    @Query(value = "select branch.name from  Branch branch where branch.name = : name")

    Branch getByName(String name);

    Branch getBranchByNameAndCity_Name(String name, String cityName);

    boolean existsBranchByName(String name);
    Branch getBranchByName(String name);


    boolean existsBranchByNameIgnoreCase(String name);
}

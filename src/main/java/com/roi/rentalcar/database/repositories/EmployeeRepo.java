package com.roi.rentalcar.database.repositories;

import com.roi.rentalcar.database.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    boolean existsEmployeeByNameIgnoreCase(String name);
    Employee getEmployeeByName(String name);
}

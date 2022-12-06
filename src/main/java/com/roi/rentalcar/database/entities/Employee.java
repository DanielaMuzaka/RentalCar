package com.roi.rentalcar.database.entities;

import com.roi.rentalcar.static_data.Posittion;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String name;
    @Column(nullable = false, length = 20)
    @Enumerated(value = EnumType.STRING)
    private Posittion posittion;

 @ManyToOne
    @JoinColumn(name = "branch")
    private Branch branch;


}

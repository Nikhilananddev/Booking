package com.booking.Booking.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@Entity
@Table(name = "vehicles")
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Type cannot be null")
    private String type;

    @NotNull(message = "Wheel count cannot be null")
    @Column(name = "wheel_count")
    private int wheelCount;

    @NotNull(message = "Model cannot cannot be null")
    private String model;

    @NotNull(message = "Category cannot be null")
    private String category;

}

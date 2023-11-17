package com.booking.Booking.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class Vehicle {


    private Long id;

    @NotNull(message = "Type cannot be null")
    private String type;

    @NotNull(message = "Wheel count cannot be null")
    private Integer wheelCount;

    @NotNull(message = "Model cannot cannot be null")
    private String model;

    @NotNull(message = "Category cannot be null")
    private String category;

}

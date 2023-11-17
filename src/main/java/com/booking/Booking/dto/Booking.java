package com.booking.Booking.dto;

import com.booking.Booking.model.VehicleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @NotNull(message = "Vehicle Id cannot be null")
    private Long id;

    @NotNull(message = "Vehicle cannot be null")
    private VehicleEntity vehicle;

    @NotNull(message = "startTime cannot be null")
    private LocalDateTime startTime;

    @NotNull(message = "endTime cannot be null")
    private LocalDateTime endTime;

}

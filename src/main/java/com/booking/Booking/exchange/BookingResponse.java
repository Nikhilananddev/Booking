package com.booking.Booking.exchange;

import com.booking.Booking.dto.Booking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {

    @NotNull(message = "Booking cannot null")
    private Booking booking;
}

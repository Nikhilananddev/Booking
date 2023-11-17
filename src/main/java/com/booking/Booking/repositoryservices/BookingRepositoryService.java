package com.booking.Booking.repositoryservices;

import com.booking.Booking.dto.Booking;
import com.booking.Booking.exception.VehicleNotFoundException;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepositoryService {

    Booking createBooking(Long vehicleId, LocalDateTime startTime, LocalDateTime endTime) throws VehicleNotFoundException;

    List<Booking> findALlBooking();
}

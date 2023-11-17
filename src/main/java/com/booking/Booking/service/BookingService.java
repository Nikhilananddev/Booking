package com.booking.Booking.service;

import com.booking.Booking.exchange.BookingRequest;
import com.booking.Booking.exchange.BookingResponse;
import com.booking.Booking.exchange.Response;

public interface BookingService {

    BookingResponse addBooking(BookingRequest bookingRequest);

    Response getAllBooking();
}

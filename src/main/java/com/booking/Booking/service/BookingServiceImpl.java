package com.booking.Booking.service;

import com.booking.Booking.dto.Booking;
import com.booking.Booking.exception.VehicleNotFoundException;
import com.booking.Booking.exchange.BookingRequest;
import com.booking.Booking.exchange.BookingResponse;
import com.booking.Booking.exchange.Response;
import com.booking.Booking.repositoryservices.BookingRepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    static Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

    @Autowired
    BookingRepositoryService bookingRepositoryService;


    @Override
    public BookingResponse addBooking(BookingRequest bookingRequest) {

        Booking booking = null;
        try {
            booking = bookingRepositoryService.createBooking(bookingRequest.getVehicleId(),
                    bookingRequest.getStartTime(), bookingRequest.getEndTime()
            );
        }
       catch (IllegalArgumentException | VehicleNotFoundException | InvalidDataAccessApiUsageException e){
           logger.error("addBooking:" + e.getMessage());
        }


        BookingResponse bookingResponse = null;
        bookingResponse = new BookingResponse(booking);
        return bookingResponse;


    }

    @Override
    public Response getAllBooking() {

        List<Booking> getAllBooking = bookingRepositoryService.findALlBooking();

        Response<Booking> listResponse = new Response<>(getAllBooking);

        return listResponse;
    }
}

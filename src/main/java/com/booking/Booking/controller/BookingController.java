package com.booking.Booking.controller;


import com.booking.Booking.exchange.BookingRequest;
import com.booking.Booking.exchange.BookingResponse;
import com.booking.Booking.exchange.Response;
import com.booking.Booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/vehicles")
public class BookingController {


    @Autowired
    BookingService bookingService;


    @PostMapping("/bookMyVehicle")
    public ResponseEntity<BookingResponse> bookVehicle(@RequestBody BookingRequest bookingRequest) {


            BookingResponse bookingResponse = bookingService.addBooking(bookingRequest);


            if (bookingResponse.getBooking()!=null)
            {
                return ResponseEntity.ok().body(bookingResponse);

            }


        return ResponseEntity.badRequest().body(null);



    }

    @GetMapping("/booking")
    public ResponseEntity<Response> getBooking() {

        Response getBookingResponse = bookingService.getAllBooking();

        return ResponseEntity.ok().body(getBookingResponse);
    }
}

package com.booking.Booking.service;

import com.booking.Booking.exchange.Response;


public interface VehicleService {


    Response getTypesVehicleWheel();

    Response getVehicleByWheel(int numOfWheel);

    Response getVehicleCategory(String vehicleType);

    Response getVehicle(String type, String category);


}

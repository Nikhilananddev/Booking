package com.booking.Booking.repositoryservices;

import com.booking.Booking.dto.Vehicle;
import com.booking.Booking.exception.NotFoundException;

import java.util.List;

public interface VehicleRepositoryService {

    List<Integer> findAllWheelType() throws NotFoundException;

    List<String> findVehicleByWheel(int numOfWheel) throws NotFoundException;
    List<String> findVehicleCategory(String vehicleType) throws NotFoundException;

    List<Vehicle> getVehicle(String type, String category);


}

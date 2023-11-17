package com.booking.Booking.service;

import com.booking.Booking.dto.Vehicle;
import com.booking.Booking.exception.NotFoundException;
import com.booking.Booking.exchange.Response;
import com.booking.Booking.repositoryservices.VehicleRepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VehicleServiceImpl implements VehicleService {

    static Logger logger = LoggerFactory.getLogger(VehicleServiceImpl.class);

    @Autowired
    VehicleRepositoryService vehicleRepositoryService;


    @Override
    public Response getTypesVehicleWheel() {

        List<Integer> getVehicleWheelResponse = null;
        try {
            getVehicleWheelResponse = vehicleRepositoryService.findAllWheelType();
        } catch (NotFoundException e) {

            logger.error("getTypesVehicleWheel" + e.getMessage(), e);

        }

        Response<Integer> listResponse = new Response<>(getVehicleWheelResponse);

        return listResponse;


    }

    @Override
    public Response getVehicleByWheel(int wheel) {
        List<String> getVehicleList = null;
        try {
            getVehicleList = vehicleRepositoryService.findVehicleByWheel(wheel);
        } catch (NotFoundException e) {

            logger.error("getVehicleByWheel:" + e.getMessage(), e);

        }

        Response<String> listResponse = new Response<>(getVehicleList);

        return listResponse;
    }

    @Override
    public Response getVehicleCategory(String vehicleType) {
        List<String> getVehicleTypeCategory = null;
        try {
            getVehicleTypeCategory = vehicleRepositoryService.findVehicleCategory(vehicleType);
        } catch (NotFoundException e) {

            logger.error("getVehicleCategory:" + e.getMessage(), e);

        }

        Response<String> listResponse = new Response<>(getVehicleTypeCategory);

        return listResponse;
    }

    @Override
    public Response getVehicle(String type, String category) {

        List<Vehicle> getVehicleTypeCategory = vehicleRepositoryService.getVehicle(type, category);

        Response<Vehicle> listResponse = new Response<>(getVehicleTypeCategory);

        return listResponse;
    }
}

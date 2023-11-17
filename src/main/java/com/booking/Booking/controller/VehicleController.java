package com.booking.Booking.controller;

import com.booking.Booking.exchange.Response;
import com.booking.Booking.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/getWheel")
    public ResponseEntity<Response> getWheel() {

        Response getWheelResponse = vehicleService.getTypesVehicleWheel();

        if (getWheelResponse != null) {
            return ResponseEntity.ok().body(getWheelResponse);
        }

        return ResponseEntity.badRequest().body(null);
    }


    @GetMapping("/byWheelCount/{wheelCount}")
    public ResponseEntity<Response> getVehiclesByWheelCount(@PathVariable int wheelCount) {

        Response getVehiclesResponse = vehicleService.getVehicleByWheel(wheelCount);

        if (getVehiclesResponse != null) {
            return ResponseEntity.ok().body(getVehiclesResponse);
        }

        return ResponseEntity.badRequest().body(null);
    }


    @GetMapping("/byType/{type}")
    public ResponseEntity<Response> getVehiclesCategoryByType(@PathVariable String type) {

        Response getVehiclesCategorResponse = vehicleService.getVehicleCategory(type);

        if (getVehiclesCategorResponse != null) {
            return ResponseEntity.ok().body(getVehiclesCategorResponse);
        }

        return ResponseEntity.badRequest().body(null);
    }


    @GetMapping("/getVehicle/{type}/{category}")
    public ResponseEntity<Response> getVehicles(
            @PathVariable String type,
            @PathVariable String category) {

        Response getVehiclesResponse = vehicleService.getVehicle(type, category);

        if (getVehiclesResponse != null) {
            return ResponseEntity.ok().body(getVehiclesResponse);
        }

        return ResponseEntity.badRequest().body(null);
    }

}

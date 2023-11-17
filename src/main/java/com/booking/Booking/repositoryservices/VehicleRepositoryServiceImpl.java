package com.booking.Booking.repositoryservices;

import com.booking.Booking.dto.Vehicle;
import com.booking.Booking.exception.NotFoundException;
import com.booking.Booking.model.VehicleEntity;
import com.booking.Booking.repository.VehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleRepositoryServiceImpl implements VehicleRepositoryService {


    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    private Provider<ModelMapper> modelMapperProvider;

    @Override
    public List<Integer> findAllWheelType() throws NotFoundException {

        Optional<List<Integer>> optionalList = vehicleRepository.findDistinctTypeWheel();

        if (optionalList.isPresent())
            return optionalList.get();

        else
            throw new NotFoundException("WheelType not found");


    }

    @Override
    public List<String> findVehicleByWheel(int numOfWheel) throws NotFoundException {

        Optional<List<String>> optionalListVehicle = vehicleRepository.findByWheelCount(numOfWheel);

        if (optionalListVehicle.isPresent())
            return optionalListVehicle.get();

        else
            throw new NotFoundException(numOfWheel + "numOfWheel vehicle not found");
    }

    @Override
    public List<String> findVehicleCategory(String vehicleType) throws NotFoundException {
        Optional<List<String>> VehicleCategory = vehicleRepository.findByType(vehicleType);

        if (VehicleCategory.isPresent())
            return VehicleCategory.get();

        else
            throw new NotFoundException(vehicleType + "vehicleType vehicle not found");
    }


    @Override
    public List<Vehicle> getVehicle(String type, String category) {

        ModelMapper modelMapper = modelMapperProvider.get();

        Optional<List<VehicleEntity>> vehicleEntities = vehicleRepository.findDistinctAvailableVehicles(type, category);
        List<Vehicle> vehicles = new ArrayList<>();


        if (vehicleEntities.isPresent()) {
            for (VehicleEntity entity : vehicleEntities.get()) {
                new Vehicle();
                Vehicle vehicle;
                vehicle = modelMapper.map(entity, Vehicle.class);
                vehicles.add(vehicle);

            }
        }

        return vehicles;


    }
}

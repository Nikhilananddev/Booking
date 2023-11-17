package com.booking.Booking.repositoryservices;

import com.booking.Booking.dto.Booking;
import com.booking.Booking.exception.VehicleNotFoundException;
import com.booking.Booking.model.BookingEntity;
import com.booking.Booking.model.VehicleEntity;
import com.booking.Booking.repository.BookingRepository;
import com.booking.Booking.repository.VehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Provider;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingRepositoryServiceImpl implements BookingRepositoryService {

    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    BookingRepository bookingRepository;


    @Autowired
    private Provider<ModelMapper> modelMapperProvider;

    @Override
    public Booking createBooking(Long vehicleId, LocalDateTime startTime, LocalDateTime endTime) throws VehicleNotFoundException {

        ModelMapper modelMapper = modelMapperProvider.get();
        Booking booking = new Booking();
        Optional<VehicleEntity> vehicleEntity = vehicleRepository.findByIdAndIdNotInBooking(vehicleId);

        BookingEntity bookingEntity = new BookingEntity();

        if (vehicleEntity.isPresent()) {
            bookingEntity.setVehicle(vehicleEntity.get());
            bookingEntity.setStartTime(startTime);
            bookingEntity.setEndTime(endTime);
            bookingEntity = bookingRepository.save(bookingEntity);
            booking = modelMapper.map(bookingEntity, Booking.class);
        } else
            throw new VehicleNotFoundException("Vehicle already book or Vehicle not found  vehicle Id");


        return booking;
    }

    @Override
    public List<Booking> findALlBooking() {

        ModelMapper modelMapper = modelMapperProvider.get();

        List<BookingEntity> bookingEntities = bookingRepository.findAll();
        List<Booking> bookingList = new ArrayList<>();


        for (BookingEntity entity : bookingEntities) {

            Booking booking = new Booking();
            booking = modelMapper.map(entity, Booking.class);
            bookingList.add(booking);
        }

        return bookingList;
    }
}

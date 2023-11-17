package com.booking.Booking.repository;

import com.booking.Booking.model.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {

    @Query(value = "SELECT DISTINCT v.type FROM  VehicleEntity v WHERE  v.wheelCount= :wheelCount")
    Optional<List<String>> findByWheelCount(@Param("wheelCount") int wheelCount);

    @Query(value = "SELECT DISTINCT v.category FROM  VehicleEntity v  WHERE UPPER(v.type) = UPPER(:type)")
    Optional<List<String>> findByType(@Param("type") String type);

    @Query(value = "SELECT DISTINCT v.wheelCount FROM  VehicleEntity v")
    Optional<List<Integer>> findDistinctTypeWheel();


    @Query("SELECT DISTINCT v FROM VehicleEntity v " +
            "WHERE UPPER(v.type) = UPPER(:type) AND UPPER(v.category) = UPPER(:category) " +
            "AND v.id NOT IN (SELECT DISTINCT b.vehicle.id FROM BookingEntity b)")
    Optional<List<VehicleEntity>> findDistinctAvailableVehicles(
            @Param("type") String type,
            @Param("category") String category);

    @Query("SELECT v FROM VehicleEntity v WHERE v.id = :vehicleId AND v.id NOT IN (SELECT b.vehicle.id FROM BookingEntity b)")
    Optional<VehicleEntity> findByIdAndIdNotInBooking(@Param("vehicleId") Long vehicleId);

}

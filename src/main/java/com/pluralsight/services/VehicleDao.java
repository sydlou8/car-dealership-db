package com.pluralsight.services;

import com.pluralsight.models.Vehicle;

import java.util.List;

public interface VehicleDao {
    // Create
    void addVehicle (Vehicle vehicle);

    // Read
    List<Vehicle> getAllVehicles();

    List<Vehicle> getByPriceRange(double min, double max);
    List<Vehicle> getByMakeModel(String make, String model);
    List<Vehicle> getByYearRange(int min, int max);
    List<Vehicle> getByColor(String color);
    List<Vehicle> getByMileage(int min, int max);
    List<Vehicle> getByVehicleType(String vehicleType);

    // Needed for Contracts
    Vehicle getVehicle(int vin);

    // Update -- Not Needed for workshop
    //void updateVehicle (Vehicle vehicle);

    // Delete
    void removeVehicleByVin(int vin);
}

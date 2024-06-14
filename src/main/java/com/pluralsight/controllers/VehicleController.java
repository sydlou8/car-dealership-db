package com.pluralsight.controllers;

import com.pluralsight.models.Vehicle;
import com.pluralsight.services.VehicleDao;

import java.util.List;

public class VehicleController {
    private VehicleDao vehicleDao;

    public VehicleController (VehicleDao vehicleDao) {
        this.vehicleDao = vehicleDao;
    }

    public List<Vehicle> getAll() {
        return vehicleDao.getAllVehicles();
    }
    public List<Vehicle> searchByPriceRange(double min, double max) {
        return vehicleDao.getByPriceRange(min, max);
    }
    public List<Vehicle> searchByMakeModel(String make, String model) {
        return vehicleDao.getByMakeModel(make, model);
    }
    public List<Vehicle> searchByYearRange(int min, int max) {
        return vehicleDao.getByYearRange(min, max);
    }
    public List<Vehicle> searchByColor(String color) {
        return vehicleDao.getByColor(color);
    }
    public List<Vehicle> searchByMileage(int min, int max) {
        return vehicleDao.getByMileage(min, max);
    }
    public List<Vehicle> searchByVehicleType(String vehicleType) {
        return vehicleDao.getByVehicleType(vehicleType);
    }

    public void add(Vehicle vehicle) {
        vehicleDao.addVehicle(vehicle);
    }
    public void remove(int vin) {
        vehicleDao.removeVehicleByVin(vin);
    }
}

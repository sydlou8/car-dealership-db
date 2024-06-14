package com.pluralsight.models;

public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    // <editor-fold desc="Getters">
    public int getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

    public int getOdometer() {
        return odometer;
    }

    public double getPrice() {
        return price;
    }
    // </editor-fold >

    @Override
    public String toString() {
        return String.format("""
                        -----------------------------------------
                        VEHICLE:
                            VIN:        %-10d
                            Year:       %-10d
                            Make:       %-10s
                            Model:      %-10s
                            Color:      %-10s
                            Mileage:    %-10d mi
                            Type:       %-10s
                        - - - - - - - - - - - - - - - - - - - - -
                            Price:      $%-8.2f
                        -----------------------------------------
                        """, vin, year, make, model, color, odometer, vehicleType, price
        );
    }
}

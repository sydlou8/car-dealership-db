package com.pluralsight.ui;

import com.pluralsight.models.Vehicle;

import java.util.List;

public class Displays {
    public void err() {
        System.out.println("Please input correct choice");
    }
    public void display(List<Vehicle> vehicles) {
        vehicles.forEach(System.out::println);
    }
    public void display(Vehicle vehicle) {

    }
}

package com.pluralsight.ui;

import com.pluralsight.models.Vehicle;

import java.util.List;

public class Displays {
    public void err() {
        System.out.println("Please input correct choice");
    }
    public void display(List<Vehicle> vehicles) {
        System.out.println("-".repeat(114));
        System.out.printf("%-10s%-6s%-18s%-25s%-10s%-10s\t\t%-15s\t%-12s",
                "vin", "year", "make", "model", "color", "odometer", "vehicleType", "price");
        System.out.println();
        System.out.println("-".repeat(114));
        vehicles.forEach(System.out::println);
    }
}

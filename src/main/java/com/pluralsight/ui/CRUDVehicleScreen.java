package com.pluralsight.ui;

import com.pluralsight.models.Vehicle;

import java.util.Scanner;

public class CRUDVehicleScreen {
    Displays displays = new Displays();
    Scanner userInput = new Scanner(System.in);

    public Vehicle addVehicle() {
        System.out.println("-".repeat(40));
        while(true) {
            System.out.println("Please enter the vehicle details to add: ");
            try {
                System.out.println("VIN: ");
                int vin = Integer.parseInt(userInput.nextLine().strip());
                System.out.println("YEAR: ");
                int year = Integer.parseInt(userInput.nextLine().strip());
                System.out.println("MAKE: ");
                String make = userInput.nextLine().strip();
                System.out.println("MODEL: ");
                String model = userInput.nextLine().strip();
                System.out.println("VEHICLE TYPE: ");
                String vehicleType = userInput.nextLine().strip();
                System.out.println("COLOR: ");
                String color = userInput.nextLine().strip();
                System.out.println("MILEAGE: ");
                int odometer = Integer.parseInt(userInput.nextLine().strip());
                System.out.println("PRICE: $");
                double price = Double.parseDouble(userInput.nextLine().strip());

                return new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
            } catch (Exception _) {
                displays.err();
            }
        }
    }
    public int removeVehicle() {
        while(true) {
            try {
                System.out.println("-".repeat(40));
                System.out.print("Please enter the vehicle VIN to remove: ");
                return Integer.parseInt(userInput.nextLine().strip());
            } catch (Exception _) {
                displays.err();
            }
        }
    }
}

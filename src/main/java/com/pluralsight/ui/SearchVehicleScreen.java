package com.pluralsight.ui;

import java.util.Scanner;

public class SearchVehicleScreen {
    Displays displays = new Displays();
    Scanner userInput = new Scanner(System.in);

    // get all

    // search by price range
    public double[] priceRange() {
        double[] range = new double[2];
        while(true) {
            try {
                System.out.println("-".repeat(40));
                System.out.print("Please enter minimum price: ");
                range[0] = Double.parseDouble(userInput.nextLine().strip());
                System.out.print("Please enter maximum price: ");
                range[1] = Double.parseDouble(userInput.nextLine().strip());
                return range;
            } catch (Exception _) {
                displays.err();
            }
        }
    }
    // search by make model
    public String[] makeModel() {
        String[] makeModel = new String[2];
        while(true) {
            try {
                System.out.println("-".repeat(40));
                System.out.print("Please enter make: ");
                makeModel[0] = userInput.nextLine().strip();
                System.out.print("Please enter model: ");
                makeModel[1] = userInput.nextLine().strip();
                return makeModel;
            } catch (Exception _) {
                displays.err();
            }
        }
    }
    // search by year range
    public int[] yearRange() {
        int[] range = new int[2];
        while(true) {
            try {
                System.out.println("-".repeat(40));
                System.out.print("Please enter minimum year: ");
                range[0] = Integer.parseInt(userInput.nextLine().strip());
                System.out.print("Please enter maximum year: ");
                range[1] = Integer.parseInt(userInput.nextLine().strip());
                return range;
            } catch (Exception _) {
                displays.err();
            }
        }
    }
    // search by color
    public String color() {
        while(true) {
            try {
                System.out.println("-".repeat(40));
                System.out.print("Please color: ");
                return userInput.nextLine().strip();
            } catch (Exception _) {
                displays.err();
            }
        }
    }
    // search by mileage
    public int[] mileage() {
        int[] range = new int[2];

        return range;
    }
    // search by type
    public String vehicleType() {
        while(true) {
            try {
                System.out.println("-".repeat(40));
                System.out.print("Please color: ");
                return userInput.nextLine().strip();
            } catch (Exception _) {
                displays.err();
            }
        }
    }


}

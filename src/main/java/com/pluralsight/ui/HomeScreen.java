package com.pluralsight.ui;

import java.util.Scanner;

public class HomeScreen {
    Scanner userInput = new Scanner(System.in);
    Displays displays = new Displays();

    public int getHomeScreen () {
        while(true) {
            try {
                System.out.print("""
                        ------------------------------------------------------------------------------------------------------------------
                                                                            HOME PAGE
                        ------------------------------------------------------------------------------------------------------------------
                        Welcome!
                        
                        [1] - Find Vehicles by Price Range
                        [2] - Find Vehicles by Make/Model
                        [3] - Find Vehicles by Year Range
                        [4] - Find Vehicles by Color
                        [5] - Find Vehicles by Mileage Range
                        [6] - Find Vehicles by Vehicle Type
                        [7] - List All Vehicles
                        [8] - Add a Vehicle
                        [9] - Remove a Vehicle
                        [0] - Add a new Contract (Lease/Buy)
                        [any other key] - Quit"
                        
                        Please make a selection:
                        """);
                String input = userInput.nextLine().strip();
                if (input.length() != 1 || !Character.isDigit(input.charAt(0))) System.exit(0);
                return Integer.parseInt(input);
            } catch (Exception _) { displays.err(); }
        }
    }

}

package com.pluralsight.ui;

import java.util.Scanner;

public class ContractScreen {
    Scanner userInput = new Scanner(System.in);

    public int getContract() {
        System.out.print("""
                Would you like to:
                    [1] - LEASE Vehicle
                    [2] - PURCHASE Vehicle
                    [Any key] - Exit
                """);
        while(true) {
            System.out.print("Your selection: ");
            try {
                return Integer.parseInt(userInput.nextLine().strip());
            } catch (Exception e) {
                System.out.println("That key is invalid.");
            }
        }
    }

    public String[] getUser() {
        String [] userInfo = new String[2];
        System.out.println("Please enter your name");
        userInfo[0] = userInput.nextLine().strip();
        System.out.println("Please enter your Email address");
        userInfo[1] = userInput.nextLine().strip();
        return userInfo;
    }

    public boolean getFinance() {
        System.out.print("""
                Would you like to Finance Vehicle:
                    [1] - Yes
                    [2] - No
                """);
        while(true) {
            try {
                int financeChoice = Integer.parseInt(userInput.nextLine().strip());
                return financeChoice == 1;
            } catch (Exception _) {
            }
        }
    }

    public int getVin() {
        while (true) {
            try {
                System.out.println("Please enter the VIN number of the vehicle you would like to lease.");
                return Integer.parseInt(userInput.nextLine().strip());
            } catch (Exception _) {}
        }
    }

}

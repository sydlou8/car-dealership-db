package com.pluralsight.application;

import com.pluralsight.controllers.VehicleController;
import com.pluralsight.services.VehicleDao;
import com.pluralsight.services.mysql.MySqlVehicleDao;
import com.pluralsight.ui.HomeScreen;
import com.pluralsight.ui.CRUDVehicleScreen;
import com.pluralsight.ui.SearchVehicleScreen;

public class CarDealership {
    VehicleDao vehicleDao = new MySqlVehicleDao();

    HomeScreen homeScreen = new HomeScreen();
    CRUDVehicleScreen crudScreen = new CRUDVehicleScreen();
    SearchVehicleScreen searchScreen = new SearchVehicleScreen();

    VehicleController vehicleController = new VehicleController(vehicleDao);

    public void run () {
        int choice = homeScreen.getHomeScreen();
        handleChoice(choice);
    }

    private void handleChoice(int choice) {
       switch (choice) {
           case 8:
               vehicleController.add(crudScreen.addVehicle());
               break;
           case 9:
               vehicleController.remove(crudScreen.removeVehicle());
               break;
           default:
               System.exit(0);
       }
    }
}

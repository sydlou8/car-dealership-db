package com.pluralsight.application;

import com.pluralsight.controllers.VehicleController;
import com.pluralsight.services.VehicleDao;
import com.pluralsight.services.mysql.MySqlVehicleDao;
import com.pluralsight.ui.Displays;
import com.pluralsight.ui.HomeScreen;
import com.pluralsight.ui.CRUDVehicleScreen;
import com.pluralsight.ui.SearchVehicleScreen;

public class CarDealership {
    VehicleDao vehicleDao = new MySqlVehicleDao();

    Displays displays = new Displays();
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
           case 1:
               double[] priceRange = searchScreen.priceRange();
               displays.display(vehicleController.searchByPriceRange(
                               priceRange[0],
                               priceRange[1]
                       ));
               break;
           case 2:
               String[] makeModel = searchScreen.makeModel();
               displays.display(vehicleController.searchByMakeModel(
                               makeModel[0],
                               makeModel[1]
                       ));
               break;
           case 3:
               int[] yearRange = searchScreen.yearRange();
               displays.display(vehicleController.searchByYearRange(
                               yearRange[0],
                               yearRange[1]
                       ));
               break;
           case 4:
               displays.display(vehicleController.searchByColor(searchScreen.color()));
               break;
           case 5:
               int[] mileage = searchScreen.mileage();
               displays.display(vehicleController.searchByMileage(
                               mileage[0],
                               mileage[1]
                       ));
               break;
           case 6:
               displays.display(vehicleController.searchByVehicleType(searchScreen.vehicleType()));
               break;
           case 7:
               displays.display(vehicleController.getAll());
               break;
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

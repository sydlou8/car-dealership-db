package com.pluralsight.application;

import com.pluralsight.controllers.ContractController;
import com.pluralsight.controllers.VehicleController;
import com.pluralsight.models.Vehicle;
import com.pluralsight.models.contracts.Contract;
import com.pluralsight.models.contracts.LeaseContract;
import com.pluralsight.models.contracts.SalesContract;
import com.pluralsight.services.ContractDao;
import com.pluralsight.services.VehicleDao;
import com.pluralsight.services.mysql.MySqlVehicleDao;
import com.pluralsight.ui.*;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class CarDealership {
    private DataSource dataSource;
    private VehicleDao vehicleDao;

    private Displays displays;
    private HomeScreen homeScreen;
    private CRUDVehicleScreen crudScreen;
    private SearchVehicleScreen searchScreen;
    private ContractScreen contractScreen;

    private VehicleController vehicleController;
    private ContractController contractController;

    public CarDealership() {
        this.dataSource = buildDataSource();
        this.vehicleDao = new MySqlVehicleDao(dataSource);
        this.displays = new Displays();
        this.homeScreen = new HomeScreen();
        this.crudScreen = new CRUDVehicleScreen();
        this.searchScreen = new SearchVehicleScreen();
        this.contractScreen = new ContractScreen();
        this.vehicleController = new VehicleController(vehicleDao);
        this.contractController = new ContractController(dataSource, vehicleController);
    }

    private DataSource buildDataSource() {
        try (FileInputStream stream = new FileInputStream("src/main/resources/config.properties")) {
            // first get the variables from the properties file
            Properties properties = new Properties();
            properties.load(stream);

            String connectionString = properties.getProperty("db.connectionString");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");

            // build a BasicDataSource object
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setUrl(connectionString);
            dataSource.setUsername(username);
            dataSource.setPassword(password);

            return dataSource;

        } catch (IOException _) {}
        return null;
    }

    public void run () {
        while(true) {
            int choice = homeScreen.getHomeScreen();
            handleChoice(choice);
        }
    }

    private void handleChoice(int choice) {
       switch (choice) {
           case 1:
               double[] priceRange = searchScreen.priceRange();
               displays.display(vehicleController.searchByPriceRange(priceRange[0], priceRange[1]));
               break;
           case 2:
               String[] makeModel = searchScreen.makeModel();
               displays.display(vehicleController.searchByMakeModel(makeModel[0], makeModel[1]));
               break;
           case 3:
               int[] yearRange = searchScreen.yearRange();
               displays.display(vehicleController.searchByYearRange(yearRange[0], yearRange[1]));
               break;
           case 4:
               displays.display(vehicleController.searchByColor(searchScreen.color()));
               break;
           case 5:
               int[] mileage = searchScreen.mileage();
               displays.display(vehicleController.searchByMileage(mileage[0], mileage[1]));
               break;
           case 6:
               displays.display(vehicleController.searchByVehicleType(searchScreen.vehicleType()));
               break;
           case 7:
               List<Vehicle> vehicles = vehicleController.getAll();
               displays.display(vehicles);
               break;
           case 8:
               vehicleController.add(crudScreen.addVehicle());
               break;
           case 9:
               vehicleController.remove(crudScreen.removeVehicle());
               break;
           case 0:
               handleContracts();
               break;
           default:
               System.out.println("Goodbye!");
               System.exit(0);
       }
    }

    private void handleContracts() {
        int type = contractScreen.getContract();
        String[] userInfo;
        int vin;
        switch(type) {
            case 1:
                // Lease
                userInfo = contractScreen.getUser();
                vin = contractScreen.getVin();
                Contract leaseContract = contractController.processLeaseContract(userInfo, vin);
                contractController.add(leaseContract);
                break;
            case 2:
                // buy
                userInfo = contractScreen.getUser();
                vin = contractScreen.getVin();
                boolean finance = contractScreen.getFinance();
                Contract salesContract = contractController.processSalesContract(userInfo, vin, finance);
                contractController.add(salesContract);
                break;
            default:
                System.out.println("Goodbye!");
                System.exit(0);
        }
    }
}

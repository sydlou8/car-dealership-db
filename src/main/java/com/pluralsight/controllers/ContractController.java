package com.pluralsight.controllers;

import com.pluralsight.models.Vehicle;
import com.pluralsight.models.contracts.Contract;
import com.pluralsight.models.contracts.LeaseContract;
import com.pluralsight.models.contracts.SalesContract;
import com.pluralsight.services.LeaseDao;
import com.pluralsight.services.SalesDao;
import com.pluralsight.services.mysql.MySqlLeaseDao;
import com.pluralsight.services.mysql.MySqlSalesDao;

import javax.sql.DataSource;


public class ContractController {
    private LeaseDao leaseDao;
    private SalesDao salesDao;

    private VehicleController vehicleController;

    public ContractController (DataSource dataSource, VehicleController vehicleController) {
        this.leaseDao = new MySqlLeaseDao(dataSource);
        this.salesDao = new MySqlSalesDao(dataSource);

        this.vehicleController = vehicleController;
    }

    public void add(Contract contract) {
        if (contract instanceof LeaseContract) {
            leaseDao.saveContract((LeaseContract) contract);
        } else {
            salesDao.saveContract((SalesContract) contract);
        }
    }

    public LeaseContract processLeaseContract(String[] userInfo, int vin) {
        String name = userInfo[0];
        String email = userInfo[1];
        Vehicle vehicle = vehicleController.getVehicle(vin);
        return new LeaseContract(name, email, vehicle);
    }
    public SalesContract processSalesContract(String[] userInfo, int vin, boolean finance) {
        String name = userInfo[0];
        String email = userInfo[1];
        Vehicle vehicle = vehicleController.getVehicle(vin);
        return new SalesContract(name, email, vehicle, finance);
    }
}

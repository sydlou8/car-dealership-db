package com.pluralsight.services;

import com.pluralsight.models.contracts.SalesContract;

public interface SalesDao {
    // add a new Sale Contract
    void saveContract(SalesContract contract);
}

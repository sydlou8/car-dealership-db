package com.pluralsight.services;

import com.pluralsight.models.contracts.LeaseContract;

public interface LeaseDao {
    void saveContract(LeaseContract contract);
}

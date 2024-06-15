package com.pluralsight.services;

import com.pluralsight.models.contracts.LeaseContract;

public interface LeaseDao extends ContractDao{
    void saveContract(LeaseContract contract);
}

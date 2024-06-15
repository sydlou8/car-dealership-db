package com.pluralsight.services.mysql;

import com.pluralsight.models.Vehicle;
import com.pluralsight.models.contracts.SalesContract;
import com.pluralsight.services.SalesDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySqlSalesDao implements SalesDao {
    private DataSource dataSource;

    public MySqlSalesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void saveContract(SalesContract contract) {
        Vehicle vehicleSold = contract.getVehicleSold();
        try(Connection connection = dataSource.getConnection()) {
            String sql = """
                    INSERT INTO contracts (
                        contract_type
                        , date
                        , name
                        , email
                        , vin
                        , total_cost
                        , finance
                    ) VALUES (?, ?, ?, ?, ?, ?, ?);
                    """;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "SALE");
            statement.setString(2, contract.getDate());
            statement.setString(3, contract.getCustomerName());
            statement.setString(4, contract.getCustomerEmail());
            statement.setInt(5, vehicleSold.getVin());
            statement.setDouble(6, contract.getTotalPrice());
            statement.setBoolean(7, contract.isFinance());

            statement.executeUpdate();
            System.out.println(contract);
            System.out.println("[ADDED TO DATABASE]");
        } catch (SQLException _) {}
    }
}

package com.pluralsight.services.mysql;

import com.pluralsight.models.Vehicle;
import com.pluralsight.services.VehicleDao;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlVehicleDao implements VehicleDao {
    private DataSource dataSource;

    private Vehicle mapRow(ResultSet row) {
        try {
            int vin = row.getInt("vin");
            int year = row.getInt("year");
            String make = row.getString("make");
            String model = row.getString("model");
            String vehicleType = row.getString("vehicleType");
            String color = row.getString("color");
            int odometer = row.getInt("odometer");
            double price = row.getDouble("price");

            return new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        } catch (SQLException _) {
            System.out.println("SQL Exception Occurred");
        }
        return null;
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        try(Connection connection = dataSource.getConnection())
        {
            String sql = """
                    INSERT INTO vehicles (
                        vin
                        , year
                        , make
                        , model
                        , vehicleType
                        , color
                        , odometer
                        , price
                    ) VALUES (?, ?, ?, ?, ?, ?, ?, ?);
                    """;

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, vehicle.getVin());
            statement.setInt(2, vehicle.getYear());
            statement.setString(3, vehicle.getMake());
            statement.setString(4, vehicle.getModel());
            statement.setString(5, vehicle.getVehicleType());
            statement.setString(6, vehicle.getColor());
            statement.setInt(7, vehicle.getOdometer());
            statement.setDouble(8, vehicle.getPrice());

            statement.executeUpdate();

            System.out.println(vehicle);
            System.out.println("[ADDED TO DATABASE]");
        } catch (Exception _){}
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()){
            String sql = "SELECT * FROM vehicles";

            Statement statement = connection.createStatement();
            ResultSet row = statement.executeQuery(sql);

            while(row.next()) {
                Vehicle vehicle = mapRow(row);
                vehicles.add(vehicle);
            }
            return List.of();
        } catch (SQLException _) {}
        return vehicles;
    }

    @Override
    public List<Vehicle> getByPriceRange(double min, double max) {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()){
            String sql = """
                    SELECT * FROM vehicles
                    WHERE price BETWEEN ? AND ?;
                    """;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, min);
            statement.setDouble(2, max);

            ResultSet row = statement.executeQuery();
            while(row.next()) {
                Vehicle vehicle = mapRow(row);
                vehicles.add(vehicle);
            }
        } catch (SQLException _) {}
        return vehicles;
    }

    @Override
    public List<Vehicle> getByMakeModel(String make, String model) {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()){
            String sql = """
                    SELECT * FROM vehicles
                    WHERE make = ? AND model = ?;
                    """;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, make);
            statement.setString(2, model);

            ResultSet row = statement.executeQuery();
            while(row.next()) {
                Vehicle vehicle = mapRow(row);
                vehicles.add(vehicle);
            }
        } catch (SQLException _) {}
        return vehicles;
    }

    @Override
    public List<Vehicle> getByYearRange(int min, int max) {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()){
            String sql = """
                    SELECT * FROM vehicles
                    WHERE year BETWEEN ? AND ?;
                    """;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, min);
            statement.setInt(2, max);

            ResultSet row = statement.executeQuery();
            while(row.next()) {
                Vehicle vehicle = mapRow(row);
                vehicles.add(vehicle);
            }
        } catch (SQLException _) {}
        return vehicles;
    }

    @Override
    public List<Vehicle> getByColor(String color) {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()){
            String sql = """
                    SELECT * FROM vehicles
                    WHERE color = ?;
                    """;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, color);

            ResultSet row = statement.executeQuery();
            while(row.next()) {
                Vehicle vehicle = mapRow(row);
                vehicles.add(vehicle);
            }
        } catch (SQLException _) {}
        return vehicles;
    }

    @Override
    public List<Vehicle> getByMileage(int min, int max) {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()){
            String sql = """
                    SELECT * FROM vehicles
                    WHERE odometer BETWEEN ? AND ?;
                    """;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, min);
            statement.setInt(2, max);

            ResultSet row = statement.executeQuery();
            while(row.next()) {
                Vehicle vehicle = mapRow(row);
                vehicles.add(vehicle);
            }
        } catch (SQLException _) {}
        return vehicles;
    }

    @Override
    public List<Vehicle> getByVehicleType(String vehicleType) {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()){
            String sql = """
                    SELECT * FROM vehicles
                    WHERE vehicleType = ?;
                    """;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, vehicleType);

            ResultSet row = statement.executeQuery();
            while(row.next()) {
                Vehicle vehicle = mapRow(row);
                vehicles.add(vehicle);
            }
        } catch (SQLException _) {}
        return vehicles;
    }

    @Override
    public void removeVehicleByVin(int vin) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = """
                    REMOVE * FROM vehicles
                    WHERE vin = ?;
                    """;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, vin);
            statement.executeUpdate();

            System.out.println("[VEHICLE OF VIN: " + vin + " REMOVED FROM DATABASE]");
        } catch (SQLException _) {}
    }
}

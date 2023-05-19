/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.secondhanddbcars;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kovacs.mark
 */
public class CarManager {

    private final String URL = "jdbc:sqlite:Secondhand.db";

    public List<Car> getAllCars() {
        try {
            Statement st = getStatement();
            List<Car> cars = new ArrayList<>();
            ResultSet resultSet = st.executeQuery(
                    "SELECT * FROM Cars");
            while (resultSet.next()) {
                String plateNumber = resultSet.getString(
                        "PlateNumber");
                String carType = resultSet.getString(
                        "CarType");
                int price = resultSet.getInt(
                        "Price");
                int year = resultSet.getInt(
                        "Year");
                int carBrandId = resultSet.getInt(
                        "CarBrandId");
                Car car = new Car(plateNumber, carType,
                        price, year, carBrandId);
                cars.add(car);
            }
            return cars;
        } catch (SQLException e) {
            System.out.println("Hiba történt: " + e.getMessage());
            return null;
        }
    }

    public List<CarBrand> getAllCarBrands() {
        try {
            Statement st = getStatement();
            List<CarBrand> carBrands = new ArrayList<>();
            ResultSet resultSet = st.executeQuery(
                    "SELECT * FROM CarBrands");
            while (resultSet.next()) {
                int id = resultSet.getInt(
                        "Id");
                String brandName = resultSet.getString(
                        "BrandName");
                String description = resultSet.getString(
                        "Description");
                CarBrand cb = new CarBrand(
                        id, brandName, description);
                carBrands.add(cb);
            }
            return carBrands;
        } catch (SQLException e) {
            System.out.println("Hiba történt: " + e.getMessage());
            return null;
        }
    }

    public List<CarQuery> getAll() {
        try {
            Statement st = getStatement();
            String query = "SELECT c.PlateNumber, b.BrandName, \n"
                    + "c.CarType, c.Price, c.Year\n"
                    + "FROM Cars as c\n"
                    + "INNER JOIN CarBrands as b\n"
                    + "on c.CarBrandId = b.Id";
            List<CarQuery> carQueries = new ArrayList<>();
            boolean isQuery = st.execute(query);
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                String plateNumber
                        = rs.getString("PlateNumber");
                String carType
                        = rs.getString("CarType");
                String brandName
                        = rs.getString("BrandName");
                int price = rs.getInt("Price");
                int year = rs.getInt("Year");
                carQueries.add(new CarQuery(plateNumber, carType,
                        price, year, brandName));
            }
            return carQueries;
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean insertCar(Car car) {
        String sql = "INSERT INTO Cars(PlateNumber, CarType, "
                + "Price, Year,CarBrandId)\n"
                + "VALUES ('" + car.getPlateNumber() + "', '"
                + car.getCarType() + "', "
                + car.getPrice() + ", "
                + car.getYear() + ", "
                + car.getCarBrandId() + ")";
        try {
            Statement st = getStatement();
            int rows = st.executeUpdate(sql);

            return rows == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteCar(String plateNumber) {
        String sql = "DELETE FROM Cars WHERE PlateNumber = '"
                + plateNumber + "'";
        try {
            Statement statement = getStatement();
            int rows = statement.executeUpdate(sql);
            return rows == 1; //true
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
        }
        return false;
    }

    public CarQuery maxPrice() {
        try (Statement statement = getStatement()) {
            List<CarQuery> cars = getAll();
            CarQuery maxPrice = cars.get(0);
            for (int i = 1; i < cars.size(); i++) {
                if (cars.get(i).getPrice() > maxPrice.getPrice()) {
                    maxPrice = cars.get(i);
                }
            }
            return maxPrice;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean updateCarPrice(String plateNumber, int price) {
        String sql = "UPDATE Cars SET Price = ? WHERE "
                + "PlateNumber = ?";
        try(Connection conn = DriverManager.getConnection(URL);
                PreparedStatement statement = 
                        conn.prepareStatement(sql)) {
            statement.setInt(1, price);
            statement.setString(2, plateNumber);
            
            int rows = statement.executeUpdate();
            
            return rows == 1;
        } catch (Exception e) {
        }
        return false;
    }
    
    private Statement getStatement() throws SQLException {
        Connection connection = DriverManager.getConnection(URL);
        Statement st = connection.createStatement();
        return st;
    }
}

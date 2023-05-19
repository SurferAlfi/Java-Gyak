/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.secondhanddbcars;

/**
 *
 * @author kovacs.mark
 */
public class Car {
    private String plateNumber;
    private String carType;
    private int price;
    private int year;
    private int carBrandId;

    public Car(String plateNumber, String carType, int price, int year, int carBrandId) {
        this.plateNumber = plateNumber;
        this.carType = carType;
        this.price = price;
        this.year = year;
        this.carBrandId = carBrandId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCarBrandId() {
        return carBrandId;
    }

    public void setCarBrandId(int carBrandId) {
        this.carBrandId = carBrandId;
    }

    @Override
    public String toString() {
        return "Car{" + "plateNumber=" + plateNumber + ", carType=" + carType + ", price=" + price + ", year=" + year + ", carBrandId=" + carBrandId + '}';
    }
}

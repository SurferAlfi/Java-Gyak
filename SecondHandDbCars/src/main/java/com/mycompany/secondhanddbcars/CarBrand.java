/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.secondhanddbcars;

/**
 *
 * @author kovacs.mark
 */
public class CarBrand {
    private int id;
    private String brandName;
    private String description;

    public CarBrand(int id, String brandName, String description) {
        this.id = id;
        this.brandName = brandName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CarBrand{" + "id=" + id + ", brandName=" + brandName + ", description=" + description + '}';
    }
    
    
}

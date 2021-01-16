/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.model;

/**
 *
 * @author Admin
 */
public class loai_phongModel extends abstractModel {
   
    
    private Long id;
    private String name_LP;
    private float price;
    private int maxPeople;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_LP() {
        return name_LP;
    }

    public void setName_LP(String name_LP) {
        this.name_LP = name_LP;
    }

    

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    @Override
    public String toString() {
        return this.name_LP;
    }
    
    
    
}

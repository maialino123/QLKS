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
    
    //singleTon Pattern
    private static loai_phongModel instance = null;
    
    public static loai_phongModel getInstance(){
        if (instance == null) {
            instance = new loai_phongModel();
        }
        return instance;
    }
    //singleTon Pattern
    
    private Long id;
    private String name;
    private float price;
    private int maxPeople;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    
    
}

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
public class dich_vuModel extends abstractModel {
    //singleTon pattern
    private static dich_vuModel instance = null;
    public static dich_vuModel getInstance(){
        if (instance == null) {
            instance = new dich_vuModel();
        }
        return instance;
    }
    //singleTon pattern
    
    private Long id;
    private Long id_LDV;
    private float price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_LDV() {
        return id_LDV;
    }

    public void setId_LDV(Long id_LDV) {
        this.id_LDV = id_LDV;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}

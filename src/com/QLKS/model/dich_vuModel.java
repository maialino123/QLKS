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
public class dich_vuModel  extends abstractModel{
    
     //singleTon Pattern
    private static dich_vuModel instance = null;
    
    public static dich_vuModel getInstance(){
        if (instance == null) {
            instance = new dich_vuModel();
        }
        return instance;
    }
    //singleTon Pattern
    
    private Long id;
    private Long id_LDV;
    private Long id_DV;
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

    public Long getId_DV() {
        return id_DV;
    }

    public void setId_DV(Long id_DV) {
        this.id_DV = id_DV;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}

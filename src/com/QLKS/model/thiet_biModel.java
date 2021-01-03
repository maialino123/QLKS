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
public class thiet_biModel extends abstractModel {
    
     //singleTon Pattern
    private static thiet_biModel instance = null;
    
    public static thiet_biModel getInstance(){
        if (instance == null) {
            instance = new thiet_biModel();
        }
        return instance;
    }
    //singleTon Pattern
    
    private Long id;
    private Long id_LP;
    private String name;
    private int amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_LP() {
        return id_LP;
    }

    public void setId_LP(Long id_LP) {
        this.id_LP = id_LP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
}

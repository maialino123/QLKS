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
public class su_dung_dich_vuModel {
    
     //singleTon pattern
    private static su_dung_dich_vuModel instance = null;
    public static su_dung_dich_vuModel getInstance(){
        if (instance == null) {
            instance = new su_dung_dich_vuModel();
        }
        return instance;
    }
    //singleTon pattern
    
    private Long id;
    private Long id_DV;
    private int amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_DV() {
        return id_DV;
    }

    public void setId_DV(Long id_DV) {
        this.id_DV = id_DV;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
}

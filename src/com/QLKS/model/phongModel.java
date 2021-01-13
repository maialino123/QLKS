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
public class phongModel extends abstractModel {
    //singleTon pattern
    private static phongModel instance = null;
    public static phongModel getInstance(){
        if (instance == null) {
            instance = new phongModel();
        }
        return instance;
    }
    //singleTon pattern
    
    private String id;
    private Long id_LP;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getId_LP() {
        return id_LP;
    }

    public void setId_LP(Long id_LP) {
        this.id_LP = id_LP;
    }
    
    
}

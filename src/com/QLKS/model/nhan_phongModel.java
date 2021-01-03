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
public class nhan_phongModel extends abstractModel{
    //singleTon Pattern
    private static nhan_phongModel instance = null;
    
    public static nhan_phongModel getInstance(){
        if (instance == null) {
            instance = new nhan_phongModel();
        }
        return instance;
    }
    //singleTon Pattern
    
    private Long id;
    private Long id_KH;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_KH() {
        return id_KH;
    }

    public void setId_KH(Long id_KH) {
        this.id_KH = id_KH;
    }
    
    
}

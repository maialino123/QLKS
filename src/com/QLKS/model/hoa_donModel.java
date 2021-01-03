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
public class hoa_donModel extends abstractModel {
    
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
    private Long id_KH;
    private Long id_NP;
    private Long id_KM;

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

    public Long getId_NP() {
        return id_NP;
    }

    public void setId_NP(Long id_NP) {
        this.id_NP = id_NP;
    }

    public Long getId_KM() {
        return id_KM;
    }

    public void setId_KM(Long id_KM) {
        this.id_KM = id_KM;
    }
    
    
}

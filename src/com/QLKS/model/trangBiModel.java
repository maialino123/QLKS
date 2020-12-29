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
public class trangBiModel extends abstractModel {
    
     //    singleTon pattern
    private static trangBiModel instance = null;

    public static trangBiModel getInstance() {
        if (instance == null) {
            instance = new trangBiModel();
        }
        return instance;

    }

//    singleTon pattern
    
    
    private int maTb;
    private String maLp;
    private int soLuong;

    public int getMaTb() {
        return maTb;
    }

    public void setMaTb(int maTb) {
        this.maTb = maTb;
    }

    public String getMaLp() {
        return maLp;
    }

    public void setMaLp(String maLp) {
        this.maLp = maLp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    
}

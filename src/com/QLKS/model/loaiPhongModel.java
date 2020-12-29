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
public class loaiPhongModel extends abstractModel{
    
    
      //    singleTon pattern
    private static loaiPhongModel instance = null;

    public static loaiPhongModel getInstance() {
        if (instance == null) {
            instance = new loaiPhongModel();
        }
        return instance;

    }

//    singleTon pattern
    
    
    
    
    private String maLp;
    private String tenLp;
    private float giaLp;
    private int soNguoi;

    public loaiPhongModel() {
    }

    public loaiPhongModel(String maLp, String tenLp, float giaLp, int soNguoi) {
        this.maLp = maLp;
        this.tenLp = tenLp;
        this.giaLp = giaLp;
        this.soNguoi = soNguoi;
    }

    public int getSoNguoi() {
        return soNguoi;
    }

    public void setSoNguoi(int soNguoi) {
        this.soNguoi = soNguoi;
    }
    
    

    public String getMaLp() {
        return maLp;
    }

    public void setMaLp(String maLp) {
        this.maLp = maLp;
    }

    public String getTenLp() {
        return tenLp;
    }

    public void setTenLp(String tenLp) {
        this.tenLp = tenLp;
    }

    public float getGiaLp() {
        return giaLp;
    }

    public void setGiaLp(float giaLp) {
        this.giaLp = giaLp;
    }
    
    
}

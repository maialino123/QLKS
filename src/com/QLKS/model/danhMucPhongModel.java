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
public class danhMucPhongModel extends abstractModel{
    
    //    singleTon pattern
    private static danhMucPhongModel instance = null;

    public static danhMucPhongModel getInstance() {
        if (instance == null) {
            instance = new danhMucPhongModel();
        }
        return instance;

    }

//    singleTon pattern
    
    
    
    private String maPhong;
    private String tinhTrang;
    private String dacDiem;
    private String maLp;
    private boolean status;

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getDacDiem() {
        return dacDiem;
    }

    public void setDacDiem(String dacDiem) {
        this.dacDiem = dacDiem;
    }

    public String getMaLp() {
        return maLp;
    }

    public void setMaLp(String maLp) {
        this.maLp = maLp;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}

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
    private String maLp;
    private String tenLp;
    private float giaLp;

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

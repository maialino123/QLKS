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
public class tienTeModel extends abstractModel {
    private String maTT;
    private String tenTienTe;
    private float doiSanVND;

    public String getMaTT() {
        return maTT;
    }

    public void setMaTT(String maTT) {
        this.maTT = maTT;
    }

    public String getTenTienTe() {
        return tenTienTe;
    }

    public void setTenTienTe(String tenTienTe) {
        this.tenTienTe = tenTienTe;
    }

    public float getDoiSanVND() {
        return doiSanVND;
    }

    public void setDoiSanVND(float doiSanVND) {
        this.doiSanVND = doiSanVND;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.model;

import java.sql.Timestamp;

/**
 *
 * @author Admin
 */
public class suDungDVModel extends abstractModel {
    
    
   //    singleTon pattern
    private static suDungDVModel instance = null;

    public static suDungDVModel getInstance() {
        if (instance == null) {
            instance = new suDungDVModel();
        }
        return instance;

    }

//    singleTon pattern
    
    
    private int soHopDongTp;
    private int maTB;
    private Timestamp ngaySD;
    private int soLuong;

    public int getSoHopDongTp() {
        return soHopDongTp;
    }

    public void setSoHopDongTp(int soHopDongTp) {
        this.soHopDongTp = soHopDongTp;
    }

    public int getMaTB() {
        return maTB;
    }

    public void setMaTB(int maTB) {
        this.maTB = maTB;
    }

    public Timestamp getNgaySD() {
        return ngaySD;
    }

    public void setNgaySD(Timestamp ngaySD) {
        this.ngaySD = ngaySD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.model;

import java.sql.Timestamp;
import java.time.LocalDate;


/**
 *
 * @author Admin
 */
public class thuePhongModel {
    private int soHopDongTP;
    private String maNV;
    private int maKH;
    private Timestamp ngayThue;
    private LocalDate ngayTra;

  
    public thuePhongModel() {
    }
      

    

 
    public thuePhongModel(int soHopDongTP, String maNV, int maKH, Timestamp ngayThue, LocalDate ngayTra) {
        this.soHopDongTP = soHopDongTP;
        this.maNV = maNV;
        this.maKH = maKH;
        this.ngayThue = ngayThue;
        this.ngayTra = ngayTra;
    }

    public LocalDate getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(LocalDate ngayTra) {
        this.ngayTra = ngayTra;
    }
    public int getSoHopDongTP() {
        return soHopDongTP;
    }

    public void setSoHopDongTP(int soHopDongTP) {
        this.soHopDongTP = soHopDongTP;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public Timestamp getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(Timestamp ngayThue) {
        this.ngayThue = ngayThue;
    }

    
    
}
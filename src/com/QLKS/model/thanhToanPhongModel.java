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
public class thanhToanPhongModel extends abstractModel {
    
    //    singleTon pattern
    private static thanhToanPhongModel instance = null;

    public static thanhToanPhongModel getInstance() {
        if (instance == null) {
            instance = new thanhToanPhongModel();
        }
        return instance;

    }

//    singleTon pattern
    
    
    private int soTT;
    private Timestamp ngayThanhToan;
    private float tienPhong;
    private float tienDichVu;
    private int soHopDongTP;
    private String maNV;

    public int getSoTT() {
        return soTT;
    }

    public void setSoTT(int soTT) {
        this.soTT = soTT;
    }

    public Timestamp getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Timestamp ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public float getTienPhong() {
        return tienPhong;
    }

    public void setTienPhong(float tienPhong) {
        this.tienPhong = tienPhong;
    }

    public float getTienDichVu() {
        return tienDichVu;
    }

    public void setTienDichVu(float tienDichVu) {
        this.tienDichVu = tienDichVu;
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
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.model;

import java.time.LocalDate;



/**
 *
 * @author Admin
 */
public class KH_TiemNangModel extends khachHangModel {
    private int maKH_TN;

    public KH_TiemNangModel() {
    }

     
    

    public KH_TiemNangModel(int maKH_TN, int maKH, String hoTen, String cmnd, LocalDate ngaySinh, String gioiTinh, String thanhPho, String diaChi, String sdt, int soLanCheckIn, String maQG, String maTT) {
        super(maKH, hoTen, cmnd, ngaySinh, gioiTinh, thanhPho, diaChi, sdt, soLanCheckIn, maQG, maTT);
        this.maKH_TN = maKH_TN;
    }

    public int getMaKH_TN() {
        return maKH_TN;
    }

    public void setMaKH_TN(int maKH_TN) {
        this.maKH_TN = maKH_TN;
    }
    
    
    
}

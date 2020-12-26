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
public class khachHangModel extends abstractModel {
    private int maKH;
    private String hoTen;
    private String cmnd;
    private LocalDate ngaySinh;
    private String gioiTinh;
    private String thanhPho;
    private String diaChi;
    private String sdt;
    private int soLanCheckIn;
    private String maQG;
    private String maTT;

    public khachHangModel() {
    }
    
    

    public khachHangModel(int maKH, String hoTen, String cmnd, LocalDate ngaySinh, String gioiTinh, String thanhPho, String diaChi, String sdt, int soLanCheckIn, String maQG, String maTT) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.cmnd = cmnd;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.thanhPho = thanhPho;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.soLanCheckIn = soLanCheckIn;
        this.maQG = maQG;
        this.maTT = maTT;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getSoLanCheckIn() {
        return soLanCheckIn;
    }

    public void setSoLanCheckIn(int soLanCheckIn) {
        this.soLanCheckIn = soLanCheckIn;
    }

    public String getMaQG() {
        return maQG;
    }

    public void setMaQG(String maQG) {
        this.maQG = maQG;
    }

    public String getMaTT() {
        return maTT;
    }

    public void setMaTT(String maTT) {
        this.maTT = maTT;
    }
    
    
}

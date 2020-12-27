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
public class bookingModel extends abstractModel {
    private int bkId;
    private String hoTen;
    private String cmnd;
    private LocalDate ngaySinh;
    private String gioiTinh;
    private String thanhPho;
    private String diaChi;
    private String sdt;
    private String email;
    private LocalDate ngayDangKy;
    private LocalDate ngayNhan;
    private float datCoc;
    private String yeuCau;
    private String maNV;
    private String maQG;

    public bookingModel() {
    }
    
    

    public bookingModel(int bkId, String hoTen, String cmnd, LocalDate ngaySinh, String gioiTinh, String thanhPho, String diaChi, String sdt, String email, LocalDate ngayDangKy, LocalDate ngayNhan, float datCoc, String yeuCau, String maNV, String maQG) {
        this.bkId = bkId;
        this.hoTen = hoTen;
        this.cmnd = cmnd;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.thanhPho = thanhPho;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.ngayDangKy = ngayDangKy;
        this.ngayNhan = ngayNhan;
        this.datCoc = datCoc;
        this.yeuCau = yeuCau;
        this.maNV = maNV;
        this.maQG = maQG;
    }

    public int getBkId() {
        return bkId;
    }

    public void setBkId(int bkId) {
        this.bkId = bkId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(LocalDate ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public LocalDate getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(LocalDate ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public float getDatCoc() {
        return datCoc;
    }

    public void setDatCoc(float datCoc) {
        this.datCoc = datCoc;
    }

    public String getYeuCau() {
        return yeuCau;
    }

    public void setYeuCau(String yeuCau) {
        this.yeuCau = yeuCau;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaQG() {
        return maQG;
    }

    public void setMaQG(String maQG) {
        this.maQG = maQG;
    }
    
    
    
}

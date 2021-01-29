/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class hoa_donModel extends abstractModel {
   
    private Long id;
    private Long id_KH;
    private String id_P;
    private Long id_TTHD;
    private String hinh_thucTT;
    private float phu_phi;
    private float tien_phong;
    private float tien_dich_vu;
    private float giam_giaKH;
    private float so_ngay;
    private float thanh_tien;
    private Date so_ngay_thuc_te;
    private Date so_ngay_du_kien;
    private Date ngay_den_thuc_te;
    private Date ngay_den_du_kien;
    private khach_hang_model khach_hang = new khach_hang_model();
    private phongModel phong = new phongModel();
    private trang_thai_hoa_donModel trang_thaiHD = new trang_thai_hoa_donModel();
    private su_dung_dich_vuModel su_dungDV = new su_dung_dich_vuModel();

    public khach_hang_model getKhach_hang() {
        return khach_hang;
    }

    public void setKhach_hang(khach_hang_model khach_hang) {
        this.khach_hang = khach_hang;
    }

    public phongModel getPhong() {
        return phong;
    }

    public void setPhong(phongModel phong) {
        this.phong = phong;
    }

    public trang_thai_hoa_donModel getTrang_thaiHD() {
        return trang_thaiHD;
    }

    public void setTrang_thaiHD(trang_thai_hoa_donModel trang_thaiHD) {
        this.trang_thaiHD = trang_thaiHD;
    }

    public su_dung_dich_vuModel getSu_dungDV() {
        return su_dungDV;
    }

    public void setSu_dungDV(su_dung_dich_vuModel su_dungDV) {
        this.su_dungDV = su_dungDV;
    }

    public Date getNgay_den_thuc_te() {
        return ngay_den_thuc_te;
    }

    public void setNgay_den_thuc_te(Date ngay_den_thuc_te) {
        this.ngay_den_thuc_te = ngay_den_thuc_te;
    }

    public Date getNgay_den_du_kien() {
        return ngay_den_du_kien;
    }

    public void setNgay_den_du_kien(Date ngay_den_du_kien) {
        this.ngay_den_du_kien = ngay_den_du_kien;
    }
    
    public Date getSo_ngay_thuc_te() {
        return so_ngay_thuc_te;
    }

    public void setSo_ngay_thuc_te(Date so_ngay_thuc_te) {
        this.so_ngay_thuc_te = so_ngay_thuc_te;
    }

    public Date getSo_ngay_du_kien() {
        return so_ngay_du_kien;
    }

    public void setSo_ngay_du_kien(Date so_ngay_du_kien) {
        this.so_ngay_du_kien = so_ngay_du_kien;
    }
    
    public float getTien_dich_vu() {
        return tien_dich_vu;
    }

    public void setTien_dich_vu(float tien_dich_vu) {
        this.tien_dich_vu = tien_dich_vu;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_KH() {
        return id_KH;
    }

    public void setId_KH(Long id_KH) {
        this.id_KH = id_KH;
    }

    public String getId_P() {
        return id_P;
    }

    public void setId_P(String id_P) {
        this.id_P = id_P;
    }

    public Long getId_TTHD() {
        return id_TTHD;
    }

    public void setId_TTHD(Long id_TTHD) {
        this.id_TTHD = id_TTHD;
    }
    public String getHinh_thucTT() {
        return hinh_thucTT;
    }

    public void setHinh_thucTT(String hinh_thucTT) {
        this.hinh_thucTT = hinh_thucTT;
    }

    public float getPhu_phi() {
        return phu_phi;
    }

    public void setPhu_phi(float phu_phi) {
        this.phu_phi = phu_phi;
    }

    public float getTien_phong() {
        return tien_phong;
    }

    public void setTien_phong(float tien_phong) {
        this.tien_phong = tien_phong;
    }

    public float getGiam_giaKH() {
        return giam_giaKH;
    }

    public void setGiam_giaKH(float giam_giaKH) {
        this.giam_giaKH = giam_giaKH;
    }

    public float getSo_ngay() {
        return so_ngay;
    }

    public void setSo_ngay(float so_ngay) {
        this.so_ngay = so_ngay;
    }

    public float getThanh_tien() {
        return thanh_tien;
    }

    public void setThanh_tien(float thanh_tien) {
        this.thanh_tien = thanh_tien;
    }
    
    
}

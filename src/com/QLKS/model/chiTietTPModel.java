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
public class chiTietTPModel extends abstractModel {
    private int soHopDongTP;
    private int maKH;
    private String vaiTro;

    public chiTietTPModel(int soHopDongTP, int maKH, String vaiTro) {
        this.soHopDongTP = soHopDongTP;
        this.maKH = maKH;
        this.vaiTro = vaiTro;
    }

    public int getSoHopDongTP() {
        return soHopDongTP;
    }

    public void setSoHopDongTP(int soHopDongTP) {
        this.soHopDongTP = soHopDongTP;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }
    
    
    
    
}

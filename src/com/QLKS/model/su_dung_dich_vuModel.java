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
public class su_dung_dich_vuModel {
    
   
    
    private Long id;
    private Long id_DV;
    private int amount;
    private String id_P;
    private dich_vuModel dich_vu = new dich_vuModel();
    private phongModel phong = new phongModel();

    public String getId_P() {
        return id_P;
    }

    public void setId_P(String id_P) {
        this.id_P = id_P;
    }
    public phongModel getPhong() {
        return phong;
    }

    public void setPhong(phongModel phong) {
        this.phong = phong;
    }
    public dich_vuModel getDich_vu() {
        return dich_vu;
    }

    public void setDich_vu(dich_vuModel dich_vu) {
        this.dich_vu = dich_vu;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_DV() {
        return id_DV;
    }

    public void setId_DV(Long id_DV) {
        this.id_DV = id_DV;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return this.dich_vu.toString();
    }
    
    
}

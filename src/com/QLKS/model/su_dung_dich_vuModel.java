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
    private Long id_HD;
    private dich_vuModel dich_vu = new dich_vuModel();

    public Long getId_HD() {
        return id_HD;
    }

    public void setId_HD(Long id_HD) {
        this.id_HD = id_HD;
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

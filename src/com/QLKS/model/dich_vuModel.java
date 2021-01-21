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
public class dich_vuModel extends abstractModel {
    
    private Long id;
    private Long id_LDV;
    private float price;
    private Long id_DV;
    private loai_dich_vuModel loai_dich_vuModel = new loai_dich_vuModel();
    private don_viModel don_viModel = new don_viModel();

    public Long getId_DV() {
        return id_DV;
    }

    public void setId_DV(Long id_DV) {
        this.id_DV = id_DV;
    }
    
    public don_viModel getDon_viModel() {
        return don_viModel;
    }

    public void setDon_viModel(don_viModel don_viModel) {
        this.don_viModel = don_viModel;
    }
    public loai_dich_vuModel getLoai_dich_vuModel() {
        return loai_dich_vuModel;
    }

    public void setLoai_dich_vuModel(loai_dich_vuModel loai_dich_vuModel) {
        this.loai_dich_vuModel = loai_dich_vuModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_LDV() {
        return id_LDV;
    }

    public void setId_LDV(Long id_LDV) {
        this.id_LDV = id_LDV;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.getLoai_dich_vuModel().getName();
    }
    
    
    
    
}

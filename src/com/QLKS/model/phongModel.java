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
public class phongModel extends abstractModel {
   
    
    private String id;
    private Long id_LP;
    private boolean status;
    private loai_phongModel loai_phong = new loai_phongModel();

    public loai_phongModel getLoai_phong() {
        return loai_phong;
    }

    public void setLoai_phong(loai_phongModel loai_phong) {
        this.loai_phong = loai_phong;
    }
    
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getId_LP() {
        return id_LP;
    }

    public void setId_LP(Long id_LP) {
        this.id_LP = id_LP;
    }
    
    
}

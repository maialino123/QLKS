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
public class khuyen_maiModel extends abstractModel {
   
    private Long id;
    private String code;
    private float value;
    private String content;
    private boolean type;
    private Date thoi_gian_bat_dau;
    private Date thoi_gian_ket_thuc;

    public Date getThoi_gian_bat_dau() {
        return thoi_gian_bat_dau;
    }

    public void setThoi_gian_bat_dau(Date thoi_gian_bat_dau) {
        this.thoi_gian_bat_dau = thoi_gian_bat_dau;
    }

    public Date getThoi_gian_ket_thuc() {
        return thoi_gian_ket_thuc;
    }

    public void setThoi_gian_ket_thuc(Date thoi_gian_ket_thuc) {
        this.thoi_gian_ket_thuc = thoi_gian_ket_thuc;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }
    
    
}

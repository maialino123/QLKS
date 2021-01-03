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
public class CT_nhan_phong extends abstractModel {
    
    //singleTon Pattern
    private static CT_nhan_phong instance = null;
    
    public static CT_nhan_phong getInstance(){
        if (instance == null) {
            instance = new CT_nhan_phong();
        }
        return instance;
    }
    //singleTon Pattern
    
    private Long id_NP;
    private String id_phong;
    private String nameKH;
    private String identityCard;
    private Date receivedDate;
    private Date payDateExpect;

    public Long getId_NP() {
        return id_NP;
    }

    public void setId_NP(Long id_NP) {
        this.id_NP = id_NP;
    }

    public String getId_phong() {
        return id_phong;
    }

    public void setId_phong(String id_phong) {
        this.id_phong = id_phong;
    }

    public String getNameKH() {
        return nameKH;
    }

    public void setNameKH(String nameKH) {
        this.nameKH = nameKH;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Date getPayDateExpect() {
        return payDateExpect;
    }

    public void setPayDateExpect(Date payDateExpect) {
        this.payDateExpect = payDateExpect;
    }
    
    
}

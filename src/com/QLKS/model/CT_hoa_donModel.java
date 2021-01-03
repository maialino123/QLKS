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
public class CT_hoa_donModel extends abstractModel {
    
     //singleTon Pattern
    private static CT_hoa_donModel instance = null;
    
    public static CT_hoa_donModel getInstance(){
        if (instance == null) {
            instance = new CT_hoa_donModel();
        }
        return instance;
    }
    //singleTon Pattern
    
    
    private Long id_HD;
    private String id_P;
    private Long id_sddv;
    private Long id_CSTP;
    private float surCharge;
    private float roomCharge;
    private float serviceFee;
    private float discount;
    private String payments;
    private int numberDays;
    private float totalMoney;

    public Long getId_HD() {
        return id_HD;
    }

    public void setId_HD(Long id_HD) {
        this.id_HD = id_HD;
    }

    public String getId_P() {
        return id_P;
    }

    public void setId_P(String id_P) {
        this.id_P = id_P;
    }

    public Long getId_sddv() {
        return id_sddv;
    }

    public void setId_sddv(Long id_sddv) {
        this.id_sddv = id_sddv;
    }

    public Long getId_CSTP() {
        return id_CSTP;
    }

    public void setId_CSTP(Long id_CSTP) {
        this.id_CSTP = id_CSTP;
    }

    public float getSurCharge() {
        return surCharge;
    }

    public void setSurCharge(float surCharge) {
        this.surCharge = surCharge;
    }

    public float getRoomCharge() {
        return roomCharge;
    }

    public void setRoomCharge(float roomCharge) {
        this.roomCharge = roomCharge;
    }

    public float getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(float serviceFee) {
        this.serviceFee = serviceFee;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getPayments() {
        return payments;
    }

    public void setPayments(String payments) {
        this.payments = payments;
    }

    public int getNumberDays() {
        return numberDays;
    }

    public void setNumberDays(int numberDays) {
        this.numberDays = numberDays;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }
    
    
}

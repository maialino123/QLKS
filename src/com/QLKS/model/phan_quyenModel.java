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
public class phan_quyenModel {
    
     //singleTon pattern
    private static phan_quyenModel instance = null;
    public static phan_quyenModel getInstance(){
        if (instance == null) {
            instance = new phan_quyenModel();
        }
        return instance;
    }
    //singleTon pattern
    
    
    private Long id_Q;
    private Long id_NQ;
    
    
    

    public Long getId_Q() {
        return id_Q;
    }

    public void setId_Q(Long id_Q) {
        this.id_Q = id_Q;
    }

    public Long getId_NQ() {
        return id_NQ;
    }

    public void setId_NQ(Long id_NQ) {
        this.id_NQ = id_NQ;
    }
    
    
    
}

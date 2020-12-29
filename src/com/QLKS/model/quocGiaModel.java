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
public class quocGiaModel extends abstractModel {
    
    //    singleTon pattern
    private static quocGiaModel instance = null;

    public static quocGiaModel getInstance() {
        if (instance == null) {
            instance = new quocGiaModel();
        }
        return instance;

    }

//    singleTon pattern
    
    
    
   private String maQG;
   private String tenQG;

    public quocGiaModel() {
    }

    public quocGiaModel(String maQG, String tenQG) {
        this.maQG = maQG;
        this.tenQG = tenQG;
    }

    public String getMaQG() {
        return maQG;
    }

    public void setMaQG(String maQG) {
        this.maQG = maQG;
    }

    public String getTenQG() {
        return tenQG;
    }

    public void setTenQG(String tenQG) {
        this.tenQG = tenQG;
    }
   
   
   
}

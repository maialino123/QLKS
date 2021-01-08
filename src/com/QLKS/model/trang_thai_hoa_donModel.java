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
public class trang_thai_hoa_donModel extends abstractModel {
    //singleTon pattern
    private static trang_thai_hoa_donModel instance = null;
    public static trang_thai_hoa_donModel getInstance(){
        if (instance == null) {
            instance = new trang_thai_hoa_donModel();
        }
        return instance;
    }
    //singleTon pattern
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}

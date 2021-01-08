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
public class quyenModel extends abstractModel {
     //singleTon pattern
    private static quyenModel instance = null;
    public static quyenModel getInstance(){
        if (instance == null) {
            instance = new quyenModel();
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

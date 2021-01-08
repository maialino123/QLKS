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
public class loai_dich_vuModel extends abstractModel {
    //singleTon pattern
    private static loai_dich_vuModel instance = null;
    public static loai_dich_vuModel getInstance(){
        if (instance == null) {
            instance = new loai_dich_vuModel();
        }
        return instance;
    }
    //singleTon pattern
    
    private Long  id;
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

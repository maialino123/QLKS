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
public class don_viModel extends abstractModel {
    private Long id;
    private String name_DV;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_DV() {
        return name_DV;
    }

    public void setName_DV(String name_DV) {
        this.name_DV = name_DV;
    }

    @Override
    public String toString() {
        return this.name_DV;
    }
    
    
}

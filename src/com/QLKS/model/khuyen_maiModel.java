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
public class khuyen_maiModel extends abstractModel {
    //singleTon pattern
    private static khuyen_maiModel instance = null;
    public static khuyen_maiModel getInstance(){
        if (instance == null) {
            instance = new khuyen_maiModel();
        }
        return instance;
    }
    //singleTon pattern
    private Long id;
    private String code;
    private float value;
    private String content;
    private boolean type;

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

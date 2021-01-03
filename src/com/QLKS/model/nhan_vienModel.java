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
public class nhan_vienModel extends abstractModel {
    
     //singleTon Pattern
    private static nhan_vienModel instance = null;
    
    public static nhan_vienModel getInstance(){
        if (instance == null) {
            instance = new nhan_vienModel();
        }
        return instance;
    }
    //singleTon Pattern
    
    private Long id;
    private String name;
    private Date birthDay;
    private String gender;
    private Byte image;
    private String email;
    private String userName;
    private String password;
    private Long id_NQ;
    private nhom_quyenModel nhom_quyen = nhom_quyenModel.getInstance();

    public nhom_quyenModel getNhom_quyen() {
        return nhom_quyen;
    }

    public void setNhom_quyen(nhom_quyenModel nhom_quyen) {
        this.nhom_quyen = nhom_quyen;
    } 

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Byte getImage() {
        return image;
    }

    public void setImage(Byte image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId_NQ() {
        return id_NQ;
    }

    public void setId_NQ(Long id_NQ) {
        this.id_NQ = id_NQ;
    }
    
    
}

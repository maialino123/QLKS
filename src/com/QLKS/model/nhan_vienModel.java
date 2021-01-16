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
    
    
    
    
    private Long id;
    private String name;
    private Date birthDay;
    private String gender;
    private byte[] image;
    private String email;
    private String userName;
    private String password;
    private String cmnd;
    private String degree;
    private long id_NQ;
    private nhom_quyenModel nhom_quyen = new nhom_quyenModel();
    private String random_code_pass;

    public String getRandom_code_pass() {
        return random_code_pass;
    }

    public void setRandom_code_pass(String random_code_pass) {
        this.random_code_pass = random_code_pass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public nhom_quyenModel getNhom_quyen() {
        return nhom_quyen;
    }

    public void setNhom_quyen(nhom_quyenModel nhom_quyen) {
        this.nhom_quyen = nhom_quyen;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public long getId_NQ() {
        return id_NQ;
    }

    public void setId_NQ(long id_NQ) {
        this.id_NQ = id_NQ;
    }
    
    
    
}

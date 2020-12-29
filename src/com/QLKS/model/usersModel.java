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
public class usersModel extends abstractModel {
    
    
      //    singleTon pattern
    private static usersModel instance = null;

    public static usersModel getInstance() {
        if (instance == null) {
            instance = new usersModel();
        }
        return instance;

    }

//    singleTon pattern
    
    
    private int id;
    private String userName;
    private String password;
    private int roleId;
    private boolean status;
    private roleModel role = roleModel.getInstance();

    public usersModel() {
    }

    public usersModel(int id, String userName, String password, int roleId, boolean status) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.roleId = roleId;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public roleModel getRole() {
        return role;
    }

    public void setRole(roleModel role) {
        this.role = role;
    }
    
    
}

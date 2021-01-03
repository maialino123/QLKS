/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO.authorization;



/**
 *
 * @author Admin
 */
public class Authorization implements IAuthorization{
    
    private String userName;
    private String password;

    public Authorization(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    @Override
    public String getUserName() {
        return this.userName;
    }

    @Override
    public String getPassWord() {
        return this.password;
    }
   
}

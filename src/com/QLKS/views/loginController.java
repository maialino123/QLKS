/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.views;

import com.QLKS.model.nhan_vienModel;


/**
 *
 * @author Admin
 */
public class loginController {
    SigninForm login = new SigninForm();
    nhan_vienModel nhan_vien;
    public void login(SigninForm login){
        nhan_vien = login.getSignIn();
        if (nhan_vien != null) {
            mainFrame mainFrame1 = new mainFrame(nhan_vien);
            login.setVisible(false);
            mainFrame1.setVisible(true);
        }
    }
}

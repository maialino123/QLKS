/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.views;

import com.QLKS.views.SigninForm;
import com.QLKS.views.runSystem;

/**
 *
 * @author Admin
 */
public class miniFarme {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        runSystem running = new runSystem();
        SigninForm signin = new SigninForm();
        loginController logiController = new loginController();
        running.setVisible(true);
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(100);
                running.loadingnumber.setText(Integer.toString(i)+"%");
                running.loading.setValue(i);
                if (i == 100) {
                    running.setVisible(false);
                    signin.setVisible(true);
                    logiController.login(signin);
                }
            }
        } catch (Exception e) {
        }
    }
    
}

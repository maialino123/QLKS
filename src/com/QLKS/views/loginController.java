/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.views;

import com.QLKS.model.nhan_vienModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



/**
 *
 * @author Admin
 */
public class loginController {

    SigninForm login = new SigninForm();
    nhan_vienModel nhan_vien;

    public void login(SigninForm login) {
        nhan_vien = login.getSignIn();
        if (nhan_vien != null) {
            mainFrame mainFrame1 = new mainFrame(nhan_vien);
            login.setVisible(false);
            mainFrame1.setVisible(true);
            if (!mainFrame1.isVisible()) {
                mainFrame1.setVisible(true);
                showLogOutBtn(mainFrame1);
            }
        }
    }

    private void showLogOutBtn(mainFrame mainJFrame) {
        mainJFrame.getLbl_logout().addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                nhan_vien = null;
                mainJFrame.dispose();
                login.setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent me) {

            }

            @Override
            public void mouseReleased(MouseEvent me) {

            }

            @Override
            public void mouseEntered(MouseEvent me) {

            }

            @Override
            public void mouseExited(MouseEvent me) {

            }
        });

    }
}

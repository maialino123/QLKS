/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.views.JintenalFrame;

import static com.QLKS.views.mainFrame.changeColor;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Admin
 */
public class ITN_quan_ly_nhan_vien extends javax.swing.JInternalFrame {

    /**
     * Creates new form ITN_quan_ly_nhan_vien
     */
    boolean a = true;
    public ITN_quan_ly_nhan_vien() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        menu_icon = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        menu_barQLNV = new javax.swing.JPanel();
        line_button = new javax.swing.JPanel();
        custom_line = new javax.swing.JLabel();
        button_add_NV = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        line_button_click = new javax.swing.JLabel();
        line_button1 = new javax.swing.JPanel();
        custom_line1 = new javax.swing.JLabel();
        button_update_NV = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        line_button_click1 = new javax.swing.JLabel();
        line_button2 = new javax.swing.JPanel();
        custom_line2 = new javax.swing.JLabel();
        button_delete_NV = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        line_button_click2 = new javax.swing.JLabel();
        line_button3 = new javax.swing.JPanel();
        custom_line3 = new javax.swing.JLabel();
        button_search_NV = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        line_button_click3 = new javax.swing.JLabel();
        line_button4 = new javax.swing.JPanel();
        custom_line4 = new javax.swing.JLabel();
        button_refesh_NV1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        line_button_click4 = new javax.swing.JLabel();
        content_Jinternal = new javax.swing.JPanel();
        pnl_tableContent = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLKS/icon/icon_button/icons8_hotel_star_40px.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1100, 600));

        header.setBackground(new java.awt.Color(8, 13, 23));
        header.setPreferredSize(new java.awt.Dimension(1132, 50));
        header.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setPreferredSize(new java.awt.Dimension(50, 50));
        header.add(jLabel1, java.awt.BorderLayout.LINE_END);

        menu_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLKS/icon/icon_button/custom-iconMenu.png"))); // NOI18N
        menu_icon.setPreferredSize(new java.awt.Dimension(50, 50));
        menu_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_iconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menu_iconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menu_iconMouseExited(evt);
            }
        });
        header.add(menu_icon, java.awt.BorderLayout.LINE_START);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(154, 231, 246));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Quản Lý  Nhân Viên");
        header.add(jLabel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        menu_barQLNV.setBackground(new java.awt.Color(16, 14, 17));
        menu_barQLNV.setPreferredSize(new java.awt.Dimension(150, 582));
        menu_barQLNV.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));

        line_button.setBackground(new java.awt.Color(0, 0, 0));
        line_button.setPreferredSize(new java.awt.Dimension(150, 5));
        line_button.setLayout(new java.awt.BorderLayout());

        custom_line.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        custom_line.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLKS/icon/icon_button/custom-lineJinternal.png"))); // NOI18N
        line_button.add(custom_line, java.awt.BorderLayout.CENTER);

        menu_barQLNV.add(line_button);

        button_add_NV.setBackground(new java.awt.Color(27, 27, 27));
        button_add_NV.setPreferredSize(new java.awt.Dimension(150, 40));
        button_add_NV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_add_NVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button_add_NVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button_add_NVMouseExited(evt);
            }
        });
        button_add_NV.setLayout(new java.awt.BorderLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLKS/icon/icon_button/icons8_add_20px.png"))); // NOI18N
        jLabel4.setPreferredSize(new java.awt.Dimension(40, 40));
        button_add_NV.add(jLabel4, java.awt.BorderLayout.LINE_START);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(154, 231, 246));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Thêm Mới");
        button_add_NV.add(jLabel5, java.awt.BorderLayout.CENTER);

        line_button_click.setBackground(new java.awt.Color(0, 0, 0));
        line_button_click.setPreferredSize(new java.awt.Dimension(5, 40));
        button_add_NV.add(line_button_click, java.awt.BorderLayout.LINE_END);

        menu_barQLNV.add(button_add_NV);

        line_button1.setBackground(new java.awt.Color(0, 0, 0));
        line_button1.setLayout(new java.awt.BorderLayout());

        custom_line1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        custom_line1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLKS/icon/icon_button/custom-lineJinternal.png"))); // NOI18N
        line_button1.add(custom_line1, java.awt.BorderLayout.CENTER);

        menu_barQLNV.add(line_button1);

        button_update_NV.setBackground(new java.awt.Color(27, 27, 27));
        button_update_NV.setPreferredSize(new java.awt.Dimension(150, 40));
        button_update_NV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_update_NVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button_update_NVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button_update_NVMouseExited(evt);
            }
        });
        button_update_NV.setLayout(new java.awt.BorderLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLKS/icon/icon_button/icons8_edit_property_20px.png"))); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(40, 40));
        button_update_NV.add(jLabel6, java.awt.BorderLayout.LINE_START);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(154, 231, 246));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Sửa");
        button_update_NV.add(jLabel7, java.awt.BorderLayout.CENTER);

        line_button_click1.setBackground(new java.awt.Color(0, 0, 0));
        line_button_click1.setPreferredSize(new java.awt.Dimension(5, 40));
        button_update_NV.add(line_button_click1, java.awt.BorderLayout.LINE_END);

        menu_barQLNV.add(button_update_NV);

        line_button2.setBackground(new java.awt.Color(0, 0, 0));
        line_button2.setLayout(new java.awt.BorderLayout());

        custom_line2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        custom_line2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLKS/icon/icon_button/custom-lineJinternal.png"))); // NOI18N
        line_button2.add(custom_line2, java.awt.BorderLayout.CENTER);

        menu_barQLNV.add(line_button2);

        button_delete_NV.setBackground(new java.awt.Color(27, 27, 27));
        button_delete_NV.setPreferredSize(new java.awt.Dimension(150, 40));
        button_delete_NV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_delete_NVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button_delete_NVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button_delete_NVMouseExited(evt);
            }
        });
        button_delete_NV.setLayout(new java.awt.BorderLayout());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLKS/icon/icon_button/icons8_delete_trash_20px.png"))); // NOI18N
        jLabel8.setPreferredSize(new java.awt.Dimension(40, 40));
        button_delete_NV.add(jLabel8, java.awt.BorderLayout.LINE_START);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(154, 231, 246));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Xóa");
        button_delete_NV.add(jLabel9, java.awt.BorderLayout.CENTER);

        line_button_click2.setBackground(new java.awt.Color(0, 0, 0));
        line_button_click2.setPreferredSize(new java.awt.Dimension(5, 40));
        button_delete_NV.add(line_button_click2, java.awt.BorderLayout.LINE_END);

        menu_barQLNV.add(button_delete_NV);

        line_button3.setBackground(new java.awt.Color(0, 0, 0));
        line_button3.setLayout(new java.awt.BorderLayout());

        custom_line3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        custom_line3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLKS/icon/icon_button/custom-lineJinternal.png"))); // NOI18N
        line_button3.add(custom_line3, java.awt.BorderLayout.CENTER);

        menu_barQLNV.add(line_button3);

        button_search_NV.setBackground(new java.awt.Color(27, 27, 27));
        button_search_NV.setPreferredSize(new java.awt.Dimension(150, 40));
        button_search_NV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_search_NVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button_search_NVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button_search_NVMouseExited(evt);
            }
        });
        button_search_NV.setLayout(new java.awt.BorderLayout());

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLKS/icon/icon_button/icons8_search_20px.png"))); // NOI18N
        jLabel10.setPreferredSize(new java.awt.Dimension(40, 40));
        button_search_NV.add(jLabel10, java.awt.BorderLayout.LINE_START);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(154, 231, 246));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Tìm Kiếm");
        button_search_NV.add(jLabel11, java.awt.BorderLayout.CENTER);

        line_button_click3.setBackground(new java.awt.Color(0, 0, 0));
        line_button_click3.setPreferredSize(new java.awt.Dimension(5, 40));
        button_search_NV.add(line_button_click3, java.awt.BorderLayout.LINE_END);

        menu_barQLNV.add(button_search_NV);

        line_button4.setBackground(new java.awt.Color(0, 0, 0));
        line_button4.setLayout(new java.awt.BorderLayout());

        custom_line4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        custom_line4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLKS/icon/icon_button/custom-lineJinternal.png"))); // NOI18N
        line_button4.add(custom_line4, java.awt.BorderLayout.CENTER);

        menu_barQLNV.add(line_button4);

        button_refesh_NV1.setBackground(new java.awt.Color(27, 27, 27));
        button_refesh_NV1.setPreferredSize(new java.awt.Dimension(150, 40));
        button_refesh_NV1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_refesh_NV1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button_refesh_NV1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button_refesh_NV1MouseExited(evt);
            }
        });
        button_refesh_NV1.setLayout(new java.awt.BorderLayout());

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLKS/icon/icon_button/icons8_update_left_rotation_20px.png"))); // NOI18N
        jLabel12.setPreferredSize(new java.awt.Dimension(40, 40));
        button_refesh_NV1.add(jLabel12, java.awt.BorderLayout.LINE_START);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(154, 231, 246));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Cập Nhật");
        button_refesh_NV1.add(jLabel13, java.awt.BorderLayout.CENTER);

        line_button_click4.setBackground(new java.awt.Color(0, 0, 0));
        line_button_click4.setPreferredSize(new java.awt.Dimension(5, 40));
        button_refesh_NV1.add(line_button_click4, java.awt.BorderLayout.LINE_END);

        menu_barQLNV.add(button_refesh_NV1);

        getContentPane().add(menu_barQLNV, java.awt.BorderLayout.LINE_START);

        content_Jinternal.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pnl_tableContentLayout = new javax.swing.GroupLayout(pnl_tableContent);
        pnl_tableContent.setLayout(pnl_tableContentLayout);
        pnl_tableContentLayout.setHorizontalGroup(
            pnl_tableContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1040, Short.MAX_VALUE)
        );
        pnl_tableContentLayout.setVerticalGroup(
            pnl_tableContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 656, Short.MAX_VALUE)
        );

        content_Jinternal.add(pnl_tableContent, java.awt.BorderLayout.CENTER);

        getContentPane().add(content_Jinternal, java.awt.BorderLayout.CENTER);

        setBounds(0, 0, 1206, 736);
    }// </editor-fold>//GEN-END:initComponents

    
     public  void changeimage(JLabel btn, String resourceImage) {
        ImageIcon a = new ImageIcon(getClass().getResource(resourceImage));
        btn.setIcon(a);
    } 
     
    public void hideShowMenu(JPanel menuClick, boolean check, JLabel button) {
        if (check == true) {
            menuClick.setPreferredSize(new Dimension(150, this.getHeight()));
            changeimage(button, "/com/QLKS/icon/icon_button/icon_menuJpanelClick.png");
        } else {
            menuClick.setPreferredSize(new Dimension(0, this.getHeight()));
            changeimage(button, "/com/QLKS/icon/icon_button/custom-iconMenu.png");
        }
    }
    
    private void button_add_NVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_add_NVMouseEntered
        changeColor(button_add_NV, new Color(0, 0, 0));
    }//GEN-LAST:event_button_add_NVMouseEntered

    private void button_add_NVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_add_NVMouseExited
        changeColor(button_add_NV, new Color(8, 13, 21));
        changeimage(custom_line, "/com/QLKS/icon/icon_button/custom-lineJinternal.png");
    }//GEN-LAST:event_button_add_NVMouseExited

    private void button_add_NVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_add_NVMouseClicked
       changeimage(custom_line, "/com/QLKS/icon/icon_button/line_custom_hover_jinternal.png");
    }//GEN-LAST:event_button_add_NVMouseClicked

    private void button_update_NVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_update_NVMouseClicked
       changeimage(custom_line1, "/com/QLKS/icon/icon_button/line_custom_hover_jinternal.png");
    }//GEN-LAST:event_button_update_NVMouseClicked

    private void button_update_NVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_update_NVMouseEntered
        changeColor(button_update_NV, new Color(0, 0, 0));
    }//GEN-LAST:event_button_update_NVMouseEntered

    private void button_update_NVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_update_NVMouseExited
       changeColor(button_update_NV, new Color(8, 13, 21));
        changeimage(custom_line1, "/com/QLKS/icon/icon_button/custom-lineJinternal.png");
    }//GEN-LAST:event_button_update_NVMouseExited

    private void button_delete_NVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_delete_NVMouseClicked
       changeimage(custom_line2, "/com/QLKS/icon/icon_button/line_custom_hover_jinternal.png");
    }//GEN-LAST:event_button_delete_NVMouseClicked

    private void button_delete_NVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_delete_NVMouseEntered
       changeColor(button_delete_NV, new Color(0, 0, 0));
    }//GEN-LAST:event_button_delete_NVMouseEntered

    private void button_delete_NVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_delete_NVMouseExited
       changeColor(button_delete_NV, new Color(8, 13, 21));
        changeimage(custom_line2, "/com/QLKS/icon/icon_button/custom-lineJinternal.png");
    }//GEN-LAST:event_button_delete_NVMouseExited

    private void button_search_NVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_search_NVMouseClicked
        changeimage(custom_line3, "/com/QLKS/icon/icon_button/line_custom_hover_jinternal.png");
    }//GEN-LAST:event_button_search_NVMouseClicked

    private void button_search_NVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_search_NVMouseEntered
        changeColor(button_search_NV, new Color(0, 0, 0));
    }//GEN-LAST:event_button_search_NVMouseEntered

    private void button_search_NVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_search_NVMouseExited
        changeColor(button_search_NV, new Color(8, 13, 21));
        changeimage(custom_line3, "/com/QLKS/icon/icon_button/custom-lineJinternal.png");
    }//GEN-LAST:event_button_search_NVMouseExited

    private void button_refesh_NV1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_refesh_NV1MouseClicked
       changeimage(custom_line4, "/com/QLKS/icon/icon_button/line_custom_hover_jinternal.png");
    }//GEN-LAST:event_button_refesh_NV1MouseClicked

    private void button_refesh_NV1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_refesh_NV1MouseEntered
        changeColor(button_refesh_NV1, new Color(0, 0, 0));
    }//GEN-LAST:event_button_refesh_NV1MouseEntered

    private void button_refesh_NV1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_refesh_NV1MouseExited
       changeColor(button_refesh_NV1, new Color(8, 13, 21));
        changeimage(custom_line4, "/com/QLKS/icon/icon_button/custom-lineJinternal.png");
    }//GEN-LAST:event_button_refesh_NV1MouseExited

    private void menu_iconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_iconMouseEntered
       
    }//GEN-LAST:event_menu_iconMouseEntered

    private void menu_iconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_iconMouseExited
        
    }//GEN-LAST:event_menu_iconMouseExited

    private void menu_iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_iconMouseClicked
        if (a == true) {
            hideShowMenu(menu_barQLNV, a, menu_icon);
            SwingUtilities.updateComponentTreeUI(this);
            a = false;
        } else {
            hideShowMenu(menu_barQLNV, a, menu_icon);
            SwingUtilities.updateComponentTreeUI(this);
            a = true;
        }
    }//GEN-LAST:event_menu_iconMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel button_add_NV;
    private javax.swing.JPanel button_delete_NV;
    private javax.swing.JPanel button_refesh_NV1;
    private javax.swing.JPanel button_search_NV;
    private javax.swing.JPanel button_update_NV;
    private javax.swing.JPanel content_Jinternal;
    private javax.swing.JLabel custom_line;
    private javax.swing.JLabel custom_line1;
    private javax.swing.JLabel custom_line2;
    private javax.swing.JLabel custom_line3;
    private javax.swing.JLabel custom_line4;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel line_button;
    private javax.swing.JPanel line_button1;
    private javax.swing.JPanel line_button2;
    private javax.swing.JPanel line_button3;
    private javax.swing.JPanel line_button4;
    private javax.swing.JLabel line_button_click;
    private javax.swing.JLabel line_button_click1;
    private javax.swing.JLabel line_button_click2;
    private javax.swing.JLabel line_button_click3;
    private javax.swing.JLabel line_button_click4;
    private javax.swing.JPanel menu_barQLNV;
    private javax.swing.JLabel menu_icon;
    private javax.swing.JPanel pnl_tableContent;
    // End of variables declaration//GEN-END:variables
}

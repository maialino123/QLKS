/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.views.JintenalFrame;

import com.QLKS.Service.impl.khuyen_maiService;
import com.QLKS.model.khuyen_maiModel;
import com.QLKS.utils.functionBase;
import com.QLKS.views.JintenalFrame.action.ITN_add_khuyenmai;
import com.QLKS.views.JintenalFrame.action.ITN_edit_khuyenmai;
import static com.QLKS.views.mainFrame.changeColor;
import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author steve
 */
public class ITN_quan_ly_khuyenmai extends javax.swing.JInternalFrame implements ITN_add_khuyenmai.CallBackAdd, ITN_edit_khuyenmai.CallbackUpdate {

    ITN_add_khuyenmai ITN_add_khuyenmai;
    ITN_edit_khuyenmai ITN_edit_khuyenmai;

    /**
     * Creates new form ITN_quan_ly_khuyenmai
     */
    khuyen_maiModel khuyen_maiModel;
    List<khuyen_maiModel> list_khuyenMai;
    khuyen_maiService khuyen_maiService;
    DefaultTableModel dfmKhuyenmai;
    functionBase funBase;
    SimpleDateFormat sf;

    public ITN_quan_ly_khuyenmai() {
        initComponents();
        khuyen_maiModel = new khuyen_maiModel();
        khuyen_maiService = new khuyen_maiService();
        dfmKhuyenmai = new DefaultTableModel();
        funBase = new functionBase();
        sf = new SimpleDateFormat("dd/MM/yyyy");
        checkCodeKM();
        loadData();
    }

    public void centerJIF(JInternalFrame jif) {
        Dimension desktopSize = add_dsktop_pnl.getSize();
        Dimension jInternalFrameSize = jif.getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        jif.setLocation(width, height);
        jif.setVisible(true);
    }

    public void showInternalFrame(JInternalFrame jif) {
        if (!jif.isVisible()) {
            add_dsktop_pnl = getDesktopPane();
            add_dsktop_pnl.add(jif);
            centerJIF(jif);
            jif.setVisible(true);
            add_dsktop_pnl.show();
        }
    }

    public void checkCodeKM() {
        list_khuyenMai = khuyen_maiService.findAll();
        Date dateNow = new Date();
//        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
        String dateNowStr = sf.format(dateNow);
        String converDateStr;
        String errDeltete = "";
        boolean check_up = false;
        for (khuyen_maiModel model : list_khuyenMai) {
            converDateStr = sf.format(model.getThoi_gian_ket_thuc());
            if (dateNowStr.equals(converDateStr) == true && model.isType() == true) {
                khuyen_maiModel.setId(model.getId());
                khuyen_maiModel.setCode(model.getCode());
                khuyen_maiModel.setValue(model.getValue());
                khuyen_maiModel.setContent(model.getContent());
                khuyen_maiModel.setType(false);
                khuyen_maiModel.setThoi_gian_bat_dau(model.getThoi_gian_bat_dau());
                khuyen_maiModel.setThoi_gian_ket_thuc(model.getThoi_gian_ket_thuc());
                int key = khuyen_maiService.edit(khuyen_maiModel);
                if (key > 0) {
                    check_up = true;
                    errDeltete += "\t" + model.getCode() + "\n";
                }
            }
        }
        if (check_up == true) {
            String mess = "";
            mess += "Mã Khuyến Mãi " + errDeltete + " Đã Hết Hạn!";
            JOptionPane.showMessageDialog(rootPane, mess, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void loadData() {
        Object[] columnNames = {"STT", "ID", "Mã Khuyến Mãi", "Giá Trị", "Nội Dung", "Trạng Thái", "Thoi_gian_bat_dau", "Thoi_gian_ket_thuc", ""};
//        if (nameSeaechInput != null) {
//            dfmThietBi = thiet_biService.search(nameSeaechInput);
//        } else {
//            dfmThietBi = cauhinhDAO.getAll();
//        }
        list_khuyenMai = khuyen_maiService.findAll();

        dfmKhuyenmai = new DefaultTableModel(new Object[0][0], columnNames);
        int index = 1;
        for (khuyen_maiModel adv : list_khuyenMai) {
            Object[] o = new Object[9];
            o[0] = index;
            o[1] = adv.getId();
            o[2] = adv.getCode();
            o[3] = adv.getValue();
            o[4] = adv.getContent();
            o[5] = adv.isType() ? "Đang Sử Dụng" : "Hết Hạn";
            o[6] = sf.format(adv.getThoi_gian_bat_dau());
            o[7] = sf.format(adv.getThoi_gian_ket_thuc());
            dfmKhuyenmai.addRow(o);
            index++;
        }
        tbl_khuyenMai.setModel(dfmKhuyenmai);
        funBase.addCheckBox(8, tbl_khuyenMai);
    }

    public void changeimage(JLabel btn, String resourceImage) {
        ImageIcon a = new ImageIcon(getClass().getResource(resourceImage));
        btn.setIcon(a);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        line_button = new javax.swing.JPanel();
        custom_line = new javax.swing.JLabel();
        button_add_KH = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        line_button_click = new javax.swing.JLabel();
        line_button1 = new javax.swing.JPanel();
        custom_line1 = new javax.swing.JLabel();
        button_update_KH = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        line_button_click1 = new javax.swing.JLabel();
        line_button2 = new javax.swing.JPanel();
        custom_line2 = new javax.swing.JLabel();
        button_delete_KH = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        line_button_click2 = new javax.swing.JLabel();
        line_button3 = new javax.swing.JPanel();
        custom_line3 = new javax.swing.JLabel();
        button_search_KH = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        line_button_click3 = new javax.swing.JLabel();
        line_button4 = new javax.swing.JPanel();
        custom_line4 = new javax.swing.JLabel();
        button_refesh_KH = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        line_button_click4 = new javax.swing.JLabel();
        content = new javax.swing.JPanel();
        add_dsktop_pnl = new javax.swing.JDesktopPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_khuyenMai = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);

        header.setBackground(new java.awt.Color(16, 14, 17));
        header.setMaximumSize(new java.awt.Dimension(876, 50));
        header.setMinimumSize(new java.awt.Dimension(876, 50));
        header.setPreferredSize(new java.awt.Dimension(876, 50));
        header.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(154, 231, 246));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý khuyến mãi");
        header.add(jLabel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        menu.setBackground(new java.awt.Color(16, 14, 17));
        menu.setMaximumSize(new java.awt.Dimension(150, 604));
        menu.setMinimumSize(new java.awt.Dimension(150, 604));
        menu.setPreferredSize(new java.awt.Dimension(150, 604));

        line_button.setBackground(new java.awt.Color(0, 0, 0));
        line_button.setMaximumSize(new java.awt.Dimension(150, 5));
        line_button.setLayout(new java.awt.BorderLayout());

        custom_line.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        custom_line.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLKS/icon/icon_button/custom-lineJinternal.png"))); // NOI18N
        line_button.add(custom_line, java.awt.BorderLayout.CENTER);

        menu.add(line_button);

        button_add_KH.setBackground(new java.awt.Color(27, 27, 27));
        button_add_KH.setMaximumSize(new java.awt.Dimension(150, 40));
        button_add_KH.setMinimumSize(new java.awt.Dimension(150, 40));
        button_add_KH.setPreferredSize(new java.awt.Dimension(150, 40));
        button_add_KH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_add_KHMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button_add_KHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button_add_KHMouseExited(evt);
            }
        });
        button_add_KH.setLayout(new java.awt.BorderLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLKS/icon/icon_button/icons8_add_20px.png"))); // NOI18N
        jLabel4.setPreferredSize(new java.awt.Dimension(40, 40));
        button_add_KH.add(jLabel4, java.awt.BorderLayout.LINE_START);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(154, 231, 246));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Thêm Mới");
        button_add_KH.add(jLabel5, java.awt.BorderLayout.CENTER);

        line_button_click.setBackground(new java.awt.Color(0, 0, 0));
        line_button_click.setPreferredSize(new java.awt.Dimension(5, 40));
        button_add_KH.add(line_button_click, java.awt.BorderLayout.LINE_END);

        menu.add(button_add_KH);

        line_button1.setBackground(new java.awt.Color(0, 0, 0));
        line_button1.setMaximumSize(new java.awt.Dimension(150, 5));
        line_button1.setLayout(new java.awt.BorderLayout());

        custom_line1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        custom_line1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLKS/icon/icon_button/custom-lineJinternal.png"))); // NOI18N
        line_button1.add(custom_line1, java.awt.BorderLayout.CENTER);

        menu.add(line_button1);

        button_update_KH.setBackground(new java.awt.Color(27, 27, 27));
        button_update_KH.setMaximumSize(new java.awt.Dimension(150, 40));
        button_update_KH.setMinimumSize(new java.awt.Dimension(150, 40));
        button_update_KH.setPreferredSize(new java.awt.Dimension(150, 40));
        button_update_KH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_update_KHMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button_update_KHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button_update_KHMouseExited(evt);
            }
        });
        button_update_KH.setLayout(new java.awt.BorderLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLKS/icon/icon_button/icons8_edit_property_20px.png"))); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(40, 40));
        button_update_KH.add(jLabel6, java.awt.BorderLayout.LINE_START);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(154, 231, 246));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Sửa");
        button_update_KH.add(jLabel7, java.awt.BorderLayout.CENTER);

        line_button_click1.setBackground(new java.awt.Color(0, 0, 0));
        line_button_click1.setPreferredSize(new java.awt.Dimension(5, 40));
        button_update_KH.add(line_button_click1, java.awt.BorderLayout.LINE_END);

        menu.add(button_update_KH);

        line_button2.setBackground(new java.awt.Color(0, 0, 0));
        line_button2.setMaximumSize(new java.awt.Dimension(150, 5));
        line_button2.setLayout(new java.awt.BorderLayout());

        custom_line2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        custom_line2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLKS/icon/icon_button/custom-lineJinternal.png"))); // NOI18N
        line_button2.add(custom_line2, java.awt.BorderLayout.CENTER);

        menu.add(line_button2);

        button_delete_KH.setBackground(new java.awt.Color(27, 27, 27));
        button_delete_KH.setMaximumSize(new java.awt.Dimension(150, 40));
        button_delete_KH.setMinimumSize(new java.awt.Dimension(150, 40));
        button_delete_KH.setPreferredSize(new java.awt.Dimension(150, 40));
        button_delete_KH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_delete_KHMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button_delete_KHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button_delete_KHMouseExited(evt);
            }
        });
        button_delete_KH.setLayout(new java.awt.BorderLayout());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLKS/icon/icon_button/icons8_delete_trash_20px.png"))); // NOI18N
        jLabel8.setPreferredSize(new java.awt.Dimension(40, 40));
        button_delete_KH.add(jLabel8, java.awt.BorderLayout.LINE_START);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(154, 231, 246));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Xóa");
        button_delete_KH.add(jLabel9, java.awt.BorderLayout.CENTER);

        line_button_click2.setBackground(new java.awt.Color(0, 0, 0));
        line_button_click2.setPreferredSize(new java.awt.Dimension(5, 40));
        button_delete_KH.add(line_button_click2, java.awt.BorderLayout.LINE_END);

        menu.add(button_delete_KH);

        line_button3.setBackground(new java.awt.Color(0, 0, 0));
        line_button3.setMaximumSize(new java.awt.Dimension(150, 5));
        line_button3.setLayout(new java.awt.BorderLayout());

        custom_line3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        custom_line3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLKS/icon/icon_button/custom-lineJinternal.png"))); // NOI18N
        line_button3.add(custom_line3, java.awt.BorderLayout.CENTER);

        menu.add(line_button3);

        button_search_KH.setBackground(new java.awt.Color(27, 27, 27));
        button_search_KH.setMaximumSize(new java.awt.Dimension(150, 40));
        button_search_KH.setMinimumSize(new java.awt.Dimension(150, 40));
        button_search_KH.setPreferredSize(new java.awt.Dimension(150, 40));
        button_search_KH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_search_KHMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button_search_KHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button_search_KHMouseExited(evt);
            }
        });
        button_search_KH.setLayout(new java.awt.BorderLayout());

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLKS/icon/icon_button/icons8_search_20px.png"))); // NOI18N
        jLabel10.setPreferredSize(new java.awt.Dimension(40, 40));
        button_search_KH.add(jLabel10, java.awt.BorderLayout.LINE_START);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(154, 231, 246));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Tìm Kiếm");
        button_search_KH.add(jLabel11, java.awt.BorderLayout.CENTER);

        line_button_click3.setBackground(new java.awt.Color(0, 0, 0));
        line_button_click3.setPreferredSize(new java.awt.Dimension(5, 40));
        button_search_KH.add(line_button_click3, java.awt.BorderLayout.LINE_END);

        menu.add(button_search_KH);

        line_button4.setBackground(new java.awt.Color(0, 0, 0));
        line_button4.setMaximumSize(new java.awt.Dimension(150, 5));
        line_button4.setLayout(new java.awt.BorderLayout());

        custom_line4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        custom_line4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLKS/icon/icon_button/custom-lineJinternal.png"))); // NOI18N
        line_button4.add(custom_line4, java.awt.BorderLayout.CENTER);

        menu.add(line_button4);

        button_refesh_KH.setBackground(new java.awt.Color(27, 27, 27));
        button_refesh_KH.setMaximumSize(new java.awt.Dimension(150, 40));
        button_refesh_KH.setMinimumSize(new java.awt.Dimension(150, 40));
        button_refesh_KH.setPreferredSize(new java.awt.Dimension(150, 40));
        button_refesh_KH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_refesh_KHMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button_refesh_KHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button_refesh_KHMouseExited(evt);
            }
        });
        button_refesh_KH.setLayout(new java.awt.BorderLayout());

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLKS/icon/icon_button/icons8_update_left_rotation_20px.png"))); // NOI18N
        jLabel12.setPreferredSize(new java.awt.Dimension(40, 40));
        button_refesh_KH.add(jLabel12, java.awt.BorderLayout.LINE_START);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(154, 231, 246));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Cập Nhật");
        button_refesh_KH.add(jLabel13, java.awt.BorderLayout.CENTER);

        line_button_click4.setBackground(new java.awt.Color(0, 0, 0));
        line_button_click4.setPreferredSize(new java.awt.Dimension(5, 40));
        button_refesh_KH.add(line_button_click4, java.awt.BorderLayout.LINE_END);

        menu.add(button_refesh_KH);

        getContentPane().add(menu, java.awt.BorderLayout.LINE_START);

        content.setLayout(new java.awt.BorderLayout());

        add_dsktop_pnl.setBackground(new java.awt.Color(238, 238, 238));
        add_dsktop_pnl.setLayout(new java.awt.BorderLayout());

        tbl_khuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_khuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_khuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_khuyenMai);

        add_dsktop_pnl.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        content.add(add_dsktop_pnl, java.awt.BorderLayout.CENTER);

        getContentPane().add(content, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_add_KHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_add_KHMouseClicked
        changeimage(custom_line, "/com/QLKS/icon/icon_button/line_custom_hover_jinternal.png");
        ITN_add_khuyenmai = new ITN_add_khuyenmai(this);
        showInternalFrame(ITN_add_khuyenmai);
    }//GEN-LAST:event_button_add_KHMouseClicked

    private void button_add_KHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_add_KHMouseEntered
        changeColor(button_add_KH, new Color(0, 0, 0));
    }//GEN-LAST:event_button_add_KHMouseEntered

    private void button_add_KHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_add_KHMouseExited
        changeColor(button_add_KH, new Color(8, 13, 21));
        changeimage(custom_line, "/com/QLKS/icon/icon_button/custom-lineJinternal.png");
    }//GEN-LAST:event_button_add_KHMouseExited

    private void button_update_KHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_update_KHMouseClicked
        changeimage(custom_line1, "/com/QLKS/icon/icon_button/line_custom_hover_jinternal.png");
        int currentRow = tbl_khuyenMai.getSelectedRow();
        if (currentRow > 0) {
            Long idKM = Long.parseLong(dfmKhuyenmai.getValueAt(currentRow, 1).toString());
            khuyen_maiModel = khuyen_maiService.findOne(idKM);
            ITN_edit_khuyenmai = new ITN_edit_khuyenmai(khuyen_maiModel, this);
            showInternalFrame(ITN_edit_khuyenmai);
        }

    }//GEN-LAST:event_button_update_KHMouseClicked

    private void button_update_KHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_update_KHMouseEntered
        changeColor(button_update_KH, new Color(0, 0, 0));
    }//GEN-LAST:event_button_update_KHMouseEntered

    private void button_update_KHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_update_KHMouseExited
        changeColor(button_update_KH, new Color(8, 13, 21));
        changeimage(custom_line1, "/com/QLKS/icon/icon_button/custom-lineJinternal.png");
    }//GEN-LAST:event_button_update_KHMouseExited

    private void button_delete_KHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_delete_KHMouseClicked
        changeimage(custom_line2, "/com/QLKS/icon/icon_button/line_custom_hover_jinternal.png");
        String succesDeltete = "";
        String errDeltete = "";
        String errCheckType = "";
        boolean check_del = false;

        int thongBao = JOptionPane.showConfirmDialog(this, "Bạn có chắc không?", "Thông báo!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (thongBao == JOptionPane.YES_OPTION) {
            for (int i = 0; i < tbl_khuyenMai.getRowCount(); i++) {
                if (funBase.IsSelected(i, 8, tbl_khuyenMai)) {
                    String typeCheckStr = tbl_khuyenMai.getValueAt(i, 5).toString();
                    boolean convertType = true;
                    if (typeCheckStr.equals("Hết Hạn") == true) {
                        convertType = false;
                    }
                    check_del = true;
                    if (convertType == false) {
                        int rowSuccess = khuyen_maiService.delete(Long.parseLong(tbl_khuyenMai.getValueAt(i, 1).toString()));
                        tbl_khuyenMai.clearSelection();
                        if (rowSuccess > 0) {
                            succesDeltete += "\t" + tbl_khuyenMai.getValueAt(i, 2).toString() + "\n";
                        } else {
                            errDeltete += "\t" + tbl_khuyenMai.getValueAt(i, 2).toString() + "\n";
                        }
                    } else {
                        errCheckType += "\t" + tbl_khuyenMai.getValueAt(i, 2).toString() + "\n";
                    }
                }
            }
            loadData();
            if (check_del == true) {
                String mess = "";
                if (succesDeltete.length() > 0) {
                    mess += "Bạn đã xóa thành công: \n" + succesDeltete;
                }
                if (errDeltete.length() > 0) {
                    mess += "Không thể xóa: \n" + errDeltete;
                }
                if (errCheckType.length() > 0) {
                    mess += "Mã Khuyến Mãi " + errCheckType + " Đang Được Sử Dụng";
                }
                JOptionPane.showMessageDialog(rootPane, mess, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hàng để xóa", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_button_delete_KHMouseClicked

    private void button_delete_KHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_delete_KHMouseEntered
        changeColor(button_delete_KH, new Color(0, 0, 0));
    }//GEN-LAST:event_button_delete_KHMouseEntered

    private void button_delete_KHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_delete_KHMouseExited
        changeColor(button_delete_KH, new Color(8, 13, 21));
        changeimage(custom_line2, "/com/QLKS/icon/icon_button/custom-lineJinternal.png");
    }//GEN-LAST:event_button_delete_KHMouseExited

    private void button_search_KHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_search_KHMouseClicked
        changeimage(custom_line3, "/com/QLKS/icon/icon_button/line_custom_hover_jinternal.png");
    }//GEN-LAST:event_button_search_KHMouseClicked

    private void button_search_KHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_search_KHMouseEntered
        changeColor(button_search_KH, new Color(0, 0, 0));
    }//GEN-LAST:event_button_search_KHMouseEntered

    private void button_search_KHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_search_KHMouseExited
        changeColor(button_search_KH, new Color(8, 13, 21));
        changeimage(custom_line3, "/com/QLKS/icon/icon_button/custom-lineJinternal.png");
    }//GEN-LAST:event_button_search_KHMouseExited

    private void button_refesh_KHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_refesh_KHMouseClicked
        changeimage(custom_line4, "/com/QLKS/icon/icon_button/line_custom_hover_jinternal.png");
        loadData();
    }//GEN-LAST:event_button_refesh_KHMouseClicked

    private void button_refesh_KHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_refesh_KHMouseEntered
        changeColor(button_refesh_KH, new Color(0, 0, 0));
    }//GEN-LAST:event_button_refesh_KHMouseEntered

    private void button_refesh_KHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_refesh_KHMouseExited
        changeColor(button_refesh_KH, new Color(8, 13, 21));
        changeimage(custom_line4, "/com/QLKS/icon/icon_button/custom-lineJinternal.png");
    }//GEN-LAST:event_button_refesh_KHMouseExited

    private void tbl_khuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_khuyenMaiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_khuyenMaiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane add_dsktop_pnl;
    private javax.swing.JPanel button_add_KH;
    private javax.swing.JPanel button_delete_KH;
    private javax.swing.JPanel button_refesh_KH;
    private javax.swing.JPanel button_search_KH;
    private javax.swing.JPanel button_update_KH;
    private javax.swing.JPanel content;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
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
    private javax.swing.JPanel menu;
    private javax.swing.JTable tbl_khuyenMai;
    // End of variables declaration//GEN-END:variables

    @Override
    public void doAdd() {
        loadData();
    }

    @Override
    public void doUpdate() {
        loadData();
    }
}

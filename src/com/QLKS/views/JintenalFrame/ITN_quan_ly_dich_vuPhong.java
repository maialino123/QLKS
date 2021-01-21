/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.views.JintenalFrame;

import com.QLKS.Service.impl.hoa_donService;
import com.QLKS.model.hoa_donModel;
import com.QLKS.utils.CustomButtonClumnJTable;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hello
 */
public class ITN_quan_ly_dich_vuPhong extends javax.swing.JInternalFrame {

    hoa_donModel hoa_donModel;
    hoa_donService hoa_donService;
    List<hoa_donModel> listHoaDon;
    DefaultTableModel dfmDSphong;
    private JDesktopPane jdek;

    public ITN_quan_ly_dich_vuPhong() {
        initComponents();
        hoa_donModel = new hoa_donModel();
        hoa_donService = new hoa_donService();
        dfmDSphong = new DefaultTableModel();
        loadData();
    }

    public void loadData() {
        Object[] columnNames = {"STT", "Mã Hóa Đơn", "Tên Khách Hàng", "Phòng", "Trạng Thái Hóa Đơn", ""};
//        if (nameSeaechInput != null) {
//            dfmThietBi = thiet_biService.search(nameSeaechInput);
//        } else {
//            dfmThietBi = cauhinhDAO.getAll();
//        }
        listHoaDon = hoa_donService.findAll();

        dfmDSphong = new DefaultTableModel(new Object[0][0], columnNames);
        int index = 1;
        for (hoa_donModel adv : listHoaDon) {
            if (adv.getTrang_thaiHD().getName().equals("Chưa Thanh Toán")) {
                Object[] o = new Object[6];
                o[0] = index;
                o[1] = adv.getId();
                o[2] = adv.getKhach_hang().getName();
                o[3] = adv.getId_P();
                o[4] = adv.getTrang_thaiHD().getName();
                o[5] = "Thêm Dịch Vụ";
                dfmDSphong.addRow(o);
                index++;
            }
        }
        tblThongTinPhongKH.setModel(dfmDSphong);
        new CustomButtonClumnJTable(tblThongTinPhongKH, 5);
    }

    public void centerJIF(JInternalFrame jif) {
        Dimension desktopSize = jdek.getSize();
        Dimension jInternalFrameSize = jif.getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        jif.setLocation(width, height);
        jif.setVisible(true);
    }

    public void showInternalFrame(JInternalFrame jif) {
        if (!jif.isVisible()) {
            jdek = getDesktopPane();
            jdek.add(jif);
            centerJIF(jif);
            jif.setVisible(true);
            jdek.show();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupBtn = new javax.swing.JPanel();
        btnLamMoi = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongTinPhongKH = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Quản lý dịch vụ phòng");

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLKS/icon/icon_button/icons8_update_left_rotation_20px.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        btnLamMoi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLamMoiKeyPressed(evt);
            }
        });

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLKS/icon/icon_button/icons8_search_20px.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GroupBtnLayout = new javax.swing.GroupLayout(GroupBtn);
        GroupBtn.setLayout(GroupBtnLayout);
        GroupBtnLayout.setHorizontalGroup(
            GroupBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GroupBtnLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        GroupBtnLayout.setVerticalGroup(
            GroupBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GroupBtnLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(GroupBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        tblThongTinPhongKH.setModel(new javax.swing.table.DefaultTableModel(
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
        tblThongTinPhongKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThongTinPhongKHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblThongTinPhongKH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1178, Short.MAX_VALUE)
                    .addComponent(GroupBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GroupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLamMoiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLamMoiKeyPressed

    }//GEN-LAST:event_btnLamMoiKeyPressed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed

    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed

    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblThongTinPhongKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongTinPhongKHMouseClicked
        int currentRow = tblThongTinPhongKH.getSelectedRow();
        int currentColumns = tblThongTinPhongKH.getSelectedColumn();
        if (currentRow >= 0 && currentColumns == 5) {
            String trang_thaiHD = dfmDSphong.getValueAt(currentRow, 4).toString();
            if (trang_thaiHD.equals("Chưa Thanh Toán")) {
                String id_Phong = dfmDSphong.getValueAt(currentRow, 3).toString();
                String tenKH = dfmDSphong.getValueAt(currentRow, 2).toString();
                showInternalFrame(new ITN_Sudungdichvu(id_Phong, tenKH));
            } else {
                JOptionPane.showMessageDialog(rootPane, "Khách hàng này đã thanh toán hoặc chưa nhận phòng. Không thể thêm dịch vụ cho khách hàng này !", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        }

    }//GEN-LAST:event_tblThongTinPhongKHMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GroupBtn;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblThongTinPhongKH;
    // End of variables declaration//GEN-END:variables

}

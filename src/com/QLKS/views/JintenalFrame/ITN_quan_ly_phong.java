/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.views.JintenalFrame;

import com.QLKS.Service.impl.loai_phongService;
import com.QLKS.Service.impl.phongService;
import com.QLKS.model.loai_phongModel;
import com.QLKS.model.phongModel;
import com.QLKS.utils.functionBase;
import java.awt.Color;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author steve
 */
public class ITN_quan_ly_phong extends javax.swing.JInternalFrame {

    /**
     * Creates new form ITN_quan_ly_phong
     */
    loai_phongModel loai_Model;
    phongService phongService;
    phongModel phongModel;
    loai_phongService loai_phongService;
    DefaultTableModel dfmPhongmodel;
    List<phongModel> list_phong;
    List<loai_phongModel> list_loai_phong;
    DefaultComboBoxModel<loai_phongModel> loai_phongModelC;
    functionBase funBase;

    public ITN_quan_ly_phong() {
        initComponents();
        loai_Model = new loai_phongModel();
        phongService = new phongService();
        dfmPhongmodel = new DefaultTableModel();
        loai_phongService = new loai_phongService();
        loai_phongModelC = new DefaultComboBoxModel();
        funBase = new functionBase();
        list_loai_phong = loai_phongService.findAll();
        phongModel = new phongModel();
        initLoaiPhong();
        loadData();

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
        jLabel2 = new javax.swing.JLabel();
        menu_icon = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jpnLoaiTinhTrang = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_IDP = new javax.swing.JTextField();
        jlbName1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        combo_loai_phong = new javax.swing.JComboBox<>();
        button_clickReset = new javax.swing.JPanel();
        btn_add_phong = new javax.swing.JLabel();
        button_clickAdd = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        button_updatePhong = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        button_delete_P = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhong = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jlbSearch = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("QUẢN LÝ PHÒNG");

        header.setBackground(new java.awt.Color(8, 13, 23));
        header.setMaximumSize(new java.awt.Dimension(900, 50));
        header.setMinimumSize(new java.awt.Dimension(900, 50));
        header.setPreferredSize(new java.awt.Dimension(900, 50));
        header.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(154, 231, 246));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Quản lý phòng");
        jLabel2.setMaximumSize(new java.awt.Dimension(850, 50));
        jLabel2.setMinimumSize(new java.awt.Dimension(850, 50));
        jLabel2.setPreferredSize(new java.awt.Dimension(850, 50));
        header.add(jLabel2, java.awt.BorderLayout.CENTER);

        menu_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLKS/icon/icon_button/custom-iconMenu.png"))); // NOI18N
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

        jpnLoaiTinhTrang.setBackground(new java.awt.Color(48, 48, 48));
        jpnLoaiTinhTrang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản Lý Phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(154, 231, 246))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(154, 231, 246));
        jLabel3.setText("ID:");

        txt_IDP.setBackground(new java.awt.Color(32, 32, 32));
        txt_IDP.setColumns(5);
        txt_IDP.setForeground(new java.awt.Color(154, 231, 246));
        txt_IDP.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 15));
        txt_IDP.setCaretColor(new java.awt.Color(154, 231, 246));
        txt_IDP.setMaximumSize(new java.awt.Dimension(70, 26));
        txt_IDP.setMinimumSize(new java.awt.Dimension(70, 26));
        txt_IDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IDPActionPerformed(evt);
            }
        });

        jlbName1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlbName1.setForeground(new java.awt.Color(154, 231, 246));
        jlbName1.setText("Loại Phòng:");

        jPanel8.setBackground(new java.awt.Color(32, 32, 32));
        jPanel8.setMaximumSize(new java.awt.Dimension(180, 22));
        jPanel8.setMinimumSize(new java.awt.Dimension(180, 22));
        jPanel8.setPreferredSize(new java.awt.Dimension(180, 22));
        jPanel8.setLayout(new java.awt.BorderLayout());

        combo_loai_phong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_loai_phongActionPerformed(evt);
            }
        });
        jPanel8.add(combo_loai_phong, java.awt.BorderLayout.CENTER);

        button_clickReset.setBackground(new java.awt.Color(36, 36, 36));
        button_clickReset.setPreferredSize(new java.awt.Dimension(100, 50));
        button_clickReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_clickResetMouseClicked(evt);
            }
        });
        button_clickReset.setLayout(new java.awt.BorderLayout());

        btn_add_phong.setForeground(new java.awt.Color(154, 231, 246));
        btn_add_phong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_add_phong.setText("Làm mới");
        button_clickReset.add(btn_add_phong, java.awt.BorderLayout.CENTER);

        button_clickAdd.setBackground(new java.awt.Color(36, 36, 36));
        button_clickAdd.setPreferredSize(new java.awt.Dimension(100, 50));
        button_clickAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_clickAddMouseClicked(evt);
            }
        });
        button_clickAdd.setLayout(new java.awt.BorderLayout());

        jLabel5.setForeground(new java.awt.Color(154, 231, 246));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Thêm mới");
        button_clickAdd.add(jLabel5, java.awt.BorderLayout.CENTER);

        button_updatePhong.setBackground(new java.awt.Color(36, 36, 36));
        button_updatePhong.setPreferredSize(new java.awt.Dimension(100, 50));
        button_updatePhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_updatePhongMouseClicked(evt);
            }
        });
        button_updatePhong.setLayout(new java.awt.BorderLayout());

        jLabel6.setForeground(new java.awt.Color(154, 231, 246));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Cập nhật");
        button_updatePhong.add(jLabel6, java.awt.BorderLayout.CENTER);

        button_delete_P.setBackground(new java.awt.Color(36, 36, 36));
        button_delete_P.setPreferredSize(new java.awt.Dimension(100, 50));
        button_delete_P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_delete_PMouseClicked(evt);
            }
        });
        button_delete_P.setLayout(new java.awt.BorderLayout());

        jLabel7.setForeground(new java.awt.Color(154, 231, 246));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Xoá");
        button_delete_P.add(jLabel7, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jpnLoaiTinhTrangLayout = new javax.swing.GroupLayout(jpnLoaiTinhTrang);
        jpnLoaiTinhTrang.setLayout(jpnLoaiTinhTrangLayout);
        jpnLoaiTinhTrangLayout.setHorizontalGroup(
            jpnLoaiTinhTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLoaiTinhTrangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnLoaiTinhTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnLoaiTinhTrangLayout.createSequentialGroup()
                        .addGroup(jpnLoaiTinhTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnLoaiTinhTrangLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnLoaiTinhTrangLayout.createSequentialGroup()
                                .addComponent(jlbName1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jpnLoaiTinhTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_IDP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpnLoaiTinhTrangLayout.createSequentialGroup()
                        .addComponent(button_clickReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button_clickAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button_updatePhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(button_delete_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))))
        );
        jpnLoaiTinhTrangLayout.setVerticalGroup(
            jpnLoaiTinhTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLoaiTinhTrangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnLoaiTinhTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_IDP, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(jpnLoaiTinhTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnLoaiTinhTrangLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnLoaiTinhTrangLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jlbName1)))
                .addGap(95, 95, 95)
                .addGroup(jpnLoaiTinhTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_clickReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_clickAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_updatePhong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_delete_P, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(48, 48, 48));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblPhong.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPhong);

        txtSearch.setBackground(new java.awt.Color(32, 32, 32));
        txtSearch.setForeground(new java.awt.Color(154, 231, 246));

        jlbSearch.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jlbSearch.setForeground(new java.awt.Color(154, 231, 246));
        jlbSearch.setText("Nhập tên phòng:");

        jPanel3.setBackground(new java.awt.Color(32, 32, 32));
        jPanel3.setPreferredSize(new java.awt.Dimension(90, 30));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel8.setBackground(new java.awt.Color(32, 32, 32));
        jLabel8.setForeground(new java.awt.Color(154, 231, 246));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Tìm kiếm");
        jPanel3.add(jLabel8, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jlbSearch)
                .addGap(18, 18, 18)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 95, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlbSearch)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnLoaiTinhTrang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnLoaiTinhTrang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void ressetText() {
        txt_IDP.setText("");
        txt_IDP.setEditable(true);
        txt_IDP.setCaretColor(new Color(154, 231, 246));
    }

    public void initLoaiPhong() {
        for (loai_phongModel adv : list_loai_phong) {
            loai_phongModelC.addElement(adv);
        }
        combo_loai_phong.setModel(loai_phongModelC);
    }

    public void loadData() {
        Object[] columnNames = {"STT", "Mã Phòng", "Tên loại phòng", "Trạng Thái", "Giá", ""};
//        if (nameSeaechInput != null) {
//            dfmThietBi = thiet_biService.search(nameSeaechInput);
//        } else {
//            dfmThietBi = cauhinhDAO.getAll();
//        }
        list_phong = phongService.findAll();

        dfmPhongmodel = new DefaultTableModel(new Object[0][0], columnNames);
        int index = 1;
        for (phongModel adv : list_phong) {
            Object[] o = new Object[6];
            o[0] = index;
            o[1] = adv.getId();
            o[2] = adv.getLoai_phong().getName_LP();
            o[3] = adv.isStatus() ? "Đã Thuê" : "trống";
            o[4] = adv.getLoai_phong().getPrice();
            dfmPhongmodel.addRow(o);
            index++;
        }
        tblPhong.setModel(dfmPhongmodel);
        funBase.addCheckBox(5, tblPhong);

        // Cài đặt sự kiện khi click từng dòng trong bảng
        if (list_phong.size() > 0) {

            tblPhong.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    int currentRow = tblPhong.getSelectedRow();
                    if (currentRow < 0) {
                        currentRow = 0;
                    }

                    // Chèn dữ liệu lên form
                    if (currentRow >= 0) {
                        txt_IDP.setText(tblPhong.getValueAt(currentRow, 1).toString());
                        txt_IDP.setEditable(false);
                    }
                }
            });
        }
    }

    private void menu_iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_iconMouseClicked

    }//GEN-LAST:event_menu_iconMouseClicked

    private void menu_iconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_iconMouseEntered

    }//GEN-LAST:event_menu_iconMouseEntered

    private void menu_iconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_iconMouseExited

    }//GEN-LAST:event_menu_iconMouseExited

    private void txt_IDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IDPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IDPActionPerformed

    private void combo_loai_phongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_loai_phongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_loai_phongActionPerformed

    private void button_clickResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_clickResetMouseClicked
        ressetText();
        loadData();
    }//GEN-LAST:event_button_clickResetMouseClicked

    private void button_clickAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_clickAddMouseClicked
        String maPhong = txt_IDP.getText();
        loai_phongModel loai_phong = (loai_phongModel) loai_phongModelC.getSelectedItem();
        Long loai_id = loai_phong.getId();
        phongModel check_IdP = phongService.findOne(maPhong);
        if (check_IdP == null) {
            phongModel.setId(maPhong);
            phongModel.setId_LP(loai_id);
            Long key = phongService.add(phongModel);
            if (key >= 0) {
                JOptionPane.showMessageDialog(this, "Thêm Mới Thành Công!");
                ressetText();
                loadData();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm Mới Thất Bại!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Phòng Đã Tồn Tại");
        }

    }//GEN-LAST:event_button_clickAddMouseClicked

    private void button_updatePhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_updatePhongMouseClicked
        String maPhongUD = txt_IDP.getText();
        loai_phongModel loai_phong = (loai_phongModel) loai_phongModelC.getSelectedItem();
        Long loai_id = loai_phong.getId();
        phongModel.setId(maPhongUD);
        phongModel.setId_LP(loai_id);
        int key = phongService.edit(phongModel);
        if (key > 0) {
            JOptionPane.showMessageDialog(this, "Cập Nhật Thành CÔng!");
            loadData();
            ressetText();
        } else {
            JOptionPane.showMessageDialog(this, "Cập Nhật Thất Bại!");
            loadData();
        }


    }//GEN-LAST:event_button_updatePhongMouseClicked

    private void button_delete_PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_delete_PMouseClicked
        String succesDeltete = "";
        String errDeltete = "";
        boolean check_del = false;

        int thongBao = JOptionPane.showConfirmDialog(this, "Bạn có chắc không?", "Thông báo!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (thongBao == JOptionPane.YES_OPTION) {

            for (int i = 0; i < tblPhong.getRowCount(); i++) {
                if (funBase.IsSelected(i, 5, tblPhong)) {
                    check_del = true;
                    int rowSuccess = phongService.delete(tblPhong.getValueAt(i, 1).toString());
                    tblPhong.clearSelection();
                    if (rowSuccess > 0) {
                        succesDeltete += "\t" + tblPhong.getValueAt(i, 1).toString() + "\n";
                    } else {
                        errDeltete += "\t" + tblPhong.getValueAt(i, 1).toString() + "\n";
                    }
                }
            }
            ressetText();
            loadData();
            if (check_del == true) {
                String mess = "";
                if (succesDeltete.length() > 0) {
                    mess += "Bạn đã xóa thành công: \n" + succesDeltete;

                }
                if (errDeltete.length() > 0) {
                    mess += "Không thể xóa: \n" + errDeltete;
                }
                JOptionPane.showMessageDialog(rootPane, mess, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hàng để xóa", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        }

    }//GEN-LAST:event_button_delete_PMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_add_phong;
    private javax.swing.JPanel button_clickAdd;
    private javax.swing.JPanel button_clickReset;
    private javax.swing.JPanel button_delete_P;
    private javax.swing.JPanel button_updatePhong;
    private javax.swing.JComboBox<loai_phongModel> combo_loai_phong;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbName1;
    private javax.swing.JLabel jlbSearch;
    private javax.swing.JPanel jpnLoaiTinhTrang;
    private javax.swing.JLabel menu_icon;
    private javax.swing.JTable tblPhong;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txt_IDP;
    // End of variables declaration//GEN-END:variables
}

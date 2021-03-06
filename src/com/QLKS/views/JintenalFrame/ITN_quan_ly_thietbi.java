/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.views.JintenalFrame;

import com.QLKS.Service.impl.loai_phongService;
import com.QLKS.Service.impl.thiet_biService;
import com.QLKS.model.loai_phongModel;
import com.QLKS.model.thiet_biModel;
import com.QLKS.utils.functionBase;
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
public class ITN_quan_ly_thietbi extends javax.swing.JInternalFrame {

    /**
     * Creates new form ITN_quan_ly_khachhang
     */
    thiet_biService thiet_biService;
    thiet_biModel thiet_biModel;
    loai_phongService loai_phongService;
    boolean check = true;
    private DefaultComboBoxModel modelLoaiPhong;
    private List<loai_phongModel> list_loaiPhong;
    private List<thiet_biModel> list_thietBi;
    private DefaultTableModel dfmThietBi;
    private functionBase funBase;

    public ITN_quan_ly_thietbi() {
        initComponents();
        thiet_biService = new thiet_biService();
        loai_phongService = new loai_phongService();
        thiet_biModel = new thiet_biModel();
        modelLoaiPhong = new DefaultComboBoxModel();
        list_loaiPhong = loai_phongService.findAll();
        dfmThietBi = new DefaultTableModel();
        funBase = new functionBase();
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
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThietBi = new javax.swing.JTable();
        txtSearchTenLoaiDV = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jlbMaLoaiDv2 = new javax.swing.JLabel();
        jpnLoaiDichVu = new javax.swing.JPanel();
        jlbMaLoaiDv1 = new javax.swing.JLabel();
        txt_tenThietBi = new javax.swing.JTextField();
        txtErrorTenThietBi = new javax.swing.JLabel();
        jlbTenLoaiDv1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox<>();
        txtErrorTenLoaiDichVu = new javax.swing.JLabel();
        button_reset = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        button_addTB = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        update_thiet_biButton = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btn_dropThietBi = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jlbMaLoaiDv3 = new javax.swing.JLabel();
        txt_soLuong = new javax.swing.JTextField();
        txtErrorSoLuong = new javax.swing.JLabel();
        txt_ID = new javax.swing.JTextField();
        txtErrorTenThietBi1 = new javax.swing.JLabel();
        jlbMaLoaiDv4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximumSize(new java.awt.Dimension(900, 700));
        setMinimumSize(new java.awt.Dimension(900, 700));

        header.setBackground(new java.awt.Color(38, 38, 38));
        header.setMaximumSize(new java.awt.Dimension(876, 40));
        header.setMinimumSize(new java.awt.Dimension(876, 40));
        header.setPreferredSize(new java.awt.Dimension(876, 40));
        header.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(154, 231, 246));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Quản lý thiết bị");
        header.add(jLabel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(48, 48, 48));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblThietBi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblThietBi);

        txtSearchTenLoaiDV.setBackground(new java.awt.Color(32, 32, 32));
        txtSearchTenLoaiDV.setForeground(new java.awt.Color(154, 231, 246));
        txtSearchTenLoaiDV.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 15));
        txtSearchTenLoaiDV.setCaretColor(new java.awt.Color(154, 231, 246));
        txtSearchTenLoaiDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchTenLoaiDVActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(32, 32, 32));
        jPanel4.setPreferredSize(new java.awt.Dimension(149, 21));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel7.setBackground(new java.awt.Color(32, 32, 32));
        jLabel7.setForeground(new java.awt.Color(154, 231, 246));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Tìm kiếm");
        jPanel4.add(jLabel7, java.awt.BorderLayout.CENTER);

        jlbMaLoaiDv2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jlbMaLoaiDv2.setForeground(new java.awt.Color(154, 231, 246));
        jlbMaLoaiDv2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbMaLoaiDv2.setText("Tên thiết bị:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jlbMaLoaiDv2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(txtSearchTenLoaiDV, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearchTenLoaiDV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbMaLoaiDv2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnLoaiDichVu.setBackground(new java.awt.Color(48, 48, 48));
        jpnLoaiDichVu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thiết bị", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(154, 231, 246))); // NOI18N

        jlbMaLoaiDv1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jlbMaLoaiDv1.setForeground(new java.awt.Color(154, 231, 246));
        jlbMaLoaiDv1.setText("Tên thiết bị:");
        jlbMaLoaiDv1.setPreferredSize(new java.awt.Dimension(67, 30));

        txt_tenThietBi.setBackground(new java.awt.Color(32, 32, 32));
        txt_tenThietBi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_tenThietBi.setForeground(new java.awt.Color(154, 231, 246));
        txt_tenThietBi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 15));
        txt_tenThietBi.setCaretColor(new java.awt.Color(154, 231, 246));
        txt_tenThietBi.setPreferredSize(new java.awt.Dimension(30, 30));

        txtErrorTenThietBi.setForeground(new java.awt.Color(48, 48, 48));
        txtErrorTenThietBi.setText("...");
        txtErrorTenThietBi.setMaximumSize(new java.awt.Dimension(12, 20));
        txtErrorTenThietBi.setMinimumSize(new java.awt.Dimension(12, 20));
        txtErrorTenThietBi.setPreferredSize(new java.awt.Dimension(12, 20));

        jlbTenLoaiDv1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jlbTenLoaiDv1.setForeground(new java.awt.Color(154, 231, 246));
        jlbTenLoaiDv1.setText("Loại phòng:");
        jlbTenLoaiDv1.setMaximumSize(new java.awt.Dimension(66, 30));
        jlbTenLoaiDv1.setMinimumSize(new java.awt.Dimension(66, 30));
        jlbTenLoaiDv1.setPreferredSize(new java.awt.Dimension(66, 30));

        jPanel10.setBackground(new java.awt.Color(32, 32, 32));
        jPanel10.setMaximumSize(new java.awt.Dimension(180, 22));
        jPanel10.setMinimumSize(new java.awt.Dimension(180, 22));
        jPanel10.setPreferredSize(new java.awt.Dimension(180, 22));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jComboBox3.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jPanel10.add(jComboBox3, java.awt.BorderLayout.CENTER);

        txtErrorTenLoaiDichVu.setForeground(new java.awt.Color(48, 48, 48));
        txtErrorTenLoaiDichVu.setText("...");
        txtErrorTenLoaiDichVu.setMaximumSize(new java.awt.Dimension(12, 20));
        txtErrorTenLoaiDichVu.setMinimumSize(new java.awt.Dimension(12, 20));
        txtErrorTenLoaiDichVu.setPreferredSize(new java.awt.Dimension(12, 20));

        button_reset.setBackground(new java.awt.Color(36, 36, 36));
        button_reset.setMaximumSize(new java.awt.Dimension(100, 35));
        button_reset.setMinimumSize(new java.awt.Dimension(100, 35));
        button_reset.setPreferredSize(new java.awt.Dimension(90, 30));
        button_reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_resetMouseClicked(evt);
            }
        });
        button_reset.setLayout(new java.awt.BorderLayout());

        jLabel3.setForeground(new java.awt.Color(154, 231, 246));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Làm mới");
        button_reset.add(jLabel3, java.awt.BorderLayout.CENTER);

        button_addTB.setBackground(new java.awt.Color(36, 36, 36));
        button_addTB.setMaximumSize(new java.awt.Dimension(100, 35));
        button_addTB.setMinimumSize(new java.awt.Dimension(100, 35));
        button_addTB.setPreferredSize(new java.awt.Dimension(90, 30));
        button_addTB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_addTBMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button_addTBMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button_addTBMouseExited(evt);
            }
        });
        button_addTB.setLayout(new java.awt.BorderLayout());

        jLabel4.setForeground(new java.awt.Color(154, 231, 246));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Thêm mới");
        button_addTB.add(jLabel4, java.awt.BorderLayout.CENTER);

        update_thiet_biButton.setBackground(new java.awt.Color(36, 36, 36));
        update_thiet_biButton.setMaximumSize(new java.awt.Dimension(100, 35));
        update_thiet_biButton.setMinimumSize(new java.awt.Dimension(100, 35));
        update_thiet_biButton.setPreferredSize(new java.awt.Dimension(90, 30));
        update_thiet_biButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                update_thiet_biButtonMouseClicked(evt);
            }
        });
        update_thiet_biButton.setLayout(new java.awt.BorderLayout());

        jLabel5.setForeground(new java.awt.Color(154, 231, 246));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Cập nhật");
        update_thiet_biButton.add(jLabel5, java.awt.BorderLayout.CENTER);

        btn_dropThietBi.setBackground(new java.awt.Color(36, 36, 36));
        btn_dropThietBi.setMaximumSize(new java.awt.Dimension(100, 35));
        btn_dropThietBi.setMinimumSize(new java.awt.Dimension(100, 35));
        btn_dropThietBi.setPreferredSize(new java.awt.Dimension(90, 30));
        btn_dropThietBi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dropThietBiMouseClicked(evt);
            }
        });
        btn_dropThietBi.setLayout(new java.awt.BorderLayout());

        jLabel6.setForeground(new java.awt.Color(154, 231, 246));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Xoá");
        btn_dropThietBi.add(jLabel6, java.awt.BorderLayout.CENTER);

        jlbMaLoaiDv3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jlbMaLoaiDv3.setForeground(new java.awt.Color(154, 231, 246));
        jlbMaLoaiDv3.setText("Số lượng");
        jlbMaLoaiDv3.setMaximumSize(new java.awt.Dimension(51, 30));
        jlbMaLoaiDv3.setMinimumSize(new java.awt.Dimension(51, 30));
        jlbMaLoaiDv3.setPreferredSize(new java.awt.Dimension(51, 30));

        txt_soLuong.setBackground(new java.awt.Color(32, 32, 32));
        txt_soLuong.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_soLuong.setForeground(new java.awt.Color(154, 231, 246));
        txt_soLuong.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 15));
        txt_soLuong.setCaretColor(new java.awt.Color(154, 231, 246));
        txt_soLuong.setPreferredSize(new java.awt.Dimension(30, 30));

        txtErrorSoLuong.setForeground(new java.awt.Color(48, 48, 48));
        txtErrorSoLuong.setText("...");
        txtErrorSoLuong.setMaximumSize(new java.awt.Dimension(12, 20));
        txtErrorSoLuong.setMinimumSize(new java.awt.Dimension(12, 20));
        txtErrorSoLuong.setPreferredSize(new java.awt.Dimension(12, 20));

        txt_ID.setEditable(false);
        txt_ID.setBackground(new java.awt.Color(32, 32, 32));
        txt_ID.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_ID.setForeground(new java.awt.Color(154, 231, 246));
        txt_ID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 15));
        txt_ID.setCaretColor(new java.awt.Color(154, 231, 246));
        txt_ID.setPreferredSize(new java.awt.Dimension(30, 30));

        txtErrorTenThietBi1.setForeground(new java.awt.Color(48, 48, 48));
        txtErrorTenThietBi1.setText("...");
        txtErrorTenThietBi1.setMaximumSize(new java.awt.Dimension(12, 20));
        txtErrorTenThietBi1.setMinimumSize(new java.awt.Dimension(12, 20));
        txtErrorTenThietBi1.setPreferredSize(new java.awt.Dimension(12, 20));

        jlbMaLoaiDv4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jlbMaLoaiDv4.setForeground(new java.awt.Color(154, 231, 246));
        jlbMaLoaiDv4.setText("ID");
        jlbMaLoaiDv4.setPreferredSize(new java.awt.Dimension(15, 30));

        javax.swing.GroupLayout jpnLoaiDichVuLayout = new javax.swing.GroupLayout(jpnLoaiDichVu);
        jpnLoaiDichVu.setLayout(jpnLoaiDichVuLayout);
        jpnLoaiDichVuLayout.setHorizontalGroup(
            jpnLoaiDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLoaiDichVuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnLoaiDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnLoaiDichVuLayout.createSequentialGroup()
                        .addComponent(jlbMaLoaiDv4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jpnLoaiDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtErrorTenThietBi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_ID, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                    .addGroup(jpnLoaiDichVuLayout.createSequentialGroup()
                        .addComponent(button_reset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button_addTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(update_thiet_biButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_dropThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnLoaiDichVuLayout.createSequentialGroup()
                        .addGroup(jpnLoaiDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jlbMaLoaiDv3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlbMaLoaiDv1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlbTenLoaiDv1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jpnLoaiDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtErrorTenThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtErrorTenLoaiDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtErrorSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tenThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jpnLoaiDichVuLayout.setVerticalGroup(
            jpnLoaiDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLoaiDichVuLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jpnLoaiDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbMaLoaiDv4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtErrorTenThietBi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpnLoaiDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tenThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbMaLoaiDv1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtErrorTenThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jpnLoaiDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbTenLoaiDv1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtErrorTenLoaiDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jpnLoaiDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbMaLoaiDv3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtErrorSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addGroup(jpnLoaiDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button_reset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_addTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_thiet_biButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_dropThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnLoaiDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnLoaiDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void initLoaiPhong() {
        for (loai_phongModel adv : list_loaiPhong) {
            modelLoaiPhong.addElement(adv);
        }
        jComboBox3.setModel(modelLoaiPhong);
    }

    public void loadData() {
        Object[] columnNames = {"STT", "Mã Thiết Bị", "Tên loại phòng", "Tên Thiết Bị", "Số Lượng", ""};
//        if (nameSeaechInput != null) {
//            dfmThietBi = thiet_biService.search(nameSeaechInput);
//        } else {
//            dfmThietBi = cauhinhDAO.getAll();
//        }
        list_thietBi = thiet_biService.findAll();

        dfmThietBi = new DefaultTableModel(new Object[0][0], columnNames);
        int index = 1;
        for (thiet_biModel adv : list_thietBi) {
            Object[] o = new Object[6];
            o[0] = index;
            o[1] = adv.getId();
            o[2] = adv.getLoaiModel().getName_LP();
            o[3] = adv.getName();
            o[4] = adv.getAmount();
            dfmThietBi.addRow(o);
            index++;
        }
        tblThietBi.setModel(dfmThietBi);
        funBase.addCheckBox(5, tblThietBi);

        // Cài đặt sự kiện khi click từng dòng trong bảng
        if (list_thietBi.size() > 0) {

            tblThietBi.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    int currentRow = tblThietBi.getSelectedRow();
                    if (currentRow < 0) {
                        currentRow = 0;
                    }

                    // Chèn dữ liệu lên form
                    if (currentRow >= 0) {
                        txt_ID.setText(tblThietBi.getValueAt(currentRow, 1).toString());
                        txt_tenThietBi.setText(tblThietBi.getValueAt(currentRow, 3).toString());
                        txt_soLuong.setText(tblThietBi.getValueAt(currentRow, 4).toString());
                    }
                }
            });
        }
    }

    public void resetText() {
        txt_tenThietBi.setText("");
        txt_soLuong.setText("");
        txtErrorTenThietBi.setText("");
        txtErrorSoLuong.setText("");
        txt_ID.setText("");
    }
    private void txtSearchTenLoaiDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchTenLoaiDVActionPerformed

    }//GEN-LAST:event_txtSearchTenLoaiDVActionPerformed

    private void button_addTBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_addTBMouseEntered

    }//GEN-LAST:event_button_addTBMouseEntered

    private void button_addTBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_addTBMouseExited

    }//GEN-LAST:event_button_addTBMouseExited

    private void button_addTBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_addTBMouseClicked
        String nameTB = txt_tenThietBi.getText();
        int soLuongTB = Integer.parseInt(txt_soLuong.getText());
        loai_phongModel loai_phong = (loai_phongModel) modelLoaiPhong.getSelectedItem();
        Long loai_phongId = loai_phong.getId();

        try {
            if (nameTB.length() == 0) {
                txtErrorTenThietBi.setText("Tên Thiết Bị Không Được Để Trống");
                check = false;
            } else {
                txtErrorSoLuong.setText("");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (soLuongTB == 0) {
                txtErrorSoLuong.setText("Số lượng phải > 0");
                check = false;
            }
        } catch (Exception e) {
        }

        if (check = true) {
            thiet_biModel = thiet_biService.findByName(nameTB);
            if (thiet_biModel != null) {
                int countSL = thiet_biModel.getAmount() + soLuongTB;
                thiet_biModel.setName(nameTB);
                thiet_biModel.setAmount(countSL);
                thiet_biModel.setId_LP(loai_phongId);
                int key = thiet_biService.edit(thiet_biModel);
                if (key > 0) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công!");
                    resetText();
                    loadData();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Thất Bại!");
                }
            } else {
                thiet_biModel newModel = new thiet_biModel();
                newModel.setName(nameTB);
                newModel.setAmount(soLuongTB);
                newModel.setId_LP(loai_phongId);
                Long id = thiet_biService.add(newModel);
                if (id > 0) {
                    JOptionPane.showMessageDialog(this, "Thêm Mới Thành Công!");
                    resetText();
                    loadData();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm Mới Thất Bại!");
                }
            }

        }
    }//GEN-LAST:event_button_addTBMouseClicked

    private void button_resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_resetMouseClicked
        resetText();
        loadData();
    }//GEN-LAST:event_button_resetMouseClicked

    private void update_thiet_biButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_thiet_biButtonMouseClicked
        String nameTB = txt_tenThietBi.getText();
        int soLuongTB = Integer.parseInt(txt_soLuong.getText());
        loai_phongModel loai_phong = (loai_phongModel) modelLoaiPhong.getSelectedItem();
        Long loai_phongId = loai_phong.getId();
        Long id = Long.parseLong(txt_ID.getText());
        try {
            if (nameTB.length() == 0) {
                txtErrorTenThietBi.setText("Tên Thiết Bị Không Được Để Trống");
                check = false;
            } else {
                txtErrorSoLuong.setText("");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (soLuongTB == 0) {
                txtErrorSoLuong.setText("Số lượng phải > 0");
                check = false;
            }
        } catch (Exception e) {
        }
        if (check == true) {
            thiet_biModel.setName(nameTB);
            thiet_biModel.setAmount(soLuongTB);
            thiet_biModel.setId_LP(loai_phongId);
            thiet_biModel.setId(id);
            int key = thiet_biService.edit(thiet_biModel);
            if (key > 0) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                resetText();
                loadData();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
            }
        }
    }//GEN-LAST:event_update_thiet_biButtonMouseClicked

    private void btn_dropThietBiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dropThietBiMouseClicked
        String succesDeltete = "";
        String errDeltete = "";
        boolean check_del = false;

        int thongBao = JOptionPane.showConfirmDialog(this, "Bạn có chắc không?", "Thông báo!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (thongBao == JOptionPane.YES_OPTION) {

            for (int i = 0; i < tblThietBi.getRowCount(); i++) {
                if (funBase.IsSelected(i, 5, tblThietBi)) {
                    check_del = true;
                    int rowSuccess = thiet_biService.delete(Long.parseLong(tblThietBi.getValueAt(i, 1).toString()));
                    tblThietBi.clearSelection();
                    if (rowSuccess > 0) {
                        succesDeltete += "\t" + tblThietBi.getValueAt(i, 2).toString() + "\n";
                    } else {
                        errDeltete += "\t" + tblThietBi.getValueAt(i, 2).toString() + "\n";
                    }
                }
            }
            loadData();
            resetText();
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
    }//GEN-LAST:event_btn_dropThietBiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_dropThietBi;
    private javax.swing.JPanel button_addTB;
    private javax.swing.JPanel button_reset;
    private javax.swing.JPanel header;
    private javax.swing.JComboBox<loai_phongModel> jComboBox3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbMaLoaiDv1;
    private javax.swing.JLabel jlbMaLoaiDv2;
    private javax.swing.JLabel jlbMaLoaiDv3;
    private javax.swing.JLabel jlbMaLoaiDv4;
    private javax.swing.JLabel jlbTenLoaiDv1;
    private javax.swing.JPanel jpnLoaiDichVu;
    private javax.swing.JTable tblThietBi;
    private javax.swing.JLabel txtErrorSoLuong;
    private javax.swing.JLabel txtErrorTenLoaiDichVu;
    private javax.swing.JLabel txtErrorTenThietBi;
    private javax.swing.JLabel txtErrorTenThietBi1;
    private javax.swing.JTextField txtSearchTenLoaiDV;
    private javax.swing.JTextField txt_ID;
    private javax.swing.JTextField txt_soLuong;
    private javax.swing.JTextField txt_tenThietBi;
    private javax.swing.JPanel update_thiet_biButton;
    // End of variables declaration//GEN-END:variables
}

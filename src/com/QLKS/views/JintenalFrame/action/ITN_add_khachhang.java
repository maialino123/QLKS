/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.views.JintenalFrame.action;

import com.QLKS.Service.impl.khach_hangService;
import com.QLKS.model.khach_hang_model;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author steve
 */
public class ITN_add_khachhang extends javax.swing.JInternalFrame {

    /**
     * Creates new form ITN_add_khachhang
     */
    khach_hang_model khach_hangModel;
    khach_hangService khach_hangService;
    DefaultTableModel dfmKhachhang;
    private CallBackAdd cb;
    
    public interface CallBackAdd {
        
        void doAdd();
    }
    
    public ITN_add_khachhang(CallBackAdd _cb) {
        initComponents();
        this.cb = _cb;
        khach_hangModel = new khach_hang_model();
        khach_hangService = new khach_hangService();
        dfmKhachhang = new DefaultTableModel();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        content1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        add_name = new javax.swing.JPanel();
        pnl_name_content = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_inputName = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        pnl_birthDay = new javax.swing.JPanel();
        pnl_name_content1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dateBirthDayKH = new com.toedter.calendar.JDateChooser();
        jPanel6 = new javax.swing.JPanel();
        pnl_gender = new javax.swing.JPanel();
        pnl_name_content7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        pnl_button_radio = new javax.swing.JPanel();
        radio_nam = new javax.swing.JRadioButton();
        radio_nu = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        add_sdt = new javax.swing.JPanel();
        pnl_name_content2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_inputSDT = new javax.swing.JTextField();
        content2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        add_diachi = new javax.swing.JPanel();
        pnl_name_content4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_inputAddress = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        add_cmnd = new javax.swing.JPanel();
        pnl_name_content5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_inputCmnd = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        add_quocgia = new javax.swing.JPanel();
        pnl_name_content6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_inputQuocGia = new javax.swing.JTextField();
        pnl_add = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pnl_reset = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        pnl_edit = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("THÊM MỚI KHÁCH HÀNG");
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));

        header.setBackground(new java.awt.Color(8, 13, 23));
        header.setPreferredSize(new java.awt.Dimension(776, 50));
        header.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(154, 231, 246));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thêm mới khách hàng");
        header.add(jLabel1, java.awt.BorderLayout.CENTER);

        content1.setBackground(new java.awt.Color(48, 48, 48));
        content1.setPreferredSize(new java.awt.Dimension(380, 700));

        jPanel4.setBackground(new java.awt.Color(48, 48, 48));
        jPanel4.setPreferredSize(new java.awt.Dimension(380, 30));
        content1.add(jPanel4);

        add_name.setBackground(new java.awt.Color(36, 36, 36));
        add_name.setPreferredSize(new java.awt.Dimension(320, 45));
        add_name.setLayout(new java.awt.BorderLayout());

        pnl_name_content.setBackground(new java.awt.Color(16, 16, 16));
        pnl_name_content.setPreferredSize(new java.awt.Dimension(100, 40));
        pnl_name_content.setLayout(new java.awt.BorderLayout());

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setPreferredSize(new java.awt.Dimension(5, 40));
        pnl_name_content.add(jLabel4, java.awt.BorderLayout.LINE_END);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(154, 231, 246));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Họ và Tên");
        pnl_name_content.add(jLabel5, java.awt.BorderLayout.CENTER);

        add_name.add(pnl_name_content, java.awt.BorderLayout.LINE_START);

        txt_inputName.setBackground(new java.awt.Color(32, 32, 32));
        txt_inputName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_inputName.setForeground(new java.awt.Color(154, 231, 246));
        txt_inputName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 15));
        txt_inputName.setCaretColor(new java.awt.Color(154, 231, 246));
        add_name.add(txt_inputName, java.awt.BorderLayout.CENTER);

        content1.add(add_name);

        jPanel5.setBackground(new java.awt.Color(48, 48, 48));
        jPanel5.setPreferredSize(new java.awt.Dimension(380, 40));
        content1.add(jPanel5);

        pnl_birthDay.setBackground(new java.awt.Color(36, 36, 36));
        pnl_birthDay.setPreferredSize(new java.awt.Dimension(320, 45));
        pnl_birthDay.setLayout(new java.awt.BorderLayout());

        pnl_name_content1.setBackground(new java.awt.Color(16, 16, 16));
        pnl_name_content1.setPreferredSize(new java.awt.Dimension(100, 40));
        pnl_name_content1.setLayout(new java.awt.BorderLayout());

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setPreferredSize(new java.awt.Dimension(5, 40));
        pnl_name_content1.add(jLabel6, java.awt.BorderLayout.LINE_END);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(154, 231, 246));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Ngày Sinh");
        pnl_name_content1.add(jLabel7, java.awt.BorderLayout.CENTER);

        pnl_birthDay.add(pnl_name_content1, java.awt.BorderLayout.LINE_START);

        dateBirthDayKH.setBackground(new java.awt.Color(255, 255, 255));
        dateBirthDayKH.setDateFormatString("dd/MM/yyyy");
        dateBirthDayKH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        pnl_birthDay.add(dateBirthDayKH, java.awt.BorderLayout.CENTER);

        content1.add(pnl_birthDay);

        jPanel6.setBackground(new java.awt.Color(48, 48, 48));
        jPanel6.setPreferredSize(new java.awt.Dimension(380, 40));
        content1.add(jPanel6);

        pnl_gender.setBackground(new java.awt.Color(36, 36, 36));
        pnl_gender.setPreferredSize(new java.awt.Dimension(320, 45));
        pnl_gender.setLayout(new java.awt.BorderLayout());

        pnl_name_content7.setBackground(new java.awt.Color(16, 16, 16));
        pnl_name_content7.setPreferredSize(new java.awt.Dimension(100, 40));
        pnl_name_content7.setLayout(new java.awt.BorderLayout());

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setPreferredSize(new java.awt.Dimension(5, 40));
        pnl_name_content7.add(jLabel18, java.awt.BorderLayout.LINE_END);

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(154, 231, 246));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Giới Tính");
        jLabel19.setPreferredSize(new java.awt.Dimension(60, 17));
        pnl_name_content7.add(jLabel19, java.awt.BorderLayout.CENTER);

        pnl_gender.add(pnl_name_content7, java.awt.BorderLayout.LINE_START);

        pnl_button_radio.setBackground(new java.awt.Color(36, 36, 36));
        pnl_button_radio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        radio_nam.setBackground(new java.awt.Color(27, 27, 27));
        buttonGroup1.add(radio_nam);
        radio_nam.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        radio_nam.setForeground(new java.awt.Color(154, 231, 246));
        radio_nam.setSelected(true);
        radio_nam.setText("Nam");
        radio_nam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        radio_nam.setPreferredSize(new java.awt.Dimension(90, 40));
        pnl_button_radio.add(radio_nam, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 50));

        radio_nu.setBackground(new java.awt.Color(27, 27, 27));
        buttonGroup1.add(radio_nu);
        radio_nu.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        radio_nu.setForeground(new java.awt.Color(154, 231, 246));
        radio_nu.setText("Nữ");
        radio_nu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        radio_nu.setPreferredSize(new java.awt.Dimension(90, 40));
        radio_nu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_nuActionPerformed(evt);
            }
        });
        pnl_button_radio.add(radio_nu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, -1, 50));

        pnl_gender.add(pnl_button_radio, java.awt.BorderLayout.CENTER);

        content1.add(pnl_gender);

        jPanel7.setBackground(new java.awt.Color(48, 48, 48));
        jPanel7.setPreferredSize(new java.awt.Dimension(380, 40));
        content1.add(jPanel7);

        add_sdt.setBackground(new java.awt.Color(36, 36, 36));
        add_sdt.setPreferredSize(new java.awt.Dimension(320, 45));
        add_sdt.setLayout(new java.awt.BorderLayout());

        pnl_name_content2.setBackground(new java.awt.Color(16, 16, 16));
        pnl_name_content2.setPreferredSize(new java.awt.Dimension(100, 40));
        pnl_name_content2.setLayout(new java.awt.BorderLayout());

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setPreferredSize(new java.awt.Dimension(5, 40));
        pnl_name_content2.add(jLabel8, java.awt.BorderLayout.LINE_END);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(154, 231, 246));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("SĐT");
        pnl_name_content2.add(jLabel9, java.awt.BorderLayout.CENTER);

        add_sdt.add(pnl_name_content2, java.awt.BorderLayout.LINE_START);

        txt_inputSDT.setBackground(new java.awt.Color(32, 32, 32));
        txt_inputSDT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_inputSDT.setForeground(new java.awt.Color(154, 231, 246));
        txt_inputSDT.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 15));
        txt_inputSDT.setCaretColor(new java.awt.Color(154, 231, 246));
        add_sdt.add(txt_inputSDT, java.awt.BorderLayout.CENTER);

        content1.add(add_sdt);

        content2.setBackground(new java.awt.Color(48, 48, 48));
        content2.setPreferredSize(new java.awt.Dimension(320, 700));

        jPanel8.setBackground(new java.awt.Color(48, 48, 48));
        jPanel8.setPreferredSize(new java.awt.Dimension(380, 30));

        add_diachi.setBackground(new java.awt.Color(36, 36, 36));
        add_diachi.setPreferredSize(new java.awt.Dimension(320, 45));
        add_diachi.setLayout(new java.awt.BorderLayout());

        pnl_name_content4.setBackground(new java.awt.Color(16, 16, 16));
        pnl_name_content4.setPreferredSize(new java.awt.Dimension(100, 40));
        pnl_name_content4.setLayout(new java.awt.BorderLayout());

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setPreferredSize(new java.awt.Dimension(5, 40));
        pnl_name_content4.add(jLabel12, java.awt.BorderLayout.LINE_END);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(154, 231, 246));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Địa chỉ");
        pnl_name_content4.add(jLabel13, java.awt.BorderLayout.CENTER);

        add_diachi.add(pnl_name_content4, java.awt.BorderLayout.LINE_START);

        txt_inputAddress.setBackground(new java.awt.Color(32, 32, 32));
        txt_inputAddress.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_inputAddress.setForeground(new java.awt.Color(154, 231, 246));
        txt_inputAddress.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 15));
        txt_inputAddress.setCaretColor(new java.awt.Color(154, 231, 246));
        add_diachi.add(txt_inputAddress, java.awt.BorderLayout.CENTER);

        jPanel9.setBackground(new java.awt.Color(48, 48, 48));
        jPanel9.setPreferredSize(new java.awt.Dimension(380, 40));

        add_cmnd.setBackground(new java.awt.Color(36, 36, 36));
        add_cmnd.setPreferredSize(new java.awt.Dimension(320, 45));
        add_cmnd.setLayout(new java.awt.BorderLayout());

        pnl_name_content5.setBackground(new java.awt.Color(16, 16, 16));
        pnl_name_content5.setPreferredSize(new java.awt.Dimension(100, 40));
        pnl_name_content5.setLayout(new java.awt.BorderLayout());

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setPreferredSize(new java.awt.Dimension(5, 40));
        pnl_name_content5.add(jLabel14, java.awt.BorderLayout.LINE_END);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(154, 231, 246));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("CMND");
        pnl_name_content5.add(jLabel15, java.awt.BorderLayout.CENTER);

        add_cmnd.add(pnl_name_content5, java.awt.BorderLayout.LINE_START);

        txt_inputCmnd.setBackground(new java.awt.Color(32, 32, 32));
        txt_inputCmnd.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_inputCmnd.setForeground(new java.awt.Color(154, 231, 246));
        txt_inputCmnd.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 15));
        txt_inputCmnd.setCaretColor(new java.awt.Color(154, 231, 246));
        add_cmnd.add(txt_inputCmnd, java.awt.BorderLayout.CENTER);

        jPanel10.setBackground(new java.awt.Color(48, 48, 48));
        jPanel10.setPreferredSize(new java.awt.Dimension(380, 40));

        add_quocgia.setBackground(new java.awt.Color(36, 36, 36));
        add_quocgia.setPreferredSize(new java.awt.Dimension(320, 45));
        add_quocgia.setLayout(new java.awt.BorderLayout());

        pnl_name_content6.setBackground(new java.awt.Color(16, 16, 16));
        pnl_name_content6.setPreferredSize(new java.awt.Dimension(100, 40));
        pnl_name_content6.setLayout(new java.awt.BorderLayout());

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setPreferredSize(new java.awt.Dimension(5, 40));
        pnl_name_content6.add(jLabel16, java.awt.BorderLayout.LINE_END);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(154, 231, 246));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Quốc gia");
        pnl_name_content6.add(jLabel17, java.awt.BorderLayout.CENTER);

        add_quocgia.add(pnl_name_content6, java.awt.BorderLayout.LINE_START);

        txt_inputQuocGia.setBackground(new java.awt.Color(32, 32, 32));
        txt_inputQuocGia.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_inputQuocGia.setForeground(new java.awt.Color(154, 231, 246));
        txt_inputQuocGia.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 15));
        txt_inputQuocGia.setCaretColor(new java.awt.Color(154, 231, 246));
        add_quocgia.add(txt_inputQuocGia, java.awt.BorderLayout.CENTER);

        pnl_add.setBackground(new java.awt.Color(36, 36, 36));
        pnl_add.setPreferredSize(new java.awt.Dimension(100, 50));
        pnl_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_addMouseClicked(evt);
            }
        });
        pnl_add.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(154, 231, 246));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Thêm");
        pnl_add.add(jLabel3, java.awt.BorderLayout.CENTER);

        pnl_reset.setBackground(new java.awt.Color(36, 36, 36));
        pnl_reset.setPreferredSize(new java.awt.Dimension(100, 50));
        pnl_reset.setLayout(new java.awt.BorderLayout());

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(154, 231, 246));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Thoát");
        pnl_reset.add(jLabel10, java.awt.BorderLayout.CENTER);

        pnl_edit.setBackground(new java.awt.Color(36, 36, 36));
        pnl_edit.setPreferredSize(new java.awt.Dimension(100, 50));
        pnl_edit.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(154, 231, 246));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Làm mới");
        pnl_edit.add(jLabel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout content2Layout = new javax.swing.GroupLayout(content2);
        content2.setLayout(content2Layout);
        content2Layout.setHorizontalGroup(
            content2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(content2Layout.createSequentialGroup()
                .addGroup(content2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(content2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(content2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(add_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(content2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(content2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(add_cmnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(content2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(content2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(add_quocgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(content2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(pnl_add, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnl_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnl_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        content2Layout.setVerticalGroup(
            content2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(content2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(add_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(add_cmnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(add_quocgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addGroup(content2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_edit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_add, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_reset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(content1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(content2, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(content1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(content2, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void ressetText() {
        txt_inputName.setText("");
        txt_inputAddress.setText("");
        dateBirthDayKH.setDate(null);
        txt_inputCmnd.setText("");
        txt_inputQuocGia.setText("");
        txt_inputSDT.setText("");
    }
    private void radio_nuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_nuActionPerformed

    }//GEN-LAST:event_radio_nuActionPerformed

    private void pnl_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_addMouseClicked
        String nameKH = txt_inputName.getText();
        String addressKH = txt_inputAddress.getText();
        java.util.Date utilDate = dateBirthDayKH.getDate();
        String cmndKH = txt_inputCmnd.getText();
        String quocGiaKH = txt_inputQuocGia.getText();
        String sdtlKH = txt_inputSDT.getText();
        String gioiTinh = "nam";
        if (radio_nu.isSelected() == true) {
            gioiTinh = "nữ";
        }
        khach_hangModel.setName(nameKH);
        khach_hangModel.setAddress(addressKH);
        if (utilDate != null) {
            java.sql.Date sqlStartDate = new java.sql.Date(utilDate.getTime());
            khach_hangModel.setBirthDay(sqlStartDate);
        } else {
            khach_hangModel.setBirthDay(null);
        }
        khach_hangModel.setIdentityCard(cmndKH);
        khach_hangModel.setNation(quocGiaKH);
        khach_hangModel.setPhone(sdtlKH);
        khach_hangModel.setGender(gioiTinh);
        
        khach_hang_model checkSoluot = khach_hangService.findCmnd(cmndKH);
        if (checkSoluot != null) {
            String soLuot = String.valueOf(checkSoluot.getNumberOfCheckIn());
            String mess = "";
            mess += "Khách Hàng Đã Đến Khách Sạn " + soLuot + "Lần";
            checkSoluot.setNumberOfCheckIn(checkSoluot.getNumberOfCheckIn() + 1);
            
            int keyu = khach_hangService.edit_khachHang(checkSoluot);
            if (keyu > 0) {
                JOptionPane.showMessageDialog(this, "Thành Công!");
                ressetText();
                cb.doAdd();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Thất Bại!");
            }
        } else {
            khach_hangModel.setNumberOfCheckIn(1);
            Long key = khach_hangService.add_khachHang(khach_hangModel);
            if (key > 0) {
                JOptionPane.showMessageDialog(this, "Thêm Mới Thành Công!");
                ressetText();
                cb.doAdd();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm Mới Thất Bại");
            }
        }
        
    }//GEN-LAST:event_pnl_addMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel add_cmnd;
    private javax.swing.JPanel add_diachi;
    private javax.swing.JPanel add_name;
    private javax.swing.JPanel add_quocgia;
    private javax.swing.JPanel add_sdt;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel content1;
    private javax.swing.JPanel content2;
    private com.toedter.calendar.JDateChooser dateBirthDayKH;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel pnl_add;
    private javax.swing.JPanel pnl_birthDay;
    private javax.swing.JPanel pnl_button_radio;
    private javax.swing.JPanel pnl_edit;
    private javax.swing.JPanel pnl_gender;
    private javax.swing.JPanel pnl_name_content;
    private javax.swing.JPanel pnl_name_content1;
    private javax.swing.JPanel pnl_name_content2;
    private javax.swing.JPanel pnl_name_content4;
    private javax.swing.JPanel pnl_name_content5;
    private javax.swing.JPanel pnl_name_content6;
    private javax.swing.JPanel pnl_name_content7;
    private javax.swing.JPanel pnl_reset;
    private javax.swing.JRadioButton radio_nam;
    private javax.swing.JRadioButton radio_nu;
    private javax.swing.JTextField txt_inputAddress;
    private javax.swing.JTextField txt_inputCmnd;
    private javax.swing.JTextField txt_inputName;
    private javax.swing.JTextField txt_inputQuocGia;
    private javax.swing.JTextField txt_inputSDT;
    // End of variables declaration//GEN-END:variables
}

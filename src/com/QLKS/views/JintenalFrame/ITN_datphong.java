/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.views.JintenalFrame;

import com.QLKS.Service.impl.hoa_donService;
import com.QLKS.Service.impl.khach_hangService;
import com.QLKS.Service.impl.khuyen_maiService;
import com.QLKS.Service.impl.phongService;
import com.QLKS.Service.impl.trang_thai_hoa_donService;
import com.QLKS.model.hoa_donModel;
import com.QLKS.model.khach_hang_model;
import com.QLKS.model.khuyen_maiModel;
import com.QLKS.model.nhan_vienModel;
import com.QLKS.model.phongModel;
import com.QLKS.model.trang_thai_hoa_donModel;
import com.QLKS.utils.functionBase;
import com.QLKS.views.mainFrame;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author steve
 */
public class ITN_datphong extends javax.swing.JInternalFrame {

    /**
     * Creates new form ITN_datphong
     */
    List<khach_hang_model> listKhachHang;
    List<phongModel> listPhong;
    List<trang_thai_hoa_donModel> listTrangThaiHoaDon;
    trang_thai_hoa_donModel trang_thaiHD;
    phongModel phongModel;
    khach_hang_model khach_hangModel;
    trang_thai_hoa_donService trang_thaiKDService;
    phongService phongSevice;
    khach_hangService khach_hangService;
    DefaultTableModel dfmPhong;
    DefaultTableModel dfmKhachHang;
    functionBase funBase;
    DefaultComboBoxModel<khach_hang_model> cbxKhachHang;
    DefaultComboBoxModel<trang_thai_hoa_donModel> cbxTTHD;
    List<String> lstMaPhong123;
    hoa_donModel hoa_donModel;
    hoa_donService hoa_donService;
    SimpleDateFormat sf;
    khuyen_maiModel khuyen_maiModel;
    khuyen_maiService khuyen_maiService;
    nhan_vienModel nhanModel;

    public ITN_datphong() {
        initComponents();
        phongModel = new phongModel();
        khach_hangModel = new khach_hang_model();
        trang_thaiHD = new trang_thai_hoa_donModel();
        khach_hangService = new khach_hangService();
        phongSevice = new phongService();
        trang_thaiKDService = new trang_thai_hoa_donService();
        dfmPhong = new DefaultTableModel();
        dfmKhachHang = new DefaultTableModel();
        funBase = new functionBase();
        cbxKhachHang = new DefaultComboBoxModel();
        cbxTTHD = new DefaultComboBoxModel();
        listKhachHang = khach_hangService.findAll();
        listTrangThaiHoaDon = trang_thaiKDService.findAll();
        listPhong = phongSevice.findAll();
        hoa_donModel = new hoa_donModel();
        hoa_donService = new hoa_donService();
        java.util.Date dateNews = new java.util.Date();
        ngay_den_thuc_te.setDate(dateNews);
        sf = new SimpleDateFormat("dd/MM/yyyy");
        khuyen_maiModel = new khuyen_maiModel();
        khuyen_maiService = new khuyen_maiService();
        initKhachHang();
        initTrangThaiHD();
        loadDataKH();
        loadDataPhongTrong();
    }

    public void ressetText() {
        txtIDP.setText("");
        txt_HTTT.setText("");
        ngay_den_du_kien.setDate(null);
    }

    public void Reload() {
        mainFrame main = new mainFrame(nhanModel);
        main.setVisible(true);
        this.dispose();
//        SwingUtilities.updateComponentTreeUI(main);
//        main.invalidate();
//        main.validate();
//        main.repaint();
    }

    public void initKhachHang() {
        for (khach_hang_model modelKH : listKhachHang) {
            cbxKhachHang.addElement(modelKH);
        }
        comboBoxKhachHang.setModel(cbxKhachHang);
    }

    public void initTrangThaiHD() {
        for (trang_thai_hoa_donModel modelTTHD : listTrangThaiHoaDon) {
            cbxTTHD.addElement(modelTTHD);
        }
        comboBoxTTHD.setModel(cbxTTHD);
    }

    public void loadDataKH() {
        Object[] columnNames = {"STT", "Mã Khách Hàng", "Tên Khách Hàng", "Giới Tính", "Số Điện Thoại", "CMND"};
//        if (nameSeaechInput != null) {
//            dfmThietBi = thiet_biService.search(nameSeaechInput);
//        } else {
//            dfmThietBi = cauhinhDAO.getAll();
//        }

        dfmKhachHang = new DefaultTableModel(new Object[0][0], columnNames);
        int index = 1;
        for (khach_hang_model adv : listKhachHang) {
            Object[] o = new Object[6];
            o[0] = index;
            o[1] = adv.getId();
            o[2] = adv.getName();
            o[3] = adv.getGender();
            o[4] = adv.getPhone();
            o[5] = adv.getIdentityCard();
            dfmKhachHang.addRow(o);
            index++;
        }
        tbl_KhachHang.setModel(dfmKhachHang);
    }

    public void loadDataPhongTrong() {
        Object[] columnNames = {"STT", "Mã Phòng", "Tên loại phòng", "Giá", ""};
//        if (nameSeaechInput != null) {
//            dfmThietBi = thiet_biService.search(nameSeaechInput);
//        } else {
//            dfmThietBi = cauhinhDAO.getAll();
//        }
        dfmPhong = new DefaultTableModel(new Object[0][0], columnNames);
        int index = 1;
        for (phongModel adv : listPhong) {
            if (adv.getStatus().equals("Đang Trống")) {
                Object[] o = new Object[5];
                o[0] = index;
                o[1] = adv.getId();
                o[2] = adv.getLoai_phong().getName_LP();
                o[3] = adv.getLoai_phong().getPrice();
                dfmPhong.addRow(o);
                index++;
            }
        }
        tbl_PhongTrong.setModel(dfmPhong);
        funBase.addCheckBox(4, tbl_PhongTrong);
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
        content = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jlbMaDv = new javax.swing.JLabel();
        jlbMaDv1 = new javax.swing.JLabel();
        jlbMaDv2 = new javax.swing.JLabel();
        jlbMaDv3 = new javax.swing.JLabel();
        txtErrorMaLoaiDichVu = new javax.swing.JLabel();
        comboBoxKhachHang = new javax.swing.JComboBox<>();
        comboBoxTTHD = new javax.swing.JComboBox<>();
        jlbMaDv4 = new javax.swing.JLabel();
        ngay_den_du_kien = new com.toedter.calendar.JDateChooser();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_HTTT = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtIDP = new javax.swing.JLabel();
        jlbMaDv5 = new javax.swing.JLabel();
        ngay_den_thuc_te = new com.toedter.calendar.JDateChooser();
        ngay_tra_du_kien = new com.toedter.calendar.JDateChooser();
        jlbMaDv6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_PhongTrong = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_KhachHang = new javax.swing.JTable();

        setClosable(true);

        header.setBackground(new java.awt.Color(8, 18, 28));
        header.setPreferredSize(new java.awt.Dimension(776, 40));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(154, 231, 246));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đặt phòng");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        content.setBackground(new java.awt.Color(48, 48, 48));

        jPanel2.setBackground(new java.awt.Color(48, 48, 48));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đặt phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(154, 231, 246))); // NOI18N

        jlbMaDv.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jlbMaDv.setForeground(new java.awt.Color(154, 231, 246));
        jlbMaDv.setText("Phòng:");

        jlbMaDv1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jlbMaDv1.setForeground(new java.awt.Color(154, 231, 246));
        jlbMaDv1.setText("Khách hàng:");

        jlbMaDv2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jlbMaDv2.setForeground(new java.awt.Color(154, 231, 246));
        jlbMaDv2.setText("HT thanh toán:");

        jlbMaDv3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jlbMaDv3.setForeground(new java.awt.Color(154, 231, 246));
        jlbMaDv3.setText("Trạng thái:");

        txtErrorMaLoaiDichVu.setForeground(new java.awt.Color(255, 0, 0));
        txtErrorMaLoaiDichVu.setText("...");
        txtErrorMaLoaiDichVu.setPreferredSize(new java.awt.Dimension(12, 25));

        comboBoxKhachHang.setPreferredSize(new java.awt.Dimension(96, 30));

        comboBoxTTHD.setPreferredSize(new java.awt.Dimension(96, 30));

        jlbMaDv4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jlbMaDv4.setForeground(new java.awt.Color(154, 231, 246));
        jlbMaDv4.setText("Ngày Đến Dự Kiến:");

        ngay_den_du_kien.setDateFormatString("dd/MM/yyyy");

        jPanel6.setBackground(new java.awt.Color(36, 36, 36));
        jPanel6.setMaximumSize(new java.awt.Dimension(100, 35));
        jPanel6.setMinimumSize(new java.awt.Dimension(100, 35));
        jPanel6.setPreferredSize(new java.awt.Dimension(90, 30));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });
        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel3.setForeground(new java.awt.Color(154, 231, 246));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Làm mới");
        jPanel6.add(jLabel3, java.awt.BorderLayout.CENTER);

        jPanel7.setBackground(new java.awt.Color(36, 36, 36));
        jPanel7.setMaximumSize(new java.awt.Dimension(100, 35));
        jPanel7.setMinimumSize(new java.awt.Dimension(100, 35));
        jPanel7.setPreferredSize(new java.awt.Dimension(90, 30));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });
        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel4.setForeground(new java.awt.Color(154, 231, 246));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Đặt Phòng");
        jPanel7.add(jLabel4, java.awt.BorderLayout.CENTER);

        txt_HTTT.setBackground(new java.awt.Color(27, 27, 27));
        txt_HTTT.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txt_HTTT.setForeground(new java.awt.Color(154, 231, 246));
        txt_HTTT.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 15));
        txt_HTTT.setCaretColor(new java.awt.Color(154, 231, 246));

        jScrollPane3.setBackground(new java.awt.Color(27, 27, 27));

        txtIDP.setBackground(new java.awt.Color(27, 27, 27));
        txtIDP.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtIDP.setText("...");
        txtIDP.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 1));
        jScrollPane3.setViewportView(txtIDP);

        jlbMaDv5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jlbMaDv5.setForeground(new java.awt.Color(154, 231, 246));
        jlbMaDv5.setText("Ngày Đến Thực Tế:");

        ngay_den_thuc_te.setDateFormatString("dd/MM/yyyy");
        ngay_den_thuc_te.setEnabled(false);
        ngay_den_thuc_te.setFocusable(false);
        ngay_den_thuc_te.setRequestFocusEnabled(false);

        ngay_tra_du_kien.setDateFormatString("dd/MM/yyyy");

        jlbMaDv6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jlbMaDv6.setForeground(new java.awt.Color(154, 231, 246));
        jlbMaDv6.setText("Ngày trả dự kiến:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlbMaDv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbMaDv2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbMaDv1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbMaDv3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbMaDv4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbMaDv5)
                            .addComponent(jlbMaDv6))
                        .addGap(0, 38, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_HTTT, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ngay_den_du_kien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboBoxTTHD, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboBoxKhachHang, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ngay_den_thuc_te, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addComponent(ngay_tra_du_kien, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                .addComponent(txtErrorMaLoaiDichVu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jlbMaDv)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(txtErrorMaLoaiDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbMaDv1)
                    .addComponent(comboBoxKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbMaDv2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_HTTT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbMaDv3)
                    .addComponent(comboBoxTTHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ngay_den_du_kien, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jlbMaDv4)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jlbMaDv5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(ngay_den_thuc_te, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(ngay_tra_du_kien, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jlbMaDv6)
                        .addGap(65, 65, 65)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(148, 148, 148))
        );

        jPanel3.setBackground(new java.awt.Color(48, 48, 48));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách phòng trống", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(154, 231, 246))); // NOI18N

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setHorizontalScrollBar(null);

        tbl_PhongTrong.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_PhongTrong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_PhongTrongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_PhongTrong);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(48, 48, 48));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(154, 231, 246))); // NOI18N

        tbl_KhachHang.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_KhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_KhachHang);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
            .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        ressetText();
        loadDataKH();
        loadDataPhongTrong();
    }//GEN-LAST:event_jPanel6MouseClicked

    private void tbl_KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_KhachHangMouseClicked
        int pos = tbl_KhachHang.getSelectedRow();
        Long ma_KH = listKhachHang.get(pos).getId();
        khach_hang_model c = listKhachHang.stream().filter(x -> x.getId().equals(ma_KH)).findAny().orElse(null);
        comboBoxKhachHang.setSelectedItem(c);
    }//GEN-LAST:event_tbl_KhachHangMouseClicked

    private void tbl_PhongTrongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_PhongTrongMouseClicked
        lstMaPhong123 = new ArrayList();
        StringBuilder resultStr = new StringBuilder();
        for (int i = 0; i < tbl_PhongTrong.getRowCount(); i++) {
            if (funBase.IsSelected(i, 4, tbl_PhongTrong)) {
                lstMaPhong123.add(tbl_PhongTrong.getValueAt(i, 1).toString());
            }
        }
        
        for (int i = 0; i < lstMaPhong123.size(); i++) {
            resultStr.append(lstMaPhong123.get(i) + " , ");
        }
        txtIDP.setText(resultStr.toString());

    }//GEN-LAST:event_tbl_PhongTrongMouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        khach_hang_model khachhang = (khach_hang_model) cbxKhachHang.getSelectedItem();
        trang_thai_hoa_donModel trangThai = (trang_thai_hoa_donModel) cbxTTHD.getSelectedItem();
        Long idTT = trangThai.getId();
        Long IDKH = khachhang.getId();
        String HinhThucTT = txt_HTTT.getText();
        java.util.Date utilNgay_den_du_kien = ngay_den_du_kien.getDate();
        java.util.Date utilNgay_den_thuc_te = ngay_den_thuc_te.getDate();
        java.util.Date utilngay_tra_du_kien = ngay_tra_du_kien.getDate();
        Date date1 = null;
        Date date2 = null;
        Date date3 = null;
        String messSuccess = "";
        String messErr = "";
        boolean checkDP = true;
        Float tongTienDP = Float.valueOf(0);
        if (utilNgay_den_thuc_te.after(utilngay_tra_du_kien) == true) {
            JOptionPane.showMessageDialog(rootPane, "Thêm thất bại vì ngày trả trước ngày đến", "Thông báo", JOptionPane.ERROR_MESSAGE);
            ressetText();
            checkDP = false;
        } else {
            String ngayDenTTStr = sf.format(utilNgay_den_thuc_te);
            String ngayDenDK = sf.format(utilNgay_den_du_kien);
            String ngayTraDK = sf.format(utilngay_tra_du_kien);
            try {
                date1 = sf.parse(ngayDenTTStr);
                date2 = sf.parse(ngayDenDK);
                date3 = sf.parse(ngayTraDK);
            } catch (ParseException ex) {
                Logger.getLogger(ITN_datphong.class.getName()).log(Level.SEVERE, null, ex);
            }
            Long getDiffNgayTTAndNgayTra;
            Long getDiffNgayTTAndNgayDK;
            Long getDaysDiff;
            Long getDaysDiffSD;
            getDiffNgayTTAndNgayTra = date3.getTime() - date1.getTime();
            getDaysDiffSD = getDiffNgayTTAndNgayTra / (24 * 60 * 60 * 1000);
            khach_hangModel = khach_hangService.findOne(IDKH);
            khuyen_maiModel = khuyen_maiService.findByCode("khachquen1234");
            Float giamGia;
            if (khach_hangModel.getNumberOfCheckIn() > 1) {
                if (khuyen_maiModel != null) {
                    giamGia = khuyen_maiModel.getValue();
                } else {
                    giamGia = Float.valueOf(0);
                }
            } else {
                giamGia = Float.valueOf(0);
            }
            for (String idP : lstMaPhong123) {
                phongModel = phongSevice.findOne(idP);
                if (utilNgay_den_du_kien.after(utilNgay_den_thuc_te) == false) {
                    phongModel checkTGP = phongSevice.findOne(idP);
                    if (checkTGP.getStatus().equals("Đã Đặt") == false) {
                        if (utilNgay_den_du_kien != null) {
                            java.sql.Date sqlNgay_den_du_kien = new java.sql.Date(utilNgay_den_du_kien.getTime());
                            hoa_donModel.setNgay_den_du_kien(sqlNgay_den_du_kien);
                        } else {
                            hoa_donModel.setNgay_den_du_kien(null);
                        }
                        if (utilNgay_den_thuc_te != null) {
                            java.sql.Date SQLNgay_den_thuc_te = new java.sql.Date(utilNgay_den_thuc_te.getTime());
                            hoa_donModel.setNgay_den_thuc_te(SQLNgay_den_thuc_te);
                        } else {
                            hoa_donModel.setNgay_den_thuc_te(null);
                        }
                        if (utilngay_tra_du_kien != null) {
                            java.sql.Date sql_ngay_tra_du_kien = new java.sql.Date(utilngay_tra_du_kien.getTime());
                            hoa_donModel.setSo_ngay_du_kien(sql_ngay_tra_du_kien);
                        } else {
                            hoa_donModel.setSo_ngay_du_kien(null);
                        }
                        phongModel newPhongModel = new phongModel();
                        Float tienPhong = checkTGP.getLoai_phong().getPrice();
                        newPhongModel.setId(idP);
                        newPhongModel.setId_LP(checkTGP.getId_LP());
                        newPhongModel.setStatus("Đã Đặt");
                        tongTienDP = ((tienPhong * getDaysDiffSD) - giamGia);
                        hoa_donModel.setId_KH(IDKH);
                        hoa_donModel.setId_P(idP);
                        hoa_donModel.setHinh_thucTT(HinhThucTT);
                        hoa_donModel.setId_TTHD(idTT);
                        hoa_donModel.setSo_ngay(getDaysDiffSD);
                        hoa_donModel.setTien_phong(tienPhong);
                        hoa_donModel.setGiam_giaKH(giamGia);
                        hoa_donModel.setThanh_tien(tongTienDP);
                        phongSevice.edit(newPhongModel);
                        Long key = hoa_donService.add(hoa_donModel);
                        if (key > 0) {
                            JOptionPane.showMessageDialog(this, "Đặt Phòng Thành Công!");
                            loadDataKH();
                            loadDataPhongTrong();
                            ressetText();
                            Reload();
                        } else {
                            JOptionPane.showMessageDialog(this, "Đặt Phòng Thất Bại!");
                            ressetText();
                        }
                    }
                } else {
                    getDiffNgayTTAndNgayDK = date2.getTime() - date1.getTime();
                    getDaysDiff = getDiffNgayTTAndNgayDK / (24 * 60 * 60 * 1000);
                    if (getDaysDiff < getDaysDiffSD / 2 || getDaysDiff == getDaysDiffSD / 2) {
                        if (utilNgay_den_du_kien != null) {
                            java.sql.Date sqlNgay_den_du_kien = new java.sql.Date(utilNgay_den_du_kien.getTime());
                            hoa_donModel.setNgay_den_du_kien(sqlNgay_den_du_kien);
                        } else {
                            hoa_donModel.setNgay_den_du_kien(null);
                        }
                        if (utilNgay_den_thuc_te != null) {
                            java.sql.Date SQLNgay_den_thuc_te = new java.sql.Date(utilNgay_den_thuc_te.getTime());
                            hoa_donModel.setNgay_den_thuc_te(SQLNgay_den_thuc_te);
                        } else {
                            hoa_donModel.setNgay_den_thuc_te(null);
                        }
                        if (utilngay_tra_du_kien != null) {
                            java.sql.Date sql_ngay_tra_du_kien = new java.sql.Date(utilngay_tra_du_kien.getTime());
                            hoa_donModel.setSo_ngay_du_kien(sql_ngay_tra_du_kien);
                        } else {
                            hoa_donModel.setSo_ngay_du_kien(null);
                        }
                        phongModel newPhongModel = new phongModel();
                        Float tienPhong = phongModel.getLoai_phong().getPrice();
                        newPhongModel.setId(idP);
                        newPhongModel.setId_LP(phongModel.getId_LP());
                        newPhongModel.setStatus("Đã Đặt");
                        tongTienDP = ((tienPhong * getDaysDiffSD) - giamGia);
                        hoa_donModel.setId_KH(IDKH);
                        hoa_donModel.setId_P(idP);
                        hoa_donModel.setHinh_thucTT(HinhThucTT);
                        hoa_donModel.setId_TTHD(idTT);
                        hoa_donModel.setSo_ngay(getDaysDiffSD);
                        hoa_donModel.setTien_phong(tienPhong);
                        hoa_donModel.setGiam_giaKH(giamGia);
                        hoa_donModel.setThanh_tien(tongTienDP);
                        phongSevice.edit(newPhongModel);
                        Long key = hoa_donService.add(hoa_donModel);
                        if (key > 0) {
                            JOptionPane.showMessageDialog(this, "Đặt Phòng Thành Công!");
                            loadDataKH();
                            loadDataPhongTrong();
                            ressetText();
                            Reload();
                        } else {
                            JOptionPane.showMessageDialog(this, "Đặt Phòng Thất Bại!");
                            ressetText();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Phòng Đã bị hủy do khách hàng đến quá hạn!");
                        ressetText();
                        loadDataKH();
                        loadDataPhongTrong();
                        dispose();
                    }
                }
            }

        }

    }//GEN-LAST:event_jPanel7MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<khach_hang_model> comboBoxKhachHang;
    private javax.swing.JComboBox<trang_thai_hoa_donModel> comboBoxTTHD;
    private javax.swing.JPanel content;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jlbMaDv;
    private javax.swing.JLabel jlbMaDv1;
    private javax.swing.JLabel jlbMaDv2;
    private javax.swing.JLabel jlbMaDv3;
    private javax.swing.JLabel jlbMaDv4;
    private javax.swing.JLabel jlbMaDv5;
    private javax.swing.JLabel jlbMaDv6;
    private com.toedter.calendar.JDateChooser ngay_den_du_kien;
    private com.toedter.calendar.JDateChooser ngay_den_thuc_te;
    private com.toedter.calendar.JDateChooser ngay_tra_du_kien;
    private javax.swing.JTable tbl_KhachHang;
    private javax.swing.JTable tbl_PhongTrong;
    private javax.swing.JLabel txtErrorMaLoaiDichVu;
    private javax.swing.JLabel txtIDP;
    private javax.swing.JTextField txt_HTTT;
    // End of variables declaration//GEN-END:variables
}

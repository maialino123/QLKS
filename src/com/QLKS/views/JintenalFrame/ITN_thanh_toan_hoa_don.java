/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.views.JintenalFrame;

import com.QLKS.Service.impl.dich_vuService;
import com.QLKS.Service.impl.hoa_donService;
import com.QLKS.Service.impl.khach_hangService;
import com.QLKS.Service.impl.khuyen_maiService;
import com.QLKS.Service.impl.phongService;
import com.QLKS.Service.impl.su_dung_dich_vuService;
import com.QLKS.Service.impl.trang_thai_hoa_donService;
import com.QLKS.model.dich_vuModel;
import com.QLKS.model.hoa_donModel;
import com.QLKS.model.khach_hang_model;
import com.QLKS.model.khuyen_maiModel;
import com.QLKS.model.phongModel;
import com.QLKS.model.su_dung_dich_vuModel;
import com.QLKS.model.trang_thai_hoa_donModel;
import com.QLKS.utils.functionBase;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hello
 */
public class ITN_thanh_toan_hoa_don extends javax.swing.JInternalFrame {

    /**
     * Creates new form PhieuSDDichVu
     */
    CallbackCheckout cb;
    private String cmndKH;
    hoa_donModel hoa_donModel;
    dich_vuModel dich_vuModel;
    khach_hang_model khach_hangModel;
    su_dung_dich_vuModel su_dung_dich_vuModel;
    phongModel phongModel;
    trang_thai_hoa_donModel trang_thaiHDModel;
    List<su_dung_dich_vuModel> listSDDV;
    hoa_donService hoa_donService;
    khach_hangService khach_hangService;
    su_dung_dich_vuService su_dung_dich_vuService;
    phongService phongService;
    trang_thai_hoa_donService trang_thai_hoa_donService;
    List<hoa_donModel> listHoaDon;

    private float tongTien = 0;
    SimpleDateFormat sf;
    functionBase funBase;
    DefaultTableModel dfmSDDV;
    dich_vuService dich_vuService;
    khuyen_maiModel khuyen_maiModel;
    khuyen_maiService khuyen_maiService;

    public interface CallbackCheckout {

        void doCheckOut();
    }

    public ITN_thanh_toan_hoa_don(CallbackCheckout _cb, String _cmndKH) {
        initComponents();
        this.cb = _cb;
        cmndKH = _cmndKH;
        sf = new SimpleDateFormat("dd/MM/yyyy");
        hoa_donModel = new hoa_donModel();
        khach_hangModel = new khach_hang_model();
        su_dung_dich_vuModel = new su_dung_dich_vuModel();
        phongModel = new phongModel();
        trang_thaiHDModel = new trang_thai_hoa_donModel();
        hoa_donService = new hoa_donService();
        khach_hangService = new khach_hangService();
        su_dung_dich_vuService = new su_dung_dich_vuService();
        phongService = new phongService();
        trang_thai_hoa_donService = new trang_thai_hoa_donService();
        funBase = new functionBase();
        dfmSDDV = new DefaultTableModel();
        dich_vuModel = new dich_vuModel();
        dich_vuService = new dich_vuService();
        khuyen_maiModel = new khuyen_maiModel();
        khuyen_maiService = new khuyen_maiService();
        listHoaDon = hoa_donService.findAllHDByKH(_cmndKH);
        hoa_donModel = listHoaDon.get(0);
        lblMaNhanPhong.setText(hoa_donModel.getId().toString());
        lblTenKhachHang.setText(hoa_donModel.getKhach_hang().getName());
        lblGioiTinh.setText(hoa_donModel.getKhach_hang().getGender());
        lblCMND.setText(hoa_donModel.getKhach_hang().getIdentityCard());
        lblSDT.setText(hoa_donModel.getKhach_hang().getPhone());
        lblNgayThue.setText(sf.format(hoa_donModel.getNgay_den_thuc_te()));
        if (hoa_donModel.getSo_ngay_thuc_te() == null) {
            Date nowDateNgayTT = new Date();
            java.sql.Date sqlNowDateTT = new java.sql.Date(nowDateNgayTT.getTime());
            lblNgayDi.setText(sf.format(nowDateNgayTT));
        } else {
            lblNgayDi.setText(sf.format(hoa_donModel.getSo_ngay_thuc_te()));
        }
        lblSoNgayO.setText(funBase.formatTien(hoa_donModel.getSo_ngay()));
        setData();

    }

    public void setData() {
        if (listHoaDon.size() > 0) {
            float tinhTienPhuThu = 0;
            float tienPhong = 0;
            StringBuilder phongtxt = new StringBuilder();
            for (hoa_donModel modelHD : listHoaDon) {
                tienPhong += modelHD.getTien_phong();
                tinhTienPhuThu += modelHD.getTien_phong() * modelHD.getPhu_phi() / 100;
                phongtxt.append(modelHD.getId_P() + ",");
                initDVDSD();
            }
            phongtxt.setLength(phongtxt.length() - 1);
            lblMaPhong.setText(phongtxt.toString());
            lblGiaPhong.setText(funBase.formatTien(tienPhong * hoa_donModel.getSo_ngay()));
            float tongTienPhong = tienPhong * hoa_donModel.getSo_ngay();
            float tienDichVu = SumTienDV();
            float tienKM = hoa_donModel.getGiam_giaKH();
            float TongTien = tongTienPhong + tienDichVu + tinhTienPhuThu - tienKM;
            lblTongTien.setText(funBase.formatTien(TongTien));
        }
    }

    public void ressetText() {
        lblMaNhanPhong.setText("");
        lblMaPhong.setText("");
        lblNgayThue.setText("");
        lblTenKhachHang.setText("");
        lblCMND.setText("");
        lblNgayDi.setText("");
        lblGioiTinh.setText("");
        lblSDT.setText("");
        lblSoNgayO.setText("");
        lblGiaPhong.setText("");
        lblTienDichVu.setText("");
        lblKhuyenMai.setText("");
        lblPhuThu.setText("");
        lblTongTien.setText("");
    }

    public void initDVDSD() {
        Object[] columnNames = {"STT", "Mã Sử Dụng DV", "Mã Dịch Vụ", "Tên Loại DV", "Đơn Vị", "Số Lượng", "Tổng Tiền", ""};
//        if (nameSeaechInput != null) {
//            dfmThietBi = thiet_biService.search(nameSeaechInput);
//        } else {
//            dfmThietBi = cauhinhDAO.getAll();
//        }
        listSDDV = su_dung_dich_vuService.findAll();
        dfmSDDV = new DefaultTableModel(new Object[0][0], columnNames);
        int index = 1;
        for (su_dung_dich_vuModel adv : listSDDV) {
            dich_vuModel = dich_vuService.findOne(adv.getId_DV());
            Object[] o = new Object[7];
            o[0] = index;
            o[1] = adv.getId();
            o[2] = adv.getId_DV();
            o[3] = dich_vuModel.getLoai_dich_vuModel().getName();
            o[4] = dich_vuModel.getDon_viModel().getName_DV();
            o[5] = adv.getAmount();
            o[6] = (adv.getAmount() * dich_vuModel.getPrice());
            dfmSDDV.addRow(o);
            index++;
        }
        tblDichVuDaSD.setModel(dfmSDDV);
        lblTienDichVu.setText(funBase.formatTien(SumTienDV()));
        lblPhuThu.setText(funBase.formatTien(hoa_donModel.getPhu_phi()));

    }

    public float sumPhuPhi() {

        return 0;
    }

    public float SumTienDV() {
        int rowcount = tblDichVuDaSD.getRowCount();
        float sum = 0;
        for (int i = 0; i < rowcount; i++) {
            sum += Float.parseFloat(tblDichVuDaSD.getValueAt(i, 6).toString());
        }
        return sum;
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
        jpnTTKhachHang = new javax.swing.JPanel();
        jlbMaNhanPhong = new javax.swing.JLabel();
        lblMaNhanPhong = new javax.swing.JLabel();
        jlbMaPhong = new javax.swing.JLabel();
        lblMaPhong = new javax.swing.JLabel();
        jlbTenKhachhang = new javax.swing.JLabel();
        lblTenKhachHang = new javax.swing.JLabel();
        jlbCMND = new javax.swing.JLabel();
        lblCMND = new javax.swing.JLabel();
        jlbGioiTinh = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        jlbSDT = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        jlbSoNgayO = new javax.swing.JLabel();
        lblSoNgayO = new javax.swing.JLabel();
        jlbNgayThue = new javax.swing.JLabel();
        lblNgayThue = new javax.swing.JLabel();
        jlbNgayDi = new javax.swing.JLabel();
        lblNgayDi = new javax.swing.JLabel();
        jtbDanhSachSuDungDichVu = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDichVuDaSD = new javax.swing.JTable();
        jblTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jlbTienPhong = new javax.swing.JLabel();
        lblGiaPhong = new javax.swing.JLabel();
        jlbTienDichVu = new javax.swing.JLabel();
        lblTienDichVu = new javax.swing.JLabel();
        jlbTongTien = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        btnHuyBo = new javax.swing.JButton();
        jlbMaGiamGia = new javax.swing.JLabel();
        txtSearchMaKhuyenMai = new javax.swing.JTextField();
        jlbKhuyenMai = new javax.swing.JLabel();
        lblKhuyenMai = new javax.swing.JLabel();
        jlbHinhThucThanhToan = new javax.swing.JLabel();
        rdTienMat = new javax.swing.JRadioButton();
        rdTienThe = new javax.swing.JRadioButton();
        jlbPhuThu = new javax.swing.JLabel();
        lblPhuThu = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btnKiemTraMaKM = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jpnTTKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin phòng và khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jlbMaNhanPhong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbMaNhanPhong.setText("Mã Hóa Đơn");

        lblMaNhanPhong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMaNhanPhong.setText("...");

        jlbMaPhong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbMaPhong.setText("Mã phòng:");

        lblMaPhong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMaPhong.setText("...");

        jlbTenKhachhang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbTenKhachhang.setText("Tên khách hàng:");

        lblTenKhachHang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTenKhachHang.setText("....");

        jlbCMND.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbCMND.setText("CMND:");

        lblCMND.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCMND.setText("...");

        jlbGioiTinh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbGioiTinh.setText("Giới tính:");

        lblGioiTinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGioiTinh.setText("...");

        jlbSDT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbSDT.setText("SĐT:");

        lblSDT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSDT.setText("...");

        jlbSoNgayO.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbSoNgayO.setText("Số ngày ở:");

        lblSoNgayO.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSoNgayO.setText("...");

        jlbNgayThue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbNgayThue.setText("Ngày thuê:");

        lblNgayThue.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNgayThue.setText("...");

        jlbNgayDi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbNgayDi.setText("Ngày đi:");

        lblNgayDi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNgayDi.setText("...");

        javax.swing.GroupLayout jpnTTKhachHangLayout = new javax.swing.GroupLayout(jpnTTKhachHang);
        jpnTTKhachHang.setLayout(jpnTTKhachHangLayout);
        jpnTTKhachHangLayout.setHorizontalGroup(
            jpnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTTKhachHangLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jpnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnTTKhachHangLayout.createSequentialGroup()
                        .addGroup(jpnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbMaNhanPhong)
                            .addComponent(jlbMaPhong))
                        .addGap(27, 27, 27)
                        .addGroup(jpnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblMaNhanPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMaPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)))
                    .addGroup(jpnTTKhachHangLayout.createSequentialGroup()
                        .addComponent(jlbNgayThue)
                        .addGap(18, 18, 18)
                        .addComponent(lblNgayThue, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jpnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnTTKhachHangLayout.createSequentialGroup()
                        .addGroup(jpnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbTenKhachhang)
                            .addComponent(jlbCMND))
                        .addGap(18, 18, 18)
                        .addGroup(jpnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTenKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(lblCMND, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jpnTTKhachHangLayout.createSequentialGroup()
                        .addComponent(jlbNgayDi)
                        .addGap(18, 18, 18)
                        .addComponent(lblNgayDi, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbGioiTinh)
                    .addComponent(jlbSDT)
                    .addComponent(jlbSoNgayO))
                .addGap(18, 18, 18)
                .addGroup(jpnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSoNgayO, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jpnTTKhachHangLayout.setVerticalGroup(
            jpnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTTKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbMaNhanPhong)
                    .addComponent(lblMaNhanPhong)
                    .addComponent(jlbTenKhachhang)
                    .addComponent(lblTenKhachHang)
                    .addComponent(jlbGioiTinh)
                    .addComponent(lblGioiTinh))
                .addGap(18, 18, 18)
                .addGroup(jpnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbMaPhong)
                    .addComponent(lblMaPhong)
                    .addComponent(jlbCMND)
                    .addComponent(lblCMND)
                    .addComponent(jlbSDT)
                    .addComponent(lblSDT))
                .addGap(20, 20, 20)
                .addGroup(jpnTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNgayThue)
                    .addComponent(jlbNgayDi)
                    .addComponent(lblNgayDi)
                    .addComponent(jlbNgayThue)
                    .addComponent(jlbSoNgayO)
                    .addComponent(lblSoNgayO))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtbDanhSachSuDungDichVu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách dịch vụ đã sử dụng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        tblDichVuDaSD.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblDichVuDaSD);

        javax.swing.GroupLayout jtbDanhSachSuDungDichVuLayout = new javax.swing.GroupLayout(jtbDanhSachSuDungDichVu);
        jtbDanhSachSuDungDichVu.setLayout(jtbDanhSachSuDungDichVuLayout);
        jtbDanhSachSuDungDichVuLayout.setHorizontalGroup(
            jtbDanhSachSuDungDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jtbDanhSachSuDungDichVuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jtbDanhSachSuDungDichVuLayout.setVerticalGroup(
            jtbDanhSachSuDungDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jtbDanhSachSuDungDichVuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jblTitle.setText("THANH TOÁN");

        jlbTienPhong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbTienPhong.setText("Tổng Tiền phòng:");

        lblGiaPhong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGiaPhong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGiaPhong.setText("...");

        jlbTienDichVu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbTienDichVu.setText("Tiền dịch vụ: ");

        lblTienDichVu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTienDichVu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTienDichVu.setText("...");

        jlbTongTien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbTongTien.setText("Tổng tiền:");

        lblTongTien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTongTien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTongTien.setText("...");

        btnThanhToan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnThanhToan.setText("Trả phòng và thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnHuyBo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnHuyBo.setText("Hủy bỏ");
        btnHuyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyBoActionPerformed(evt);
            }
        });

        jlbMaGiamGia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbMaGiamGia.setText("Mã giảm giá:");

        jlbKhuyenMai.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbKhuyenMai.setText("Khuyến mại:");

        lblKhuyenMai.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblKhuyenMai.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblKhuyenMai.setText("...");

        jlbHinhThucThanhToan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbHinhThucThanhToan.setText("Hình thức thanh toán:");

        buttonGroup1.add(rdTienMat);
        rdTienMat.setSelected(true);
        rdTienMat.setText("Tiền mặt");

        buttonGroup1.add(rdTienThe);
        rdTienThe.setText("Tiền thẻ");

        jlbPhuThu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbPhuThu.setText("Phụ thu:");

        lblPhuThu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPhuThu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPhuThu.setText("...");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("VND");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("VND");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("%");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("VND");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("VND");

        btnKiemTraMaKM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnKiemTraMaKM.setText("Kiểm tra");
        btnKiemTraMaKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKiemTraMaKMMouseClicked(evt);
            }
        });
        btnKiemTraMaKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKiemTraMaKMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(482, Short.MAX_VALUE)
                .addComponent(btnHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnThanhToan)
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlbHinhThucThanhToan)
                        .addGap(18, 18, 18)
                        .addComponent(rdTienMat)
                        .addGap(18, 18, 18)
                        .addComponent(rdTienThe))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlbMaGiamGia)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearchMaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnKiemTraMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jlbTienDichVu)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jlbTongTien)
                            .addGap(36, 36, 36)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlbPhuThu)
                            .addComponent(jlbTienPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlbKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(27, 27, 27)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPhuThu, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblKhuyenMai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTienDichVu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblGiaPhong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(jLabel16)
                    .addComponent(jLabel23)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel14)))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel10)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbTienPhong)
                            .addComponent(lblGiaPhong))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbTienDichVu)
                            .addComponent(lblTienDichVu))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblKhuyenMai)
                                    .addComponent(jlbKhuyenMai))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlbPhuThu)
                                    .addComponent(lblPhuThu)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlbTongTien)
                                    .addComponent(lblTongTien)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSearchMaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlbMaGiamGia)
                                    .addComponent(btnKiemTraMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlbHinhThucThanhToan)
                                    .addComponent(rdTienMat)
                                    .addComponent(rdTienThe))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpnTTKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtbDanhSachSuDungDichVu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(339, 339, 339)
                            .addComponent(jblTitle))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jblTitle)
                .addGap(41, 41, 41)
                .addComponent(jpnTTKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jtbDanhSachSuDungDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed


    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnHuyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyBoActionPerformed
        dispose();
    }//GEN-LAST:event_btnHuyBoActionPerformed

    private void btnKiemTraMaKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKiemTraMaKMActionPerformed

    }//GEN-LAST:event_btnKiemTraMaKMActionPerformed

    private void btnKiemTraMaKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKiemTraMaKMMouseClicked
        String maCode = txtSearchMaKhuyenMai.getText();
        khuyen_maiModel = khuyen_maiService.findByCode(maCode);
        boolean checkKMM = false;
        if (khuyen_maiModel != null) {
            try {
                Date date1 = null;
                Date date2 = null;
                Date nowDate = new Date();
                java.util.Date tgKetThuc = khuyen_maiModel.getThoi_gian_ket_thuc();
                String currentDateStr = sf.format(nowDate);
                String tgKTStr = sf.format(tgKetThuc);
                date1 = sf.parse(currentDateStr);
                date2 = sf.parse(tgKTStr);
                Long diff = date2.getTime() - date1.getTime();
                Long diffNgayKM = diff / (24 * 60 * 60 * 1000);
                if (diffNgayKM >= 0) {
                    String checkKMma = lblKhuyenMai.getText();
                    if (checkKMma.equals("...")) {
                        checkKMM = true;
                    } else {
                        txtSearchMaKhuyenMai.setEnabled(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Mã Khuyến Mại Này Không Còn Hiệu Lực!");
                }
            } catch (ParseException ex) {
                Logger.getLogger(ITN_thanh_toan_hoa_don.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (checkKMM == true) {
                hoa_donModel.setGiam_giaKH(khuyen_maiModel.getValue());
                lblKhuyenMai.setText(funBase.formatTien(khuyen_maiModel.getValue()));
                String checkKMma = lblKhuyenMai.getText();
                if (checkKMma.equals("...") == false) {
                    txtSearchMaKhuyenMai.setEnabled(false);
                }
                setData();

            }

        } else {

        }

    }//GEN-LAST:event_btnKiemTraMaKMMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyBo;
    private javax.swing.JButton btnKiemTraMaKM;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jblTitle;
    private javax.swing.JLabel jlbCMND;
    private javax.swing.JLabel jlbGioiTinh;
    private javax.swing.JLabel jlbHinhThucThanhToan;
    private javax.swing.JLabel jlbKhuyenMai;
    private javax.swing.JLabel jlbMaGiamGia;
    private javax.swing.JLabel jlbMaNhanPhong;
    private javax.swing.JLabel jlbMaPhong;
    private javax.swing.JLabel jlbNgayDi;
    private javax.swing.JLabel jlbNgayThue;
    private javax.swing.JLabel jlbPhuThu;
    private javax.swing.JLabel jlbSDT;
    private javax.swing.JLabel jlbSoNgayO;
    private javax.swing.JLabel jlbTenKhachhang;
    private javax.swing.JLabel jlbTienDichVu;
    private javax.swing.JLabel jlbTienPhong;
    private javax.swing.JLabel jlbTongTien;
    private javax.swing.JPanel jpnTTKhachHang;
    private javax.swing.JPanel jtbDanhSachSuDungDichVu;
    private javax.swing.JLabel lblCMND;
    private javax.swing.JLabel lblGiaPhong;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblKhuyenMai;
    private javax.swing.JLabel lblMaNhanPhong;
    private javax.swing.JLabel lblMaPhong;
    private javax.swing.JLabel lblNgayDi;
    private javax.swing.JLabel lblNgayThue;
    private javax.swing.JLabel lblPhuThu;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblSoNgayO;
    private javax.swing.JLabel lblTenKhachHang;
    private javax.swing.JLabel lblTienDichVu;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JRadioButton rdTienMat;
    private javax.swing.JRadioButton rdTienThe;
    private javax.swing.JTable tblDichVuDaSD;
    private javax.swing.JTextField txtSearchMaKhuyenMai;
    // End of variables declaration//GEN-END:variables
}

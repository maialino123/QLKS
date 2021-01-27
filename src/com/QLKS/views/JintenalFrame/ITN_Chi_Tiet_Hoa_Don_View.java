/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.views.JintenalFrame;

import com.QLKS.Service.impl.dich_vuService;
import com.QLKS.Service.impl.hoa_donService;
import com.QLKS.Service.impl.khach_hangService;
import com.QLKS.Service.impl.phongService;
import com.QLKS.Service.impl.su_dung_dich_vuService;
import com.QLKS.model.dich_vuModel;
import com.QLKS.model.hoa_donModel;
import com.QLKS.model.khach_hang_model;
import com.QLKS.model.phongModel;
import com.QLKS.model.su_dung_dich_vuModel;
import com.QLKS.utils.MethodMain;
import com.QLKS.utils.functionBase;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hoangdung
 */
public class ITN_Chi_Tiet_Hoa_Don_View extends javax.swing.JInternalFrame {

    /**
     * Creates new form ChiTietHoaDon
     */
    private Long idHD;
    hoa_donModel hoa_donModel;
    phongModel phongModel;
    dich_vuModel dich_vuModel;
    khach_hang_model khach_hangModel;
    su_dung_dich_vuModel su_dungDVModel;
    List<su_dung_dich_vuModel> listSDDV;
    List<khach_hang_model> Listkhach_hang;
    List<dich_vuModel> listDichVu;
    List<hoa_donModel> listHoaDon;
    List<phongModel> listPhong;
    DefaultTableModel dfmSDDV;
    hoa_donService hoa_donService;
    phongService phongService;
    dich_vuService dich_vuService;
    khach_hangService khach_hangService;
    su_dung_dich_vuService su_dung_dich_vuService;
    SimpleDateFormat sf;
    SimpleDateFormat fomatGio;
    functionBase funBase;
    private JDesktopPane jdek;

    public ITN_Chi_Tiet_Hoa_Don_View(Long _idHD) {
        initComponents();
        this.idHD = _idHD;
        hoa_donModel = new hoa_donModel();
        phongModel = new phongModel();
        dich_vuModel = new dich_vuModel();
        khach_hangModel = new khach_hang_model();
        su_dungDVModel = new su_dung_dich_vuModel();
        dfmSDDV = new DefaultTableModel();
        hoa_donService = new hoa_donService();
        phongService = new phongService();
        dich_vuService = new dich_vuService();
        khach_hangService = new khach_hangService();
        su_dung_dich_vuService = new su_dung_dich_vuService();
        sf = new SimpleDateFormat("dd/MM/yyyy");
        fomatGio = new SimpleDateFormat("HH");
        funBase = new functionBase();
        setData();
        initDVDSD();
    }

    public void setData() {

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
        hoa_donModel = hoa_donService.findByJoinHD(idHD);

        if (hoa_donModel != null) {
            if (listSDDV.size() > 1) {
                lblTienDichVu.setText(String.valueOf(SumTienDV()));
            } else {
                lblTienDichVu.setText(String.valueOf(0));
            }
            Date newDate = new Date();
            String gioTraPhongStr = fomatGio.format(Calendar.getInstance().getTime());
            int gioTraPhong = Integer.parseInt(gioTraPhongStr);
            java.sql.Date ngayTraTT = new java.sql.Date(newDate.getTime());
            lblMaHoaDon.setText(hoa_donModel.getId().toString());
            lblPhongThue.setText(hoa_donModel.getId_P());
            lblSoNgayO.setText(String.valueOf(hoa_donModel.getSo_ngay()));
            String dateNgayDen = sf.format(hoa_donModel.getNgay_den_thuc_te());
            String dateNgayTra = sf.format(ngayTraTT);
            lblNgayThue.setText(dateNgayDen);
            lblNgayTra.setText(dateNgayTra);
            float phuThu = 0;
            if (gioTraPhong >= 13 && gioTraPhong < 15) {
                phuThu = hoa_donModel.getPhu_phi() + 20;
            } else if (gioTraPhong >= 15 && gioTraPhong < 17) {
                phuThu = hoa_donModel.getPhu_phi() + 40;
            } else if (gioTraPhong >= 17 && gioTraPhong < 19) {
                phuThu = hoa_donModel.getPhu_phi() + 60;
            } else if (gioTraPhong >= 19) {
                phuThu = hoa_donModel.getPhu_phi() + 100;
            } else {
                phuThu = hoa_donModel.getPhu_phi();
            }
            lblPhuThu.setText(String.valueOf(phuThu));
            hoa_donModel.setPhu_phi(phuThu);
            lblHinhThucThanhToan.setText(hoa_donModel.getHinh_thucTT());
            lblTienPhong.setText(String.valueOf(hoa_donModel.getTien_phong() * hoa_donModel.getSo_ngay()));
            lblTienDichVu.setText(funBase.formatTien(SumTienDV()));
            lblTienKhuyenMai.setText(String.valueOf(funBase.formatTien(hoa_donModel.getGiam_giaKH())));
            lblTenKH.setText(String.valueOf(hoa_donModel.getKhach_hang().getName()));
            lblGioiTinh.setText(String.valueOf(hoa_donModel.getKhach_hang().getGender()));
            lblDienThoai.setText(String.valueOf(hoa_donModel.getKhach_hang().getPhone()));
            lblQuocTich.setText(String.valueOf(hoa_donModel.getKhach_hang().getNation()));
            lblDiaChi.setText(String.valueOf(hoa_donModel.getKhach_hang().getAddress()));
            float tong_gia = (hoa_donModel.getTien_phong() * hoa_donModel.getSo_ngay()) + SumTienDV() + (hoa_donModel.getTien_phong() * (phuThu / 100)) - hoa_donModel.getGiam_giaKH();
            lblTongTien.setText(funBase.formatTien(tong_gia));
            hoa_donModel updateHoaDon = new hoa_donModel();
            updateHoaDon.setId(hoa_donModel.getId());
            updateHoaDon.setId_KH(hoa_donModel.getId_KH());
            updateHoaDon.setId_P(hoa_donModel.getId_P());
            updateHoaDon.setId_TTHD(hoa_donModel.getId_TTHD());
            updateHoaDon.setId_SDDV(hoa_donModel.getId_SDDV());
            updateHoaDon.setHinh_thucTT(hoa_donModel.getHinh_thucTT());
            updateHoaDon.setPhu_phi(phuThu);
            updateHoaDon.setTien_phong(hoa_donModel.getTien_phong());
            updateHoaDon.setTien_dich_vu(SumTienDV());
            updateHoaDon.setGiam_giaKH(hoa_donModel.getGiam_giaKH());
            updateHoaDon.setSo_ngay(hoa_donModel.getSo_ngay());
            updateHoaDon.setThanh_tien(tong_gia);
            updateHoaDon.setSo_ngay_du_kien(hoa_donModel.getSo_ngay_du_kien());
            updateHoaDon.setSo_ngay_thuc_te(hoa_donModel.getSo_ngay_thuc_te());
            updateHoaDon.setNgay_den_du_kien(hoa_donModel.getNgay_den_du_kien());
            updateHoaDon.setNgay_den_thuc_te(hoa_donModel.getNgay_den_thuc_te());
            hoa_donService.edit(updateHoaDon);
            reloadITNHD();
        } else {
            JOptionPane.showConfirmDialog(this, "Đã Có Lỗi!");
        }

    }

    public float SumTienDV() {
        int rowcount = tblDichVuDaSD.getRowCount();
        float sum = 0;
        for (int i = 0; i < rowcount; i++) {
            sum += Float.parseFloat(tblDichVuDaSD.getValueAt(i, 6).toString());
        }
        return sum;
    }
    
    public void reloadITNHD(){
        ITN_quan_ly_hoadon ITNQLHD = new ITN_quan_ly_hoadon();
        ITNQLHD.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        jSpinner1 = new javax.swing.JSpinner();
        jpnHoaDon = new javax.swing.JPanel();
        jlbHoaDonTitle = new javax.swing.JLabel();
        jpnC = new javax.swing.JPanel();
        jlbCustommerN2 = new javax.swing.JLabel();
        jlbCustommerN1 = new javax.swing.JLabel();
        jlbCustommerN = new javax.swing.JLabel();
        lblTenKH = new javax.swing.JLabel();
        jlbCustomerGenderLb = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        lblQuocTich = new javax.swing.JLabel();
        jlbCustomerGenderLb1 = new javax.swing.JLabel();
        lblDienThoai = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        jlbCustommerN4 = new javax.swing.JLabel();
        lblPhongThue = new javax.swing.JLabel();
        jlbCustommerN5 = new javax.swing.JLabel();
        lblNgayThue = new javax.swing.JLabel();
        jlbCustommerN6 = new javax.swing.JLabel();
        lblNgayTra = new javax.swing.JLabel();
        jlbCustommerN7 = new javax.swing.JLabel();
        lblSoNgayO = new javax.swing.JLabel();
        jlbCustommerN3 = new javax.swing.JLabel();
        lblMaHoaDon = new javax.swing.JLabel();
        jpnC1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDichVuDaSD = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblTienPhong = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblTienDichVu = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblTienKhuyenMai = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblPhuThu = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblHinhThucThanhToan = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblSo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnXuatFile = new javax.swing.JButton();

        popupMenu1.setLabel("popupMenu1");

        setClosable(true);
        setIconifiable(true);

        jpnHoaDon.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N

        jlbHoaDonTitle.setFont(new java.awt.Font("DejaVu Serif", 1, 28)); // NOI18N
        jlbHoaDonTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbHoaDonTitle.setText("Hóa Đơn");

        jpnC.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 1, 12))); // NOI18N

        jlbCustommerN2.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jlbCustommerN2.setText("Số điện thoại:");

        jlbCustommerN1.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jlbCustommerN1.setText("Địa chỉ:");

        jlbCustommerN.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jlbCustommerN.setText("Mã hóa đơn:");

        lblTenKH.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblTenKH.setText("Nguyễn Bá Tú");

        jlbCustomerGenderLb.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jlbCustomerGenderLb.setText("Giới tính:");

        lblGioiTinh.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblGioiTinh.setText("Nam");

        lblQuocTich.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblQuocTich.setText("Việt Nam");

        jlbCustomerGenderLb1.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jlbCustomerGenderLb1.setText("Quốc tịch:");

        lblDienThoai.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblDienThoai.setText("012345678");

        lblDiaChi.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblDiaChi.setText("abc");

        jlbCustommerN4.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jlbCustommerN4.setText("Phòng thuê:");

        lblPhongThue.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblPhongThue.setText("abc");

        jlbCustommerN5.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jlbCustommerN5.setText("Ngày thuê:");

        lblNgayThue.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblNgayThue.setText("abc");

        jlbCustommerN6.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jlbCustommerN6.setText("Ngày trả:");

        lblNgayTra.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblNgayTra.setText("abc");

        jlbCustommerN7.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jlbCustommerN7.setText("Số ngày ở:");

        lblSoNgayO.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblSoNgayO.setText("abc");

        jlbCustommerN3.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jlbCustommerN3.setText("Họ tên khách hàng: ");

        lblMaHoaDon.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        lblMaHoaDon.setText("123#");

        javax.swing.GroupLayout jpnCLayout = new javax.swing.GroupLayout(jpnC);
        jpnC.setLayout(jpnCLayout);
        jpnCLayout.setHorizontalGroup(
            jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnCLayout.createSequentialGroup()
                        .addComponent(jlbCustommerN)
                        .addGap(18, 18, 18)
                        .addComponent(lblMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnCLayout.createSequentialGroup()
                        .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnCLayout.createSequentialGroup()
                                .addComponent(jlbCustommerN1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jpnCLayout.createSequentialGroup()
                                    .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jpnCLayout.createSequentialGroup()
                                            .addComponent(jlbCustommerN4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(lblPhongThue, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jpnCLayout.createSequentialGroup()
                                            .addComponent(jlbCustommerN7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lblSoNgayO, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(54, 54, 54)
                                    .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jlbCustommerN5)
                                        .addComponent(jlbCustommerN6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(30, 30, 30)
                                    .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblNgayThue, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                        .addComponent(lblNgayTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jpnCLayout.createSequentialGroup()
                                    .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jpnCLayout.createSequentialGroup()
                                            .addComponent(jlbCustommerN2)
                                            .addGap(18, 18, 18)
                                            .addComponent(lblDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jpnCLayout.createSequentialGroup()
                                            .addComponent(jlbCustommerN3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(73, 73, 73)
                                    .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jlbCustomerGenderLb, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jlbCustomerGenderLb1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblQuocTich, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 22, Short.MAX_VALUE))))
        );
        jpnCLayout.setVerticalGroup(
            jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbCustommerN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMaHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbCustommerN3)
                    .addComponent(lblTenKH)
                    .addComponent(jlbCustomerGenderLb, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGioiTinh))
                .addGap(8, 8, 8)
                .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbCustommerN2)
                    .addComponent(lblDienThoai)
                    .addComponent(jlbCustomerGenderLb1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuocTich, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbCustommerN1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDiaChi))
                .addGap(9, 9, 9)
                .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnCLayout.createSequentialGroup()
                        .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbCustommerN4)
                            .addComponent(lblPhongThue))
                        .addGap(10, 10, 10)
                        .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbCustommerN7)
                            .addComponent(lblSoNgayO)))
                    .addGroup(jpnCLayout.createSequentialGroup()
                        .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbCustommerN5)
                            .addComponent(lblNgayThue, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jpnCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnCLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jlbCustommerN6))
                            .addGroup(jpnCLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNgayTra)))))
                .addGap(12, 12, 12))
        );

        jpnC1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách dịch vụ đã sử dụng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 1, 12))); // NOI18N

        tblDichVuDaSD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        jScrollPane1.setViewportView(tblDichVuDaSD);

        javax.swing.GroupLayout jpnC1Layout = new javax.swing.GroupLayout(jpnC1);
        jpnC1.setLayout(jpnC1Layout);
        jpnC1Layout.setHorizontalGroup(
            jpnC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jpnC1Layout.setVerticalGroup(
            jpnC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnC1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Tiền phòng:");

        lblTienPhong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTienPhong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTienPhong.setText("....");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Tiền dịch vụ:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Tiền khuyến mại:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Phụ thu:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Tổng tiền:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("VND");

        lblTienDichVu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTienDichVu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTienDichVu.setText("...");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("VND");

        lblTienKhuyenMai.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTienKhuyenMai.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTienKhuyenMai.setText("...");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("VND");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("%");

        lblTongTien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTongTien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTongTien.setText("...");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("VND");

        lblPhuThu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPhuThu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPhuThu.setText("...");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Hình thức thanh toán:");

        lblHinhThucThanhToan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblHinhThucThanhToan.setText("...");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(lblHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblTienKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblTienPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel11))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblTienDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel13))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblPhuThu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(52, 52, 52)
                                .addComponent(lblTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel19)))))
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblTienPhong)
                    .addComponent(jLabel11)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHinhThucThanhToan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblTienDichVu)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblTienKhuyenMai)
                    .addComponent(jLabel15))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhuThu)
                    .addComponent(jLabel16)
                    .addComponent(jLabel9))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblTongTien)
                    .addComponent(jLabel19))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Khách sạn: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Số:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Hoa Hồng");

        lblSo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSo.setText("1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSo)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(lblSo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnHoaDonLayout = new javax.swing.GroupLayout(jpnHoaDon);
        jpnHoaDon.setLayout(jpnHoaDonLayout);
        jpnHoaDonLayout.setHorizontalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnC1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpnHoaDonLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addComponent(jlbHoaDonTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        jpnHoaDonLayout.setVerticalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHoaDonLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbHoaDonTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnC1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnXuatFile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnXuatFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLKS/icon/contacts_18px.png"))); // NOI18N
        btnXuatFile.setText("Xuất file");
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jpnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFileActionPerformed
        MethodMain.printComponenet(jpnHoaDon);
        JOptionPane.showMessageDialog(this, "Xuất File Thành Công!");

    }//GEN-LAST:event_btnXuatFileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXuatFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel jlbCustomerGenderLb;
    private javax.swing.JLabel jlbCustomerGenderLb1;
    private javax.swing.JLabel jlbCustommerN;
    private javax.swing.JLabel jlbCustommerN1;
    private javax.swing.JLabel jlbCustommerN2;
    private javax.swing.JLabel jlbCustommerN3;
    private javax.swing.JLabel jlbCustommerN4;
    private javax.swing.JLabel jlbCustommerN5;
    private javax.swing.JLabel jlbCustommerN6;
    private javax.swing.JLabel jlbCustommerN7;
    private javax.swing.JLabel jlbHoaDonTitle;
    private javax.swing.JPanel jpnC;
    private javax.swing.JPanel jpnC1;
    private javax.swing.JPanel jpnHoaDon;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblDienThoai;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblHinhThucThanhToan;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JLabel lblNgayThue;
    private javax.swing.JLabel lblNgayTra;
    private javax.swing.JLabel lblPhongThue;
    private javax.swing.JLabel lblPhuThu;
    private javax.swing.JLabel lblQuocTich;
    private javax.swing.JLabel lblSo;
    private javax.swing.JLabel lblSoNgayO;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lblTienDichVu;
    private javax.swing.JLabel lblTienKhuyenMai;
    private javax.swing.JLabel lblTienPhong;
    private javax.swing.JLabel lblTongTien;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JTable tblDichVuDaSD;
    // End of variables declaration//GEN-END:variables
}

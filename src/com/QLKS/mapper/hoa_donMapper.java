/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.hoa_donModel;
import com.QLKS.model.khach_hang_model;
import com.QLKS.model.loai_phongModel;
import com.QLKS.model.phongModel;
import com.QLKS.model.su_dung_dich_vuModel;
import com.QLKS.model.trang_thai_hoa_donModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class hoa_donMapper implements rowMapper<hoa_donModel> {
    
    @Override
    public hoa_donModel maprow(ResultSet rs) {
        try {
            hoa_donModel model = new hoa_donModel();
            model.setId(rs.getLong("id"));
            model.setId_KH(rs.getLong("id_KH"));
            model.setId_P(rs.getString("id_P"));
            model.setId_TTHD(rs.getLong("id_TTHD"));
            model.setId_SDDV(rs.getLong("id_SDDV"));
            model.setHinh_thucTT(rs.getString("hinh_thucTT"));
            model.setPhu_phi(rs.getFloat("phu_phi"));
            model.setTien_phong(rs.getFloat("tien_phong"));
            model.setTien_dich_vu(rs.getFloat("tien_dich_vu"));
            model.setGiam_giaKH(rs.getFloat("giam_giaKH"));
            model.setSo_ngay(rs.getFloat("so_ngay"));
            model.setThanh_tien(rs.getFloat("thanh_tien"));
            model.setCreatedDate(rs.getTimestamp("createdDate"));
            model.setCreatedBy(rs.getString("createdBy"));
            if (rs.getTimestamp("modifiedDate") != null) {
                model.setModifiedDate(rs.getTimestamp("modifiedDate"));
            }
            if (rs.getString("modifiedBy") != null) {
                model.setModifiedBy(rs.getString("modifiedBy"));
            }
            if (rs.getDate("so_ngay_thuc_te") != null) {
                model.setSo_ngay_thuc_te(rs.getDate("so_ngay_thuc_te"));
            }
            model.setSo_ngay_du_kien(rs.getDate("so_ngay_du_kien"));
            model.setNgay_den_du_kien(rs.getDate("ngay_den_du_kien"));
            model.setNgay_den_thuc_te(rs.getDate("ngay_den_thuc_te"));
            try {
                khach_hang_model khach_hang = new khach_hang_model();
                khach_hang.setName(rs.getString("name"));
                khach_hang.setBirthDay(rs.getDate("birthDay"));
                khach_hang.setGender(rs.getString("gennder"));
                khach_hang.setPhone(rs.getString("phone"));
                khach_hang.setAddress(rs.getString("address"));
                khach_hang.setIdentityCard(rs.getString("identityCard"));
                khach_hang.setNation(rs.getString("nation"));
                model.setKhach_hang(khach_hang);
            } catch (Exception e) {
            }
            try {
                phongModel phong = new phongModel();
                phong.setId_LP(rs.getLong("id_LP"));
                phong.setStatus(rs.getString("status"));
                model.setPhong(phong);
            } catch (Exception e) {
            }
            try {
                trang_thai_hoa_donModel trang_thaiHD = new trang_thai_hoa_donModel();
                trang_thaiHD.setName(rs.getString("name_TTHD"));
                model.setTrang_thaiHD(trang_thaiHD);
            } catch (Exception e) {
            }
            try {
                su_dung_dich_vuModel su_dungDV = new su_dung_dich_vuModel();
                su_dungDV.setId_DV(rs.getLong("id_DV"));
                su_dungDV.setAmount(rs.getInt("amount"));
                model.setSu_dungDV(su_dungDV);
            } catch (Exception e) {
            }
            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}

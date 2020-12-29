/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.khachHangModel;
import com.QLKS.utils.convertDate;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class khachHangMapper implements rowMapper<khachHangModel>{

    @Override
    public khachHangModel maprow(ResultSet rs) {
        try {
            khachHangModel model = khachHangModel.getInstance();
            model.setMaKH(rs.getInt("maKH"));
            model.setHoTen(rs.getString("hoTen"));
            model.setCmnd(rs.getString("CMND"));
            model.setNgaySinh(rs.getDate("ngaySinh"));
            model.setGioiTinh(rs.getString("gioiTinh"));
            model.setThanhPho(rs.getString("thanhPho"));
            model.setDiaChi(rs.getString("diaChi"));
            model.setSdt(rs.getString("SDT"));
            model.setSoLanCheckIn(rs.getInt("soLanCheckIn"));
            model.setMaQG(rs.getString("maQG"));
            model.setMaTT(rs.getString("maTT"));
            model.setCreatedDate(rs.getTimestamp("createdDate"));
            model.setCreatedBy(rs.getString("createdBy"));
            if (rs.getTimestamp("modifiedDate") != null) {
                   model.setModifiedDate(rs.getTimestamp("modifiedDate"));
              }
            if (rs.getString("modifiedBy") != null) {
                   model.setModifiedBy(rs.getString("modifiedBy"));
              }
            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}

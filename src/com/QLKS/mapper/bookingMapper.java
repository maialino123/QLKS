/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.bookingModel;
import com.QLKS.utils.convertDate;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class bookingMapper implements rowMapper<bookingModel>{

    @Override
    public bookingModel maprow(ResultSet rs) {
        try {
           bookingModel model = bookingModel.getInstance();
           model.setBkId(rs.getInt("BKID"));
           model.setHoTen(rs.getString("hoTenBK"));
           model.setCmnd(rs.getString("CMND"));
           model.setNgaySinh(convertDate.convertToLoCalDate(rs.getDate("ngaySinh")));
           model.setGioiTinh(rs.getString("gioiTinh"));
           model.setThanhPho(rs.getString("thanhPho"));
           model.setDiaChi(rs.getString("diaChi"));
           model.setSdt(rs.getString("SDT"));
           model.setEmail(rs.getString("email"));
           model.setNgayDangKy(rs.getDate("ngayDangKy"));
           model.setNgayNhan(rs.getDate("ngayNhan"));
           model.setDatCoc(rs.getFloat("datCoc"));
           model.setYeuCau(rs.getString("yeuCau"));
           model.setMaNV(rs.getString("maNV"));
           model.setMaQG(rs.getString("maQG"));
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

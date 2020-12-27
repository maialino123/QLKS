/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.thanhToanPhongModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class thanhToanPhongMapper implements rowMapper<thanhToanPhongModel>{

    @Override
    public thanhToanPhongModel maprow(ResultSet rs) {
        try {
            thanhToanPhongModel model = new thanhToanPhongModel();
            model.setSoTT(rs.getInt("soTT"));
            model.setNgayThanhToan(rs.getTimestamp("ngayThanhToan"));
            model.setTienPhong(rs.getFloat("tienPhong"));
            model.setTienDichVu(rs.getFloat("tienDichVu"));
            model.setSoHopDongTP(rs.getInt("soHopDongTP"));
            model.setMaNV(rs.getString("maNV"));
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

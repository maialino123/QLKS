/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.loaiPhongModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class loaiPhongMapper implements rowMapper<loaiPhongModel>{

    @Override
    public loaiPhongModel maprow(ResultSet rs) {
        try {
            loaiPhongModel model = new loaiPhongModel();
            model.setMaLp(rs.getString("maLP"));
            model.setTenLp(rs.getString("tenLP"));
            model.setGiaLp(rs.getFloat("giaLP"));
            model.setSoNguoi(rs.getInt("soNguoi"));
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

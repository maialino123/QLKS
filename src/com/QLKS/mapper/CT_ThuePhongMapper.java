/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.chiTietTPModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class CT_ThuePhongMapper implements rowMapper<chiTietTPModel>{

    @Override
    public chiTietTPModel maprow(ResultSet rs) {
        try {
            chiTietTPModel model = chiTietTPModel.getInstance();
            model.setSoHopDongTP(rs.getInt("soHopDongTP"));
            model.setMaKH(rs.getInt("maKH"));
            model.setVaiTro(rs.getString("vaiTro"));
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

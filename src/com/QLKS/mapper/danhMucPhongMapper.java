/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.danhMucPhongModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class danhMucPhongMapper implements rowMapper<danhMucPhongModel>{

    @Override
    public danhMucPhongModel maprow(ResultSet rs) {
        try {
            danhMucPhongModel model = danhMucPhongModel.getInstance();
            model.setMaPhong(rs.getString("maPhong"));
            model.setTinhTrang(rs.getString("tinhTrang"));
            model.setDacDiem(rs.getString("dacDiem"));
            model.setMaLp(rs.getString("maLP"));
            model.setCreatedDate(rs.getTimestamp("createdDate"));
            model.setCreatedBy(rs.getString("createdBy"));
            if (rs.getTimestamp("modifiedDate") != null) {
                   model.setModifiedDate(rs.getTimestamp("modifiedDate"));
              }
            if (rs.getString("modifiedBy") != null) {
                   model.setModifiedBy(rs.getString("modifiedBy"));
              }
            model.setStatus(rs.getBoolean("status"));
            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}

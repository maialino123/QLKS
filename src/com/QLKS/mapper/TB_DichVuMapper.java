/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.ThietBi_DichVuModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class TB_DichVuMapper implements rowMapper<ThietBi_DichVuModel>{

    @Override
    public ThietBi_DichVuModel maprow(ResultSet rs) {
        try {
            ThietBi_DichVuModel model = ThietBi_DichVuModel.getInstance();
            model.setMaTb(rs.getInt("maTB"));
            model.setTenTb(rs.getString("tenThietBi"));
            model.setDonViTinh(rs.getString("donViTinh"));
            model.setGiaTien(rs.getFloat("giaTien"));
            model.setCoDinh(rs.getString("coDinh"));
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

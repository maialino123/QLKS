/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.loai_phongModel;
import com.QLKS.model.phongModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class phongMapper implements rowMapper<phongModel> {
    
    @Override
    public phongModel maprow(ResultSet rs) {
        try {
            phongModel model = new phongModel();
            model.setId(rs.getString("id"));
            model.setId_LP(rs.getLong("id_LP"));
            model.setCreatedDate(rs.getTimestamp("createdDate"));
            model.setCreatedBy(rs.getString("createdBy"));
            if (rs.getTimestamp("modifiedDate") != null) {
                model.setModifiedDate(rs.getTimestamp("modifiedDate"));
            }
            if (rs.getString("modifiedBy") != null) {
                model.setModifiedBy(rs.getString("modifiedBy"));
            }
            model.setStatus(rs.getBoolean("status"));
            try {
                loai_phongModel loaiModel = new loai_phongModel();
                loaiModel.setName_LP(rs.getString("name_LP"));
                loaiModel.setPrice(rs.getFloat("price"));
                model.setLoai_phong(loaiModel);
            } catch (Exception e) {
            }
            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}

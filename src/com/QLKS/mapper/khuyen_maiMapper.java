/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.khuyen_maiModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class khuyen_maiMapper implements rowMapper<khuyen_maiModel>{

    @Override
    public khuyen_maiModel maprow(ResultSet rs) {
        try {
            khuyen_maiModel model = new khuyen_maiModel();
            model.setId(rs.getLong("id"));
            model.setCode(rs.getString("code"));
            model.setContent(rs.getString("content"));
            model.setValue(rs.getFloat("value"));
            model.setType(rs.getBoolean("type"));
            model.setCreatedDate(rs.getTimestamp("createdDate"));
            model.setCreatedBy(rs.getString("createdBy"));
            if (rs.getTimestamp("modifiedDate") != null) {
                model.setModifiedDate(rs.getTimestamp("modifiedDate"));
            }
            if (rs.getString("modifiedBy") != null) {
                model.setModifiedBy(rs.getString("modifiedBy"));
            }
            model.setThoi_gian_bat_dau(rs.getDate("thoi_gian_bat_dau"));
            model.setThoi_gian_ket_thuc(rs.getDate("thoi_gian_ket_thuc"));
            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}

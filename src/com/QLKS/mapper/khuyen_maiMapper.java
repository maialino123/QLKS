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
            khuyen_maiModel model = khuyen_maiModel.getInstance();
            model.setId(rs.getLong("id"));
            model.setCode(rs.getString("code"));
            model.setContent(rs.getString("content"));
            model.setType(rs.getBoolean("type"));
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.nhom_quyenModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class nhom_quyenMapper implements rowMapper<nhom_quyenModel>{

    @Override
    public nhom_quyenModel maprow(ResultSet rs) {
        try {
            nhom_quyenModel model = nhom_quyenModel.getInstance();
            model.setId(rs.getLong("id"));
            model.setName(rs.getString("name"));
            model.setCreatedDate(rs.getTimestamp("createdDate"));
            model.setCreatedBy(rs.getString("createdBy"));
            if (rs.getTimestamp("modifiedDate")!= null) {
                model.setModifiedDate(rs.getTimestamp("modifiedDate"));
            }
            if (rs.getString("modifiedBy") != null) {
                model.setModifiedBy(rs.getString("modifiedBy"));
            }
            return model;
        } catch (SQLException e) {
             System.err.println(e.getMessage());
        }
        return null;
    }
    
}

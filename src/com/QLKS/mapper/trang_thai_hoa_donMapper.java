/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.trang_thai_hoa_donModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class trang_thai_hoa_donMapper implements rowMapper<trang_thai_hoa_donModel>{

    @Override
    public trang_thai_hoa_donModel maprow(ResultSet rs) {
        try {
            trang_thai_hoa_donModel model = new trang_thai_hoa_donModel();
           model.setId(rs.getLong("id"));
           model.setName(rs.getString("name_TTHD"));
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

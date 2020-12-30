/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.tienTeModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class tienTeMapper implements rowMapper<tienTeModel>{

    @Override
    public tienTeModel maprow(ResultSet rs) {
        try {
            tienTeModel model = tienTeModel.getInstance();
            model.setMaTT(rs.getString("maTT"));
            model.setTenTienTe(rs.getString("tenTienTe"));
            model.setDoiSanVND(rs.getFloat("doiSanVND"));
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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.quyenModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class quyenMapper implements rowMapper<quyenModel> {

    @Override
    public quyenModel maprow(ResultSet rs) {
        try {
            quyenModel model = quyenModel.getInstance();
            model.setId(rs.getLong("id"));
            model.setName(rs.getString("name"));
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.dich_vuModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class dich_vuMapper implements rowMapper<dich_vuModel> {

    @Override
    public dich_vuModel maprow(ResultSet rs) {
        try {
            dich_vuModel model = dich_vuModel.getInstance();
            model.setId(rs.getLong("id"));
            model.setId_LDV(rs.getLong("id_LDV"));
            model.setPrice(rs.getFloat("price"));
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.thiet_biModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class thiet_biMapper implements rowMapper<thiet_biModel> {

    @Override
    public thiet_biModel maprow(ResultSet rs) {
        try {
            thiet_biModel model = thiet_biModel.getInstance();
            model.setId(rs.getLong("id"));
            model.setId_LP(rs.getLong("id_LP"));
            model.setName(rs.getString("name"));
            model.setAmount(rs.getInt("amount"));
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

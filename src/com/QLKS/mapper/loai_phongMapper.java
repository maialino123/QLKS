/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.loai_phongModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class loai_phongMapper implements rowMapper<loai_phongModel> {

    @Override
    public loai_phongModel maprow(ResultSet rs) {
        try {
            loai_phongModel model = loai_phongModel.getInstance();
            model.setId(rs.getLong("id"));
            model.setName(rs.getString("name"));
            model.setPrice(rs.getFloat("price"));
            model.setMaxPeople(rs.getInt("maxPeople"));
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

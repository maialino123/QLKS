/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.loai_phongModel;
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
            thiet_biModel model = new thiet_biModel();
            model.setId(rs.getLong("id"));
            model.setId_LP(rs.getLong("id_LP"));
            model.setName(rs.getString("name_TB"));
            model.setAmount(rs.getInt("amount_TB"));
            model.setCreatedDate(rs.getTimestamp("createdDate"));
            model.setCreatedBy(rs.getString("createdBy"));
            if (rs.getTimestamp("modifiedDate") != null) {
                model.setModifiedDate(rs.getTimestamp("modifiedDate"));
            }
            if (rs.getString("modifiedBy") != null) {
                model.setModifiedBy(rs.getString("modifiedBy"));
            }
            try {
               loai_phongModel loai_phongModel = new loai_phongModel();
               loai_phongModel.setName_LP(rs.getString("name_LP"));
               loai_phongModel.setPrice(rs.getFloat("price"));
               loai_phongModel.setMaxPeople(rs.getInt("maxPeople"));
               model.setLoaiModel(loai_phongModel);
            } catch (Exception e) {
            }
            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

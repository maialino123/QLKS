/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.khach_hang_model;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class khach_hangMapper implements rowMapper<khach_hang_model> {

    @Override
    public khach_hang_model maprow(ResultSet rs) {
        try {
            khach_hang_model model = new khach_hang_model();
            model.setId(rs.getLong("id"));
            model.setName(rs.getString("name"));
            model.setBirthDay(rs.getDate("birthDay"));
            model.setGender(rs.getString("gender"));
            model.setPhone(rs.getString("phone"));
            model.setAddress(rs.getString("address"));
            model.setIdentityCard(rs.getString("identityCard"));
            model.setNation(rs.getString("nation"));
            model.setNumberOfCheckIn(rs.getInt("numberOfCheckIn"));
            model.setCreatedDate(rs.getTimestamp("createdDate"));
            model.setCreatedBy(rs.getString("createdBy"));
            if (rs.getTimestamp("modifiedDate") != null) {
                model.setModifiedDate(rs.getTimestamp("modifiedDate"));
            }
            if (rs.getString("modifiedBy") != null) {
                model.setModifiedBy(rs.getString("modifiedBy"));
            }
            return model;
        } catch (Exception e) {
            e.printStackTrace();
        }
         return null;
    }
}

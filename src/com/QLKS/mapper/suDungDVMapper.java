/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.suDungDVModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class suDungDVMapper implements rowMapper<suDungDVModel>{

    @Override
    public suDungDVModel maprow(ResultSet rs) {
        try {
            suDungDVModel model = suDungDVModel.getInstance();
            model.setSoHopDongTp(rs.getInt("soHopDongTP"));
            model.setNgaySD(rs.getTimestamp("ngaySD"));
            model.setSoLuong(rs.getInt("soLuong"));
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

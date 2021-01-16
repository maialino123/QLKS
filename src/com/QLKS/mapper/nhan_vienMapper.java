/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.nhan_vienModel;
import com.QLKS.model.nhom_quyenModel;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class nhan_vienMapper implements rowMapper<nhan_vienModel> {

    @Override
    public nhan_vienModel maprow(ResultSet rs) {
        try {
            Blob blob = rs.getBlob("image");
            nhan_vienModel model = new nhan_vienModel();
            model.setId(rs.getLong("id"));
            model.setName(rs.getString("name"));
            model.setBirthDay(rs.getDate("birthDay"));
            if (blob != null) {
                model.setImage(blob.getBytes(1, (int) blob.length()));
            }
            model.setGender(rs.getString("gender"));
            model.setEmail(rs.getString("email"));
            model.setUserName(rs.getString("userName"));
            model.setPassword(rs.getString("passWord"));
            model.setCmnd(rs.getString("cmnd"));
            model.setDegree(rs.getString("degree"));
            model.setId_NQ(rs.getLong("id_NQ"));
            model.setCreatedDate(rs.getTimestamp("createdDate"));
            model.setCreatedBy(rs.getString("createdBy"));
            if (rs.getTimestamp("modifiedDate") != null) {
                model.setModifiedDate(rs.getTimestamp("modifiedDate"));
            }
            if (rs.getString("modifiedBy") != null) {
                model.setModifiedBy(rs.getString("modifiedBy"));
            }
            try {
                nhom_quyenModel nhom_quyen = new nhom_quyenModel();
                nhom_quyen.setId(rs.getLong("id"));
                nhom_quyen.setName(rs.getString("name_NQ"));
                model.setNhom_quyen(nhom_quyen);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

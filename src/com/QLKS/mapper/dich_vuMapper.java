/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.dich_vuModel;
import com.QLKS.model.don_viModel;
import com.QLKS.model.loai_dich_vuModel;
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
            dich_vuModel model = new dich_vuModel();
            model.setId(rs.getLong("id"));
            model.setId_LDV(rs.getLong("id_LDV"));
            model.setPrice(rs.getFloat("price"));
            model.setCreatedDate(rs.getTimestamp("createdDate"));
            model.setCreatedBy(rs.getString("createdBy"));
            model.setId_DV(rs.getLong("id_DV"));
            if (rs.getTimestamp("modifiedDate") != null) {
                model.setModifiedDate(rs.getTimestamp("modifiedDate"));
            }
            if (rs.getString("modifiedBy") != null) {
                model.setModifiedBy(rs.getString("modifiedBy"));
            }
            try {
                loai_dich_vuModel loai_dich_vuModel = new loai_dich_vuModel();
                loai_dich_vuModel.setName(rs.getString("name_LDV"));
                model.setLoai_dich_vuModel(loai_dich_vuModel);
            } catch (Exception e) {
            }
            try {
                don_viModel don_viModel = new don_viModel();
                don_viModel.setName_DV(rs.getString("name_DV"));
                model.setDon_viModel(don_viModel);
            } catch (Exception e) {
            }
            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

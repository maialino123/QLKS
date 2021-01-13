/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.phan_quyenModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class phan_quyenMapper implements rowMapper<phan_quyenModel> {

    @Override
    public phan_quyenModel maprow(ResultSet rs) {
        try {
            phan_quyenModel model = phan_quyenModel.getInstance();
            model.setId_Q(rs.getLong("id_Q"));
            model.setId_NQ(rs.getLong("id_NQ"));
            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

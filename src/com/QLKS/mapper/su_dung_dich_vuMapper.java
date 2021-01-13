/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.su_dung_dich_vuModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class su_dung_dich_vuMapper implements rowMapper<su_dung_dich_vuModel>{

    @Override
    public su_dung_dich_vuModel maprow(ResultSet rs) {
        try {
            su_dung_dich_vuModel model = su_dung_dich_vuModel.getInstance();
            model.setId(rs.getLong("id"));
            model.setId_DV(rs.getLong("id_LDV"));
            model.setAmount(rs.getInt("amount"));
            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}

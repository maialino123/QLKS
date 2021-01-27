/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.dich_vuModel;
import com.QLKS.model.phongModel;
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
            su_dung_dich_vuModel model = new su_dung_dich_vuModel();
            model.setId(rs.getLong("id"));
            model.setId_DV(rs.getLong("id_DV"));
            model.setAmount(rs.getInt("amount"));
            model.setId_HD(rs.getLong("id_HD"));
            try {
                dich_vuModel dich_vu = new dich_vuModel();
                dich_vu.setId_LDV(rs.getLong("id_LDV"));
                dich_vu.setPrice(rs.getFloat("price"));
                model.setDich_vu(dich_vu);
            } catch (Exception e) {
            }
            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}

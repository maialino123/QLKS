/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.thuePhongModel;
import com.QLKS.utils.convertDate;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class thuePhongMapper implements  rowMapper<thuePhongModel>{

    @Override
    public thuePhongModel maprow(ResultSet rs) {
        try {
            thuePhongModel model = thuePhongModel.getInstance();
            model.setSoHopDongTP(rs.getInt("soHopDongTP"));
            model.setMaNV(rs.getString("maNV"));
            model.setMaKH(rs.getInt("maKH"));
            model.setNgayThue(rs.getTimestamp("ngayThue"));
            model.setNgayTra(rs.getDate("ngayTra"));
            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}

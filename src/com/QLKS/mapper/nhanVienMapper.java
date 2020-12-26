/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.nhanVienModel;
import com.QLKS.model.roleModel;
import com.QLKS.utils.convertDate;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class nhanVienMapper implements rowMapper<nhanVienModel>{

    @Override
    public nhanVienModel maprow(ResultSet rs) {
        try {
          nhanVienModel model = new nhanVienModel();
          model.setMaNV(rs.getString("maNV"));
          model.setHoTen(rs.getString("hoTen"));
          model.setCmnd(rs.getString("CMND"));
          model.setNgaySinh(convertDate.convertToLoCalDate(rs.getDate("ngaySinh")));
          model.setGioiTinh(rs.getString("gioiTinh"));
          model.setDiaChi(rs.getString("diaChi"));
          model.setSdt(rs.getString("SDT"));
          model.setNgayVaoLam(rs.getTimestamp("ngayVaoLam"));
          model.setChucVu(rs.getString("chucVu"));
          model.setLuong(rs.getFloat("luong"));
          model.setHinh(rs.getString("hinh"));
          model.setRoleId(rs.getInt("roleID"));
          model.setCreatedDate(rs.getTimestamp("createdDate"));
          model.setCreatedBy(rs.getString("createdBy"));
          if (rs.getTimestamp("modifiedDate") != null) {
                 model.setModifiedDate(rs.getTimestamp("modifiedDate"));
            }
          if (rs.getString("modifiedBy") != null) {
                 model.setModifiedBy(rs.getString("modifiedBy"));
            }
          model.setStatus(rs.getBoolean("status"));
            try {
                roleModel role = new roleModel();
                role.setRoleID(rs.getInt("roleID"));
                role.setRoleName(rs.getString("roleName"));
                role.setCode(rs.getString("code"));
                model.setRole(role);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
          return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}

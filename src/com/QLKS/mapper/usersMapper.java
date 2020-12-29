/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import com.QLKS.model.roleModel;
import com.QLKS.model.usersModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class usersMapper implements rowMapper<usersModel> {

    @Override
    public usersModel maprow(ResultSet rs) {
        try {
            usersModel model = usersModel.getInstance();
            model.setId(rs.getInt("id"));
            model.setUserName(rs.getString("userName"));
            model.setPassword(rs.getString("password"));
            model.setRoleId(rs.getInt("roleId"));
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
                roleModel role = roleModel.getInstance();
                role.setRoleID(rs.getInt("roleId"));
                role.setRoleName(rs.getString("code"));
                role.setStatus(rs.getBoolean("status"));
                model.setRole(role);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            return model;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

}

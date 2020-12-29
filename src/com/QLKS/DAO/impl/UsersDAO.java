/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO.impl;

import com.QLKS.DAO.IUsersDAO;
import com.QLKS.mapper.usersMapper;
import com.QLKS.model.usersModel;
import com.QLKS.utils.security;
import java.util.List;

/**
 *
 * @author Admin
 */
public class UsersDAO extends abstractDAO<usersModel> implements IUsersDAO {

    @Override
    public List<usersModel> findAll() {
        StringBuilder sql = new StringBuilder("{CALL getUsersAll()}");
        return query(sql.toString(), new usersMapper());
    }

    @Override
    public void add(usersModel model) {
        StringBuilder sql = new StringBuilder("{CALL insertUsers(?,?,?,?,?,?)}");
        insert(sql.toString(), model.getUserName(), model.getPassword(), model.getRoleId(), model.getCreatedDate(), model.getCreatedBy(), model.isStatus());
    }

    @Override
    public void update(usersModel model) {
        StringBuilder sql = new StringBuilder("{CALL updateUsers(?,?,?,?,?,?,?,?)}");
        insert(sql.toString(), model.getUserName(), security.bcryptHashString(), model.getRoleId(), model.getCreatedDate(), model.getCreatedBy(), model.getModifiedDate(), model.getModifiedBy(), model.isStatus());
    }

    @Override
    public void delete(int id) {
        StringBuilder sql = new StringBuilder("{CALL delete_users(?)}");
        insert(sql.toString(), id);
    }

    @Override
    public usersModel findOne(int id) {
        StringBuilder sql = new StringBuilder("{CALL findOne_users(?)}");
        List<usersModel> list = query(sql.toString(), new usersMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

}

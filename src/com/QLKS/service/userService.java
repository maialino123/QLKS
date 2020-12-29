/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.service;

import com.QLKS.DAO.IUsersDAO;
import com.QLKS.model.usersModel;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Admin
 */
public class userService implements IuserService{
    
    private IUsersDAO userDAO;

    public userService(IUsersDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    @Override
    public List<usersModel> findAll() {
        return userDAO.findAll();
    }

    @Override
    public void add(usersModel model) {
        model.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        model.setCreatedBy("");
        userDAO.add(model);
    }

    @Override
    public void update(usersModel model) {
        usersModel oldModel = userDAO.findOne(model.getId());
        model.setCreatedDate(oldModel.getCreatedDate());
        model.setCreatedBy(oldModel.getCreatedBy());
        model.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        model.setModifiedBy("");
        update(model);
    }

    @Override
    public void delete(int[] ids) {
        for (int id : ids) {
            userDAO.delete(id);
        }
    }
    
}

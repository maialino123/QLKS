/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO;

import com.QLKS.model.usersModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IUsersDAO extends GenericDAO<usersModel> {
    List<usersModel> findAll();
    void add(usersModel model);
    void update(usersModel model);
    void delete(int id);
    usersModel findOne(int id);
}

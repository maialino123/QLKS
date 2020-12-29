/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.service;

import com.QLKS.model.usersModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IuserService {
    List<usersModel> findAll();
    void add(usersModel model);
    void update(usersModel model);
    void delete(int[] ids);
}

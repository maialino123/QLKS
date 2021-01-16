/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO;

import com.QLKS.model.phongModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface Iphong_DAO extends GenericDAO<phongModel> {
    List<phongModel> findAll();
    phongModel findOne(String id);
    Long add(phongModel model);
    int edit(phongModel model);
    int delete(String id);
    List<phongModel> findByStatus(boolean status);
    int countPhong();
    
}

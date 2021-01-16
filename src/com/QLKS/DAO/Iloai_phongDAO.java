/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO;

import com.QLKS.model.loai_phongModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface Iloai_phongDAO extends GenericDAO<loai_phongModel> {
    List<loai_phongModel> findAll();
    loai_phongModel findOne(Long id);
    Long add(loai_phongModel model);
    int edit(loai_phongModel model);
    int delete(Long id);
    loai_phongModel findByName(String name);
}

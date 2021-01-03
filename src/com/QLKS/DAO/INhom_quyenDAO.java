/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO;

import com.QLKS.model.nhom_quyenModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface INhom_quyenDAO extends GenericDAO<nhom_quyenModel> {
    List<nhom_quyenModel> findAll();
    Long add(nhom_quyenModel model);
    void edit(nhom_quyenModel model);
    void delete(Long id);
    nhom_quyenModel findOne(Long id);
}

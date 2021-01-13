/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO;

import com.QLKS.model.quyenModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IquyenDAO extends GenericDAO<quyenModel>{
    List<quyenModel> findAll();
    quyenModel findOne(Long id);
    void add(quyenModel model);
    void edit(quyenModel model);
    void delete(Long id);
}

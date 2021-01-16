/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service.impl;

import com.QLKS.DAO.INhom_quyenDAO;
import com.QLKS.DAO.impl.nhom_quyenDAO;
import com.QLKS.Service.Inhom_quyenService;
import com.QLKS.model.nhom_quyenModel;
import java.sql.Timestamp;
import java.util.List;


/**
 *
 * @author Admin
 */
public class nhom_quyenService implements Inhom_quyenService{
    
    nhom_quyenDAO nhom_quyenDAO = new nhom_quyenDAO();

    @Override
    public List<nhom_quyenModel> findAll() {
        return nhom_quyenDAO.findAll();
    }

    @Override
    public nhom_quyenModel add(nhom_quyenModel model) {
        model.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        model.setCreatedBy("");
        Long id = nhom_quyenDAO.add(model);
        return nhom_quyenDAO.findOne(id);
    }

    @Override
    public void edit(nhom_quyenModel model) {
        nhom_quyenModel oldModel = nhom_quyenDAO.findOne(model.getId());
        model.setCreatedDate(oldModel.getCreatedDate());
        model.setCreatedBy(model.getCreatedBy());
        model.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        model.setModifiedBy("");
        nhom_quyenDAO.edit(model);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            nhom_quyenDAO.delete(id);
        }
    }

    @Override
    public nhom_quyenModel findOne(Long id) {
        return nhom_quyenDAO.findOne(id);
    }
    
}

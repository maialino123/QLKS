/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service.impl;

import com.QLKS.DAO.impl.quyenDAO;
import com.QLKS.Service.IquyenService;
import com.QLKS.model.quyenModel;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Admin
 */
public class quyenService implements IquyenService{
    quyenDAO quyenDAO = new quyenDAO();

    @Override
    public List<quyenModel> findAll() {
        return quyenDAO.findAll();
    }

    @Override
    public quyenModel findOne(Long id) {
        return quyenDAO.findOne(id);
    }

    @Override
    public void add(quyenModel model) {
        model.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        model.setCreatedBy("");
        quyenDAO.add(model);
    }

    @Override
    public void edit(quyenModel model) {
        quyenModel oldModel = quyenDAO.findOne(model.getId());
        model.setCreatedDate(oldModel.getCreatedDate());
        model.setCreatedBy(oldModel.getCreatedBy());
        model.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        model.setModifiedBy("");
        quyenDAO.edit(model);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            quyenDAO.delete(id);
        }
    }
}

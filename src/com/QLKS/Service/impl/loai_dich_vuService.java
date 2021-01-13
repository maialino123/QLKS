/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service.impl;

import com.QLKS.DAO.impl.loai_dich_vuDAO;
import com.QLKS.Service.Iloai_dich_vuService;
import com.QLKS.model.loai_dich_vuModel;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Admin
 */
public class loai_dich_vuService implements Iloai_dich_vuService{
    
    loai_dich_vuDAO loai_dich_vuDAO = new loai_dich_vuDAO();

    @Override
    public List<loai_dich_vuModel> findAll() {
        return loai_dich_vuDAO.findAll();
    }

    @Override
    public loai_dich_vuModel findOne(Long id) {
        return loai_dich_vuDAO.findOne(id);
    }

    @Override
    public void add(loai_dich_vuModel model) {
        model.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        model.setCreatedBy("");
        loai_dich_vuDAO.add(model);
    }

    @Override
    public void edit(loai_dich_vuModel model) {
        loai_dich_vuModel oldModel = loai_dich_vuDAO.findOne(model.getId());
        model.setCreatedDate(oldModel.getCreatedDate());
        model.setCreatedBy(oldModel.getCreatedBy());
        model.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        model.setModifiedBy("");
        loai_dich_vuDAO.edit(model);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            loai_dich_vuDAO.delete(id);
        }
    }
    
}

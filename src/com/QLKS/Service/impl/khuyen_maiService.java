/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service.impl;

import com.QLKS.DAO.impl.khuyen_maiDAO;
import com.QLKS.Service.Ikhuyen_maiService;
import com.QLKS.model.khuyen_maiModel;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Admin
 */
public class khuyen_maiService implements Ikhuyen_maiService{
    
    khuyen_maiDAO khuyen_maiDAO = new khuyen_maiDAO();

    @Override
    public List<khuyen_maiModel> findAll() {
        return khuyen_maiDAO.findAll();
    }

    @Override
    public khuyen_maiModel findOne(Long id) {
        return khuyen_maiDAO.findOne(id);
    }

    @Override
    public void add(khuyen_maiModel model) {
        model.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        model.setCreatedBy("");
        khuyen_maiDAO.add(model);
    }

    @Override
    public void edit(khuyen_maiModel model) {
        khuyen_maiModel oldModel = khuyen_maiDAO.findOne(model.getId());
        model.setCreatedDate(oldModel.getCreatedDate());
        model.setCreatedBy(oldModel.getCreatedBy());
        model.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        model.setModifiedBy("");
        khuyen_maiDAO.edit(model);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            khuyen_maiDAO.delete(id);
        }
    }
    
}

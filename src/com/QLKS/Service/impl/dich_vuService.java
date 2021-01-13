/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service.impl;

import com.QLKS.DAO.impl.dich_vuDAO;
import com.QLKS.Service.Idich_vuService;
import com.QLKS.model.dich_vuModel;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Admin
 */
public class dich_vuService implements Idich_vuService {
    
    dich_vuDAO dich_vuDAO = new dich_vuDAO();
    
    @Override
    public List<dich_vuModel> findAll() {
        return dich_vuDAO.findAll();
    }
    
    @Override
    public dich_vuModel findOne(Long id) {
        return dich_vuDAO.findOne(id);
    }
    
    @Override
    public void add(dich_vuModel model) {
        model.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        model.setCreatedBy("");
        dich_vuDAO.add(model);
    }
    
    @Override
    public void edit(dich_vuModel model) {
        dich_vuModel oldModel = dich_vuDAO.findOne(model.getId());
        model.setCreatedDate(oldModel.getCreatedDate());
        model.setCreatedBy(oldModel.getCreatedBy());
        model.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        model.setModifiedBy("");
        dich_vuDAO.edit(model);
    }
    
    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            dich_vuDAO.delete(id);
        }
    }
    
}

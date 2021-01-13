/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service.impl;

import com.QLKS.DAO.impl.hoa_donDAO;
import com.QLKS.Service.Ihoa_donService;
import com.QLKS.model.hoa_donModel;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Admin
 */
public class hoa_donService implements Ihoa_donService{
    
    hoa_donDAO hoa_donDAO = new hoa_donDAO();

    @Override
    public List<hoa_donModel> findAll() {
       return hoa_donDAO.findAll();
    }

    @Override
    public hoa_donModel findONe(Long id) {
        return hoa_donDAO.findONe(id);
    }

    @Override
    public void add(hoa_donModel model) {
       model.setCreatedDate(new Timestamp(System.currentTimeMillis()));
       model.setCreatedBy("");
       hoa_donDAO.add(model);
    }

    @Override
    public void edit(hoa_donModel model) {
        hoa_donModel oldModel = hoa_donDAO.findONe(model.getId());
        model.setCreatedDate(oldModel.getCreatedDate());
        model.setCreatedBy(oldModel.getCreatedBy());
        model.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        model.setModifiedBy("");
        hoa_donDAO.edit(model);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            hoa_donDAO.delete(id);
        }
    }
    
}

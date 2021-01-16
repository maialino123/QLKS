/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service.impl;

import com.QLKS.DAO.impl.thiet_biDAO;
import com.QLKS.Service.Ithiet_biService;
import com.QLKS.model.thiet_biModel;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Admin
 */
public class thiet_biService implements Ithiet_biService{
    
    thiet_biDAO thiet_biDAO = new thiet_biDAO();

    @Override
    public List<thiet_biModel> findAll() {
        return thiet_biDAO.findAll();
    }

    @Override
    public thiet_biModel findOne(Long id) {
       return thiet_biDAO.findOne(id);
    }

    @Override
    public Long add(thiet_biModel model) {
       model.setCreatedDate(new Timestamp(System.currentTimeMillis()));
       model.setCreatedBy("");
       Long id = thiet_biDAO.add(model);
       return id;
    }

    @Override
    public int edit(thiet_biModel model) {
       thiet_biModel oldModel = thiet_biDAO.findOne(model.getId());
       model.setCreatedDate(oldModel.getCreatedDate());
       model.setCreatedBy(oldModel.getCreatedBy());
       model.setModifiedDate(new Timestamp(System.currentTimeMillis()));
       model.setModifiedBy("");
       return thiet_biDAO.edit(model);
    }

    @Override
    public int delete(long ids) {
            return thiet_biDAO.delete(ids);
    }

    @Override
    public thiet_biModel findByName(String name) {
        return thiet_biDAO.findByName(name);
    }
    
}

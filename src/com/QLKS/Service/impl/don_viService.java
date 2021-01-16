/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service.impl;

import com.QLKS.DAO.impl.don_viDAO;
import com.QLKS.Service.Idon_viService;
import com.QLKS.model.don_viModel;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Admin
 */
public class don_viService implements Idon_viService {

    don_viDAO don_viDAO = new don_viDAO();

    @Override
    public List<don_viModel> findAll() {
        return don_viDAO.findAll();
    }

    @Override
    public don_viModel findByName(String Name) {
        return don_viDAO.findByName(Name);
    }

    @Override
    public Long add(don_viModel model) {
        model.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        model.setCreatedBy("");
        return don_viDAO.add(model);
    }

    @Override
    public int edit(don_viModel model) {
        don_viModel oldModel = don_viDAO.findOne(model.getId());
        model.setCreatedDate(oldModel.getCreatedDate());
        model.setCreatedBy(oldModel.getCreatedBy());
        model.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        model.setModifiedBy("");
        return don_viDAO.edit(model);
    }

    @Override
    public int delete(Long id) {
        return don_viDAO.delete(id);
    }

    @Override
    public don_viModel findOne(Long id) {
        return don_viDAO.findOne(id);
    }

}

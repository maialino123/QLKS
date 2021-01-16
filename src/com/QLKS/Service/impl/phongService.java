/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service.impl;

import com.QLKS.DAO.impl.phongDAO;
import com.QLKS.Service.IphongService;
import com.QLKS.model.phongModel;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Admin
 */
public class phongService implements IphongService {

    phongDAO phongDAO = new phongDAO();

    @Override
    public List<phongModel> findAll() {
        return phongDAO.findAll();
    }

    @Override
    public phongModel findOne(String id) {
        return phongDAO.findOne(id);
    }

    @Override
    public Long add(phongModel model) {
        model.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        model.setCreatedBy("");
        model.setStatus(false);
        return phongDAO.add(model);
    }

    @Override
    public int edit(phongModel model) {
        phongModel oldModel = phongDAO.findOne(model.getId());
        model.setCreatedDate(oldModel.getCreatedDate());
        model.setCreatedBy(oldModel.getCreatedBy());
        model.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        model.setModifiedBy("");
        return phongDAO.edit(model);
    }

    @Override
    public int delete(String id) {
        return phongDAO.delete(id);
    }

    @Override
    public List<phongModel> findByStatus(boolean status) {
        return phongDAO.findByStatus(status);
    }

    @Override
    public int countPhong() {
        return phongDAO.countPhong();
    }

}

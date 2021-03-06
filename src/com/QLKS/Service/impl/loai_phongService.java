/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service.impl;

import com.QLKS.DAO.impl.loai_phongDAO;
import com.QLKS.Service.Iloai_phongService;
import com.QLKS.model.loai_phongModel;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Admin
 */
public class loai_phongService implements Iloai_phongService {

    loai_phongDAO loai_phongDAO = new loai_phongDAO();

    @Override
    public List<loai_phongModel> findAll() {
        return loai_phongDAO.findAll();
    }

    @Override
    public loai_phongModel findOne(Long id) {
        return loai_phongDAO.findOne(id);
    }

    @Override
    public Long add(loai_phongModel model) {
        model.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        model.setCreatedBy("");
        return loai_phongDAO.add(model);
    }

    @Override
    public int edit(loai_phongModel model) {
        loai_phongModel oldModel = loai_phongDAO.findOne(model.getId());
        model.setCreatedDate(oldModel.getCreatedDate());
        model.setCreatedBy(oldModel.getCreatedBy());
        model.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        model.setModifiedBy("");
        return loai_phongDAO.edit(model);
    }

    @Override
    public int delete(Long ids) {
        return loai_phongDAO.delete(ids);
    }

    @Override
    public loai_phongModel findByName(String name) {
        return loai_phongDAO.findByName(name);
    }

}

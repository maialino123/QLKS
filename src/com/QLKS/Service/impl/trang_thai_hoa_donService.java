/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service.impl;

import com.QLKS.DAO.impl.trang_thai_hoa_donDAO;
import com.QLKS.Service.Itrang_thai_hoa_donService;
import com.QLKS.model.trang_thai_hoa_donModel;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Admin
 */
public class trang_thai_hoa_donService implements Itrang_thai_hoa_donService {

    trang_thai_hoa_donDAO trang_thai_hoa_donDAO = new trang_thai_hoa_donDAO();

    @Override
    public List<trang_thai_hoa_donModel> findAll() {
        return trang_thai_hoa_donDAO.findAll();
    }

    @Override
    public trang_thai_hoa_donModel findOne(Long id) {
        return trang_thai_hoa_donDAO.findOne(id);
    }

    @Override
    public Long add_TTHD(trang_thai_hoa_donModel model) {
        model.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        model.setCreatedBy("");
        return trang_thai_hoa_donDAO.add_TTHD(model);
    }

    @Override
    public int edit(trang_thai_hoa_donModel model) {
        trang_thai_hoa_donModel oldModel = trang_thai_hoa_donDAO.findOne(model.getId());
        model.setCreatedDate(oldModel.getCreatedDate());
        model.setCreatedBy(oldModel.getCreatedBy());
        model.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        model.setModifiedBy("");
        return trang_thai_hoa_donDAO.edit(model);
    }

    @Override
    public int delete(Long ids) {
        return trang_thai_hoa_donDAO.delete(ids);
    }

    @Override
    public trang_thai_hoa_donModel findByName(String name) {
        return trang_thai_hoa_donDAO.findByName(name);
    }

}

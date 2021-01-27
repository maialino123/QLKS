/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service.impl;

import com.QLKS.DAO.impl.khach_hangDAO;
import com.QLKS.Service.Ikhach_hangService;
import com.QLKS.model.khach_hang_model;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Admin
 */
public class khach_hangService implements Ikhach_hangService {

    khach_hangDAO khach_hangDAO = new khach_hangDAO();

    @Override
    public List<khach_hang_model> findAll() {
        return khach_hangDAO.findAll();
    }

    @Override
    public khach_hang_model findOne(Long id) {
        return khach_hangDAO.findOne(id);
    }

    @Override
    public Long add_khachHang(khach_hang_model model) {
        model.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        model.setCreatedBy("");
        model.setMissedRoom(0);
        Long id = khach_hangDAO.add_khachHang(model);
        return id;
    }

    @Override
    public int edit_khachHang(khach_hang_model model) {
        khach_hang_model oldKhach_hang = khach_hangDAO.findOne(model.getId());
        if (oldKhach_hang != null) {
            model.setCreatedDate(oldKhach_hang.getCreatedDate());
            model.setCreatedBy(oldKhach_hang.getCreatedBy());
        } else {
            model.setCreatedDate(null);
            model.setCreatedBy(null);
        }
        model.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        model.setModifiedBy("");
        return khach_hangDAO.edit_khachHang(model);
    }

    @Override
    public int delete_khachHang(Long ids) {
        return khach_hangDAO.delete_khachHang(ids);
    }

    @Override
    public khach_hang_model findCmnd(String cmnd) {
        return khach_hangDAO.findCmnd(cmnd);
    }

}

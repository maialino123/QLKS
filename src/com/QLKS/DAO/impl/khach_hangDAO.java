/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO.impl;

import com.QLKS.DAO.Ikhach_hangDAO;
import com.QLKS.mapper.khach_hangMapper;
import com.QLKS.model.khach_hang_model;
import java.util.List;

/**
 *
 * @author Admin
 */
public class khach_hangDAO extends abstractDAO<khach_hang_model> implements Ikhach_hangDAO {

    @Override
    public List<khach_hang_model> findAll() {
        String sql = resourceBundleSQL.getString("get_all_khach_hang");
        return query(sql, new khach_hangMapper());
    }

    @Override
    public khach_hang_model findOne(Long id) {
        String sql = resourceBundleSQL.getString("get_one_khach_hang");
        List<khach_hang_model> list = query(sql, new khach_hangMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public Long add_khachHang(khach_hang_model model) {
        String sql = resourceBundleSQL.getString("add_khach_hang");
        return insert(sql, model.getName(), model.getBirthDay(), model.getGender(),
                model.getPhone(), model.getAddress(), model.getIdentityCard(),
                model.getNation(), model.getNumberOfCheckIn(), model.getCreatedDate(), model.getCreatedBy(), model.getMissedRoom());
    }

    @Override
    public int edit_khachHang(khach_hang_model model) {
        String sql = resourceBundleSQL.getString("update_khach_hang");
        return update(sql, model.getName(), model.getBirthDay(), model.getGender(),
                model.getPhone(), model.getAddress(), model.getIdentityCard(),
                model.getNation(), model.getNumberOfCheckIn(), model.getCreatedDate(),
                model.getCreatedBy(), model.getModifiedDate(), model.getModifiedBy(), model.getMissedRoom() ,model.getId());
    }

    @Override
    public int delete_khachHang(Long id) {
        String sql = resourceBundleSQL.getString("delete_khach_hang");
        return update(sql, id);
    }

    @Override
    public khach_hang_model findCmnd(String cmnd) {
        String sql = resourceBundleSQL.getString("get_cmnd_khach_hang");
        List<khach_hang_model> list = query(sql, new khach_hangMapper(), cmnd);
        return list.isEmpty() ? null : list.get(0);
    }

}

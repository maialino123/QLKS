/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO.impl;

import com.QLKS.DAO.Iphong_DAO;
import com.QLKS.mapper.phongMapper;
import com.QLKS.model.phongModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public class phongDAO extends abstractDAO<phongModel> implements Iphong_DAO {

    @Override
    public List<phongModel> findAll() {
        String sql = resourceBundleSQL.getString("get_all_phong");
        return query(sql, new phongMapper());
    }

    @Override
    public phongModel findOne(String id) {
        String sql = resourceBundleSQL.getString("get_one_phong");
        List<phongModel> list = query(sql, new phongMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public Long add(phongModel model) {
        String sql = resourceBundleSQL.getString("add_phong");
        return insert(sql, model.getId(), model.getId_LP(), model.getCreatedDate(), model.getCreatedBy(), model.getStatus());
    }

    @Override
    public int edit(phongModel model) {
        String sql = resourceBundleSQL.getString("update_phong");
        return update(sql, model.getId_LP(), model.getCreatedDate(), model.getCreatedBy(), model.getModifiedDate(),model.getModifiedBy(), model.getStatus(), model.getId());
    }

    @Override
    public int delete(String id) {
        String sql = resourceBundleSQL.getString("delete_phong");
        return update(sql, id);
    }

    @Override
    public List<phongModel> findByStatus(boolean status) {
        String sql = resourceBundleSQL.getString("get_by_status_phong");
        return query(sql, new phongMapper(), status);
    }

    @Override
    public int countPhong() {
        String sql = resourceBundleSQL.getString("get_count_phong");
        return queryCount(sql);
    }

}

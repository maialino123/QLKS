/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO.impl;

import com.QLKS.DAO.Iloai_phongDAO;
import com.QLKS.mapper.loai_phongMapper;
import com.QLKS.model.loai_phongModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public class loai_phongDAO extends abstractDAO<loai_phongModel> implements Iloai_phongDAO {

    @Override
    public List<loai_phongModel> findAll() {
        String sql = resourceBundleSQL.getString("get_all_loai_phong");
        return query(sql, new loai_phongMapper());
    }

    @Override
    public loai_phongModel findOne(Long id) {
        String sql = resourceBundleSQL.getString("get_one_loai_phong");
        List<loai_phongModel> list = query(sql, new loai_phongMapper(), id);
        return list.isEmpty() ? null : list.get(0);

    }

    @Override
    public Long add(loai_phongModel model) {
        String sql = resourceBundleSQL.getString("add_loai_phong");
        return insert(sql, model.getName_LP(), model.getPrice(), model.getMaxPeople(), model.getCreatedDate(), model.getCreatedBy());
    }

    @Override
    public int edit(loai_phongModel model) {
        String sql = resourceBundleSQL.getString("update_loai_phong");
        return update(sql, model.getName_LP(), model.getPrice(), model.getMaxPeople(), model.getCreatedDate(), model.getCreatedBy(), model.getModifiedDate(), model.getModifiedBy(), model.getId());
    }

    @Override
    public int delete(Long id) {
        String sql = resourceBundleSQL.getString("get_one_loai_phong");
        return update(sql, id);
    }

    @Override
    public loai_phongModel findByName(String name) {
        String sql = resourceBundleSQL.getString("get_name_loai_phong");
        List<loai_phongModel> list = query(sql, new loai_phongMapper(), name);
        return list.isEmpty() ? null : list.get(0);
    }

}

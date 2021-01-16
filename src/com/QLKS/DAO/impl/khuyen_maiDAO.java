/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO.impl;

import com.QLKS.DAO.Ikhuyen_maiDAO;
import com.QLKS.mapper.khuyen_maiMapper;
import com.QLKS.model.khuyen_maiModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public class khuyen_maiDAO extends abstractDAO<khuyen_maiModel> implements Ikhuyen_maiDAO {

    @Override
    public List<khuyen_maiModel> findAll() {
        String sql = resourceBundleSQL.getString("get_all_khuyen_mai");
        return query(sql, new khuyen_maiMapper());
    }

    @Override
    public khuyen_maiModel findOne(Long id) {
        String sql = resourceBundleSQL.getString("get_one_khuyen_mai");
        List<khuyen_maiModel> list = query(sql, new khuyen_maiMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public Long add(khuyen_maiModel model) {
        String sql = resourceBundleSQL.getString("add_khuyen_mai");
        return insert(sql, model.getCode(), model.getValue(), model.getContent(), model.isType(), model.getCreatedDate(), model.getCreatedBy(), model.getThoi_gian_bat_dau(),model.getThoi_gian_ket_thuc());
    }

    @Override
    public int edit(khuyen_maiModel model) {
        String sql = resourceBundleSQL.getString("update_khuyen_mai");
        return update(sql, model.getCode(), model.getValue(), model.getContent(), model.isType(), model.getCreatedDate(), model.getCreatedBy(), model.getModifiedDate(), model.getModifiedBy(),model.getThoi_gian_bat_dau(),model.getThoi_gian_ket_thuc(), model.getId());
    }

    @Override
    public int delete(Long id) {
        String sql = resourceBundleSQL.getString("delete_khuyen_mai");
        return update(sql, id);
    }

    @Override
    public khuyen_maiModel findByCode(String code) {
        String sql = resourceBundleSQL.getString("get_code_khuyen_mai");
        List<khuyen_maiModel> list = query(sql, new khuyen_maiMapper(), code);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public khuyen_maiModel findByType(boolean type) {
        String sql = resourceBundleSQL.getString("get_type_khuyen_mai");
        List<khuyen_maiModel> list = query(sql, new khuyen_maiMapper(), type);
        return list.isEmpty() ? null : list.get(0);
    }

}

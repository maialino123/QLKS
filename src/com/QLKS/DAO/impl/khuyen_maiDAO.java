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
    public void add(khuyen_maiModel model) {
        String sql = resourceBundleSQL.getString("add_khuyen_mai");
        update(sql, model.getCode(),model.getValue(),model.getContent(),model.isType(),model.getCreatedDate(),model.getCreatedBy());
    }

    @Override
    public void edit(khuyen_maiModel model) {
        String sql = resourceBundleSQL.getString("update_nhan_vien");
        update(sql, model.getCode(),model.getValue(),model.getContent(),model.isType(),model.getCreatedDate(),model.getCreatedBy(), model.getModifiedDate(),model.getModifiedBy(),model.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = resourceBundleSQL.getString("delete_nhan_vien");
        update(sql, id);
    }

}

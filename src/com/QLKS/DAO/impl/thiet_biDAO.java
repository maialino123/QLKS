/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO.impl;

import com.QLKS.DAO.Ithiet_biDAO;
import com.QLKS.mapper.thiet_biMapper;
import com.QLKS.model.thiet_biModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public class thiet_biDAO extends abstractDAO<thiet_biModel> implements Ithiet_biDAO {

    @Override
    public List<thiet_biModel> findAll() {
        String sql = resourceBundleSQL.getString("get_all_thiet_bi");
        return query(sql, new thiet_biMapper());
    }

    @Override
    public thiet_biModel findOne(Long id) {
        String sql = resourceBundleSQL.getString("get_one_thiet_bi");
        List<thiet_biModel> list = query(sql, new thiet_biMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public Long add(thiet_biModel model) {
        String sql = resourceBundleSQL.getString("add_thiet_bi");
        return insert(sql, model.getId_LP(), model.getName(), model.getAmount(), model.getCreatedDate(), model.getCreatedBy());
    }

    @Override
    public int edit(thiet_biModel model) {
        String sql = resourceBundleSQL.getString("update_thiet_bi");
        return update(sql, model.getId_LP(), model.getName(), model.getAmount(), model.getCreatedDate(), model.getCreatedBy(), model.getModifiedDate(), model.getModifiedBy(), model.getId());
    }

    @Override
    public int delete(Long id) {
        String sql = resourceBundleSQL.getString("delete_thiet_bi");
        return update(sql, id);
    }

    @Override
    public thiet_biModel findByName(String name) {
        String sql = resourceBundleSQL.getString("get_name");
        List<thiet_biModel> list = query(sql, new thiet_biMapper(), name);
        return list.isEmpty() ? null : list.get(0);
    }

}

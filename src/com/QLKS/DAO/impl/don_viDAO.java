/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO.impl;

import com.QLKS.DAO.Idon_viDAO;
import com.QLKS.mapper.don_viMapper;
import com.QLKS.model.don_viModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public class don_viDAO extends abstractDAO<don_viModel> implements Idon_viDAO {

    @Override
    public List<don_viModel> findAll() {
        String sql = resourceBundleSQL.getString("get_all_don_vi");
        return query(sql, new don_viMapper());
    }

    @Override
    public don_viModel findByName(String Name) {
        String sql = resourceBundleSQL.getString("get_name_don_vi");
        List<don_viModel> list = query(sql, new don_viMapper(), Name);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public Long add(don_viModel model) {
        String sql = resourceBundleSQL.getString("add_don_vi");
        return insert(sql, model.getName_DV(), model.getCreatedDate(), model.getCreatedBy());
    }

    @Override
    public int edit(don_viModel model) {
        String sql = resourceBundleSQL.getString("update_don_vi");
        return update(sql, model.getName_DV(), model.getCreatedDate(), model.getCreatedBy(), model.getModifiedDate(), model.getModifiedBy(), model.getId());
    }

    @Override
    public int delete(Long id) {
        String sql = resourceBundleSQL.getString("delete_don_vi");
        return update(sql, id);
    }

    @Override
    public don_viModel findOne(Long id) {
        String sql = resourceBundleSQL.getString("get_one_don_vi");
        List<don_viModel> list = query(sql, new don_viMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

}

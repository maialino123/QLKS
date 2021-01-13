/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO.impl;

import com.QLKS.DAO.Idich_vuDAO;
import com.QLKS.mapper.dich_vuMapper;
import com.QLKS.mapper.rowMapper;
import com.QLKS.model.dich_vuModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public class dich_vuDAO extends abstractDAO<dich_vuModel> implements Idich_vuDAO {

    @Override
    public List<dich_vuModel> findAll() {
        String sql = resourceBundleSQL.getString("get_all_dich_vu");
        return query(sql, new dich_vuMapper());
    }

    @Override
    public dich_vuModel findOne(Long id) {
        String sql = resourceBundleSQL.getString("get_one_dich_vu");
        List<dich_vuModel> list = query(sql, new dich_vuMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void add(dich_vuModel model) {
        String sql = resourceBundleSQL.getString("add_dich_vu");
        update(sql, model.getId_LDV(), model.getPrice(), model.getCreatedDate(), model.getCreatedBy());
    }

    @Override
    public void edit(dich_vuModel model) {
        String sql = resourceBundleSQL.getString("update_dich_vu");
        update(sql, model.getId_LDV(), model.getPrice(), model.getCreatedDate(), model.getCreatedBy(), model.getModifiedDate(),model.getModifiedBy(),model.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = resourceBundleSQL.getString("delete_dich_vu");
        update(sql, id);
    }



}

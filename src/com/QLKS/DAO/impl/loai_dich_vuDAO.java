/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO.impl;

import com.QLKS.DAO.Iloai_dich_vuDAO;
import com.QLKS.mapper.loai_dich_vuMapper;
import com.QLKS.model.loai_dich_vuModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public class loai_dich_vuDAO extends abstractDAO<loai_dich_vuModel> implements Iloai_dich_vuDAO {

    @Override
    public List<loai_dich_vuModel> findAll() {
        String sql = resourceBundleSQL.getString("get_all_loai_dich_vu");
        return query(sql, new loai_dich_vuMapper());
    }

    @Override
    public loai_dich_vuModel findOne(Long id) {
        String sql = resourceBundleSQL.getString("get_one_loai_dich_vu");
        List<loai_dich_vuModel> list = query(sql, new loai_dich_vuMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void add(loai_dich_vuModel model) {
        String sql = resourceBundleSQL.getString("add_loai_dich_vu");
        update(sql, model.getName(),model.getCreatedDate(), model.getCreatedBy());
    }

    @Override
    public void edit(loai_dich_vuModel model) {
        String sql = resourceBundleSQL.getString("update_loai_dich_vu");
        update(sql, model.getName(),model.getCreatedDate(), model.getCreatedBy(),model.getModifiedDate(),model.getModifiedBy(),model.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = resourceBundleSQL.getString("delete_loai_dich_vu");
        update(sql, id);
    }

}

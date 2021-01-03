/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO.impl;

import com.QLKS.DAO.INhom_quyenDAO;
import com.QLKS.mapper.nhom_quyenMapper;
import com.QLKS.model.nhom_quyenModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public class nhom_quyenDAO extends abstractDAO<nhom_quyenModel> implements INhom_quyenDAO {

    @Override
    public List<nhom_quyenModel> findAll() {
        String sql = resourceBundleSQL.getString("get_all_nhom_quyen");
        return query(sql, new nhom_quyenMapper());
    }

    @Override
    public Long add(nhom_quyenModel model) {
        String sql = resourceBundleSQL.getString("insert_nhom_quyen");
        return insert(sql, model.getName(), model.getCreatedDate(), model.getCreatedBy());
    }

    @Override
    public void edit(nhom_quyenModel model) {
        String sql = resourceBundleSQL.getString("update_nhom_quyen");
        update(sql, model.getName(), model.getCreatedDate(), model.getCreatedBy(), model.getModifiedDate(), model.getModifiedBy(), model.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = resourceBundleSQL.getString("delete_nhom_quyen");
        update(sql, id);
    }

    @Override
    public nhom_quyenModel findOne(Long id) {
        String sql = resourceBundleSQL.getString("get_one_nhom_quyen");
        List<nhom_quyenModel> list = query(sql, new nhom_quyenMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

}

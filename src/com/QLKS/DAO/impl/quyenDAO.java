/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO.impl;

import com.QLKS.DAO.IquyenDAO;
import com.QLKS.mapper.quyenMapper;
import com.QLKS.model.quyenModel;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Admin
 */
public class quyenDAO extends abstractDAO<quyenModel> implements IquyenDAO{

    @Override
    public List<quyenModel> findAll() {
        String sql = resourceBundleSQL.getString("get_all_quyen");
        return query(sql, new quyenMapper());
    }

    @Override
    public quyenModel findOne(Long id) {
        String sql = resourceBundleSQL.getString("get_one_quyen");
        List<quyenModel> list = query(sql, new quyenMapper(), id);
        return list.isEmpty()?null:list.get(0);
    }

    @Override
    public void add(quyenModel model) {
        String sql = resourceBundleSQL.getString("add_quyen");
        update(sql, model.getName(),model.getCreatedDate(),model.getCreatedBy());
        
    }

    @Override
    public void edit(quyenModel model) {
        String sql = resourceBundleSQL.getString("update_quyen");
        update(sql, model.getName(),model.getCreatedDate(),model.getCreatedBy(),model.getModifiedDate(),model.getModifiedBy(),model.getId());
        
    }

    @Override
    public void delete(Long id) {
        String sql = resourceBundleSQL.getString("delete_quyen");
        update(sql, id);
    }
    
}

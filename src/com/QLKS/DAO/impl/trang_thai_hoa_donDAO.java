/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO.impl;

import com.QLKS.DAO.Itrang_thai_hoa_donDAO;
import com.QLKS.mapper.trang_thai_hoa_donMapper;
import com.QLKS.model.trang_thai_hoa_donModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public class trang_thai_hoa_donDAO extends abstractDAO<trang_thai_hoa_donModel> implements Itrang_thai_hoa_donDAO {

    @Override
    public List<trang_thai_hoa_donModel> findAll() {
        String sql = resourceBundleSQL.getString("get_all_trang_thai_hoa_don");
        return query(sql, new trang_thai_hoa_donMapper());
    }

    @Override
    public trang_thai_hoa_donModel findOne(Long id) {
        String sql = resourceBundleSQL.getString("get_one_trang_thai_hoa_don");
        List<trang_thai_hoa_donModel> list = query(sql, new trang_thai_hoa_donMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void add_TTHD(trang_thai_hoa_donModel model) {
        String sql = resourceBundleSQL.getString("add_trang_thai_hoa_don");
        update(sql, model.getName(),model.getCreatedDate(), model.getCreatedBy());
    }

    @Override
    public void edit(trang_thai_hoa_donModel model) {
        String sql = resourceBundleSQL.getString("update_trang_thai_hoa_don");
        update(sql, model.getName(),model.getCreatedDate(), model.getCreatedBy(),model.getModifiedDate(),model.getModifiedBy(),model.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = resourceBundleSQL.getString("delete_trang_thai_hoa_don");
        update(sql, id);
    }

}

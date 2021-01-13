/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO.impl;

import com.QLKS.DAO.Iphan_quyenDAO;
import com.QLKS.model.phan_quyenModel;

/**
 *
 * @author Admin
 */
public class phan_quyenDAO extends abstractDAO<phan_quyenModel> implements Iphan_quyenDAO{

    @Override
    public void add(phan_quyenModel model) {
        String sql = resourceBundleSQL.getString("insert_phan_quyen");
        update(sql, model.getId_Q(),model.getId_NQ());
    }

    @Override
    public void delete(Long id) {
        String sql = resourceBundleSQL.getString("delete_phan_quyen");
        update(sql, id);
    }
    
}

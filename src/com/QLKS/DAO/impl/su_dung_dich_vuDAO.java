/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO.impl;

import com.QLKS.DAO.Isu_dung_dich_vuDAO;
import com.QLKS.mapper.su_dung_dich_vuMapper;
import com.QLKS.model.su_dung_dich_vuModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public class su_dung_dich_vuDAO extends abstractDAO<su_dung_dich_vuModel> implements Isu_dung_dich_vuDAO{

    @Override
    public su_dung_dich_vuModel findOne(Long id) {
        String sql = resourceBundleSQL.getString("get_one_SDDV");
        List<su_dung_dich_vuModel> list = query(sql, new su_dung_dich_vuMapper(), id);
        return list.isEmpty()?null:list.get(0);
    }

    @Override
    public void add(su_dung_dich_vuModel model) {
        String sql = resourceBundleSQL.getString("add_SDDV");
        update(sql, model.getId_DV(), model.getAmount());
    }

    @Override
    public void delete(Long id) {
        String sql = resourceBundleSQL.getString("delete_SDDV");
        update(sql, id);
    }
    
}

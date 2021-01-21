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
public class su_dung_dich_vuDAO extends abstractDAO<su_dung_dich_vuModel> implements Isu_dung_dich_vuDAO {

    @Override
    public su_dung_dich_vuModel findOne(Long id) {
        String sql = resourceBundleSQL.getString("get_one_SDDV");
        List<su_dung_dich_vuModel> list = query(sql, new su_dung_dich_vuMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public Long add(su_dung_dich_vuModel model) {
        String sql = resourceBundleSQL.getString("add_SDDV");
        return insert(sql, model.getId_DV(), model.getAmount(), model.getId_P());
    }

    @Override
    public int delete(Long id) {
        String sql = resourceBundleSQL.getString("delete_SDDV");
        return update(sql, id);
    }

    @Override
    public List<su_dung_dich_vuModel> findAll() {
        String sql = resourceBundleSQL.getString("get_all_SDDV");
        return query(sql, new su_dung_dich_vuMapper());
    }

    @Override
    public int edit(su_dung_dich_vuModel model) {
        String sql = resourceBundleSQL.getString("update_SDDV");
        return update(sql, model.getId_DV(), model.getAmount(), model.getId_P(), model.getId());
    }

    @Override
    public su_dung_dich_vuModel findByIdDV(Long idDV) {
        String sql = resourceBundleSQL.getString("get_DV_SDDV");
        List<su_dung_dich_vuModel> list = query(sql, new su_dung_dich_vuMapper(), idDV);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public su_dung_dich_vuModel findByIdP(String idP) {
        String sql = resourceBundleSQL.getString("get_P_SDDV");
        List<su_dung_dich_vuModel> list = query(sql, new su_dung_dich_vuMapper(), idP);
        return list.isEmpty() ? null : list.get(0);
    }

}

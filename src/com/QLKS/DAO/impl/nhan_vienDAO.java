/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO.impl;

import com.QLKS.DAO.INhan_vienDAO;
import com.QLKS.DAO.authorization.IAuthorization;
import com.QLKS.mapper.nhan_vienMapper;
import com.QLKS.model.nhan_vienModel;
import com.QLKS.utils.security;
import java.util.List;

/**
 *
 * @author Admin
 */
public class nhan_vienDAO extends abstractDAO<nhan_vienModel> implements INhan_vienDAO {

    @Override
    public List<nhan_vienModel> findAll() {
        String sql = resourceBundleSQL.getString("getNhanVienAll");
        return query(sql, new nhan_vienMapper());
    }

    @Override
    public nhan_vienModel findOne(Long id) {
        String sql = resourceBundleSQL.getString("get_one_nhan_vien");
        List<nhan_vienModel> list = query(sql, new nhan_vienMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public Long add(nhan_vienModel model) {
        String sql = resourceBundleSQL.getString("insert_NhanVien");
        return insert(sql, model.getName(), model.getBirthDay(), model.getGender(),
                model.getImage(), model.getEmail(), model.getUserName(),
                security.hashPassword(model.getPassword()),model.getCmnd() ,model.getId_NQ(),
                model.getCreatedDate(), model.getCreatedBy()
        );
    }

    @Override
    public void edit(nhan_vienModel model) {
        String sql = resourceBundleSQL.getString("upate_nhan_vien");
        update(sql, model.getName(), model.getBirthDay(), model.getGender(),
                model.getImage(), model.getEmail(), model.getUserName(), security.hashPassword(model.getPassword()), model.getId_NQ(),
                model.getCreatedDate(), model.getCreatedBy(), model.getModifiedDate(), model.getModifiedBy(), model.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = resourceBundleSQL.getString("delete_nhan_vien");
        update(sql, id);
    }

    @Override
    public nhan_vienModel findByUserNameAndPassword(IAuthorization authorization) {
//        StringBuilder sql = new StringBuilder("get_by_userName_passWord");
        String sql = resourceBundleSQL.getString("get_by_userName_passWord");
        if (authorization.getUserName() != null && authorization.getPassWord() != null) {
            List<nhan_vienModel> list = query(sql.toString(), new nhan_vienMapper(),authorization.getUserName());
            return list.isEmpty() ? null : list.get(0);
        }
        return null;
    }

    @Override
    public nhan_vienModel findByUserName(String userName) {
      return null;
    }

    @Override
    public nhan_vienModel findByEmail(String email) {
        return null;
    }

    @Override
    public nhan_vienModel findByCmnd(String cmnd) {
        return null;
    }
}

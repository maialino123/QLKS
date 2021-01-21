/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO.impl;

import com.QLKS.DAO.Ihoa_donDAO;
import com.QLKS.mapper.hoa_donMapper;
import com.QLKS.model.hoa_donModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public class hoa_donDAO extends abstractDAO<hoa_donModel> implements Ihoa_donDAO {

    @Override
    public List<hoa_donModel> findAll() {
        String sql = resourceBundleSQL.getString("get_all_hoa_don");
        return query(sql, new hoa_donMapper());
    }

    @Override
    public hoa_donModel findONe(Long id) {
        String sql = resourceBundleSQL.getString("get_one_hoa_don");
        List<hoa_donModel> list = query(sql, new hoa_donMapper(), 1);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public Long add(hoa_donModel model) {
        String sql = resourceBundleSQL.getString("add_hoa_don");
        return insert(sql, model.getId_KH(), model.getId_P(), model.getId_TTHD(),
                model.getHinh_thucTT(), model.getTien_phong(), model.getGiam_giaKH(), model.getSo_ngay(), model.getThanh_tien(),
                model.getCreatedDate(), model.getCreatedBy(), model.getSo_ngay_du_kien(), model.getNgay_den_thuc_te(), model.getNgay_den_du_kien());
    }

    @Override
    public int edit(hoa_donModel model) {
        String sql = resourceBundleSQL.getString("update_hoa_don");
        return update(sql, model.getId_KH(), model.getId_P(), model.getId_TTHD(), model.getId_SDDV(),
                model.getHinh_thucTT(), model.getPhu_phi(), model.getTien_phong(),
                model.getTien_dich_vu(), model.getGiam_giaKH(), model.getSo_ngay(), model.getThanh_tien(),
                model.getCreatedDate(), model.getCreatedBy(), model.getModifiedDate(), model.getModifiedBy(),
                model.getSo_ngay_thuc_te(), model.getSo_ngay_du_kien(), model.getNgay_den_thuc_te(), model.getNgay_den_du_kien(), model.getId());
    }

    @Override
    public int delete(Long id) {
        String sql = resourceBundleSQL.getString("delete_hoa_don");
        return update(sql, id);
    }

    @Override
    public hoa_donModel findByPhong(String idP) {
        String sql = resourceBundleSQL.getString("get_phong_hoa_don");
        List<hoa_donModel> list = query(sql, new hoa_donMapper(), idP);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public hoa_donModel findByJoinHD(Long id) {
        String sql = resourceBundleSQL.getString("get_one_join_hoa_don");
        List<hoa_donModel> list = query(sql, new hoa_donMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }
}

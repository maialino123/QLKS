/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO.impl;
import com.QLKS.DAO.INhanVienDAO;
import com.QLKS.mapper.nhanVienMapper;
import com.QLKS.model.nhanVienModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public class nhanVienDAO extends abstractDAO<nhanVienModel> implements INhanVienDAO {

    @Override
    public List<nhanVienModel> findAll() {
        StringBuilder sql = new StringBuilder("{CALL getNhanVienAll()}");
        return query(sql.toString(), new nhanVienMapper());
    }

    @Override
    public void add(nhanVienModel model) {
        StringBuilder sql = new StringBuilder("{CALL insertNhanVien(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        insert(sql.toString(), model.getMaNV(), model.getHoTen(), model.getCmnd(), model.getNgaySinh(), model.getGioiTinh(), model.getDiaChi(), model.getSdt(), model.getNgayVaoLam(),
                model.getChucVu(), model.getLuong(), model.getHinh(), model.getRole(), model.getCreatedDate(), model.getCreatedBy(), model.isStatus()
        );
    }

    @Override
    public void update(nhanVienModel model) {
        StringBuilder sql = new StringBuilder("{CALL updateNhanVien(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        insert(sql.toString(), model.getMaNV(), model.getHoTen(), model.getCmnd(), model.getNgaySinh(), model.getGioiTinh(), model.getDiaChi(), model.getSdt(), model.getNgayVaoLam(),
                model.getChucVu(), model.getLuong(), model.getHinh(), model.getRole(), model.getCreatedDate(), model.getCreatedBy(), model.getModifiedDate(), model.getModifiedBy(), model.isStatus());

    }

    @Override
    public void delete(String maNV) {
        StringBuilder sql = new StringBuilder("{CALL delete_nhanVien(?)}");
        insert(sql.toString(), maNV);
    }

    @Override
    public List<nhanVienModel> findBy(String key_search) {
        StringBuilder sql = new StringBuilder("{CALL findByNV{?}");
        return query(sql.toString(), new nhanVienMapper(), key_search);
    }

}

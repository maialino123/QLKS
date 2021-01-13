/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO;

import com.QLKS.model.khach_hang_model;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface Ikhach_hangDAO extends GenericDAO<khach_hang_model> {
    List<khach_hang_model> findAll();
    khach_hang_model findOne(Long id);
    Long add_khachHang(khach_hang_model model);
    void edit_khachHang(khach_hang_model model);
    void delete_khachHang(Long id);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service;

import com.QLKS.model.khach_hang_model;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface Ikhach_hangService {
    List<khach_hang_model> findAll();
    khach_hang_model findOne(Long id);
    Long add_khachHang(khach_hang_model model);
    int edit_khachHang(khach_hang_model model);
    int delete_khachHang(Long ids);
    khach_hang_model findCmnd(String cmnd);
}

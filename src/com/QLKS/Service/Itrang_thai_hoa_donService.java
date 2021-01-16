/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service;

import com.QLKS.model.trang_thai_hoa_donModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface Itrang_thai_hoa_donService  {
    List<trang_thai_hoa_donModel> findAll();
    trang_thai_hoa_donModel findOne(Long id);
    Long add_TTHD(trang_thai_hoa_donModel model);
    int edit(trang_thai_hoa_donModel model);
    int delete(Long ids);
    trang_thai_hoa_donModel findByName(String name);
}

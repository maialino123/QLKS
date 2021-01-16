/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service;

import com.QLKS.model.loai_dich_vuModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface Iloai_dich_vuService {
    List<loai_dich_vuModel> findAll();
    loai_dich_vuModel findOne(Long id);
    Long add(loai_dich_vuModel model);
    int edit(loai_dich_vuModel model);
    int delete(Long ids);
    loai_dich_vuModel findByName(String name);
}

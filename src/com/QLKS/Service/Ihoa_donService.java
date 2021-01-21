/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service;

import com.QLKS.model.hoa_donModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface Ihoa_donService {
    List<hoa_donModel> findAll();
    hoa_donModel findONe(Long id);
    Long add(hoa_donModel model);
    int edit(hoa_donModel model);
    int delete(Long ids);
    hoa_donModel findByPhong(String idP);
    hoa_donModel findByJoinHD(Long id);
}

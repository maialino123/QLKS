/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service;

import com.QLKS.model.don_viModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface Idon_viService {
    List<don_viModel> findAll();
    don_viModel findByName(String Name);
    don_viModel findOne(Long id);
    Long add(don_viModel model);
    int edit(don_viModel model);
    int delete(Long id);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service;

import com.QLKS.model.thiet_biModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface Ithiet_biService {
    List<thiet_biModel> findAll();
    thiet_biModel findOne(Long id);
    void add(thiet_biModel model);
    void edit(thiet_biModel model);
    void delete(Long[] ids);
}

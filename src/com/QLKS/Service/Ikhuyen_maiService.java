/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service;

import com.QLKS.model.khuyen_maiModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface Ikhuyen_maiService {
    List<khuyen_maiModel> findAll();
    khuyen_maiModel findOne(Long id);
    void add(khuyen_maiModel model);
    void edit(khuyen_maiModel model);
    void delete(Long[] ids);
}

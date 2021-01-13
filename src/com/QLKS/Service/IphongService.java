/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service;

import com.QLKS.model.phongModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IphongService {
     List<phongModel> findAll();
    phongModel findOne(String id);
    void add(phongModel model);
    void edit(phongModel model);
    void delete(String id);
    List<phongModel> findByStatus(boolean status);
}

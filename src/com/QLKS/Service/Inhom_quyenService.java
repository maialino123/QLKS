/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service;

import com.QLKS.model.nhom_quyenModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface Inhom_quyenService {
    List<nhom_quyenModel> findAll();
    nhom_quyenModel add(nhom_quyenModel model);
    void edit(nhom_quyenModel model);
    void delete(Long[] ids);
    nhom_quyenModel findOne(Long id);
}

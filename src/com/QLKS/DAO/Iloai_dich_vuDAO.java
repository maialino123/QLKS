/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO;

import com.QLKS.model.loai_dich_vuModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface Iloai_dich_vuDAO extends GenericDAO<loai_dich_vuModel> {
    List<loai_dich_vuModel> findAll();
    loai_dich_vuModel findOne(Long id);
    void add(loai_dich_vuModel model);
    void edit(loai_dich_vuModel model);
    void delete(Long id);
}

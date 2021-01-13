/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO;

import com.QLKS.model.dich_vuModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface Idich_vuDAO extends GenericDAO<dich_vuModel> {
    List<dich_vuModel> findAll();
    dich_vuModel findOne(Long id);
    void add(dich_vuModel model);
    void edit(dich_vuModel model);
    void delete(Long id);
}

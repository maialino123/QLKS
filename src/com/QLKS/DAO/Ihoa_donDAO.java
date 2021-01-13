/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO;

import com.QLKS.model.hoa_donModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface Ihoa_donDAO extends GenericDAO<hoa_donModel> {
    List<hoa_donModel> findAll();
    hoa_donModel findONe(Long id);
    void add(hoa_donModel model);
    void edit(hoa_donModel model);
    void delete(Long id);
}

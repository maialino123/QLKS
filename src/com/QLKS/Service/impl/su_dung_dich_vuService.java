/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service.impl;

import com.QLKS.DAO.impl.su_dung_dich_vuDAO;
import com.QLKS.Service.Isu_dung_dich_vuService;
import com.QLKS.model.su_dung_dich_vuModel;

/**
 *
 * @author Admin
 */
public class su_dung_dich_vuService implements Isu_dung_dich_vuService{
    
    su_dung_dich_vuDAO su_dung_dich_vuDAO = new su_dung_dich_vuDAO();

    @Override
    public su_dung_dich_vuModel findOne(Long id) {
        return su_dung_dich_vuDAO.findOne(id);
    }

    @Override
    public void add(su_dung_dich_vuModel model) {
        su_dung_dich_vuDAO.add(model);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            su_dung_dich_vuDAO.delete(id);
        }
    }
    
}

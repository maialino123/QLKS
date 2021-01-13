/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service.impl;

import com.QLKS.DAO.impl.phan_quyenDAO;
import com.QLKS.Service.Iphan_quyenService;
import com.QLKS.model.phan_quyenModel;

/**
 *
 * @author Admin
 */
public class phan_quyenService implements Iphan_quyenService{
    
    phan_quyenDAO phan_quyenDAO = new phan_quyenDAO();

    @Override
    public void add(phan_quyenModel model) {
        phan_quyenDAO.add(model);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            phan_quyenDAO.delete(id);
        }
    }
    
}

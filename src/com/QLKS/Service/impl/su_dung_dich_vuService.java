/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service.impl;

import com.QLKS.DAO.impl.su_dung_dich_vuDAO;
import com.QLKS.Service.Isu_dung_dich_vuService;
import com.QLKS.model.su_dung_dich_vuModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public class su_dung_dich_vuService implements Isu_dung_dich_vuService {

    su_dung_dich_vuDAO su_dung_dich_vuDAO = new su_dung_dich_vuDAO();

    @Override
    public su_dung_dich_vuModel findOne(Long id) {
        return su_dung_dich_vuDAO.findOne(id);
    }

    @Override
    public su_dung_dich_vuModel add(su_dung_dich_vuModel model) {
        Long id = su_dung_dich_vuDAO.add(model);
        return su_dung_dich_vuDAO.findOne(id);
    }

    @Override
    public int delete(Long ids) {
        return su_dung_dich_vuDAO.delete(ids);
    }

    @Override
    public List<su_dung_dich_vuModel> findAll() {
        return su_dung_dich_vuDAO.findAll();
    }

    @Override
    public int edit(su_dung_dich_vuModel model) {
        return su_dung_dich_vuDAO.edit(model);
    }

    @Override
    public su_dung_dich_vuModel findByDVID(Long idDV) {
        return su_dung_dich_vuDAO.findByIdDV(idDV);
    }

    @Override
    public su_dung_dich_vuModel findByIdP(String idP) {
        return su_dung_dich_vuDAO.findByIdP(idP);
    }

}

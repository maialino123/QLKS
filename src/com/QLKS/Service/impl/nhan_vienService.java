/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service.impl;
import com.QLKS.DAO.INhan_vienDAO;
import com.QLKS.DAO.authorization.IAuthorization;
import com.QLKS.Service.Inhan_vienService;
import com.QLKS.model.nhan_vienModel;
import java.sql.Timestamp;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Admin
 */
public class nhan_vienService implements Inhan_vienService{
    
    @Inject private INhan_vienDAO nhan_vienDAO;

    @Override
    public List<nhan_vienModel> findAll() {
        return nhan_vienDAO.findAll();
    }

    @Override
    public nhan_vienModel findOne(Long id) {
        return nhan_vienDAO.findOne(id);
    }

    @Override
    public nhan_vienModel add(nhan_vienModel model) {
        model.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        model.setCreatedBy("");
        Long id = nhan_vienDAO.add(model);
        return nhan_vienDAO.findOne(id);
    }

    @Override
    public void edit(nhan_vienModel model) {
        nhan_vienModel oldModel = nhan_vienDAO.findOne(model.getId());
        model.setCreatedDate(oldModel.getCreatedDate());
        model.setCreatedBy(oldModel.getCreatedBy());
        model.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        model.setModifiedBy("");
        nhan_vienDAO.edit(model);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            nhan_vienDAO.delete(id);
        }
    }

    @Override
    public nhan_vienModel findByUserNameAndPassword(IAuthorization authorization) {
        return nhan_vienDAO.findByUserNameAndPassword(authorization);
    }
    
    
}

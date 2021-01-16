/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service.impl;
import com.QLKS.DAO.authorization.IAuthorization;
import com.QLKS.DAO.impl.nhan_vienDAO;
import com.QLKS.Service.Inhan_vienService;
import com.QLKS.model.nhan_vienModel;
import java.sql.Timestamp;
import java.util.List;


/**
 *
 * @author Admin
 */
public class nhan_vienService implements Inhan_vienService{
    
     nhan_vienDAO nhan_vienDAO = new nhan_vienDAO();

    @Override
    public List<nhan_vienModel> findAll() {
        return nhan_vienDAO.findAll();
    }

    @Override
    public nhan_vienModel findOne(Long id) {
        return nhan_vienDAO.findOne(id);
    }

    @Override
    public Long add(nhan_vienModel model) {
        model.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        model.setCreatedBy(model.getName());
        model.setId_NQ(1);
        Long id = nhan_vienDAO.add(model);
        return id;
    }

    @Override
    public void edit(nhan_vienModel model) {
        nhan_vienModel oldModel = nhan_vienDAO.findOne(model.getId());
        model.setCreatedDate(oldModel.getCreatedDate());
        model.setCreatedBy(oldModel.getCreatedBy());
        model.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        model.setModifiedBy(model.getName());
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

    @Override
    public nhan_vienModel findByUserName(String userName) {
        return nhan_vienDAO.findByUserName(userName);
    }

    @Override
    public nhan_vienModel findByEmail(String email) {
        return nhan_vienDAO.findByEmail(email);
    }

    @Override
    public nhan_vienModel findByCmnd(String cmnd) {
        return nhan_vienDAO.findByCmnd(cmnd);
    }
    
    
}

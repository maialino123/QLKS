/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO;

import com.QLKS.DAO.authorization.IAuthorization;
import com.QLKS.model.nhan_vienModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface INhan_vienDAO extends GenericDAO<nhan_vienModel> {
    List<nhan_vienModel> findAll();
    nhan_vienModel findOne(Long id);
    Long add(nhan_vienModel model);
    void edit(nhan_vienModel model);
    void delete(Long id);
    nhan_vienModel findByUserNameAndPassword(IAuthorization authorization);
    nhan_vienModel findByUserName(String userName);
    nhan_vienModel findByEmail(String email);
    nhan_vienModel findByCmnd(String cmnd);
}

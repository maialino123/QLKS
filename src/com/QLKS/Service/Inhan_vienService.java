/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service;

import com.QLKS.DAO.authorization.IAuthorization;
import com.QLKS.model.nhan_vienModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface Inhan_vienService {
    List<nhan_vienModel> findAll();
    nhan_vienModel findOne(Long id);
    nhan_vienModel add(nhan_vienModel model);
    void edit(nhan_vienModel model);
    void delete(Long[] ids);
    nhan_vienModel findByUserNameAndPassword(IAuthorization authorization);
}

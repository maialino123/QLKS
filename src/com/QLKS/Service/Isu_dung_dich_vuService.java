/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service;

import com.QLKS.model.su_dung_dich_vuModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface Isu_dung_dich_vuService {
    List<su_dung_dich_vuModel> findAll();
    su_dung_dich_vuModel findOne(Long id);
    su_dung_dich_vuModel add(su_dung_dich_vuModel model);
    int delete(Long ids);
    int edit(su_dung_dich_vuModel model);
    su_dung_dich_vuModel findByDVID(Long idDV);
    su_dung_dich_vuModel findByIdP(String idP);
}

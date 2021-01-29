/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO;

import com.QLKS.model.su_dung_dich_vuModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface Isu_dung_dich_vuDAO extends GenericDAO<su_dung_dich_vuModel>{
    List<su_dung_dich_vuModel> findAll();
    su_dung_dich_vuModel findOne(Long id);
    Long add(su_dung_dich_vuModel model);
    int delete(Long id);
    int edit(su_dung_dich_vuModel model);
    su_dung_dich_vuModel findByIdDV(Long idDV);
    su_dung_dich_vuModel findByIdP(String idP, Long id_HD);
    List<su_dung_dich_vuModel> get_allHD_SDDV(Long idHD, Long idKH);
    su_dung_dich_vuModel get_trungDV_SDDV(Long idDV, Long idHD);
    List<su_dung_dich_vuModel> get_DVByKH_SDDV(Long idKH);
}

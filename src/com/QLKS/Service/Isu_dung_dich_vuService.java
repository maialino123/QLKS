/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service;

import com.QLKS.model.su_dung_dich_vuModel;

/**
 *
 * @author Admin
 */
public interface Isu_dung_dich_vuService {
    su_dung_dich_vuModel findOne(Long id);
    void add(su_dung_dich_vuModel model);
    void delete(Long[] ids);
}

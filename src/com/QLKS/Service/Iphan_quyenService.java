/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.Service;

import com.QLKS.model.phan_quyenModel;

/**
 *
 * @author Admin
 */
public interface Iphan_quyenService {
    void add(phan_quyenModel model);
    void delete(Long[] ids);
}

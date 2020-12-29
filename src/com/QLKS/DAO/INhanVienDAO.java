/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO;

import com.QLKS.model.nhanVienModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface INhanVienDAO extends GenericDAO<nhanVienModel> {

    List<nhanVienModel> findAll();

    void add(nhanVienModel model);

    void update(nhanVienModel model);

    void delete(String maNV);

    List<nhanVienModel> findBy(String key_search);
}

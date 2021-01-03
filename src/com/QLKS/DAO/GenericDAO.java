/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO;

import com.QLKS.mapper.rowMapper;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface GenericDAO<T> {
    <T> List<T> query(String sql, rowMapper<T> rowMapper, Object... parameters);
    Long insert(String sql,  Object... parameters);
    void update(String sql, Object... parameters);
}

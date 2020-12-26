/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.mapper;

import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public interface rowMapper<T> {
    T maprow(ResultSet rs);
}

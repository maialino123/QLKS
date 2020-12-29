/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO.impl;

import com.QLKS.DAO.GenericDAO;
import com.QLKS.mapper.rowMapper;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class abstractDAO<T> implements GenericDAO<T> {

    ResourceBundle resourceBundle = ResourceBundle.getBundle("db");

    private Connection getConnection() {
        try {
            Class.forName(resourceBundle.getString("driverName"));
            String url = resourceBundle.getString("url");
            String user = resourceBundle.getString("user");
            String password = resourceBundle.getString("password");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(abstractDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(abstractDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public <T> List<T> query(String sql, rowMapper<T> rowMapper, Object... parameters) {
        Connection conn = null;
        CallableStatement stm = null;
        ResultSet rs = null;
        List<T> data = new ArrayList<T>();
        try {
            conn = getConnection();
            stm = conn.prepareCall(sql);
            setParameter(stm, parameters);
            rs = stm.executeQuery();
            while (rs.next()) {
                data.add(rowMapper.maprow(rs));
            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void insert(String sql, Object... parameters) {
        Connection conn = null;
        CallableStatement stm = null;
        try {
            conn = getConnection();
            stm = conn.prepareCall(sql);
            setParameter(stm, parameters);
            stm.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                e.printStackTrace();
                conn.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(abstractDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stm != null) {
                    stm.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    private void setParameter(CallableStatement stm, Object[] parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object param = parameters[i];
                int index = i + 1;
                if (param instanceof String) {
                    stm.setString(index, (String) param);
                } else if (param instanceof Integer) {
                    stm.setInt(index,(int) param);
                } else if (param instanceof Boolean) {
                    stm.setBoolean(index,(Boolean) param);
                } else if (param instanceof Byte) {
                    stm.setByte(index, (byte) param);
                } else if (param instanceof Timestamp) {
                    stm.setTimestamp(index, (Timestamp) param);
                } else if (param instanceof Date) {
                    stm.setDate(index, (Date) param);
                } else if (param instanceof Float) {
                    stm.setFloat(index,(float) param);
                } else if (param instanceof Short) {
                    stm.setShort(index, (short) param);
                } else if (param instanceof Long) {
                    stm.setLong(index,(long) param);
                } else if (param instanceof Double) {
                    stm.setDouble(index, (double) param);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage().toString());
        }
    }

    

}

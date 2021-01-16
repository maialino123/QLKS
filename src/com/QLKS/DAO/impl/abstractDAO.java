/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.DAO.impl;

import com.QLKS.DAO.GenericDAO;
import com.QLKS.mapper.rowMapper;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author Admin
 */
public class abstractDAO<T> implements GenericDAO<T> {
   
    ResourceBundle resourceBundleSQL = ResourceBundle.getBundle("com.QLKS.resource.query_sql");
    ResourceBundle resourceBundle = ResourceBundle.getBundle("com.QLKS.resource.db");

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
            System.err.println(e.getMessage());
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
            } catch (SQLException e2) {
                System.err.println(e2.getMessage());
            }
        }
        return null;

    }

    @Override
    public Long insert(String sql, Object... parameters) {
        Connection conn = null;
        CallableStatement stm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            stm = conn.prepareCall(sql);
            setParameter(stm, parameters);
            stm.executeUpdate();
            int iUpdCount = stm.getUpdateCount();
            boolean bMoreResults = true;
            long myIdentVal = -1;
            while (bMoreResults || iUpdCount!= -1) {
                rs = stm.getResultSet();
                if (rs != null) {
                    rs.next();
                    myIdentVal = rs.getLong(1);
                }
                bMoreResults = stm.getMoreResults();
                iUpdCount = stm.getUpdateCount();
            }
            conn.commit();
            return myIdentVal;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            try {
                conn.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(abstractDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException e2) {
                System.err.println(e2.getMessage());
            }
        }
        return null;
    }

    @Override
    public int update(String sql, Object... parameters) {
        Connection conn = null;
        CallableStatement stm = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            stm = conn.prepareCall(sql);
            setParameter(stm, parameters);
            int key = stm.executeUpdate();
            conn.commit();
            return key;
        } catch (SQLException e) {
            try {
                System.err.println(e.getMessage());
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
            } catch (SQLException e2) {
                System.out.println(e2.getMessage());
            }
        }
        return 0;
    }

    private void setParameter(PreparedStatement stm, Object[] parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object param = parameters[i];
                int index = i + 1;
                if (param instanceof String) {
                    stm.setString(index, (String) param);
                } else if (param instanceof Integer) {
                    stm.setInt(index, (int) param);
                } else if (param instanceof Boolean) {
                    stm.setBoolean(index, (Boolean) param);
                } else if (param instanceof Timestamp) {
                    stm.setTimestamp(index, (Timestamp) param);
                } else if (param instanceof Date) {
                    stm.setDate(index, (Date) param);
                } else if (param instanceof Float) {
                    stm.setFloat(index, (float) param);
                } else if (param instanceof Short) {
                    stm.setShort(index, (short) param);
                } else if (param instanceof Long) {
                    stm.setLong(index, (long) param);
                } else if (param instanceof Double) {
                    stm.setDouble(index, (double) param);
                } else if (param instanceof byte[]) {
                    Blob image;
                    if ((byte[]) param != null) {
                        image = new SerialBlob((byte[]) param);
                       stm.setBlob(index, image);
                    } else {
                        image = null;
                        stm.setBlob(index, image);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author Admin
 */
public class functionBase {
//     private ChinhSachTraPhongDAO chinhsachtpDAO;

//    public FunctionBase() {
//        chinhsachtpDAO = new ChinhSachTraPhongDAO();
//    }

    public void addCheckBox(int column, JTable table) {
        TableColumn tc = table.getColumnModel().getColumn(column);
        tc.setCellEditor(table.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));
    }

    public boolean IsSelected(int row, int column, JTable table) {
        if (table.getValueAt(row, column) != null && Boolean.parseBoolean(table.getValueAt(row, column).toString()) != false) {
            return true;
        }
        return false;
    }

    public void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    public int calendaDay(String stringDayBD, String stringDayKT) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
        String inputString1 = stringDayBD;
        String inputString2 = stringDayKT;
        int day = 0;
        try {
            Date date1 = myFormat.parse(inputString1);
            Date date2 = myFormat.parse(inputString2);
            long diff = date2.getTime() - date1.getTime();
            day = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            return day;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

//    public String funcGetMaPhuThu() {
//        String format = new SimpleDateFormat("HH").format(Calendar.getInstance().getTime());
//        int gio = Integer.parseInt(format);
//        List<ChinhSachTraPhong> lstCSTraPhong = chinhsachtpDAO.getAll();
//
//        String phuThu = "";
//        if (gio > 13 && gio <= 15) {
//            phuThu = lstCSTraPhong.get(1).getMaChinhSach();
//        } else if (gio > 15 && gio <= 17) {
//            phuThu = lstCSTraPhong.get(2).getMaChinhSach();
//        } else if (gio > 17 && gio <= 19) {
//            phuThu = lstCSTraPhong.get(3).getMaChinhSach();
//        } else if (gio > 19) {
//            phuThu = lstCSTraPhong.get(4).getMaChinhSach();
//        } else {
//            phuThu = lstCSTraPhong.get(0).getMaChinhSach();
//        }
//        return phuThu;
//    }
//
//    public float funcGetGiaTriPhuThu() {
//        String format = new SimpleDateFormat("HH").format(Calendar.getInstance().getTime());
//        int gio = Integer.parseInt(format);
//        List<ChinhSachTraPhong> lstCSTraPhong = chinhsachtpDAO.getAll();
//
//        float phuThu = 0;
//        if (gio >= 13 && gio < 15) {
//            phuThu = lstCSTraPhong.get(1).getPhuThu();
//        } else if (gio >= 15 && gio < 17) {
//            phuThu = lstCSTraPhong.get(2).getPhuThu();
//        } else if (gio >= 17 && gio < 19) {
//            phuThu = lstCSTraPhong.get(3).getPhuThu();
//        } else if (gio >= 19) {
//            phuThu = lstCSTraPhong.get(4).getPhuThu();
//        } else {
//            phuThu = lstCSTraPhong.get(0).getPhuThu();
//        }
//        return phuThu;
//    }

    public String formatTien(float number) {
        String pattern = "###, ###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String format = decimalFormat.format(number);
        return format;
    }

    public String formatTien(int number) {
        String pattern = "###, ###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String format = decimalFormat.format(number);
        return format;
    }
}

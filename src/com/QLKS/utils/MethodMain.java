/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLKS.utils;


import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hoangdung
 */
public class MethodMain {

//    private static ThongBao tb;
//
//    public static void globalMessagerSuccess(String msg, JDesktopPane jdp) {
//
//        tb = new ThongBao();
//        tb.getJlbThongBao().setText(msg);
//        tb.getJlbThongBao().setForeground(Color.green);
//
//        tb.setVisible(true);
//        jdp.add(tb);
//        Timer timer = new Timer(10000, (ActionEvent ae) -> {
//            if (tb != null) {
//                tb.setVisible(false);
//                tb.setVisible(false);
//                tb = null;
//            }
//        });
//        timer.setRepeats(false);
//        timer.start();
//    }
//
//    public static boolean checkQuyen(String quyen) {
//        String[] qs = quyen.split(",");
//        for (String q : qs) {
//            if (Main.quyens.stream().anyMatch(_item -> (_item.equals(q)))) {
//                return true;
//            }
//        }
//        return false;
//    }

    public static boolean checkInputNull(JPasswordField jpass, JLabel jlbMsg, String stringMsg) {

        if (jpass.getPassword().length == 0) {
            jlbMsg.setText(stringMsg);
            return false;
        } else {
            jlbMsg.setText(null);
            return true;
        }

    }

    public static boolean checkInputNull(JTextField jtext, JLabel jlbMsg, String stringMsg) {
        if (jtext != null) {
            jlbMsg.setText(stringMsg);
            return false;
        } else {
            jlbMsg.setText(null);
            return true;
        }
    }

    public static void exportExcel(JTable table) {
        JFileChooser chooser = new JFileChooser("src/com/qlks/saveFile/");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("XLS files", "xls");
        chooser.setFileFilter(filter);
        int i = chooser.showSaveDialog(chooser);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                // BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file + ".xls"), "UTF-8"));
                FileWriter out = new FileWriter(file + ".xls");
                try (BufferedWriter bwrite = new BufferedWriter(out)) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    // ten Cot
                    for (int j = 0; j < table.getColumnCount(); j++) {
                        bwrite.write(model.getColumnName(j) + "\t");
                    }
                    bwrite.write("\n");
                    // Lay du lieu dong
                    for (int j = 0; j < table.getRowCount(); j++) {
                        for (int k = 0; k < table.getColumnCount(); k++) {
                            bwrite.write(model.getValueAt(j, k) + "\t");
                        }
                        bwrite.write("\n");
                    }
                }
                JOptionPane.showMessageDialog(null, "Lưu file thành công!");
            } catch (HeadlessException | IOException e2) {
                JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
            }
        }
    }

    public static void exportImage(JInternalFrame internalFrame) {
        JFileChooser chooser = new JFileChooser("src/com/qlks/saveFile/");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpeg");
        chooser.setFileFilter(filter);

        int i = chooser.showSaveDialog(chooser);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                Container inContainer = internalFrame.getContentPane();
                BufferedImage image = new BufferedImage(inContainer.getWidth(), inContainer.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics2D = image.createGraphics();
                inContainer.paint(graphics2D);
                ImageIO.write(image, "jpeg", new File(file + ".jpeg"));
                JOptionPane.showMessageDialog(null, "Lưu file thành công!");
            } catch (HeadlessException | IOException exception) {
                JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
            }
        }
    }

    public static void exportImage(JPanel jPanel) {
        JFileChooser chooser = new JFileChooser("src/com/qlks/saveFile/");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpeg");
        chooser.setFileFilter(filter);

        int i = chooser.showSaveDialog(chooser);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {

                BufferedImage image = new BufferedImage(jPanel.getWidth(), jPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics2D = image.createGraphics();

                jPanel.print(graphics2D);

//                jPanel.paint(graphics2D);
//                ImageIO.write(image, "jpeg", new File(file + ".jpeg"));
                JOptionPane.showMessageDialog(null, "Lưu file thành công!");
            } catch (HeadlessException exception) {
                JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
            }
        }
    }

    public static boolean isOverlapping(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
        return start1.isBefore(end2) && start2.isBefore(end1);
    }

    public static void printComponenet(Component component) {
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setJobName(" Print Component ");

        pj.setPrintable((Graphics pg, PageFormat pf, int pageNum) -> {
            if (pageNum > 0) {
                return Printable.NO_SUCH_PAGE;
            }

            Graphics2D g2 = (Graphics2D) pg;
            g2.translate(pf.getImageableX(), pf.getImageableY());
            component.paint(g2);
            return Printable.PAGE_EXISTS;
        });
        if (pj.printDialog() == false) {
            return;
        }

        try {
            pj.print();
        } catch (PrinterException ex) {
            // handle exception
            JOptionPane.showMessageDialog(null, "In File thành công !");
        }
    }

}

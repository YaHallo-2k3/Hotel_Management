/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL_LoaiSanPham;
import DTO.DTO_LoaiSanPham;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Trung Thanh
 */
public class BLL_LoaiSanPham {

    public static boolean check(DTO_LoaiSanPham loaiSanPham) {
        if (loaiSanPham.getMaLoaiSanPham().isEmpty() || loaiSanPham.getTenLoaiSanPham().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    
    public static boolean alreayExits(String data, String value) {
        ResultSet rs = DAL_LoaiSanPham.select();
        ArrayList<String> array = new ArrayList<>();
        try {
            while (rs.next()) {
                array.add(rs.getString(data));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < array.size(); i++) {
            if (value.equals(array.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void add(DTO_LoaiSanPham loaiSanPham) {
        if (!check(loaiSanPham)) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else if (!alreayExits("MaLoaiSanPham", loaiSanPham.getMaLoaiSanPham())) {
            JOptionPane.showMessageDialog(null, "Giá Trị Đã Tồn Tại !!!");
        } else {
            DAL_LoaiSanPham.add(loaiSanPham);
            JOptionPane.showMessageDialog(null, "Cập Nhật Hoàn Tất !!!");
        }
    }

    public static void delete(String maLoaiSanPham) {
        try {
            DAL_LoaiSanPham.delete(maLoaiSanPham);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Đang Được Sử Dụng !!!");
        }
    }

    public static void edit(DTO_LoaiSanPham loaiSanPham) {
        if (!check(loaiSanPham)) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else {
            DAL_LoaiSanPham.edit(loaiSanPham);
            JOptionPane.showMessageDialog(null, "Cập Nhật Hoàn Tất !!!");
        }
    }

    public static ArrayList<DTO_LoaiSanPham> select() {
        ResultSet rs = DAL_LoaiSanPham.select();
        ArrayList<DTO_LoaiSanPham> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_LoaiSanPham loaiSanPham = new DTO_LoaiSanPham();
                loaiSanPham.setMaLoaiSanPham(rs.getString("MaLoaiSanPham"));
                loaiSanPham.setTenLoaiSanPham(rs.getString("TenLoaiSanPham"));
                array.add(loaiSanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public void load(ArrayList<DTO_LoaiSanPham> array, JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        for (DTO_LoaiSanPham loaiSanPham : array) {
            Object obj[] = new Object[2];
            obj[0] = loaiSanPham.getMaLoaiSanPham();
            obj[1] = loaiSanPham.getTenLoaiSanPham();
            tbl.getColumnModel().getColumn(2).setCellRenderer(new iconEdit());
            tbl.getColumnModel().getColumn(3).setCellRenderer(new iconDelete());
            tblModel.addRow(obj);
        }
    }

    public class iconEdit extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setIcon(new ImageIcon("C:\\Users\\CherryCe\\Documents\\NetBeansProjects\\Hotel_Management\\src\\IMG\\edit.png"));
            setHorizontalAlignment(CENTER);
            return this;
        }
    }

    public class iconDelete extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setIcon(new ImageIcon("C:\\Users\\CherryCe\\Documents\\NetBeansProjects\\Hotel_Management\\src\\IMG\\trash.png"));
            setHorizontalAlignment(CENTER);
            return this;
        }
    }
}

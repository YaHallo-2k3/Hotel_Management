/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL_Phong;
import DTO.DTO_Phong;
import HELPER.HELPER_SetIcon;
import java.awt.Component;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CherryCe
 */
public class BLL_Phong {

    public static boolean check(DTO_Phong phong) {
        if (phong.getMaPhong().isEmpty() || phong.getTenPhong().isEmpty() || phong.getMaTang().isEmpty() || phong.getMaLoaiPhong().isEmpty() || phong.getMaTrangThaiPhong().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean alreayExits(String data, String value) {
        ResultSet rs = DAL_Phong.select();
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

    public static void add(DTO_Phong phong) {
        if (!check(phong)) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else if (!alreayExits("MaPhong", phong.getMaPhong())) {
            JOptionPane.showMessageDialog(null, "Giá Trị Đã Tồn Tại !!!");
        } else {
            DAL_Phong.add(phong);
            JOptionPane.showMessageDialog(null, "Cập Nhật Hoàn Tất !!!");
        }
    }

    public static void delete(String maPhong) {
        try {
            DAL_Phong.delete(maPhong);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Đang Được Sử Dụng !!!");
        }
    }

    public static void edit(DTO_Phong phong) {
        if (!check(phong)) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else {
            DAL_Phong.edit(phong);
            JOptionPane.showMessageDialog(null, "Cập Nhật Hoàn Tất !!!");
        }
    }

    public static ArrayList<DTO_Phong> select() {
        ResultSet rs = DAL_Phong.select();
        ArrayList<DTO_Phong> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_Phong phong = new DTO_Phong();
                phong.setMaPhong(rs.getString("MaPhong"));
                phong.setTenPhong(rs.getString("TenPhong"));
                phong.setMaTang(rs.getString("MaTang"));
                phong.setMaLoaiPhong(rs.getString("MaLoaiPhong"));
                phong.setMaTrangThaiPhong(rs.getString("MaTrangThaiPhong"));
                array.add(phong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static void load(ArrayList<DTO_Phong> array, JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        for (DTO_Phong phong : array) {
            Object obj[] = new Object[6];
            obj[0] = array;
            obj[1] = phong.getMaPhong();
            obj[2] = phong.getTenPhong();
            obj[3] = BLL_MaTenLoai.findTenTang(phong.getMaTang());
            obj[4] = BLL_MaTenLoai.findTenLoaiPhong(phong.getMaLoaiPhong());
            obj[5] = BLL_MaTenLoai.findTenTrangThaiPhong(phong.getMaTrangThaiPhong());
            tbl.getColumnModel().getColumn(6).setCellRenderer(new HELPER_SetIcon.iconEdit());
            tbl.getColumnModel().getColumn(7).setCellRenderer(new HELPER_SetIcon.iconDelete());
            tblModel.addRow(obj);
        }
    }
}

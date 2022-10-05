/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL_LoaiPhong;
import DTO.DTO_LoaiPhong;
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
public class BLL_LoaiPhong {

    public static boolean check(DTO_LoaiPhong loaiPhong) {
        if (loaiPhong.getMaPhong().isEmpty() || loaiPhong.getTenPhong().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public static void add(DTO_LoaiPhong loaiPhong) {
        if (check(loaiPhong) == false) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else {
            DAL_LoaiPhong.add(loaiPhong);
        }
    }

    public static void delete(String maPhong) {
        try {
            DAL_LoaiPhong.delete(maPhong);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Đang Được Sử Dụng !!!");
        }
    }

    public static void edit(DTO_LoaiPhong loaiPhong) {
        if (check(loaiPhong) == false) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else {
            DAL_LoaiPhong.edit(loaiPhong);
        }
    }

    public static ArrayList<DTO_LoaiPhong> select() {
        ResultSet rs = DAL_LoaiPhong.select();
        ArrayList<DTO_LoaiPhong> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_LoaiPhong loaiPhong = new DTO_LoaiPhong();
                loaiPhong.setMaPhong(rs.getString("MaLoaiPhong"));
                loaiPhong.setTenPhong(rs.getString("TenLoaiPhong"));
                loaiPhong.setGiaGio(rs.getInt("GiaGio"));
                loaiPhong.setGiaNgay(rs.getInt("GiaNgay"));
                loaiPhong.setSoGiuong(rs.getInt("SoGiuong"));
                loaiPhong.setSoNguoi(rs.getInt("SoNguoi"));
                array.add(loaiPhong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public void load(ArrayList<DTO_LoaiPhong> array, JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setColumnIdentifiers(new Object[]{"Mã Loại", "Tên Loại", "Giá Giờ", "Giá Ngày", "Số Giường", "Số Người", "Sửa", "Xóa"});
        tblModel.setRowCount(0);
        for (DTO_LoaiPhong loaiPhong : array) {
            Object obj[] = new Object[6];
            obj[0] = loaiPhong.getMaPhong();
            obj[1] = loaiPhong.getTenPhong();
            obj[2] = loaiPhong.getGiaGio();
            obj[3] = loaiPhong.getGiaNgay();
            obj[4] = loaiPhong.getSoGiuong();
            obj[5] = loaiPhong.getSoNguoi();
            tbl.getColumnModel().getColumn(6).setCellRenderer(new iconEdit());
            tbl.getColumnModel().getColumn(7).setCellRenderer(new iconDelete());
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL_ChiTietDichVu;
import DTO.DTO_ChiTietDichVu;
import DTO.DTO_SanPham;
import HELPER.HELPER_ChuyenDoi;
import java.awt.Component;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CherryCe
 */
public class BLL_ChiTietDichVu {

    public static boolean check(DTO_ChiTietDichVu chiTietDichVu) {
        if (chiTietDichVu.getMaChiTiet().isEmpty() || chiTietDichVu.getMaPhieuDichVu().isEmpty() || chiTietDichVu.getMaSanPham().isEmpty() || chiTietDichVu.getSoLuong() == 0 || chiTietDichVu.getGiaTien() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean alreayExits(String data, String value) {
        ResultSet rs = DAL_ChiTietDichVu.select();
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

    public static void add(DTO_ChiTietDichVu chiTietDichVu) {
        if (!check(chiTietDichVu)) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else if (!alreayExits("MaChiTiet", chiTietDichVu.getMaChiTiet())) {
            JOptionPane.showMessageDialog(null, "Giá Trị Đã Tồn Tại !!!");
        } else {
            DAL_ChiTietDichVu.add(chiTietDichVu);
        }
    }

    public static void delete(String maDichVu, String maSanPham) {
        try {
            DAL_ChiTietDichVu.delete(maDichVu, maSanPham);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Đang Được Sử Dụng !!!");
        }
    }

    public static void edit(int soLuong, String maSanPham, String maPhieuDichVu) {
        try {
            DAL_ChiTietDichVu.edit(soLuong, maSanPham, maPhieuDichVu);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        }
    }

    public static ArrayList<DTO_ChiTietDichVu> select(String maDichVu) {
        ResultSet rs = DAL_ChiTietDichVu.selectMaDichVu(maDichVu);
        ArrayList<DTO_ChiTietDichVu> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_ChiTietDichVu chiTietDichVu = new DTO_ChiTietDichVu();
                chiTietDichVu.setMaChiTiet(rs.getString("MaChiTiet"));
                chiTietDichVu.setMaPhieuDichVu(rs.getString("MaPhieuDichVu"));
                chiTietDichVu.setMaSanPham(rs.getString("MaSanPham"));
                chiTietDichVu.setSoLuong(rs.getInt("SoLuongBan"));
                chiTietDichVu.setGiaTien(rs.getInt("GiaTien"));
                array.add(chiTietDichVu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static ArrayList<DTO_ChiTietDichVu> selectChiTietDichVu(int index) {
        ResultSet rs = DAL_ChiTietDichVu.rowNumber(index);
        ArrayList<DTO_ChiTietDichVu> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_ChiTietDichVu chiTietDichVu = new DTO_ChiTietDichVu();
                chiTietDichVu.setMaChiTiet(rs.getString("MaChiTiet"));
                chiTietDichVu.setMaPhieuDichVu(rs.getString("MaPhieuDichVu"));
                chiTietDichVu.setMaSanPham(rs.getString("MaSanPham"));
                chiTietDichVu.setSoLuong(rs.getInt("SoLuongBan"));
                chiTietDichVu.setGiaTien(rs.getInt("GiaTien"));
                array.add(chiTietDichVu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public void load(ArrayList<DTO_ChiTietDichVu> array, JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        for (DTO_ChiTietDichVu chiTietDichVu : array) {
            Object obj[] = new Object[5];
            obj[0] = chiTietDichVu.getMaSanPham();
            obj[1] = BLL_MaTenLoai.findTenSanPham(chiTietDichVu.getMaSanPham());
            obj[2] = chiTietDichVu.getSoLuong();
            obj[3] = chiTietDichVu.getGiaTien();
            obj[4] = chiTietDichVu.getSoLuong() * chiTietDichVu.getGiaTien();
            tbl.getColumnModel().getColumn(5).setCellRenderer(new iconDelete());
            tblModel.addRow(obj);
        }
    }

    public static void loadChiTietDichVu(ArrayList<DTO_ChiTietDichVu> array, JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        for (DTO_ChiTietDichVu chiTietDichVu : array) {
            Object obj[] = new Object[4];
            obj[0] = BLL_MaTenLoai.findTenSanPham(chiTietDichVu.getMaSanPham());
            obj[1] = chiTietDichVu.getSoLuong();
            obj[2] = chiTietDichVu.getGiaTien();
            obj[3] = chiTietDichVu.getSoLuong() * chiTietDichVu.getGiaTien();
            tblModel.addRow(obj);
        }
    }

    public class iconAdd extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setIcon(new ImageIcon("C:\\Users\\CherryCe\\Documents\\NetBeansProjects\\Hotel_Management\\src\\IMG\\queue.png"));
            setHorizontalAlignment(CENTER);
            return this;
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

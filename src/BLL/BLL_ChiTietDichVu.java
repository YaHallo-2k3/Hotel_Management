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
import HELPER.HELPER_SetIcon;
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

    public static void add(DTO_ChiTietDichVu chiTietDichVu) {
        if (!check(chiTietDichVu)) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else {
            DAL_ChiTietDichVu.add(chiTietDichVu);
        }
    }

    public static void delete(String maDichVu, String maSanPham) {
        DAL_ChiTietDichVu.delete(maDichVu, maSanPham);
    }

    public static void edit(int soLuong, String maSanPham, String maPhieuDichVu) {
//        try {
//            DAL_ChiTietDichVu.edit(soLuong, maSanPham, maPhieuDichVu);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
//        }
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

    public static void load(ArrayList<DTO_ChiTietDichVu> array, JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        for (DTO_ChiTietDichVu chiTietDichVu : array) {
            Object obj[] = new Object[5];
            obj[0] = chiTietDichVu.getMaSanPham();
            obj[1] = BLL_MaTenLoai.findTenSanPham(chiTietDichVu.getMaSanPham());
            obj[2] = chiTietDichVu.getSoLuong();
            obj[3] = chiTietDichVu.getGiaTien();
            obj[4] = chiTietDichVu.getSoLuong() * chiTietDichVu.getGiaTien();
            tbl.getColumnModel().getColumn(5).setCellRenderer(new HELPER_SetIcon.iconDelete());
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
}

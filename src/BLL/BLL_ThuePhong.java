/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL_ThuePhong;
import DTO.DTO_ThuePhong;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CherryCe
 */
public class BLL_ThuePhong {
    
    public static boolean check(DTO_ThuePhong thuePhong) {
        if (thuePhong.getMaPhong().isEmpty() || thuePhong.getMaPhieuThue().isEmpty() || thuePhong.getMaTrangThaiPhong().isEmpty() || thuePhong.getMaNhanVien().isEmpty() || thuePhong.getNgayTao() == null || thuePhong.getNgayDen() == null || thuePhong.getNgayDi() == null || thuePhong.getCCCD().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    
    public static void add(DTO_ThuePhong thuePhong) {
        if (check(thuePhong) == false) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else {
            DAL_ThuePhong.add(thuePhong);
        }
        DAL_ThuePhong.add(thuePhong);
    }
    
    public static void delete(String maPhieuThue) {
        try {
            DAL_ThuePhong.delete(maPhieuThue);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Đang Được Sử Dụng !!!");
        }
    }
    
    public static void edit(DTO_ThuePhong thuePhong) {
        if (check(thuePhong) == false) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else {
            DAL_ThuePhong.edit(thuePhong);
        }
    }
    
    public static ArrayList<DTO_ThuePhong> select() {
        ResultSet rs = DAL_ThuePhong.select();
        ArrayList<DTO_ThuePhong> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_ThuePhong thuePhong = new DTO_ThuePhong();
                thuePhong.setMaPhong(rs.getString("MaPhong"));
                thuePhong.setMaPhieuThue(rs.getString("MaPhieuThue"));
                thuePhong.setMaTrangThaiPhong(rs.getString("MaTrangThaiPhong"));
                thuePhong.setMaNhanVien(rs.getString("MaNhanVien"));
                thuePhong.setNgayTao(rs.getDate("SoGiuong"));
                thuePhong.setNgayDen(rs.getDate("SoNguoi"));
                thuePhong.setNgayDi(rs.getDate("SoNguoi"));
                thuePhong.setCCCD(rs.getString("CCCD"));
                thuePhong.setSoLuong(rs.getInt("SoLuongKhach"));
                thuePhong.setGhiChu(rs.getString("GhiChu"));
                thuePhong.setGiamGia(rs.getInt("GiamGia"));
                thuePhong.setTienCoc(rs.getInt("TienCoc"));
                array.add(thuePhong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }
    
    public void load(ArrayList<DTO_ThuePhong> array, JLabel lblSoPhong, JLabel lblMaPhieu, JLabel lblTrangThai, JLabel lblNhanVien, JLabel lblNgayTao, JDateChooser dateNgayDen, JDateChooser dateNgayDi, JTextField txtCCCD, JTextField txtTenKhach, JTextField txtSoLuong, JTextField txtGhiChu, JTextField txtGiamGia, JTextField txtTienCoc) {
        for (DTO_ThuePhong thuePhong : array) {
            lblSoPhong.setText(thuePhong.getMaPhong());
            lblMaPhieu.setText(thuePhong.getMaPhieuThue());
            lblTrangThai.setText(thuePhong.getMaTrangThaiPhong());
            lblNhanVien.setText(thuePhong.getMaNhanVien());
            lblNgayTao.setText(String.valueOf(thuePhong.getNgayTao()));
            dateNgayDen.setDate(thuePhong.getNgayDen());
            dateNgayDi.setDate(thuePhong.getNgayDi());
            txtCCCD.setText(thuePhong.getCCCD());
            txtTenKhach.setText(thuePhong.getCCCD());
            txtSoLuong.setText(String.valueOf(thuePhong.getSoLuong()));
            txtGhiChu.setText(thuePhong.getGhiChu());
            txtGiamGia.setText(String.valueOf(thuePhong.getGiamGia()));
            txtTienCoc.setText(String.valueOf(thuePhong.getTienCoc()));
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL_PhieuChi;
import DTO.DTO_PhieuChi;
import HELPER.HELPER_ChuyenDoi;
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
public class BLL_PhieuChi {
    
    public static boolean check(DTO_PhieuChi phieuChi) {
        if (phieuChi.getMaPhieuChi().isEmpty() || phieuChi.getMaLoaiTienChi().isEmpty() || phieuChi.getTienChi() == 0 || phieuChi.getMaPhuongThuc().isEmpty() || phieuChi.getNgayTao() == null || phieuChi.getMaNhanVien().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    
    public static boolean alreayExits(String data, String value) {
        ResultSet rs = DAL_PhieuChi.select();
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
    
    public static void add(DTO_PhieuChi phieuChi) {
        if (!check(phieuChi)) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else if (!alreayExits("MaPhieuChi", phieuChi.getMaPhieuChi())) {
            JOptionPane.showMessageDialog(null, "Giá Trị Đã Tồn Tại !!!");
        } else {
            DAL_PhieuChi.add(phieuChi);
            JOptionPane.showMessageDialog(null, "Cập Nhật Hoàn Tất !!!");
        }
    }
    
    public static void delete(String maPhieuChi) {
        try {
            DAL_PhieuChi.delete(maPhieuChi);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Đang Được Sử Dụng !!!");
        }
    }
    
    public static void edit(DTO_PhieuChi phieuChi) {
        if (!check(phieuChi)) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else {
            DAL_PhieuChi.edit(phieuChi);
            JOptionPane.showMessageDialog(null, "Cập Nhật Hoàn Tất !!!");
        }
    }
    
    public static ArrayList<DTO_PhieuChi> select(int index) {
        ResultSet rs = DAL_PhieuChi.rowNumber(index);
        ArrayList<DTO_PhieuChi> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_PhieuChi phieuChi = new DTO_PhieuChi();
                phieuChi.setMaPhieuChi(rs.getString("MaPhieuChi"));
                phieuChi.setMaLoaiTienChi(rs.getString("MaLoaiTienChi"));
                phieuChi.setTienChi(rs.getInt("TienChi"));
                phieuChi.setMaPhuongThuc(rs.getString("MaPhuongThuc"));
                phieuChi.setGhiChu(rs.getString("GhiChu"));
                phieuChi.setNgayTao(rs.getTimestamp("NgayTao"));
                phieuChi.setMaNhanVien(rs.getString("MaNhanVien"));
                array.add(phieuChi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }
    
    public static void load(ArrayList<DTO_PhieuChi> array, javax.swing.JLabel lblMaPhieu, javax.swing.JLabel lblMucChi, javax.swing.JLabel lblTongTien, javax.swing.JLabel lblPhuongThuc, javax.swing.JTextField txtGhiChu, javax.swing.JLabel lblNgayTao, javax.swing.JLabel lblNhanVien) {
        for (DTO_PhieuChi phieuChi : array) {
            lblMaPhieu.setText(phieuChi.getMaPhieuChi());
            lblMucChi.setText(BLL_MaTenLoai.findTenLoaiTienChi(phieuChi.getMaLoaiTienChi()));
            lblTongTien.setText(HELPER_ChuyenDoi.getSoString(phieuChi.getTienChi()));
            lblPhuongThuc.setText(BLL_MaTenLoai.findTenPhuongThuc(phieuChi.getMaPhuongThuc()));
            txtGhiChu.setText(phieuChi.getGhiChu());
            lblNgayTao.setText(HELPER_ChuyenDoi.getNgayString("dd-MM-yy HH:mm", phieuChi.getNgayTao()));
            lblNhanVien.setText(BLL_MaTenLoai.findTenNhanVien(phieuChi.getMaNhanVien()));
        }
    }
    
    public static void loadChiTiet(ArrayList<DTO_PhieuChi> array, javax.swing.JLabel lblMaPhieu, javax.swing.JComboBox cboMucChi, javax.swing.JTextField txtTongTien, javax.swing.JComboBox cboPhuongThuc, javax.swing.JTextField txtGhiChu, javax.swing.JLabel lblNgayTao, javax.swing.JLabel lblNhanVien) {
        for (DTO_PhieuChi phieuChi : array) {
            lblMaPhieu.setText(phieuChi.getMaPhieuChi());
            cboMucChi.setSelectedItem(BLL_MaTenLoai.findTenLoaiTienChi(phieuChi.getMaLoaiTienChi()));
            txtTongTien.setText(HELPER_ChuyenDoi.getSoString(phieuChi.getTienChi()));
            cboPhuongThuc.setSelectedItem(BLL_MaTenLoai.findTenPhuongThuc(phieuChi.getMaPhuongThuc()));
            txtGhiChu.setText(phieuChi.getGhiChu());
            lblNgayTao.setText(HELPER_ChuyenDoi.getNgayString("dd-MM-yy HH:mm", phieuChi.getNgayTao()));
            lblNhanVien.setText(BLL_MaTenLoai.findTenNhanVien(phieuChi.getMaNhanVien()));
        }
    }
    
    public static int count() {
        ResultSet rs = DAL_PhieuChi.count();
        try {
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}

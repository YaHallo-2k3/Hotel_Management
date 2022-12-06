/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL_DichVu;
import DAL.DAL_ThuePhong;
import DTO.DTO_DichVu;
import DTO.DTO_DichVu;
import DTO.DTO_ThuePhong;
import HELPER.HELPER_ChuyenDoi;
import java.awt.Component;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CherryCe
 */
public class BLL_DichVu {

    public static boolean check(DTO_DichVu dichVu) {
        if (dichVu.getMaPhieuDichVu().isEmpty() || dichVu.getMaNhanVien().isEmpty() || dichVu.getNgayTao() == null) {
            return false;
        } else {
            return true;
        }
    }

    public static void add(DTO_DichVu dichVu) {
        if (!check(dichVu)) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else {
            DAL_DichVu.add(dichVu);
        }
    }

    public static void delete(String maPhieuDichVu) {
        DAL_DichVu.delete(maPhieuDichVu);
    }

    public static ArrayList<DTO_ThuePhong> select(String maPhong) {
        ResultSet rs = DAL_ThuePhong.select(maPhong);
        ArrayList<DTO_ThuePhong> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_ThuePhong thuePhong = new DTO_ThuePhong();
                thuePhong.setMaPhong(rs.getString("MaPhong"));
                thuePhong.setNgayDen(rs.getTimestamp("NgayDen"));
                thuePhong.setNgayDi(rs.getTimestamp("NgayDi"));
                array.add(thuePhong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static void load(ArrayList<DTO_ThuePhong> array, JLabel lblNgayDen, JLabel lblNgayDi) {
        for (DTO_ThuePhong thuePhong : array) {
            lblNgayDen.setText(HELPER_ChuyenDoi.getNgayString("dd-MM-yy", thuePhong.getNgayDen()));
            lblNgayDi.setText(HELPER_ChuyenDoi.getNgayString("dd-MM-yy", thuePhong.getNgayDi()));
        }
    }

    public static ArrayList<DTO_DichVu> search(String dateTuNgay, String dateDenNgay, int index) {
        ResultSet rs = DAL_DichVu.search(dateTuNgay, dateDenNgay, index);
        ArrayList<DTO_DichVu> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_DichVu dichVu = new DTO_DichVu();
                dichVu.setMaPhieuDichVu(rs.getString("MaPhieuDichVu"));
                dichVu.setMaPhong(rs.getString("MaPhong"));
                dichVu.setMaNhanVien(rs.getString("MaNhanVien"));
                dichVu.setNgayTao(rs.getTimestamp("NgayTao"));
                dichVu.setGhiChu(rs.getString("GhiChu"));
                dichVu.setTrangThaiThanhToan(rs.getInt("TrangThaiThanhToan"));
                array.add(dichVu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static void loadDichVu(ArrayList<DTO_DichVu> array, JLabel lblMaPhieu, JLabel lblMaPhong, JLabel lblNgayTao) {
        for (DTO_DichVu dichVu : array) {
            lblMaPhieu.setText(dichVu.getMaPhieuDichVu());
            lblMaPhong.setText(BLL_MaTenLoai.findTenPhong(dichVu.getMaPhong()));
            lblNgayTao.setText(HELPER_ChuyenDoi.getNgayString("dd-MM-yy HH:mm", dichVu.getNgayTao()));
        }
    }

    public static void loadChiTietDichVu(ArrayList<DTO_DichVu> array, JLabel lblMaPhieu, JLabel lblMaPhong, JLabel lblMaNhanVien, JLabel lblNgayTao, JTextField txtGhiChu) {
        for (DTO_DichVu dichVu : array) {
            lblMaPhieu.setText(dichVu.getMaPhieuDichVu());
            lblMaPhong.setText(BLL_MaTenLoai.findTenPhong(dichVu.getMaPhong()));
            lblMaNhanVien.setText(BLL_MaTenLoai.findTenNhanVien(dichVu.getMaNhanVien()));
            lblNgayTao.setText(HELPER_ChuyenDoi.getNgayString("dd-MM-yy HH:mm", dichVu.getNgayTao()));
            txtGhiChu.setText(dichVu.getGhiChu());
        }
    }

    public static int countSearch(String tuNgay, String denNgay) {
        ResultSet rs = DAL_DichVu.countSearch(tuNgay, denNgay);
        try {
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int money(String tuNgay, String denNgay) {
        ResultSet rs = DAL_DichVu.money(tuNgay, denNgay);
        try {
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int findThanhToan(String maPhieuDichVu) {
        ResultSet rs = DAL_DichVu.findThanhToan(maPhieuDichVu);
        try {
            while (rs.next()) {
                return rs.getInt("TrangThaiThanhToan");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}

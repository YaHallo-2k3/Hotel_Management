/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL_SoDoPhong;
import DAL.DAL_ThuePhong;
import DTO.DTO_Phong;
import DTO.DTO_ThuePhong;
import HELPER.HELPER_ChuyenDoi;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        if (thuePhong.getMaPhong().isEmpty() || thuePhong.getMaPhieuThue().isEmpty() || thuePhong.getMaNhanVien().isEmpty() || thuePhong.getNgayTao() == null || thuePhong.getNgayDen() == null || thuePhong.getCMND().isEmpty() || thuePhong.getTenKhachHang().isEmpty() || thuePhong.getSoLuong() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void addThuePhong(DTO_ThuePhong thuePhong) {
        if (!check(thuePhong)) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else {
            DAL_ThuePhong.addThuePhong(thuePhong);
            DAL_ThuePhong.setTrangThaiPhong("CoKhach", BLL_MaTenLoai.findMaPhong(thuePhong.getMaPhong()));
            JOptionPane.showMessageDialog(null, "Cập Nhật Hoàn Tất !!!");
        }
    }

    public static void addDatPhong(DTO_ThuePhong thuePhong) {
        if (!check(thuePhong)) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else {
            DAL_ThuePhong.addDatPhong(thuePhong);
            DAL_ThuePhong.setTrangThaiPhong("DatTruoc", BLL_MaTenLoai.findMaPhong(thuePhong.getMaPhong()));
            JOptionPane.showMessageDialog(null, "Cập Nhật Hoàn Tất !!!");
        }
    }

    public static void delete(String maPhieuThue) {
        try {
            DAL_ThuePhong.delete(maPhieuThue);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Đang Được Sử Dụng !!!");
        }
    }

    public static void editThuePhong(DTO_ThuePhong thuePhong) {
        if (!check(thuePhong)) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else {
            DAL_ThuePhong.editThuePhong(thuePhong);
            DAL_ThuePhong.setTrangThaiPhong("CoKhach", BLL_MaTenLoai.findMaPhong(thuePhong.getMaPhong()));
            JOptionPane.showMessageDialog(null, "Cập Nhật Hoàn Tất !!!");
        }
    }

    public static void editDatPhong(DTO_ThuePhong thuePhong) {
        if (!check(thuePhong)) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else {
            DAL_ThuePhong.editDatPhong(thuePhong);
            DAL_ThuePhong.setTrangThaiPhong("DatTruoc", BLL_MaTenLoai.findMaPhong(thuePhong.getMaPhong()));
            JOptionPane.showMessageDialog(null, "Cập Nhật Hoàn Tất !!!");
        }
    }

    public static ArrayList<DTO_ThuePhong> select(String maPhong) {
        ResultSet rs = DAL_ThuePhong.select(maPhong);
        ArrayList<DTO_ThuePhong> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_ThuePhong thuePhong = new DTO_ThuePhong();
                thuePhong.setMaPhong(rs.getString("MaPhong"));
                thuePhong.setMaPhieuThue(rs.getString("MaPhieuThue"));
                thuePhong.setMaNhanVien(rs.getString("MaNhanVien"));
                thuePhong.setNgayTao(rs.getTimestamp("NgayTao"));
                thuePhong.setNgayDen(rs.getTimestamp("NgayDen"));
                thuePhong.setNgayDi(rs.getTimestamp("NgayDi"));
                thuePhong.setCMND(rs.getString("CMND"));
                thuePhong.setTenKhachHang(rs.getString("TenKhachHang"));
                thuePhong.setSoLuong(rs.getInt("SoLuongKhach"));
                thuePhong.setGhiChu(rs.getString("GhiChu"));
                thuePhong.setTienCoc(rs.getInt("TienCoc"));
                thuePhong.setGiamGia(rs.getInt("GiamGia"));
                thuePhong.setTrangThaiThanhToan(rs.getInt("TrangThaiThanhToan"));
                array.add(thuePhong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static ArrayList<DTO_ThuePhong> selectThuePhong(int index) {
        ResultSet rs = DAL_ThuePhong.rowNumber(index);
        ArrayList<DTO_ThuePhong> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_ThuePhong thuePhong = new DTO_ThuePhong();
                thuePhong.setMaPhong(rs.getString("MaPhong"));
                thuePhong.setMaPhieuThue(rs.getString("MaPhieuThue"));
                thuePhong.setMaNhanVien(rs.getString("MaNhanVien"));
                thuePhong.setNgayTao(rs.getTimestamp("NgayTao"));
                thuePhong.setNgayDen(rs.getTimestamp("NgayDen"));
                thuePhong.setNgayDi(rs.getTimestamp("NgayDi"));
                thuePhong.setCMND(rs.getString("CMND"));
                thuePhong.setTenKhachHang(rs.getString("TenKhachHang"));
                thuePhong.setSoLuong(rs.getInt("SoLuongKhach"));
                thuePhong.setGhiChu(rs.getString("GhiChu"));
                thuePhong.setTienCoc(rs.getInt("TienCoc"));
                thuePhong.setGiamGia(rs.getInt("GiamGia"));
                thuePhong.setTrangThaiThanhToan(rs.getInt("TrangThaiThanhToan"));
                array.add(thuePhong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static ArrayList<DTO_Phong> selectPhong(int index) {
        ResultSet rs = DAL_ThuePhong.rowNumber(index);
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

    public static void load(ArrayList<DTO_ThuePhong> array, JLabel lblMaPhieu, JLabel lblNhanVien, JLabel lblNgayTao, JLabel dateNgayDen, JLabel dateNgayDi, JTextField txtCMND, JTextField txtTenKhach, JTextField txtSoLuong, JTextField txtGhiChu, JTextField txtGiamGia, JTextField txtTienCoc) {
        for (DTO_ThuePhong thuePhong : array) {
            lblMaPhieu.setText(thuePhong.getMaPhieuThue());
            lblNhanVien.setText(BLL_MaTenLoai.findTenNhanVien(thuePhong.getMaNhanVien()));
            lblNgayTao.setText(HELPER_ChuyenDoi.getNgayString("dd-MM-yy HH:mm", thuePhong.getNgayTao()));
            dateNgayDen.setText(HELPER_ChuyenDoi.getNgayString("dd-MM-yyyy HH:mm", thuePhong.getNgayDen()));

            if (thuePhong.getNgayDi() == null) {
                dateNgayDi.setText(HELPER_ChuyenDoi.getTimeNow("dd-MM-yyyy HH:mm"));
            } else {
                dateNgayDi.setText(HELPER_ChuyenDoi.getNgayString("dd-MM-yyyy HH:mm", thuePhong.getNgayDi()));
            }

            txtCMND.setText(thuePhong.getCMND());
            txtTenKhach.setText(thuePhong.getTenKhachHang());
            txtSoLuong.setText(HELPER_ChuyenDoi.getSoString(thuePhong.getSoLuong()));
            txtGhiChu.setText(thuePhong.getGhiChu());
            txtGiamGia.setText(HELPER_ChuyenDoi.getSoString(thuePhong.getGiamGia()));
            txtTienCoc.setText(HELPER_ChuyenDoi.getSoString(thuePhong.getTienCoc()));
        }
    }

    public static void loadPhong(ArrayList<DTO_Phong> array, JLabel lblSetPhong, JLabel lblSetLoaiPhong, JLabel lblSetTrangThaiPhong) {
        for (DTO_Phong phong : array) {
            lblSetPhong.setText(phong.getTenPhong());
            lblSetLoaiPhong.setText(BLL_MaTenLoai.findTenLoaiPhong(phong.getMaLoaiPhong()));
            lblSetTrangThaiPhong.setText(BLL_MaTenLoai.findTenTrangThaiPhong(phong.getMaTrangThaiPhong()));
        }
    }

    public static void loadThuePhong(ArrayList<DTO_ThuePhong> array, JLabel lblNgayDen, JLabel lblThangDen, JLabel lblGioPhutDen, JLabel lblNgayDi, JLabel lblThangDi, JLabel lblGioPhutDi, JLabel lblTenKhachHang) {
        for (DTO_ThuePhong thuePhong : array) {
            lblNgayDen.setText(HELPER_ChuyenDoi.getNgayString("dd", thuePhong.getNgayDen()));
            lblThangDen.setText(HELPER_ChuyenDoi.getNgayString("MM", thuePhong.getNgayDen()));
            lblGioPhutDen.setText(HELPER_ChuyenDoi.getNgayString("HH:mm", thuePhong.getNgayDen()));

            if (thuePhong.getNgayDi() == null) {
                lblNgayDi.setText(HELPER_ChuyenDoi.getTimeNow("dd"));
                lblThangDi.setText(HELPER_ChuyenDoi.getTimeNow("MM"));
                lblGioPhutDi.setText(HELPER_ChuyenDoi.getTimeNow("HH:mm"));
            } else {
                lblNgayDi.setText(HELPER_ChuyenDoi.getNgayString("dd", thuePhong.getNgayDi()));
                lblThangDi.setText(HELPER_ChuyenDoi.getNgayString("MM", thuePhong.getNgayDi()));
                lblGioPhutDi.setText(HELPER_ChuyenDoi.getNgayString("HH:mm", thuePhong.getNgayDi()));
            }

            lblTenKhachHang.setText(thuePhong.getTenKhachHang());
        }
    }

    public static int countThuePhong() {
        ResultSet rs = DAL_ThuePhong.count();
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

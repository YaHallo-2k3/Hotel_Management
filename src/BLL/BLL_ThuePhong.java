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
import HELPER.HELPER_SetIcon;
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
        }
    }

    public static void addDatPhong(DTO_ThuePhong thuePhong) {
        if (!check(thuePhong)) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else {
            DAL_ThuePhong.addDatPhong(thuePhong);
            DAL_ThuePhong.setTrangThaiPhong("DatTruoc", BLL_MaTenLoai.findMaPhong(thuePhong.getMaPhong()));
        }
    }

    public static void delete(String maPhong) {
        try {
            DAL_ThuePhong.delete(maPhong);
            DAL_ThuePhong.setTrangThaiPhong("PhongTrong", maPhong);
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
        }
    }

    public static void editDatPhong(DTO_ThuePhong thuePhong) {
        if (!check(thuePhong)) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else {
            DAL_ThuePhong.addThanhToan(thuePhong);
            DAL_ThuePhong.setTrangThaiPhong("DatTruoc", BLL_MaTenLoai.findMaPhong(thuePhong.getMaPhong()));
        }
    }

    public static void addThanhToan(DTO_ThuePhong thuePhong) {
        if (!check(thuePhong)) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else {
            DAL_ThuePhong.addThanhToan(thuePhong);
            DAL_ThuePhong.setTrangThaiPhong("TraPhong", BLL_MaTenLoai.findMaPhong(thuePhong.getMaPhong()));
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
                thuePhong.setHinhAnh(rs.getBytes("HinhAnh"));
                thuePhong.setTrangThaiThanhToan(rs.getInt("TrangThaiThanhToan"));
                array.add(thuePhong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static ArrayList<DTO_ThuePhong> selectThuePhong(String tuNgay, String denNgay, int index) {
        ResultSet rs = DAL_ThuePhong.rowNumber(tuNgay, denNgay, index);
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
                thuePhong.setHinhAnh(rs.getBytes("HinhAnh"));
                thuePhong.setTrangThaiThanhToan(rs.getInt("TrangThaiThanhToan"));
                array.add(thuePhong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }
    
    public static ArrayList<DTO_ThuePhong> selectThuePhong(String ngayDen, String ngayDi) {
        ResultSet rs = DAL_ThuePhong.findMaPhieuThue(ngayDen, ngayDi);
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
                thuePhong.setHinhAnh(rs.getBytes("HinhAnh"));
                thuePhong.setTrangThaiThanhToan(rs.getInt("TrangThaiThanhToan"));
                array.add(thuePhong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static ArrayList<DTO_Phong> selectPhong(String tuNgay, String denNgay, int index) {
        ResultSet rs = DAL_ThuePhong.rowNumber(tuNgay, denNgay, index);
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

    public static void load(ArrayList<DTO_ThuePhong> array, JLabel lblMaPhieu, JLabel lblNhanVien, JLabel lblNgayTao, JLabel dateNgayDen, JLabel dateNgayDi, JTextField txtCMND, JTextField txtTenKhach, JTextField txtSoLuong, JTextField txtGhiChu, JTextField txtTienCoc, JTextField txtGiamGia, JLabel lblImage) {
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
            txtTienCoc.setText(HELPER_ChuyenDoi.getSoString(thuePhong.getTienCoc()) + "K");
            txtGiamGia.setText(HELPER_ChuyenDoi.getSoString(thuePhong.getGiamGia()) + "K");
//            lblImage.setIcon(HELPER_SetIcon.resizeImage(thuePhong.getHinhAnh(), lblImage));
        }
    }

    public static void loadPhong(ArrayList<DTO_Phong> array, JLabel lblSetPhong, JLabel lblSetLoaiPhong, JLabel lblSetTrangThaiPhong) {
        for (DTO_Phong phong : array) {
            lblSetPhong.setText(phong.getTenPhong());
            lblSetLoaiPhong.setText(BLL_MaTenLoai.findTenLoaiPhong(phong.getMaLoaiPhong()));
            lblSetTrangThaiPhong.setText(BLL_MaTenLoai.findTenTrangThaiPhong(phong.getMaTrangThaiPhong()));
        }
    }

    public static void loadThuePhong(ArrayList<DTO_ThuePhong> array, JLabel lblNgayDen, JLabel lblThangDen, JLabel lblGioPhutDen, JLabel lblNgayDi, JLabel lblThangDi, JLabel lblGioPhutDi, JLabel lblTenKhachHang, JLabel lblTrangThaiPhong) {
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
            if (thuePhong.getTrangThaiThanhToan() == 1) {
                lblTrangThaiPhong.setText("Trả Phòng");
            }
        }
    }

    public static int countSearch(String tuNgay, String denNgay) {
        ResultSet rs = DAL_ThuePhong.countSearch(tuNgay, denNgay);
        try {
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String findMaPhieuThue(String ngayDen, String ngayDi) {
        ResultSet rs = DAL_ThuePhong.findMaPhieuThue(ngayDen, ngayDi);
        try {
            while (rs.next()) {
                return rs.getString("MaPhieuThue");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String findMaPhong(int index) {
        ResultSet rs = DAL_ThuePhong.findMaPhong(index);
        try {
            while (rs.next()) {
                return rs.getString("MaPhong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String findMaPhong(String maTang, int index) {
        ResultSet rs = DAL_ThuePhong.findMaPhong(maTang, index);
        try {
            while (rs.next()) {
                return rs.getString("MaPhong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

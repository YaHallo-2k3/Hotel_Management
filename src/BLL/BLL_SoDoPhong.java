/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL_MaTenLoai;
import DAL.DAL_Phong;
import DAL.DAL_SoDoPhong;
import DTO.DTO_Phong;
import DTO.DTO_ThuePhong;
import HELPER.HELPER_ChuyenDoi;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CherryCe
 */
public class BLL_SoDoPhong {

    public static int countPhong() {
        ResultSet rs = DAL_SoDoPhong.count();
        try {
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static ArrayList<DTO_Phong> selectPhong(int index) {
        ResultSet rs = DAL_SoDoPhong.rowNumber(index);
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

    public static ArrayList<DTO_ThuePhong> selectThuePhong(String tenPhong) {
        ResultSet rs = DAL_SoDoPhong.select(tenPhong);
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

    public static void loadPhong(ArrayList<DTO_Phong> array, JLabel lblSetPhong, JLabel lblSetLoaiPhong, JLabel lblSetTrangThaiPhong) {
        for (DTO_Phong phong : array) {
            lblSetPhong.setText(phong.getTenPhong());
            lblSetLoaiPhong.setText(BLL_MaTenLoai.findTenLoaiPhong(phong.getMaLoaiPhong()));
            lblSetTrangThaiPhong.setText(BLL_MaTenLoai.findTenTrangThaiPhong(phong.getMaTrangThaiPhong()));
        }
    }

    public static void loadThuePhong(ArrayList<DTO_ThuePhong> array, JLabel lblNgayDen, JLabel lblThangDen, JLabel lblGioPhutDen, JLabel lblNgayDi, JLabel lblThangDi, JLabel lblGioPhutDi, JLabel lblDatCoc) {
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
            lblDatCoc.setText(HELPER_ChuyenDoi.getSoString(thuePhong.getTienCoc()));
        }
    }

    public static void loadThongTinPhong(ArrayList<DTO_Phong> array, JLabel lblSetSo_LoaiPhong, JLabel lblSetTrangThaiPhong) {
        for (DTO_Phong phong : array) {
            lblSetSo_LoaiPhong.setText(phong.getTenPhong() + " - " + BLL_MaTenLoai.findTenLoaiPhong(phong.getMaLoaiPhong()));
            lblSetTrangThaiPhong.setText(BLL_MaTenLoai.findTenTrangThaiPhong(phong.getMaTrangThaiPhong()));
        }
    }
}

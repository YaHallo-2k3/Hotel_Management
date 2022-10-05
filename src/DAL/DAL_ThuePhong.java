/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.BLL_MaTenLoai;
import DTO.DTO_ThuePhong;
import DTO.DTO_SoTang;
import HELPER.HELPER_ChuyenDoi;
import HELPER.HELPER_ConnectSQL;
import java.sql.ResultSet;

/**
 *
 * @author CherryCe
 */
public class DAL_ThuePhong {

    public static void add(DTO_ThuePhong thuePhong) {
        String sqlSelect = "INSERT INTO PhieuThuePhong VALUES (?, ?, ?, ?, CONVERT(VARCHAR, ?), CONVERT(VARCHAR, ?), CONVERT(VARCHAR, ?), ?, ?, ?, ?, ?)";
        HELPER_ConnectSQL.executeUpdate(sqlSelect, BLL_MaTenLoai.findMaPhong(thuePhong.getMaPhong()), thuePhong.getMaPhieuThue(), BLL_MaTenLoai.findMaTrangThaiPhong(thuePhong.getMaTrangThaiPhong()), thuePhong.getMaNhanVien(), HELPER_ChuyenDoi.getNgayString("dd/MM/yyyy HH:mm", thuePhong.getNgayTao()), HELPER_ChuyenDoi.getNgayString("dd/MM/yyyy HH:mm", thuePhong.getNgayDen()), HELPER_ChuyenDoi.getNgayString("dd/MM/yyyy HH:mm", thuePhong.getNgayDi()), thuePhong.getCCCD(), thuePhong.getSoLuong(), thuePhong.getGhiChu(), thuePhong.getGiamGia(), thuePhong.getTienCoc());
    }

    public static void delete(String maPhieuThue) {
        String sqlDelete = "DELETE FROM PhieuThuePhong WHERE MaPhieuThue = ?";
        HELPER_ConnectSQL.executeUpdate(sqlDelete, maPhieuThue);
    }

    public static void edit(DTO_ThuePhong thuePhong) {
        String sqlUpdate = "UPDATE PhieuThuePhong SET MaPhong = ?, MaTrangThaiPhong = ?, MaNhanVien = ?, CONVERT(VARCHAR, NgayTao = ?), CONVERT(VARCHAR, NgayDen = ?), CONVERT(VARCHAR, NgayDi = ?), CCCD = ?, SoLuongKhach = ?, GhiChu = ?, GiamGia = ?, TienCoc = ? WHERE MaPhieuThue = ?";
        HELPER_ConnectSQL.executeUpdate(sqlUpdate, thuePhong.getMaPhong(), thuePhong.getMaTrangThaiPhong(), thuePhong.getMaNhanVien(), thuePhong.getNgayTao(), thuePhong.getNgayDen(), thuePhong.getNgayDi(), thuePhong.getCCCD(), thuePhong.getSoLuong(), thuePhong.getGhiChu(), thuePhong.getGiamGia(), thuePhong.getTienCoc(), thuePhong.getMaPhieuThue());
    }

    public static ResultSet select() {
        String sqlSelect = "SELECT * FROM PhieuThuePhong ORDER BY MaPhieuThue";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }

    public static ResultSet count(String thoiGian) {
        String sqlSelect = "SELECT COUNT(*) FROM PhieuThuePhong WHERE MaPhieuThue LIKE ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, "%" + thoiGian + "%");
    }
}

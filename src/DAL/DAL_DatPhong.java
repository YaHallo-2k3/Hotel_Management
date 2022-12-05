/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.BLL_MaTenLoai;
import DTO.DTO_DatPhong;
import HELPER.HELPER_ChuyenDoi;
import HELPER.HELPER_ConnectSQL;
import java.sql.ResultSet;

/**
 *
 * @author CherryCe
 */
public class DAL_DatPhong {

    public static void add(DTO_DatPhong datPhong) {
        String sqlInsert = "INSERT INTO DatPhong VALUES (?, ?, ?, ?, CONVERT(VARCHAR, ?), CONVERT(VARCHAR, ?), CONVERT(VARCHAR, ?), ?, ?, ?, ?, ?, ?)";
        HELPER_ConnectSQL.executeUpdate(sqlInsert, datPhong.getMaPhieu(), BLL_MaTenLoai.findMaLoaiPhong(datPhong.getMaLoaiPhong()), datPhong.getLoaiKhach(), BLL_MaTenLoai.findMaNhanVien(datPhong.getMaNhanVien()), HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd HH:mm", datPhong.getNgayTao()), HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd HH:mm", datPhong.getNgayDen()), HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd HH:mm", datPhong.getNgayDi()), datPhong.getTenKhachHang(), datPhong.getSoLuongKhach(), datPhong.getSoDienThoai(), datPhong.getGhiChu(), datPhong.getTienCoc(), datPhong.getTrangThai());
    }

    public static void delete(String maDatPhong) {
        String sqlDelete = "DELETE FROM DatPhong WHERE MaPhieuDat = ?";
        HELPER_ConnectSQL.executeUpdate(sqlDelete, maDatPhong);
    }

    public static void edit(DTO_DatPhong datPhong) {
        String sqlUpdate = "UPDATE DatPhong SET MaLoaiPhong = ?, LoaiKhach = ?, MaNhanVien = ?, NgayTao = CONVERT(VARCHAR, ?), NgayDen = CONVERT(VARCHAR, ?), NgayDi = CONVERT(VARCHAR, ?), TenKhachHang = ?, SoLuongKhach = ?, SoDienThoai = ?, GhiChu = ?, TienCoc = ?, TrangThai = ? WHERE MaPhieuDat = ?";
        HELPER_ConnectSQL.executeUpdate(sqlUpdate, BLL_MaTenLoai.findMaLoaiPhong(datPhong.getMaLoaiPhong()), datPhong.getLoaiKhach(), BLL_MaTenLoai.findMaNhanVien(datPhong.getMaNhanVien()), HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd HH:mm", datPhong.getNgayTao()), HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd HH:mm", datPhong.getNgayDen()), HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd HH:mm", datPhong.getNgayDi()), datPhong.getTenKhachHang(), datPhong.getSoLuongKhach(), datPhong.getSoDienThoai(), datPhong.getGhiChu(), datPhong.getTienCoc(), datPhong.getTrangThai(), datPhong.getMaPhieu());
    }

    public static ResultSet select(String dateTuNgay, String dateDenNgay) {
        String sqlSelect = "SELECT * FROM DatPhong WHERE CONVERT(DATE, NgayTao) BETWEEN ? AND ? ORDER BY MaPhieuDat";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, dateTuNgay, dateDenNgay);
    }

    public static ResultSet count(String thoiGian) {
        String sqlSelect = "SELECT COUNT(*) FROM DatPhong WHERE MaPhieuDat LIKE ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, "%" + thoiGian + "%");
    }
}

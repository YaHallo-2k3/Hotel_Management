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

    public static void addThuePhong(DTO_ThuePhong thuePhong) {
        String sqlSelect = "INSERT INTO ThuePhong VALUES (?, ?, ?, CONVERT(VARCHAR, ?), CONVERT(VARCHAR, ?), CONVERT(VARCHAR, ?), ?, ?, ?, ?, ?, ?, ?)";
        HELPER_ConnectSQL.executeUpdate(sqlSelect, BLL_MaTenLoai.findMaPhong(thuePhong.getMaPhong()), thuePhong.getMaPhieuThue(), BLL_MaTenLoai.findMaNhanVien(thuePhong.getMaNhanVien()), HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd HH:mm", thuePhong.getNgayTao()), HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd HH:mm", thuePhong.getNgayDen()), null, thuePhong.getCMND(), thuePhong.getTenKhachHang(), thuePhong.getSoLuong(), thuePhong.getGhiChu(), thuePhong.getTienCoc(), thuePhong.getGiamGia(), thuePhong.getTrangThaiThanhToan());
    }

    public static void addDatPhong(DTO_ThuePhong thuePhong) {
        String sqlSelect = "INSERT INTO ThuePhong VALUES (?, ?, ?, CONVERT(VARCHAR, ?), CONVERT(VARCHAR, ?), CONVERT(VARCHAR, ?), ?, ?, ?, ?, ?, ?, ?)";
        HELPER_ConnectSQL.executeUpdate(sqlSelect, BLL_MaTenLoai.findMaPhong(thuePhong.getMaPhong()), thuePhong.getMaPhieuThue(), BLL_MaTenLoai.findMaNhanVien(thuePhong.getMaNhanVien()), HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd HH:mm", thuePhong.getNgayTao()), HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd HH:mm", thuePhong.getNgayDen()), HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd HH:mm", thuePhong.getNgayDi()), thuePhong.getCMND(), thuePhong.getTenKhachHang(), thuePhong.getSoLuong(), thuePhong.getGhiChu(), thuePhong.getTienCoc(), thuePhong.getGiamGia(), thuePhong.getTrangThaiThanhToan());
    }

    public static void delete(String maPhieuThue) {
        String sqlDelete = "DELETE FROM ThuePhong WHERE MaPhieuThue = ?";
        HELPER_ConnectSQL.executeUpdate(sqlDelete, maPhieuThue);
    }

    public static void editThuePhong(DTO_ThuePhong thuePhong) {
        String sqlUpdate = "UPDATE ThuePhong SET MaPhong = ?, MaNhanVien = ?, NgayTao = CONVERT(VARCHAR, ?), NgayDen = CONVERT(VARCHAR, ?), NgayDi = CONVERT(VARCHAR, ?), CMND = ?, TenKhachHang = ?, SoLuongKhach = ?, GhiChu = ?, TienCoc = ?, GiamGia = ?, TrangThaiThanhToan = ? WHERE MaPhieuThue = ?";
        HELPER_ConnectSQL.executeUpdate(sqlUpdate, BLL_MaTenLoai.findMaPhong(thuePhong.getMaPhong()), BLL_MaTenLoai.findMaNhanVien(thuePhong.getMaNhanVien()), HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd HH:mm", thuePhong.getNgayTao()), HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd HH:mm", thuePhong.getNgayDen()), null, thuePhong.getCMND(), thuePhong.getTenKhachHang(), thuePhong.getSoLuong(), thuePhong.getGhiChu(), thuePhong.getTienCoc(), thuePhong.getGiamGia(), thuePhong.getTrangThaiThanhToan(), thuePhong.getMaPhieuThue());
    }

    public static void editDatPhong(DTO_ThuePhong thuePhong) {
        String sqlUpdate = "UPDATE ThuePhong SET MaPhong = ?, MaNhanVien = ?, NgayTao = CONVERT(VARCHAR, ?), NgayDen = CONVERT(VARCHAR, ?), NgayDi = CONVERT(VARCHAR, ?), CMND = ?, TenKhachHang = ?, SoLuongKhach = ?, GhiChu = ?, TienCoc = ?, GiamGia = ?, TrangThaiThanhToan = ? WHERE MaPhieuThue = ?";
        HELPER_ConnectSQL.executeUpdate(sqlUpdate, BLL_MaTenLoai.findMaPhong(thuePhong.getMaPhong()), BLL_MaTenLoai.findMaNhanVien(thuePhong.getMaNhanVien()), HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd HH:mm", thuePhong.getNgayTao()), HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd HH:mm", thuePhong.getNgayDen()), HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd HH:mm", thuePhong.getNgayDi()), thuePhong.getCMND(), thuePhong.getTenKhachHang(), thuePhong.getSoLuong(), thuePhong.getGhiChu(), thuePhong.getTienCoc(), thuePhong.getGiamGia(), thuePhong.getTrangThaiThanhToan(), thuePhong.getMaPhieuThue());
    }

    public static ResultSet select(String maPhong) {
        String sqlSelect = "SELECT * FROM ThuePhong WHERE MaPhong = ? AND TrangThaiThanhToan = 0";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, maPhong);
    }

    public static ResultSet count(String thoiGian) {
        String sqlSelect = "SELECT COUNT(*) FROM ThuePhong WHERE MaPhieuThue LIKE ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, "%" + thoiGian + "%");
    }

    public static ResultSet count() {
        String sqlSelect = "SELECT COUNT(*) FROM ThuePhong";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }

    public static ResultSet rowNumber(int index) {
        String sqlSelect = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER(ORDER BY MaPhieuThue) AS RowNumber FROM ThuePhong) AS ThuePhong JOIN Phong ON Phong.MaPhong = ThuePhong.MaPhong WHERE ThuePhong.RowNumber = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, index);
    }

    public static void setTrangThaiPhong(String maTrangThaiPhong, String maPhong) {
        String sqlUpdate = "UPDATE Phong SET MaTrangThaiPhong = ? WHERE MaPhong = ?";
        HELPER_ConnectSQL.executeUpdate(sqlUpdate, maTrangThaiPhong, maPhong);
    }

    public static void setTrangThaiPhong(String maTrangThaiPhong, int index) {
        String sqlUpdate = "UPDATE Phong SET Phong.MaTrangThaiPhong = ? FROM (SELECT *, ROW_NUMBER() OVER(ORDER BY TenPhong) AS RowNumber FROM Phong) AS Phong WHERE Phong.RowNumber = ?";
        HELPER_ConnectSQL.executeUpdate(sqlUpdate, maTrangThaiPhong, index);
    }

    public static void setTrangThaiThanhToan(int index) {
        String sqlUpdate = "UPDATE ThuePhong SET TrangThaiThanhToan = 1 FROM (SELECT *, ROW_NUMBER() OVER(ORDER BY TenPhong) AS RowNumber FROM Phong) AS Phong JOIN ThuePhong ON ThuePhong.MaPhong = Phong.MaPhong WHERE Phong.RowNumber = ?";
        HELPER_ConnectSQL.executeUpdate(sqlUpdate, index);
    }
}

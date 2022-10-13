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
        String sqlSelect = "INSERT INTO ThuePhong VALUES (?, ?, ?, CONVERT(VARCHAR, ?), CONVERT(VARCHAR, ?), CONVERT(VARCHAR, ?), ?, ?, ?, ?, ?, ?, ?)";
        String sqlUpdate = "UPDATE Phong SET MaTrangThaiPhong = 'CoKhach' WHERE MaPhong = ?";
        HELPER_ConnectSQL.executeUpdate(sqlSelect, BLL_MaTenLoai.findMaPhong(thuePhong.getMaPhong()), thuePhong.getMaPhieuThue(), BLL_MaTenLoai.findMaNhanVien(thuePhong.getMaNhanVien()), HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd HH:mm", thuePhong.getNgayTao()), HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd HH:mm", thuePhong.getNgayDen()), null, thuePhong.getCMND(), thuePhong.getTenKhachHang(), thuePhong.getSoLuong(), thuePhong.getGhiChu(), thuePhong.getTienCoc(), thuePhong.getGiamGia(), thuePhong.getTrangThaiThanhToan());
        HELPER_ConnectSQL.executeUpdate(sqlUpdate, BLL_MaTenLoai.findMaPhong(thuePhong.getMaPhong()));    
    }

    public static void delete(String maPhieuThue) {
        String sqlDelete = "DELETE FROM ThuePhong WHERE MaPhieuThue = ?";
        HELPER_ConnectSQL.executeUpdate(sqlDelete, maPhieuThue);
    }

    public static void edit(DTO_ThuePhong thuePhong) {
        String sqlUpdate = "UPDATE ThuePhong SET MaPhong = ?, MaNhanVien = ?, CONVERT(VARCHAR, NgayTao = ?), CONVERT(VARCHAR, NgayDen = ?), CONVERT(VARCHAR, NgayDi = ?), CMND = ?, TenKhachHang = ?, SoLuongKhach = ?, GhiChu = ?, TienCoc = ?, GiamGia = ?, TrangThaiThanhToan = ? WHERE MaPhieuThue = ?";
        HELPER_ConnectSQL.executeUpdate(sqlUpdate, BLL_MaTenLoai.findMaPhong(thuePhong.getMaPhong()), thuePhong.getMaNhanVien(), HELPER_ChuyenDoi.getNgayString("dd-MM-yyyy HH:mm", thuePhong.getNgayTao()), HELPER_ChuyenDoi.getNgayString("dd-MM-yyyy HH:mm", thuePhong.getNgayDen()), HELPER_ChuyenDoi.getNgayString("dd-MM-yyyy HH:mm", thuePhong.getNgayDi()), thuePhong.getCMND(), thuePhong.getTenKhachHang(), thuePhong.getSoLuong(), thuePhong.getGhiChu(), thuePhong.getTienCoc(), thuePhong.getGiamGia(), thuePhong.getTrangThaiThanhToan(), thuePhong.getMaPhieuThue());
    }

    public static ResultSet select(String maPhong) {
        String sqlSelect = "SELECT * FROM ThuePhong JOIN Phong ON Phong.MaPhong = ThuePhong.MaPhong WHERE Phong.MaPhong = ? AND TrangThaiThanhToan = 0 ORDER BY MaPhieuThue";
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
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.BLL_MaTenLoai;
import DTO.DTO_PhieuChi;
import DTO.DTO_SanPham;
import HELPER.HELPER_ChuyenDoi;
import HELPER.HELPER_ConnectSQL;
import java.sql.*;
import java.util.Date;

/**
 *
 * @author Trung Thanh
 */
public class DAL_PhieuChi {

    public static ResultSet select() {
        String sqlSelect = "SELECT * FROM PhieuChi ORDER BY MaPhieuChi";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }

    public static void add(DTO_PhieuChi phieuChi) {
        String sqlInsert = "INSERT INTO PhieuChi VALUES(?, ?, ?, ?, ?, CONVERT(VARCHAR, ?), ?)";
        HELPER_ConnectSQL.executeUpdate(sqlInsert, phieuChi.getMaPhieuChi(), BLL_MaTenLoai.findMaLoaiTienChi(phieuChi.getMaLoaiTienChi()), phieuChi.getTienChi(), BLL_MaTenLoai.findMaPhuongThuc(phieuChi.getMaPhuongThuc()), phieuChi.getGhiChu(), HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd HH:mm", phieuChi.getNgayTao()), BLL_MaTenLoai.findMaNhanVien(phieuChi.getMaNhanVien()));
    }

    public static void edit(DTO_PhieuChi phieuChi) {
        String sqlUpdate = "UPDATE PhieuChi SET MaLoaiTienChi = ?, TienChi = ?, MaPhuongThuc = ?, GhiChu = ?, CONVERT(VARCHAR, ?), MaNhanVien = ? WHERE MaPhieuChi = ?";
        HELPER_ConnectSQL.executeUpdate(sqlUpdate, BLL_MaTenLoai.findMaLoaiTienChi(phieuChi.getMaLoaiTienChi()), phieuChi.getTienChi(), BLL_MaTenLoai.findMaPhuongThuc(phieuChi.getMaPhuongThuc()), phieuChi.getGhiChu(), HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd HH:mm", phieuChi.getNgayTao()), BLL_MaTenLoai.findMaNhanVien(phieuChi.getMaNhanVien()), phieuChi.getMaPhieuChi());
    }

    public static void delete(String maPhieuChi) {
        String sqlDelete = "DELETE FROM PhieuChi WHERE MaPhieuChi = ?";
        HELPER_ConnectSQL.executeUpdate(sqlDelete, maPhieuChi);
    }
    
    public static ResultSet rowNumber(int index) {
        String sqlSelect = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER(ORDER BY MaPhieuChi) AS RowNumber FROM PhieuChi) AS PhieuChi WHERE PhieuChi.RowNumber = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, index);
    }
    
    public static ResultSet count() {
        String sqlSelect = "SELECT COUNT(*) FROM PhieuChi";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }
}

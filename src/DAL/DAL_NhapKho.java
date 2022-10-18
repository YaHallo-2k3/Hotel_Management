/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.BLL_MaTenLoai;
import DTO.DTO_NhapKho;
import HELPER.HELPER_ChuyenDoi;
import HELPER.HELPER_ConnectSQL;
import java.sql.ResultSet;

/**
 *
 * @author CherryCe
 */
public class DAL_NhapKho {

    public static void add(DTO_NhapKho nhapKho) {
        String sqlInsert = "INSERT INTO NhapKho VALUES (?, ?, CONVERT(VARCHAR, ?), ?)";
        HELPER_ConnectSQL.executeUpdate(sqlInsert, nhapKho.getMaNhapKho(), BLL_MaTenLoai.findMaNhanVien(nhapKho.getMaNhanVien()), HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd HH:mm", nhapKho.getNgayTao()), nhapKho.getGhiChu());
    }

    public static void delete(String maNhapKho) {
        String sqlDelete = "DELETE FROM NhapKho WHERE MaNhapKho = ?";
        HELPER_ConnectSQL.executeUpdate(sqlDelete, maNhapKho, maNhapKho);
    }

    public static void edit(DTO_NhapKho nhapKho) {
        String sqlUpdate = "UPDATE NhapKho SET MaNhanVien = ?, NgayTao = CONVERT(VARCHAR, ?), GhiChu = ? WHERE MaNhapKho = ?";
        HELPER_ConnectSQL.executeUpdate(sqlUpdate, BLL_MaTenLoai.findMaNhanVien(nhapKho.getMaNhanVien()), HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd", nhapKho.getNgayTao()), nhapKho.getGhiChu(), nhapKho.getMaNhapKho());
    }

    public static ResultSet select(String maNhapKho) {
        String sqlSelect = "SELECT * FROM NhapKho WHERE MaNhapKho = ? ORDER BY MaNhapKho";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, maNhapKho);
    }

    public static ResultSet count() {
        String sqlSelect = "SELECT COUNT(*) FROM Nhapkho";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }

    public static ResultSet count(String thoiGian) {
        String sqlSelect = "SELECT COUNT(*) FROM Nhapkho WHERE MaNhapKho LIKE ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, "%" + thoiGian + "%");
    }
    
    public static ResultSet rowNumber(int index) {
        String sqlSelect = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER(ORDER BY MaNhapKho) AS RowNumber FROM NhapKho) AS NhapKho WHERE NhapKho.RowNumber = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, index);
    }
}

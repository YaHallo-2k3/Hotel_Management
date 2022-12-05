/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.BLL_MaTenLoai;
import DTO.DTO_DichVu;
import HELPER.HELPER_ChuyenDoi;
import HELPER.HELPER_ConnectSQL;
import java.sql.ResultSet;

/**
 *
 * @author CherryCe
 */
public class DAL_DichVu {

    public static void add(DTO_DichVu dichVu) {
        String sqlInsert = "INSERT INTO PhieuDichVu VALUES (?, ?, ?, CONVERT(VARCHAR, ?), ?)";
        HELPER_ConnectSQL.executeUpdate(sqlInsert, dichVu.getMaPhieuDichVu(), BLL_MaTenLoai.findMaPhong(dichVu.getMaPhong()), BLL_MaTenLoai.findMaNhanVien(dichVu.getMaNhanVien()), HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd HH:mm", dichVu.getNgayTao()), dichVu.getGhiChu());
    }

    public static void delete(String maPhieuDichVu) {
        String sqlDelete = "DELETE FROM PhieuDichVu WHERE MaPhieuDichVu = ?";
        HELPER_ConnectSQL.executeUpdate(sqlDelete, maPhieuDichVu);
    }

    public static ResultSet countSearch(String tuNgay, String denNgay) {
        String sqlSelect = "SELECT COUNT(*) FROM PhieuDichVu WHERE CONVERT(DATE, NgayTao) BETWEEN ? AND ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, tuNgay, denNgay);
    }

    public static ResultSet count(String thoiGian) {
        String sqlSelect = "SELECT COUNT(*) FROM PhieuDichVu WHERE MaPhieuDichVu LIKE ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, "%" + thoiGian + "%");
    }

    public static ResultSet search(String tuNgay, String denNgay, int index) {
        String sqlSelect = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER(PARTITION BY CONVERT(DATE, NgayTao) ORDER BY MaPhieuDichVu) AS RowNumber FROM PhieuDichVu) AS PhieuDichVu WHERE CONVERT(DATE, NgayTao) BETWEEN ? AND ? AND PhieuDichVu.RowNumber = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, tuNgay, denNgay, index);
    }

    public static ResultSet money(String tuNgay, String denNgay) {
        String sqlSelect = "SELECT SUM(SoLuongBan * GiaTien) FROM ChiTietDichVu JOIN PhieuDichVu ON PhieuDichVu.MaPhieuDichVu = ChiTietDichVu.MaPhieuDichVu WHERE CONVERT(DATE, NgayTao) BETWEEN ? AND ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, tuNgay, denNgay);
    }
}

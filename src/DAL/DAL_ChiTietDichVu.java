/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.DTO_ChiTietDichVu;
import HELPER.HELPER_ConnectSQL;
import java.sql.ResultSet;

/**
 *
 * @author CherryCe
 */
public class DAL_ChiTietDichVu {

    public static void add(DTO_ChiTietDichVu chiTietDichVu) {
        String sqlInsert = "INSERT INTO ChiTietDichVu VALUES (?, ?, ?, ?, ?)";
        HELPER_ConnectSQL.executeUpdate(sqlInsert, chiTietDichVu.getMaChiTiet(), chiTietDichVu.getMaPhieuDichVu(), chiTietDichVu.getMaSanPham(), chiTietDichVu.getSoLuong(), chiTietDichVu.getGiaTien());
    }

    public static void delete(String maDichVu, String maSanPham) {
        String sqlDelete = "DELETE FROM ChiTietDichVu WHERE MaPhieuDichVu = ? AND MaSanPham = ?";
        HELPER_ConnectSQL.executeUpdate(sqlDelete, maDichVu, maSanPham);
    }

    public static void edit(int soLuong, String maSanPham, String maPhieuDichVu) {
        String sqlInsert = "UPDATE ChiTietDichVu SET SoLuongBan = ? WHERE MaSanPham = ? AND MaPhieuDichVu = ?";
        HELPER_ConnectSQL.executeUpdate(sqlInsert, soLuong, maSanPham, maPhieuDichVu);
    }

    public static ResultSet select(String maPhieuDichVu) {
        String sqlSelect = "SELECT * FROM ChiTietDichVu WHERE MaPhieuDichVu = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, maPhieuDichVu);
    }

    public static ResultSet count() {
        String sqlSelect = "SELECT COUNT(*) FROM ChiTietDichVu";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }

    public static ResultSet count(String thoiGian) {
        String sqlSelect = "SELECT COUNT(*) FROM ChiTietDichVu WHERE MaPhieuDichVu LIKE ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, "%" + thoiGian + "%");
    }

    public static ResultSet rowNumber(int index) {
        String sqlSelect = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER(ORDER BY MaChiTiet) AS RowNumber FROM ChiTietDichVu) AS ChiTietDichVu  WHERE ChiTietDichVu.RowNumber = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, index);
    }
}

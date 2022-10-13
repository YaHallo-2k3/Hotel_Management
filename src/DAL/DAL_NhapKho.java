/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.DTO_NhapKho;
import HELPER.HELPER_ConnectSQL;
import java.sql.ResultSet;

/**
 *
 * @author CherryCe
 */
public class DAL_NhapKho {
    
    public static void add(DTO_NhapKho nhapKho) {
        String sqlInsert = "INSERT INTO NhapKho VALUES (?, ?, ?, ?)";
        HELPER_ConnectSQL.executeUpdate(sqlInsert, nhapKho.getMaNhapKho(), nhapKho.getMaNhanVien(), nhapKho.getNgayTao(), nhapKho.getGhiChu());
    }

    public static void delete(String maNhapKho) {
        String sqlDelete = "DELETE FROM NhapKho WHERE MaNhapKho = ?";
        HELPER_ConnectSQL.executeUpdate(sqlDelete, maNhapKho, maNhapKho);
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
}

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
public class DAL_ThuNgan {

    public static ResultSet countThuePhong(String tuNgay, String denNgay) {
        String sqlSelect = "SELECT COUNT(*) FROM ThuePhong WHERE CONVERT(DATE, NgayDi) BETWEEN ? AND ? AND TrangThaiThanhToan = 1 OR NgayDi IS NOT NULL";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, tuNgay, denNgay);
    }
    
    public static ResultSet countTienCoc(String tuNgay, String denNgay) {
        String sqlSelect = "SELECT COUNT(*) FROM ThuePhong WHERE CONVERT(DATE, NgayTao) BETWEEN ? AND ? AND TienCoc != 0";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, tuNgay, denNgay);
    }

    public static ResultSet countDichVu(String tuNgay, String denNgay) {
        String sqlSelect = "SELECT COUNT(*) FROM PhieuDichVu WHERE CONVERT(DATE, NgayTao) BETWEEN ? AND ? AND TrangThaiThanhToan = 1";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, tuNgay, denNgay);
    }

    public static ResultSet rowNumberThuePhong(String tuNgay, String denNgay, int index) {
        String sqlSelect = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER(ORDER BY MaPhieuThue) AS RowNumber FROM ThuePhong WHERE CONVERT(DATE, NgayDi) BETWEEN ? AND ? AND TrangThaiThanhToan = 1 OR NgayDi IS NOT NULL) AS ThuePhong JOIN Phong ON Phong.MaPhong = ThuePhong.MaPhong WHERE ThuePhong.RowNumber = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, tuNgay, denNgay, index);
    }
    
    public static ResultSet rowNumberTienCoc(String tuNgay, String denNgay, int index) {
        String sqlSelect = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER(ORDER BY MaPhieuThue) AS RowNumber FROM ThuePhong WHERE CONVERT(DATE, NgayTao) BETWEEN ? AND ? AND TienCoc != 0) AS ThuePhong JOIN Phong ON Phong.MaPhong = ThuePhong.MaPhong WHERE ThuePhong.RowNumber = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, tuNgay, denNgay, index);
    }
    
    public static ResultSet rowNumberDichVu(String tuNgay, String denNgay, int index) {
        String sqlSelect = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER(ORDER BY MaPhieuDichVu) AS RowNumber FROM PhieuDichVu WHERE CONVERT(DATE, NgayTao) BETWEEN ? AND ? AND TrangThaiThanhToan = 1) AS PhieuDichVu WHERE PhieuDichVu.RowNumber = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, tuNgay, denNgay, index);
    }
}

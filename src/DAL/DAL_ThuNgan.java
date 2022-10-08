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

    public static ResultSet select(String maPhong, String maTrangThaiPhong) {
        String sqlSelect = "SELECT * FROM ThuePhong JOIN Phong ON Phong.MaPhong = ThuePhong.MaPhong WHERE Phong.MaPhong = ? AND MaTrangThaiPhong = ? ORDER BY MaPhieuThue";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, maPhong, maTrangThaiPhong);
    }
    
    public static ResultSet count() {
        String sqlSelect = "SELECT COUNT(*) FROM ThuePhong";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }
    
    public static ResultSet rowNumber(int index) {
        String sqlSelect = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER(ORDER BY MaPhieuThue) AS RowNumber FROM ThuePhong) AS ThuePhong JOIN Phong ON Phong.MaPhong = ThuePhong.MaPhong WHERE ThuePhong.RowNumber = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, index);
    }
}

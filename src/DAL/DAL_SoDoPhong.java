/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.BLL_MaTenLoai;
import HELPER.HELPER_ConnectSQL;
import java.sql.ResultSet;

/**
 *
 * @author CherryCe
 */
public class DAL_SoDoPhong {

    public static ResultSet select() {
        String sqlSelect = "SELECT * FROM Phong";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }

    public static ResultSet count() {
        String sqlSelect = "SELECT COUNT(*) FROM Phong";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }

    public static ResultSet rowNumber(int index) {
        String sqlSelect = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER(ORDER BY TenPhong) AS RowNumber FROM Phong) AS Phong WHERE Phong.RowNumber = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, index);
    }
    
    public static ResultSet selectThoiGian(String tenPhong) {
        String sqlSelect = "SELECT * FROM ThuePhong JOIN Phong ON Phong.MaPhong = ThuePhong.MaPhong WHERE ThuePhong.MaPhong = ? AND MaTrangThaiPhong NOT LIKE 'PhongTrong'";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, BLL_MaTenLoai.findMaPhong(tenPhong));
    }
}

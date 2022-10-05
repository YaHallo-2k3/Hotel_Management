/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.BLL_MaTenLoai;
import DTO.DTO_Phong;
import HELPER.HELPER_ConnectSQL;
import java.sql.ResultSet;

/**
 *
 * @author CherryCe
 */
public class DAL_Phong {

    public static void add(DTO_Phong phong) {
        String sqlSelect = "INSERT INTO Phong VALUES (?, ?, ?, ?, ?)";
        HELPER_ConnectSQL.executeUpdate(sqlSelect, phong.getMaPhong(), phong.getTenPhong(), BLL_MaTenLoai.findMaTang(phong.getMaTang()), BLL_MaTenLoai.findMaLoaiPhong(phong.getMaLoaiPhong()), BLL_MaTenLoai.findMaTrangThaiPhong(phong.getMaTrangThaiPhong()));
    }

    public static void delete(String maPhong) {
        String sqlDelete = "DELETE FROM Phong WHERE MaPhong = ?";
        HELPER_ConnectSQL.executeUpdate(sqlDelete, maPhong);
    }

    public static void edit(DTO_Phong phong) {
        String sqlUpdate = "UPDATE Phong SET TenPhong = ?, MaTang = ?, MaLoaiPhong = ?, MaTrangThaiPhong = ? WHERE MaPhong = ?";
        HELPER_ConnectSQL.executeUpdate(sqlUpdate, phong.getTenPhong(), BLL_MaTenLoai.findMaTang(phong.getMaTang()), BLL_MaTenLoai.findMaLoaiPhong(phong.getMaLoaiPhong()), BLL_MaTenLoai.findMaTrangThaiPhong(phong.getMaTrangThaiPhong()), phong.getMaPhong());
    }

    public static ResultSet select() {
        String sqlSelect = "SELECT * FROM Phong ORDER BY MaPhong";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }
}

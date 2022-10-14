/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import HELPER.HELPER_ConnectSQL;
import java.sql.ResultSet;

/**
 *
 * @author CherryCe
 */
public class DAL_TonKho {
    public static ResultSet select() {
        String sqlSelect = "SELECT * FROM SanPham JOIN ChiTietNhapkho ON ChiTietNhapkho.MaSanPham = SanPham.MaSanPham";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL_MaTenLoai;
import DAL.DAL_Phong;
import DAL.DAL_SoDoPhong;
import DTO.DTO_Phong;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CherryCe
 */
public class BLL_SoDoPhong {

    public static int countPhong() {
        ResultSet rs = DAL_SoDoPhong.count();
        try {
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static ArrayList<DTO_Phong> select(int index) {
        ResultSet rs = DAL_SoDoPhong.rowNumber(index);
        ArrayList<DTO_Phong> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_Phong phong = new DTO_Phong();
                phong.setSTT(rs.getInt("STT"));
                phong.setMaPhong(rs.getString("MaPhong"));
                phong.setTenPhong(rs.getString("TenPhong"));
                phong.setMaTang(rs.getString("MaTang"));
                phong.setMaLoaiPhong(rs.getString("MaLoaiPhong"));
                phong.setMaTrangThaiPhong(rs.getString("MaTrangThaiPhong"));
                array.add(phong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static void load(ArrayList<DTO_Phong> array, JLabel lblSetPhong, JLabel lblSetLoaiPhong, JLabel lblSetTrangThaiPhong) {
        for (DTO_Phong phong : array) {
            lblSetPhong.setText(phong.getTenPhong());
            lblSetLoaiPhong.setText(BLL_MaTenLoai.findTenLoaiPhong(phong.getMaLoaiPhong()));
            lblSetTrangThaiPhong.setText(BLL_MaTenLoai.findTenTrangThaiPhong(phong.getMaTrangThaiPhong()));
        }
    }

    public static void loadThongTinPhong(ArrayList<DTO_Phong> array, JLabel lblSetSo_LoaiPhong, JLabel lblSetTrangThaiPhong) {
        for (DTO_Phong phong : array) {
            lblSetSo_LoaiPhong.setText(phong.getTenPhong() + " - " + BLL_MaTenLoai.findTenLoaiPhong(phong.getMaLoaiPhong()));
            lblSetTrangThaiPhong.setText(BLL_MaTenLoai.findTenTrangThaiPhong(phong.getMaTrangThaiPhong()));
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.DAL_MaTenLoai;
import DAL.DAL_SoTang;
import DTO.DTO_LoaiPhong;
import DTO.DTO_MaTenLoai;
import DTO.DTO_SoTang;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CherryCe
 */
public class BLL_MaTenLoai {

    public static ArrayList<DTO_SoTang> selectTenTang() {
        ResultSet rs = DAL_MaTenLoai.selectTenTang();
        ArrayList<DTO_SoTang> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_SoTang soTang = new DTO_SoTang();
                soTang.setTenTang(rs.getString("TenTang"));
                array.add(soTang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static void loadTenTang(ArrayList<DTO_SoTang> array, JComboBox cbo) {
        DefaultComboBoxModel cboModel = (DefaultComboBoxModel) cbo.getModel();
        cboModel.removeAllElements();
        for (DTO_SoTang soTang : array) {
            Object obj = soTang.getTenTang();
            cboModel.addElement(obj);
        }
    }

    public static String findTenTang(String maTang) {
        ResultSet rs = DAL_MaTenLoai.findTenTang(maTang);
        try {
            while (rs.next()) {
                return rs.getString("TenTang");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String findMaTang(String tenTang) {
        ResultSet rs = DAL_MaTenLoai.findMaTang(tenTang);
        try {
            while (rs.next()) {
                return rs.getString("MaTang");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<DTO_LoaiPhong> selectTenLoaiPhong() {
        ResultSet rs = DAL_MaTenLoai.selectTenLoaiPhong();
        ArrayList<DTO_LoaiPhong> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_LoaiPhong loaiPhong = new DTO_LoaiPhong();
                loaiPhong.setTenPhong(rs.getString("TenLoaiPhong"));
                array.add(loaiPhong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static void loadTenLoaiPhong(ArrayList<DTO_LoaiPhong> array, JComboBox cbo) {
        DefaultComboBoxModel cboModel = (DefaultComboBoxModel) cbo.getModel();
        cboModel.removeAllElements();
        for (DTO_LoaiPhong loaiPhong : array) {
            Object obj = loaiPhong.getTenPhong();
            cboModel.addElement(obj);
        }
    }

    public static String findTenLoaiPhong(String maLoaiPhong) {
        ResultSet rs = DAL_MaTenLoai.findTenLoaiPhong(maLoaiPhong);
        try {
            while (rs.next()) {
                return rs.getString("TenLoaiPhong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String findMaLoaiPhong(String tenLoaiPhong) {
        ResultSet rs = DAL_MaTenLoai.findMaLoaiPhong(tenLoaiPhong);
        try {
            while (rs.next()) {
                return rs.getString("MaLoaiPhong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String findTenTrangThaiPhong(String maTrangThaiPhong) {
        ResultSet rs = DAL_MaTenLoai.findTenTrangThaiPhong(maTrangThaiPhong);
        try {
            while (rs.next()) {
                return rs.getString("TenTrangThaiPhong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String findMaTrangThaiPhong(String tenTrangThaiPhong) {
        ResultSet rs = DAL_MaTenLoai.findMaTrangThaiPhong(tenTrangThaiPhong);
        try {
            while (rs.next()) {
                return rs.getString("MaTrangThaiPhong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String findTenPhong(String maPhong) {
        ResultSet rs = DAL_MaTenLoai.findTenPhong(maPhong);
        try {
            while (rs.next()) {
                return rs.getString("TenPhong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String findMaPhong(String tenPhong) {
        ResultSet rs = DAL_MaTenLoai.findMaPhong(tenPhong);
        try {
            while (rs.next()) {
                return rs.getString("MaPhong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

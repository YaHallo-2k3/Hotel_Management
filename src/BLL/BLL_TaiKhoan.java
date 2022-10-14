/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import static BLL.BLL_NhanVien.alreayExits;
import DAL.DAL_TaiKhoan;
import DTO.DTO_LoaiPhong;
import DTO.DTO_TaiKhoan;
import java.sql.ResultSet;
import java.util.ArrayList;
import javafx.scene.control.ComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CherryCe
 */
public class BLL_TaiKhoan {
    
    public static boolean check(DTO_TaiKhoan taiKhoan) {
        if (taiKhoan.getMaTaiKhoan().isEmpty() || taiKhoan.getMaNhanVien().isEmpty() || taiKhoan.getTenDangNhap().isEmpty() || taiKhoan.getMatKhau().isEmpty() || taiKhoan.getCauHoi().isEmpty() || taiKhoan.getTraLoi().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    
    public static boolean alreayExits(String data, String value) {
        ResultSet rs = DAL_TaiKhoan.select();
        ArrayList<String> array = new ArrayList<>();
        try {
            while (rs.next()) {
                array.add(rs.getString(data));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < array.size(); i++) {
            if (value.equals(array.get(i))) {
                return false;
            }
        }
        return true;
    }
    
    public static void add(DTO_TaiKhoan taiKhoan) {
        if (!check(taiKhoan)) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else if (!alreayExits("MaTaiKhoan", taiKhoan.getMaTaiKhoan())) {
            JOptionPane.showMessageDialog(null, "Giá Trị Đã Tồn Tại !!!");
        } else {
            DAL_TaiKhoan.add(taiKhoan);
            JOptionPane.showMessageDialog(null, "Cập Nhật Hoàn Tất !!!");
        }
    }
    
    public static void delete(String maNhanVien) {
        try {
            DAL_TaiKhoan.delete(maNhanVien);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Đang Được Sử Dụng !!!");
        }
    }
    
    public static void edit(DTO_TaiKhoan taiKhoan) {
        if (!check(taiKhoan)) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else if (!alreayExits("MaTaiKhoan", taiKhoan.getMaTaiKhoan())) {
            JOptionPane.showMessageDialog(null, "Giá Trị Đã Tồn Tại !!!");
        } else {
            DAL_TaiKhoan.edit(taiKhoan);
            JOptionPane.showMessageDialog(null, "Cập Nhật Hoàn Tất !!!");
        }
    }
    
    public static ArrayList<DTO_TaiKhoan> select(String tenDangNhap, String matKhau) {
        ResultSet rs = DAL_TaiKhoan.select(tenDangNhap, matKhau);
        ArrayList<DTO_TaiKhoan> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_TaiKhoan taiKhoan = new DTO_TaiKhoan();
                taiKhoan.setMaTaiKhoan(rs.getString("MaTaiKhoan"));
                taiKhoan.setMaNhanVien(rs.getString("MaNhanVien"));
                taiKhoan.setTenDangNhap(rs.getString("TenDangNhap"));
                taiKhoan.setMatKhau(rs.getString("MatKhau"));
                taiKhoan.setCauHoi(rs.getString("CauHoi"));
                taiKhoan.setCauHoi(rs.getString("TraLoi"));
                taiKhoan.setCheckDangNhap(rs.getInt("CheckDangNhap"));
                array.add(taiKhoan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }
    
    public static ArrayList<DTO_TaiKhoan> select(String maNhanvien) {
        ResultSet rs = DAL_TaiKhoan.select(maNhanvien);
        ArrayList<DTO_TaiKhoan> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_TaiKhoan taiKhoan = new DTO_TaiKhoan();
                taiKhoan.setMaTaiKhoan(rs.getString("MaTaiKhoan"));
                taiKhoan.setMaNhanVien(rs.getString("MaNhanVien"));
                taiKhoan.setTenDangNhap(rs.getString("TenDangNhap"));
                taiKhoan.setMatKhau(rs.getString("MatKhau"));
                taiKhoan.setCauHoi(rs.getString("CauHoi"));
                taiKhoan.setTraLoi(rs.getString("TraLoi"));
                taiKhoan.setCheckDangNhap(rs.getInt("CheckDangNhap"));
                array.add(taiKhoan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }
    
    public static void load(ArrayList<DTO_TaiKhoan> array, JLabel lblMaTaiKhoan, JTextField txtTenDangNhap, JPasswordField psdMatKhau, JComboBox cboCauHoi, JTextField txtTraLoi) {
        for (DTO_TaiKhoan taiKhoan : array) {
            lblMaTaiKhoan.setText(taiKhoan.getMaTaiKhoan());
            txtTenDangNhap.setText(taiKhoan.getTenDangNhap());
            psdMatKhau.setText(taiKhoan.getMatKhau());
            cboCauHoi.setSelectedItem(taiKhoan.getCauHoi());
            txtTraLoi.setText(taiKhoan.getTraLoi());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL_ThuePhong;
import DTO.DTO_ThuePhong;
import HELPER.HELPER_ChuyenDoi;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CherryCe
 */
public class BLL_ThuePhong {

    public static void add(DTO_ThuePhong thuePhong) {
        DAL_ThuePhong.add(thuePhong);
    }

    public static void delete(String maPhieuThue) {
        DAL_ThuePhong.delete(maPhieuThue);
    }

    public static void edit(DTO_ThuePhong thuePhong) {
        DAL_ThuePhong.edit(thuePhong);
    }

    public static ArrayList<DTO_ThuePhong> select(String maPhong, String maTrangThaiPhong) {
        ResultSet rs = DAL_ThuePhong.select(maPhong, maTrangThaiPhong);
        ArrayList<DTO_ThuePhong> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_ThuePhong thuePhong = new DTO_ThuePhong();
                thuePhong.setMaPhong(rs.getString("MaPhong"));
                thuePhong.setMaPhieuThue(rs.getString("MaPhieuThue"));
                thuePhong.setMaNhanVien(rs.getString("MaNhanVien"));
                thuePhong.setNgayTao(rs.getTimestamp("NgayTao"));
                thuePhong.setNgayDen(rs.getTimestamp("NgayDen"));
                thuePhong.setNgayDi(rs.getTimestamp("NgayDi"));
                thuePhong.setCMND(rs.getString("CMND"));
                thuePhong.setTenKhachHang(rs.getString("TenKhachHang"));
                thuePhong.setSoLuong(rs.getInt("SoLuongKhach"));
                thuePhong.setGhiChu(rs.getString("GhiChu"));
                thuePhong.setTienCoc(rs.getInt("TienCoc"));
                thuePhong.setGiamGia(rs.getInt("GiamGia"));
                thuePhong.setTrangThaiThanhToan(rs.getInt("TrangThaiThanhToan"));
                array.add(thuePhong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static void load(ArrayList<DTO_ThuePhong> array, JLabel lblMaPhieu, JLabel lblNhanVien, JLabel lblNgayTao, JLabel dateNgayDen, JLabel dateNgayDi, JTextField txtCMND, JTextField txtTenKhach, JTextField txtSoLuong, JTextField txtGhiChu, JTextField txtGiamGia, JTextField txtTienCoc) {
        for (DTO_ThuePhong thuePhong : array) {
            lblMaPhieu.setText(thuePhong.getMaPhieuThue());
            lblNhanVien.setText(BLL_MaTenLoai.findTenNhanVien(thuePhong.getMaNhanVien()));
            lblNgayTao.setText(HELPER_ChuyenDoi.getNgayString("dd-MM-yy HH:mm", thuePhong.getNgayTao()));
            dateNgayDen.setText(HELPER_ChuyenDoi.getNgayString("dd-MM-yyyy HH:mm", thuePhong.getNgayDen()));
            dateNgayDi.setText(HELPER_ChuyenDoi.getNgayString("dd-MM-yyyy HH:mm", HELPER_ChuyenDoi.getNgayDate("dd/MM/yyyy HH:mm", HELPER_ChuyenDoi.getTimeNow("dd/MM/yyyy HH:mm"))));
            txtCMND.setText(thuePhong.getCMND());
            txtTenKhach.setText(thuePhong.getTenKhachHang());
            txtSoLuong.setText(HELPER_ChuyenDoi.getSoString(thuePhong.getSoLuong()));
            txtGhiChu.setText(thuePhong.getGhiChu());
            txtTienCoc.setText(HELPER_ChuyenDoi.getSoString(thuePhong.getTienCoc()));
            txtGiamGia.setText(HELPER_ChuyenDoi.getSoString(thuePhong.getGiamGia()));
        }
    }
}

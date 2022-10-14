/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL_MaTenLoai;
import DAL.DAL_NhanVien;
import DTO.DTO_NhanVien;
import HELPER.HELPER_ChuyenDoi;
import java.awt.Component;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CherryCe
 */
public class BLL_NhanVien {

    public static boolean check(DTO_NhanVien nhanVien) {
        if (nhanVien.getMaNhanVien().isEmpty() || nhanVien.getTenNhanVien().isEmpty() || nhanVien.getNgaySinh() == null || nhanVien.getSoDienThoai().isEmpty() || nhanVien.getCMND().isEmpty() || nhanVien.getMaChucVu().isEmpty() || nhanVien.getLuong() == 0 || nhanVien.getNgayTao() == null) {
            return false;
        }
        return true;
    }

    public static boolean alreayExits(String data, String value) {
        ResultSet rs = DAL_NhanVien.select();
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

    public static void add(DTO_NhanVien nhanVien) {
        if (!check(nhanVien)) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
            return;
        } else if (!alreayExits("MaNhanVien", nhanVien.getMaNhanVien())) {
            JOptionPane.showMessageDialog(null, "Giá Trị Đã Tồn Tại !!!");
        } else {
            DAL_NhanVien.add(nhanVien);
            JOptionPane.showMessageDialog(null, "Cập Nhật Hoàn Tất !!!");
        }
    }

    public static void delete(String maNhanVien) {
        try {
            DAL_NhanVien.delete(maNhanVien);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Đang Được Sử Dụng !!!");
        }
    }

    public static void edit(DTO_NhanVien nhanVien) {
        if (!check(nhanVien)) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else if (!alreayExits("MaNhanVien", nhanVien.getMaNhanVien())) {
            JOptionPane.showMessageDialog(null, "Giá Trị Đã Tồn Tại !!!");
        } else {
            DAL_NhanVien.edit(nhanVien);
            JOptionPane.showMessageDialog(null, "Cập Nhật Hoàn Tất !!!");
        }
    }

    public static ArrayList<DTO_NhanVien> select() {
        ResultSet rs = DAL_NhanVien.select();
        ArrayList<DTO_NhanVien> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_NhanVien nhanVien = new DTO_NhanVien();
                nhanVien.setMaNhanVien(rs.getString("MaNhanVien"));
                nhanVien.setTenNhanVien(rs.getString("TenNhanVien"));
                nhanVien.setGioiTinh(rs.getInt("GioiTinh"));
                nhanVien.setNgaySinh(rs.getDate("NgaySinh"));
                nhanVien.setSoDienThoai(rs.getString("SoDienThoai"));
                nhanVien.setCMND(rs.getString("CMND"));
                nhanVien.setMaChucVu(rs.getString("MaChucVu"));
                nhanVien.setLuong(rs.getInt("Luong"));
                nhanVien.setNgayTao(rs.getTimestamp("NgayTao"));
                nhanVien.setTrangThaiNhanVien(rs.getInt("TrangThaiNhanVien"));
                array.add(nhanVien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public void load(ArrayList<DTO_NhanVien> array, JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        for (DTO_NhanVien nhanVien : array) {
            Object obj[] = new Object[10];
            obj[0] = nhanVien.getMaNhanVien();
            obj[1] = nhanVien.getTenNhanVien();
            obj[2] = nhanVien.getGioiTinh() == 1 ? "Nam" : "Nữ";
            obj[3] = HELPER_ChuyenDoi.getNgayString("dd-MM-yyyy", nhanVien.getNgaySinh());
            obj[4] = nhanVien.getSoDienThoai();
            obj[5] = nhanVien.getCMND();
            obj[6] = nhanVien.getMaChucVu();
            obj[7] = nhanVien.getLuong();
            obj[8] = HELPER_ChuyenDoi.getNgayString("dd-MM-yy HH:mm", nhanVien.getNgayTao());
            obj[9] = nhanVien.getTrangThaiNhanVien() == 1 ? "Online" : "Offline";
            tbl.getColumnModel().getColumn(10).setCellRenderer(new iconAccount());
            tbl.getColumnModel().getColumn(11).setCellRenderer(new iconEdit());
            tbl.getColumnModel().getColumn(12).setCellRenderer(new iconDelete());
            tblModel.addRow(obj);
        }
    }

    public static String nhanVienOnline() {
        ResultSet rs = DAL_NhanVien.nhanVienOnline();
        try {
            while (rs.next()) {
                return rs.getString("TenNhanVien");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public class iconAccount extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setIcon(new ImageIcon("C:\\Users\\CherryCe\\Documents\\NetBeansProjects\\Hotel_Management\\src\\IMG\\profile-user (5).png"));
            setHorizontalAlignment(CENTER);
            return this;
        }
    }

    public class iconEdit extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setIcon(new ImageIcon("C:\\Users\\CherryCe\\Documents\\NetBeansProjects\\Hotel_Management\\src\\IMG\\edit.png"));
            setHorizontalAlignment(CENTER);
            return this;
        }
    }

    public class iconDelete extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setIcon(new ImageIcon("C:\\Users\\CherryCe\\Documents\\NetBeansProjects\\Hotel_Management\\src\\IMG\\trash.png"));
            setHorizontalAlignment(CENTER);
            return this;
        }
    }
}

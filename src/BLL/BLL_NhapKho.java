/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL_NhapKho;
import DTO.DTO_NhapKho;
import DTO.DTO_NhapKho;
import HELPER.HELPER_ChuyenDoi;
import java.awt.Component;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CherryCe
 */
public class BLL_NhapKho {

    public static boolean check(DTO_NhapKho nhapKho) {
        if (nhapKho.getMaNhapKho().isEmpty() || nhapKho.getMaNhanVien().isEmpty() || nhapKho.getNgayTao() == null) {
            return false;
        } else {
            return true;
        }
    }

    public static void add(DTO_NhapKho nhapKho) {
        if (!check(nhapKho)) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else {
            DAL_NhapKho.add(nhapKho);
            JOptionPane.showMessageDialog(null, "Cập Nhật Hoàn Tất !!!");
        }
    }

    public static void delete(String maNhapKho) {
        try {
            DAL_NhapKho.delete(maNhapKho);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Đang Được Sử Dụng !!!");
        }
    }

    public static void edit(DTO_NhapKho nhapKho) {
        if (check(nhapKho) == false) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else {
            DAL_NhapKho.edit(nhapKho);
        }
    }

    public static ArrayList<DTO_NhapKho> select(String maNhapKho) {
        ResultSet rs = DAL_NhapKho.select(maNhapKho);
        ArrayList<DTO_NhapKho> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_NhapKho nhapKho = new DTO_NhapKho();
                nhapKho.setMaNhapKho(rs.getString("MaNhapKho"));
                nhapKho.setMaNhanVien(rs.getString("MaNhanVien"));
                nhapKho.setNgayTao(rs.getTimestamp("NgayTao"));
                nhapKho.setGhiChu(rs.getString("GhiChu"));
                array.add(nhapKho);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static ArrayList<DTO_NhapKho> selectNhapKho(int index) {
        ResultSet rs = DAL_NhapKho.rowNumber(index);
        ArrayList<DTO_NhapKho> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_NhapKho nhapKho = new DTO_NhapKho();
                nhapKho.setMaNhapKho(rs.getString("MaNhapKho"));
                nhapKho.setMaNhanVien(rs.getString("MaNhanVien"));
                nhapKho.setNgayTao(rs.getTimestamp("NgayTao"));
                nhapKho.setGhiChu(rs.getString("GhiChu"));
                array.add(nhapKho);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static void loadNhapKho(ArrayList<DTO_NhapKho> array, JLabel lblMaPhieu, JLabel lblMaNhanVien, JLabel lblNgayTao) {
        for (DTO_NhapKho nhapKho : array) {
            lblMaPhieu.setText(nhapKho.getMaNhapKho());
            lblMaNhanVien.setText(BLL_MaTenLoai.findTenNhanVien(nhapKho.getMaNhanVien()));
            lblNgayTao.setText(HELPER_ChuyenDoi.getNgayString("dd-MM-yy HH:mm", nhapKho.getNgayTao()));
        }
    }

    public class iconAdd extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setIcon(new ImageIcon("C:\\Users\\CherryCe\\Documents\\NetBeansProjects\\Hotel_Management\\src\\IMG\\queue.png"));
            setHorizontalAlignment(CENTER);
            return this;
        }
    }

    public static int countNhapKho() {
        ResultSet rs = DAL_NhapKho.count();
        try {
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
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

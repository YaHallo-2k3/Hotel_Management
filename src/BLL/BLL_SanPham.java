/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL_LoaiSanPham;
import DAL.DAL_SanPham;
import DTO.DTO_LoaiSanPham;
import DTO.DTO_SanPham;
import HELPER.HELPER_ChuyenDoi;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Trung Thanh
 */
public class BLL_SanPham {

    public static boolean check(DTO_SanPham sanPham) {
        if (sanPham.getMaSanPham().isEmpty() || sanPham.getTenSanPham().isEmpty() || sanPham.getMaLoaiSanPham().isEmpty() || sanPham.getDonViTinh().isEmpty() || sanPham.getGiaBan() == 0 || sanPham.getNgayTao() == null) {
            return false;
        } else {
            return true;
        }
    }

    public static void add(DTO_SanPham sanPham) {
        if (!check(sanPham)) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else {
            DAL_SanPham.add(sanPham);
        }
    }

    public static void delete(String maSanPham) {
        try {
            DAL_SanPham.delete(maSanPham);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Đang Được Sử Dụng !!!");
        }
    }

    public static void edit(DTO_SanPham sanPham) {
        if (check(sanPham) == false) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else {
            DAL_SanPham.edit(sanPham);
        }
    }

    public static ArrayList<DTO_SanPham> select() {
        ResultSet rs = DAL_SanPham.select();
        ArrayList<DTO_SanPham> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_SanPham sanPham = new DTO_SanPham();
                sanPham.setMaSanPham(rs.getString("MaSanPham"));
                sanPham.setTenSanPham(rs.getString("TensanPham"));
                sanPham.setMaLoaiSanPham(rs.getString("MaLoaiSanPham"));
                sanPham.setDonViTinh(rs.getString("DonViTinh"));
                sanPham.setGiaBan(rs.getInt("GiaBan"));
                sanPham.setNgayTao(rs.getDate("NgayTao"));
                array.add(sanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public void load(ArrayList<DTO_SanPham> array, JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setColumnIdentifiers(new Object[]{"Mã Hàng", "Tên Hàng", "Loại Hàng", "Đơn Vị", "Giá Bán", "Ngày Tạo", "Sửa", "Xóa"});
        tblModel.setRowCount(0);
        for (DTO_SanPham sanPham : array) {
            Object obj[] = new Object[6];
            obj[0] = sanPham.getMaSanPham();
            obj[1] = sanPham.getTenSanPham();
            obj[2] = BLL_MaTenLoai.findTenLoaiSanPham(sanPham.getMaLoaiSanPham());
            obj[3] = sanPham.getDonViTinh();
            obj[4] = sanPham.getGiaBan();
            obj[5] = HELPER_ChuyenDoi.getNgayString("dd-MM-yyyy", sanPham.getNgayTao());
            tbl.getColumnModel().getColumn(6).setCellRenderer(new iconEdit());
            tbl.getColumnModel().getColumn(7).setCellRenderer(new iconDelete());
            tblModel.addRow(obj);
        }
    }

    public void loadPhieuNhap(ArrayList<DTO_SanPham> array, JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setColumnIdentifiers(new Object[]{"Mã Hàng", "Tên Hàng", "Số Lượng", "Giá Nhập", "Thêm"});
        tblModel.setRowCount(0);
        for (DTO_SanPham sanPham : array) {
            Object obj[] = new Object[4];
            obj[0] = sanPham.getMaSanPham();
            obj[1] = sanPham.getTenSanPham();
            obj[2] = 0;
            obj[3] = 0;
            tbl.getColumnModel().getColumn(4).setCellRenderer(new iconAdd());
            tblModel.addRow(obj);
        }
    }

    public class iconAdd extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setIcon(new ImageIcon("C:\\Users\\CherryCe\\Documents\\NetBeansProjects\\Hotel_Management\\src\\IMG\\queue.png"));
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
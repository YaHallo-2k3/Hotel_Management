/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL_ChiTietNhapKho;
import DTO.DTO_ChiTietNhapKho;
import DTO.DTO_SanPham;
import HELPER.HELPER_ChuyenDoi;
import java.awt.Component;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CherryCe
 */
public class BLL_ChiTietNhapKho {

    public static boolean check(DTO_ChiTietNhapKho chiTietNhapKho) {
        if (chiTietNhapKho.getMaChiTietNhapKho().isEmpty() || chiTietNhapKho.getMaNhapKho().isEmpty() || chiTietNhapKho.getMaSanPham().isEmpty() || chiTietNhapKho.getSoLuong() == 0 || chiTietNhapKho.getGiaNhap() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void add(DTO_ChiTietNhapKho chiTietNhapKho) {
        if (!check(chiTietNhapKho)) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Không Được Để Trống !!!");
        } else {
            DAL_ChiTietNhapKho.add(chiTietNhapKho);
        }
    }

    public static void delete(String maNhapKho, String maSanPham) {
        try {
            DAL_ChiTietNhapKho.delete(maNhapKho, maSanPham);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dữ Liệu Đang Được Sử Dụng !!!");
        }
    }

    public static ArrayList<DTO_ChiTietNhapKho> select(String maNhapKho) {
        ResultSet rs = DAL_ChiTietNhapKho.select(maNhapKho);
        ArrayList<DTO_ChiTietNhapKho> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_ChiTietNhapKho chiTietNhapKho = new DTO_ChiTietNhapKho();
                chiTietNhapKho.setMaChiTietNhapKho(rs.getString("MaChiTietNhapKho"));
                chiTietNhapKho.setMaNhapKho(rs.getString("MaNhapKho"));
                chiTietNhapKho.setMaSanPham(rs.getString("MaSanPham"));
                chiTietNhapKho.setSoLuong(rs.getInt("SoLuong"));
                chiTietNhapKho.setGiaNhap(rs.getInt("GiaNhap"));
                array.add(chiTietNhapKho);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }
    
    public static ArrayList<DTO_ChiTietNhapKho> selectChiTietNhapKho(int index) {
        ResultSet rs = DAL_ChiTietNhapKho.rowNumber(index);
        ArrayList<DTO_ChiTietNhapKho> array = new ArrayList<>();
        try {
            while (rs.next()) {
                DTO_ChiTietNhapKho chiTietNhapKho = new DTO_ChiTietNhapKho();
                chiTietNhapKho.setMaChiTietNhapKho(rs.getString("MaChiTietNhapKho"));
                chiTietNhapKho.setMaNhapKho(rs.getString("MaNhapKho"));
                chiTietNhapKho.setMaSanPham(rs.getString("MaSanPham"));
                chiTietNhapKho.setSoLuong(rs.getInt("SoLuong"));
                chiTietNhapKho.setGiaNhap(rs.getInt("GiaNhap"));
                array.add(chiTietNhapKho);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public void load(ArrayList<DTO_ChiTietNhapKho> array, JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setColumnIdentifiers(new Object[]{"Mã Hàng", "Tên Hàng", "Số Lượng", "Đơn Giá", "Thành Tiền", "Xóa"});
        tblModel.setRowCount(0);
        for (DTO_ChiTietNhapKho chiTietNhapKho : array) {
            Object obj[] = new Object[5];
            obj[0] = chiTietNhapKho.getMaSanPham();
            obj[1] = BLL_MaTenLoai.findTenSanPham(chiTietNhapKho.getMaSanPham());
            obj[2] = chiTietNhapKho.getSoLuong();
            obj[3] = chiTietNhapKho.getGiaNhap();
            obj[4] = chiTietNhapKho.getSoLuong() * chiTietNhapKho.getGiaNhap();
            tbl.getColumnModel().getColumn(5).setCellRenderer(new iconDelete());
            tblModel.addRow(obj);
        }
    }
    
    public static void loadChiTietNhapKho(ArrayList<DTO_ChiTietNhapKho> array, JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setColumnIdentifiers(new Object[]{"Tên Hàng", "Số Lượng", "Đơn Giá", "Thành Tiền"});
        tblModel.setRowCount(0);
        for (DTO_ChiTietNhapKho chiTietNhapKho : array) {
            Object obj[] = new Object[4];
            obj[0] = BLL_MaTenLoai.findTenSanPham(chiTietNhapKho.getMaSanPham());
            obj[1] = chiTietNhapKho.getSoLuong();
            obj[2] = chiTietNhapKho.getGiaNhap();
            obj[3] = chiTietNhapKho.getSoLuong() * chiTietNhapKho.getGiaNhap();
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

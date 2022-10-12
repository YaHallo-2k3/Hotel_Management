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
    
    static boolean isMaSanPham(String maSanPham)
    {
        ResultSet rs = DAL_SanPham.SelectByMaSanPham(maSanPham);
        try {
            if(rs.next())
            {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
        static boolean isTenSanPham(String tenSanPham)
    {
        ResultSet rs = DAL_SanPham.SelectByTenSanPham(tenSanPham);
        try {
            if(rs.next())
            {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    static boolean check01(DTO_SanPham dto_SanPham)
    {
        if(dto_SanPham.getMaSanPham().isEmpty() || dto_SanPham.getTenSanPham().isEmpty() || dto_SanPham.getMaLoaiSanPham().isEmpty() || dto_SanPham.getDonViTinh().isEmpty() || dto_SanPham.getGiaBan() < 1)
        {
            JOptionPane.showMessageDialog(null,"Dữ liệu trống",  "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if(!isMaSanPham(dto_SanPham.getMaSanPham()))
        {
            JOptionPane.showMessageDialog(null,"Mã đã tồn tại",  "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if(!isTenSanPham(dto_SanPham.getTenSanPham()))
        {
            JOptionPane.showMessageDialog(null,"Tên đã tồn tại",  "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }
    
    static boolean check02(DTO_SanPham dto_SanPham)
    {
        if(dto_SanPham.getMaSanPham().isEmpty() || dto_SanPham.getTenSanPham().isEmpty() || dto_SanPham.getMaLoaiSanPham().isEmpty() || dto_SanPham.getDonViTinh().isEmpty() || dto_SanPham.getGiaBan() < 1)
        {
            JOptionPane.showMessageDialog(null,"Dữ liệu trống",  "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if(!isTenSanPham(dto_SanPham.getTenSanPham()))
        {
            return false;
        }
        return true;
    }
    
    public static void add(DTO_SanPham dto_SanPham)
    {
        if(check01(dto_SanPham))
        {
        DAL_SanPham.Add(dto_SanPham);
        }
    }
    
    public static void update(DTO_SanPham dto_SanPham)
    {
        if(check02(dto_SanPham))
        {
        DAL_SanPham.Update(dto_SanPham);
        }
    }
    
    public static void delete(String maSanPham)
    {
        DAL_SanPham.Delete(maSanPham);
    }
    
    public static ArrayList<DTO_SanPham> SelectAll()
    {
        ArrayList<DTO_SanPham> arrList = new ArrayList<>();
        ResultSet rs = DAL_SanPham.SelectAll();
        try {
            while(rs.next())
            {
                DTO_SanPham dto_sanPham = new DTO_SanPham();
                dto_sanPham.setMaSanPham(rs.getString("MaSanPham"));
                dto_sanPham.setTenSanPham(rs.getString("TenSanPham"));
                dto_sanPham.setMaLoaiSanPham(rs.getString("MaLoaiSanPham"));
                dto_sanPham.setDonViTinh(rs.getString("DonViTinh"));
                dto_sanPham.setGiaBan(rs.getDouble("GiaBan"));
                arrList.add(dto_sanPham);
            }
            return arrList;
        } catch (SQLException ex) {
            Logger.getLogger(BLL_LoaiSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void fillTableSanPham(JTable tableSanPham)
    {
        ArrayList<DTO_SanPham> arrList = BLL_SanPham.SelectAll();
        DefaultTableModel model = (DefaultTableModel) tableSanPham.getModel();
        model.setRowCount(0);
        for(DTO_SanPham sp : arrList)
        {
            Object obj[] = new Object[7];
            obj[0] = BLL_LoaiSanPham.changeMaLoaiSanPhamToTenLoaiLoaiSanPham(sp.getMaLoaiSanPham());
            obj[1] = sp.getMaSanPham();
            obj[2] = sp.getTenSanPham();
            obj[3] = sp.getDonViTinh();
            obj[4] = sp.getGiaBan();
            tableSanPham.getColumnModel().getColumn(5).setCellRenderer(new BLL_LoaiSanPham.iconEdit());
            tableSanPham.getColumnModel().getColumn(6).setCellRenderer(new BLL_LoaiSanPham.iconDelete());
            model.addRow(obj);
        }
        
    }


    
    static class iconEdit extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setIcon(new ImageIcon("D:\\Github\\Hotel_Management\\src\\IMGedit.png"));
            setHorizontalAlignment(CENTER);
            return this;
        }
    }

    static class iconDelete extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setIcon(new ImageIcon("D:\\Github\\Hotel_Management\\src\\IMGtrash.png"));
            setHorizontalAlignment(CENTER);
            return this;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL_LoaiSanPham;
import DTO.DTO_LoaiSanPham;
import HELPER.MyCombobox;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Trung Thanh
 */
public class BLL_LoaiSanPham {
    
    static boolean isMaLoaiSanPham(String maLoaiSanPham)
    {
        ResultSet rs = DAL_LoaiSanPham.findByMaLoaiSanPham(maLoaiSanPham);
        try {
            if(rs.next())
            {
                return false;
            }
                } catch (SQLException ex) {
            Logger.getLogger(BLL_LoaiSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    static boolean isTenLoaiSanPham(String tenLoaiSanPham)
    {
        ResultSet rs = DAL_LoaiSanPham.findByTenLoaiSanPham(tenLoaiSanPham);
        try {
            if(rs.next())
            {
                return false;
            }
                } catch (SQLException ex) {
            Logger.getLogger(BLL_LoaiSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    // validate dữ liệu
    static boolean check(DTO_LoaiSanPham dto_LoaiSanPham)
    {
        if(dto_LoaiSanPham.getMaLoaiSanPham().isEmpty() || dto_LoaiSanPham.getTenLoaiSanPham().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Dữ liệu trống",  "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if(!BLL_LoaiSanPham.isMaLoaiSanPham(dto_LoaiSanPham.getMaLoaiSanPham()))
        {
            JOptionPane.showMessageDialog(null,"Mã đã tồn tại",  "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if(!BLL_LoaiSanPham.isTenLoaiSanPham(dto_LoaiSanPham.getTenLoaiSanPham()))
        {
            JOptionPane.showMessageDialog(null,"Tên đã tồn tại",  "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }
    
    static boolean check02(DTO_LoaiSanPham dto_LoaiSanPham)
    {
        if(dto_LoaiSanPham.getMaLoaiSanPham().isEmpty() || dto_LoaiSanPham.getTenLoaiSanPham().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Dữ liệu trống",  "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if(!BLL_LoaiSanPham.isTenLoaiSanPham(dto_LoaiSanPham.getTenLoaiSanPham()))
        {
            return false;
        }
        return true;
    }
    
    //add
    public static void add(DTO_LoaiSanPham dto_LoaiSanPham)
    {
        if(BLL_LoaiSanPham.check(dto_LoaiSanPham))
        {
            dto_LoaiSanPham.getTenLoaiSanPham();
            DAL_LoaiSanPham.Add(dto_LoaiSanPham);
        }
    }
    
    //update
    public static void update(DTO_LoaiSanPham dto_LoaiSanPham)
    {
        if(BLL_LoaiSanPham.check02(dto_LoaiSanPham))
        {
            DAL_LoaiSanPham.Update(dto_LoaiSanPham);
        }
    }
    
    //delete
    public static void delete(String maLoaiSanPham)
    {
        DAL_LoaiSanPham.Delete(maLoaiSanPham);
    }
    
    public static ArrayList<DTO_LoaiSanPham> SelectAll()
    {
        ArrayList<DTO_LoaiSanPham> arrList = new ArrayList<>();
        ResultSet rs = DAL_LoaiSanPham.SelectAll();
        try {
            while(rs.next())
            {
                DTO_LoaiSanPham dto_loaiSanPham = new DTO_LoaiSanPham();
                dto_loaiSanPham.setMaLoaiSanPham(rs.getString("MaLoaiSanPham"));
                dto_loaiSanPham.setTenLoaiSanPham(rs.getString("TenLoaiSanPham"));
                arrList.add(dto_loaiSanPham);
            }
            return arrList;
        } catch (SQLException ex) {
            Logger.getLogger(BLL_LoaiSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void fillTableLoaiSanPham(JTable tableLoaiSanPham)
    {
        ArrayList<DTO_LoaiSanPham> arrList = BLL_LoaiSanPham.SelectAll();
        DefaultTableModel model = (DefaultTableModel) tableLoaiSanPham.getModel();
        model.setRowCount(0);
        for(DTO_LoaiSanPham lsp : arrList)
        {
            Object obj[] = new Object[4];
            obj[0] = lsp.getMaLoaiSanPham();
            obj[1] = lsp.getTenLoaiSanPham();
            tableLoaiSanPham.getColumnModel().getColumn(2).setCellRenderer(new BLL_LoaiSanPham.iconEdit());
            tableLoaiSanPham.getColumnModel().getColumn(3).setCellRenderer(new BLL_LoaiSanPham.iconDelete());
            model.addRow(obj);
        }
        
    }
    
    public static void fillComboboxLoaiSanPham(JComboBox cbb)
    {
        ArrayList<DTO_LoaiSanPham> arrList = BLL_LoaiSanPham.SelectAll();
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
        cbbModel.removeAllElements();
        for(DTO_LoaiSanPham dto_LoaiSanPham : arrList)
        {
           Object value = dto_LoaiSanPham.getMaLoaiSanPham();
           Object text = dto_LoaiSanPham.getTenLoaiSanPham();
           HELPER.MyCombobox myCbb = new MyCombobox(value, text);
           cbbModel.addElement(myCbb);
        }
    }
    
    //
    public static void fillTableValueTenLoaiSanPhamToCombobox(JComboBox cbo, String tenLoaiSanPham)
    {
        int CboCount = cbo.getItemCount();
        for(int i = 0; i < CboCount; i++)
        {
            MyCombobox myCbb = (MyCombobox) cbo.getItemAt(i);
            if(myCbb.toString().equals(tenLoaiSanPham))
            {
                cbo.setSelectedIndex(i);
            }
        }
    }
    
    //thay đổi mã loại sản phẩm thành tên sản phẩm trong table sản phẩm
    public static String changeMaLoaiSanPhamToTenLoaiLoaiSanPham(String maLoaiSanPham)
    {
        ResultSet rs = DAL_LoaiSanPham.findByMaLoaiSanPham(maLoaiSanPham);
        try {
            if(rs.next())
            {
                return rs.getString("TenLoaiSanPham");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_LoaiSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    static class iconEdit extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setIcon(new ImageIcon("D:\\Github\\Hotel_Management\\src\\IMG\\edit.png"));
            setHorizontalAlignment(CENTER);
            return this;
        }
    }

    static class iconDelete extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setIcon(new ImageIcon("D:\\Github\\Hotel_Management\\src\\IMG\\trash.png"));
            setHorizontalAlignment(CENTER);
            return this;
        }
    }
}

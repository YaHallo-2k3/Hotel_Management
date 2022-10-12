/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import DTO.DTO_SanPham;
import java.sql.*;
import java.util.Date;
/**
 *
 * @author Trung Thanh
 */
public class DAL_SanPham {
    public static ResultSet SelectAll()
    {
       String sql = "select * from SanPham";
       return HELPER.HELPER_ConnectSQL.executeQuery(sql);
    }
    
    public static ResultSet SelectByMaSanPham(String maSanPham)
    {
       String sql = "select * from SanPham where MaSanPham = ?";
       return HELPER.HELPER_ConnectSQL.executeQuery(sql, maSanPham);
    }
    
    public static ResultSet SelectByTenSanPham(String tenSanPham)
    {
       String sql = "select * from SanPham where TenSanPham like ?";
       return HELPER.HELPER_ConnectSQL.executeQuery(sql, tenSanPham);
    }
    
    public static ResultSet SelectByMaLoaiSanPham(String maLoaiSanPham)
    {
       String sql = "select * from SanPham where MaLoaiSanPham = ?";
       return HELPER.HELPER_ConnectSQL.executeQuery(sql, maLoaiSanPham);
    }
    
    public static void Add(DTO_SanPham sanPham)
    {
        String sql = "set dateformat dmy INSERT INTO SanPham (MaSanPham, TenSanPham, MaLoaiSanPham, DonViTinh, GiaBan) VALUES (?,?,?,?,?)";
        HELPER.HELPER_ConnectSQL.executeUpdate(sql, sanPham.getMaSanPham().toUpperCase(), sanPham.getTenSanPham(), sanPham.getMaLoaiSanPham(), sanPham.getDonViTinh(), 
                                             sanPham.getGiaBan());
    }
    
    public static void Update(DTO_SanPham sanPham)
    {
        String sql = "UPDATE SanPham SET TenSanPham =?, MaLoaiSanPham =?, DonViTinh =?, GiaBan =? WHERE MaSanPham = ?";
        HELPER.HELPER_ConnectSQL.executeUpdate(sql, sanPham.getTenSanPham(), sanPham.getMaLoaiSanPham(), sanPham.getDonViTinh(), 
                                             sanPham.getGiaBan(), sanPham.getMaSanPham());
    }
    
    public static void Delete(String maSanPham)
    {
        String sql = "DELETE FROM SanPham WHERE MaSanPham = ?";
        HELPER.HELPER_ConnectSQL.executeUpdate(sql, maSanPham);
    }
}

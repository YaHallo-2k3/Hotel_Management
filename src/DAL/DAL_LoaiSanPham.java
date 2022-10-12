/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import DTO.DTO_LoaiSanPham;
import java.sql.*;
/**
 *
 * @author Trung Thanh
 */
public class DAL_LoaiSanPham {
    public static ResultSet SelectAll()
    {
        String sql = "select * from LoaiSanPham";
        return HELPER.HELPER_ConnectSQL.executeQuery(sql);
    }
    
    public static ResultSet findByMaLoaiSanPham(String maLoaiSanPham)
    {
        String sql = "select * from LoaiSanPham WHERE MaLoaiSanPham = ?";
        return HELPER.HELPER_ConnectSQL.executeQuery(sql, maLoaiSanPham);
    }
    
    public static ResultSet findByTenLoaiSanPham(String tenLoaiSanPham)
    {
        String sql = "select * from LoaiSanPham WHERE TenLoaiSanPham = ?";
        return HELPER.HELPER_ConnectSQL.executeQuery(sql, tenLoaiSanPham);
    }
    
    public static void Add(DTO_LoaiSanPham loaiSanPham)
    {
        String sql = "INSERT INTO LoaiSanPham (MaLoaiSanPham, TenLoaiSanPham) VALUES (?,?)";
        HELPER.HELPER_ConnectSQL.executeUpdate(sql, loaiSanPham.getMaLoaiSanPham().toUpperCase(), loaiSanPham.getTenLoaiSanPham());
    }
    
    public static void Update(DTO_LoaiSanPham loaiSanPham)
    {
        String sql = "UPDATE LoaiSanPham SET TenLoaiSanPham = ? WHERE MaLoaiSanPham = ?";
        HELPER.HELPER_ConnectSQL.executeUpdate(sql, loaiSanPham.getTenLoaiSanPham(), loaiSanPham.getMaLoaiSanPham());
    }
    
    public static void Delete(String maLoaiSanPham)
    {
        String sql = "DELETE FROM LoaiSanPham WHERE MaLoaiSanPham = ?";
        HELPER.HELPER_ConnectSQL.executeUpdate(sql, maLoaiSanPham);
    }
}

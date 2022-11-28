/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import HELPER.HELPER_ChuyenDoi;
import HELPER.HELPER_ConnectSQL;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author Trung Thanh
 */
public class DAL_ThongKe {
    
    public static ResultSet ThongKeCacTrangThaiLoaiPhong(Date date, String loaiPhong)
    {
        String sql = "EXEC dbo.SP_ThongKeCacTrangThaiLoaiPhong @date = ?, @kindOfRoom = ? ";
         return HELPER.HELPER_ConnectSQL.executeQuery(sql, HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd", date), loaiPhong);
    }
    
    public static ResultSet ThongKeCacTrangThaiPhong(Date date)
    {
        String sql = "EXEC dbo.SP_ThongKeCacTrangThaiPhong @date = ?";
         return HELPER.HELPER_ConnectSQL.executeQuery(sql, HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd", date));
    }
    
    public static ResultSet SLPhongTrongVaTongSoPhong(Date date)
    {
        String sql = "EXEC dbo.SP_SLphongTrongvsTongSoPhong @date = ?";
        return HELPER.HELPER_ConnectSQL.executeQuery(sql, HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd", date));
    }
    
    public static ResultSet SLKhachVaoTheoGio(Date date)
    {
        String sql = "select FORMAT(ngaytao,'HH') as 'hour', count(FORMAT(ngaytao,'HH')) as 'count' from thuephong where FORMAT(ngaytao,'yyyy-MM-dd') = ? group by FORMAT(ngaytao,'HH')";
        return HELPER.HELPER_ConnectSQL.executeQuery(sql, HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd", date));
    }
    
    public static ResultSet TienLoaiPhongKiemTrongNgay(Date date)
    {
        String sql = "exec SP_TienLoaiPhongTrongNgay @date = ?";
        return HELPER.HELPER_ConnectSQL.executeQuery(sql, HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd", date));
    }
    
    public static ResultSet NguonTienTrongNgay(Date date)
    {
        String sql = "exec SP_ThongKeNguonTienTrongNgay @date = ?";
        return HELPER.HELPER_ConnectSQL.executeQuery(sql, HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd", date));
    }
    
    public static ResultSet getMaLoaiPhong()
    {
        String sql = "SELECT MaLoaiPhong FROM loaiphong";
        return HELPER_ConnectSQL.executeQuery(sql);
    }
}

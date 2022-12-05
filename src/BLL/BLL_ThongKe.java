/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL_ThongKe;
import java.awt.Color;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Trung Thanh
 */
public class BLL_ThongKe {
    public static ArrayList ThongKeCacTrangThaiLoaiPhong(Date date)
    { 
        ArrayList<int[]> arrList = new ArrayList<>();
        int i = 0;
    try {
        ResultSet rsMaLoaiPhong = DAL_ThongKe.getMaLoaiPhong();
        while(rsMaLoaiPhong.next())
        {   
            ResultSet rs = DAL_ThongKe.ThongKeCacTrangThaiLoaiPhong(date, rsMaLoaiPhong.getString("MaLoaiPhong")); 
            if(rs.next())
            {
                int[] object = new int[3];
                object[0] = rs.getInt("PhongTrong");
                object[1] =rs.getInt("CoKhach");
                object[2] =rs.getInt("DaThanhToan");
                arrList.add(object);
                i++;
            }  
        }
        return arrList;
        } catch (Exception e) {
        }
    return null;
    }
    
    public static ArrayList ThongKeCacTrangThaiPhong(Date date)
    {
        ArrayList<Object> arrList = new ArrayList<>();
        try {
            ResultSet rs = DAL_ThongKe.ThongKeCacTrangThaiPhong(date);
            if(rs.next())
            {
                arrList.add(rs.getInt("PhongTrong"));
                arrList.add(rs.getInt("CoKhach"));
                arrList.add(rs.getInt("DaThanhToan"));
                arrList.add(String.format("%.2f",PhanTramPhongTrong(date)) +"%");
                return arrList;
            }
            
        } catch (Exception e) {
        }
        return null;
    }
    
    public static double PhanTramPhongTrong(Date date)
    {
        try {
            ResultSet rs = DAL_ThongKe.SLPhongTrongVaTongSoPhong(date);
            if(rs.next())
            {
                double phongTrong = rs.getInt("PhongTrong");
                double tongSoPhong = rs.getInt("TongSoPhong");
                double phanTram = Double.valueOf(phongTrong/tongSoPhong) * 100;
                return phanTram;
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    public static ArrayList<Object[]> TienLoaiPhongKiemTrongNgay(Date date)
    {
       ArrayList<Object[]> arrList = new ArrayList<>();
       ResultSet rs = DAL_ThongKe.TienLoaiPhongKiemTrongNgay(date);
        try {
            while(rs.next())
            {
                Object[] obj = new Object[2];
                obj[0] = rs.getString("tenloaiphong");
                obj[1] = rs.getDouble("tongtien");
                arrList.add(obj);
            }
            return arrList;
        } catch (Exception e) {
        }
        return null;
    }
    
    public static ArrayList NguonTienTrongNgay(Date date)
    {
        ArrayList<Double> arrList = new ArrayList<>();
        try {
            ResultSet rs = DAL_ThongKe.NguonTienTrongNgay(date);
            if(rs.next())
            {
                arrList.add(rs.getDouble("TienPhong"));
                arrList.add(rs.getDouble("TienDichVu"));
                arrList.add(rs.getDouble("TienCoc"));
                arrList.add(rs.getDouble("DoanhThu"));
                arrList.add(rs.getDouble("ChiPhi"));
                arrList.add(rs.getDouble("ConLai"));
                return arrList;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public static Color randomColor()
    {
        Random random = new Random();
    final float hue = random.nextFloat();
    // Saturation between 0.1 and 0.3
    final float saturation = (random.nextInt(2000) + 1000) / 10000f;
    final float luminance = 0.9f;
    final Color color = Color.getHSBColor(hue, saturation, luminance);
    return color;
    }
    
    public static ArrayList SLKhachVaoTheoGio(Date date)
    {
        try {
            int zeroToFour = 0;
            int fourToSix = 0;
            int sixToEight = 0;
            int eightToTen = 0;
            int tenToTwelve = 0;
            int twelveToFourteen = 0;
            int fourteenToSixteen = 0;
            int sixteenToEighteen = 0;
            int eighteenToTwenty = 0;
            int twentyToZero = 0;
            ArrayList<Integer> arrList = new ArrayList<>();
            ResultSet rs = DAL_ThongKe.SLKhachVaoTheoGio(date);
            while(rs.next())
            {
                if(rs.getInt("hour") >= 0 && rs.getInt("hour") < 4)
                {
                    zeroToFour = rs.getInt("count");
                }
                if(rs.getInt("hour") >=4 && rs.getInt("hour") < 6)
                {
                    fourToSix = rs.getInt("count");
                }
                if(rs.getInt("hour") >=6 && rs.getInt("hour") < 8)
                {
                    sixToEight = rs.getInt("count");
                }
                if(rs.getInt("hour") >=8 && rs.getInt("hour") < 10)
                {
                    eightToTen = rs.getInt("count");
                }
                if(rs.getInt("hour") >=10 && rs.getInt("hour") < 12)
                {
                    tenToTwelve = rs.getInt("count");
                }
                if(rs.getInt("hour") >=12 && rs.getInt("hour") < 14)
                {
                    twelveToFourteen = rs.getInt("count");
                }
                if(rs.getInt("hour") >=14 && rs.getInt("hour") < 16)
                {
                    fourteenToSixteen = rs.getInt("count");
                }
                if(rs.getInt("hour") >=16 && rs.getInt("hour") < 18)
                {
                    sixteenToEighteen = rs.getInt("count");
                }
                if(rs.getInt("hour") >=18 && rs.getInt("hour") < 20)
                {
                    eighteenToTwenty = rs.getInt("count");
                }
                if(rs.getInt("hour") >=20 && rs.getInt("hour") < 24)
                {
                    twentyToZero = rs.getInt("count");
                }
            }
            arrList.add(zeroToFour);
            arrList.add(fourToSix);
            arrList.add(sixToEight);
            arrList.add(eightToTen);
            arrList.add(tenToTwelve);
            arrList.add(twelveToFourteen);
            arrList.add(fourteenToSixteen);
            arrList.add(sixteenToEighteen);
            arrList.add(eighteenToTwenty);
            arrList.add(twentyToZero);
            return arrList;
        } catch (Exception e) {
        }
        return null;
    }
    //Chuyển đổi số Double <-> String 10.000.000
     public static String SoStringGiaTien(double so){
        return NumberFormat.getNumberInstance().format(so);
    }
}

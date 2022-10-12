/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author Trung Thanh
 */
public class DTO_SanPham {
    private String MaSanPham;
    private String TenSanPham;
    private String MaLoaiSanPham;
    private String DonViTinh;
    private double GiaBan;
    private Date NgayTao;

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public String getMaLoaiSanPham() {
        return MaLoaiSanPham;
    }

    public void setMaLoaiSanPham(String MaLoaiSanPham) {
        this.MaLoaiSanPham = MaLoaiSanPham;
    }

    public String getDonViTinh() {
        return DonViTinh;
    }

    public void setDonViTinh(String DonViTinh) {
        this.DonViTinh = DonViTinh;
    }


    public double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public DTO_SanPham() {
    }

    public DTO_SanPham(String MaSanPham, String TenSanPham, String MaLoaiSanPham, String DonViTinh, double GiaBan) {
        this.MaSanPham = MaSanPham;
        this.TenSanPham = TenSanPham;
        this.MaLoaiSanPham = MaLoaiSanPham;
        this.DonViTinh = DonViTinh;
        this.GiaBan = GiaBan;
    }

    public DTO_SanPham(String MaSanPham, String TenSanPham, String MaLoaiSanPham, String DonViTinh, double GiaBan, Date NgayTao) {
        this.MaSanPham = MaSanPham;
        this.TenSanPham = TenSanPham;
        this.MaLoaiSanPham = MaLoaiSanPham;
        this.DonViTinh = DonViTinh;
        this.GiaBan = GiaBan;
        this.NgayTao = NgayTao;
    }

    
}

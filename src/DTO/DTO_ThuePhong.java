/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author CherryCe
 */
public class DTO_ThuePhong {

    public String maPhong;
    public String maPhieuThue;
    public String maTrangThaiPhong;
    public String maNhanVien;
    public Date ngayTao;
    public Date ngayDen;
    public Date ngayDi;
    public String CCCD;
    public int soLuong;
    public String ghiChu;
    public int giamGia;
    public int tienCoc;

    public DTO_ThuePhong() {
    }

    public DTO_ThuePhong(String maPhong, String maPhieuThue, String maTrangThaiPhong, String maNhanVien, Date ngayTao, Date ngayDen, Date ngayDi, String CCCD, int soLuong, String ghiChu, int giamGia, int tienCoc) {
        this.maPhong = maPhong;
        this.maPhieuThue = maPhieuThue;
        this.maTrangThaiPhong = maTrangThaiPhong;
        this.maNhanVien = maNhanVien;
        this.ngayTao = ngayTao;
        this.ngayDen = ngayDen;
        this.ngayDi = ngayDi;
        this.CCCD = CCCD;
        this.soLuong = soLuong;
        this.ghiChu = ghiChu;
        this.giamGia = giamGia;
        this.tienCoc = tienCoc;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getMaPhieuThue() {
        return maPhieuThue;
    }

    public void setMaPhieuThue(String maPhieuThue) {
        this.maPhieuThue = maPhieuThue;
    }

    public String getMaTrangThaiPhong() {
        return maTrangThaiPhong;
    }

    public void setMaTrangThaiPhong(String maTrangThaiPhong) {
        this.maTrangThaiPhong = maTrangThaiPhong;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayDen() {
        return ngayDen;
    }

    public void setNgayDen(Date ngayDen) {
        this.ngayDen = ngayDen;
    }

    public Date getNgayDi() {
        return ngayDi;
    }

    public void setNgayDi(Date ngayDi) {
        this.ngayDi = ngayDi;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }

    public int getTienCoc() {
        return tienCoc;
    }

    public void setTienCoc(int tienCoc) {
        this.tienCoc = tienCoc;
    }
}

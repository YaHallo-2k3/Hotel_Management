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
public class DTO_DichVu {

    public String maPhieuDichVu;
    public String maPhong;
    public String maNhanVien;
    public Date ngayTao;
    public String ghiChu;

    public DTO_DichVu() {
    }

    public DTO_DichVu(String maPhieuDichVu, String maPhong, String maNhanVien, Date ngayTao, String ghiChu) {
        this.maPhieuDichVu = maPhieuDichVu;
        this.maPhong = maPhong;
        this.maNhanVien = maNhanVien;
        this.ngayTao = ngayTao;
        this.ghiChu = ghiChu;
    }

    public String getMaPhieuDichVu() {
        return maPhieuDichVu;
    }

    public void setMaPhieuDichVu(String maPhieuDichVu) {
        this.maPhieuDichVu = maPhieuDichVu;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
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

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}

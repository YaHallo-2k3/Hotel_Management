/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author CherryCe
 */
public class DTO_TaiKhoan {

    public String maTaiKhoan;
    public String maNhanVien;
    public String tenDangNhap;
    public String matKhau;
    public String cauHoi;
    public String traLoi;
    public int checkDangNhap;

    public DTO_TaiKhoan() {
    }

    public DTO_TaiKhoan(String maTaiKhoan, String maNhanVien, String tenDangNhap, String matKhau, String cauHoi, String traLoi, int checkDangNhap) {
        this.maTaiKhoan = maTaiKhoan;
        this.maNhanVien = maNhanVien;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.cauHoi = cauHoi;
        this.traLoi = traLoi;
        this.checkDangNhap = checkDangNhap;
    }

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public String getTraLoi() {
        return traLoi;
    }

    public void setTraLoi(String traLoi) {
        this.traLoi = traLoi;
    }

    public int getCheckDangNhap() {
        return checkDangNhap;
    }

    public void setCheckDangNhap(int checkDangNhap) {
        this.checkDangNhap = checkDangNhap;
    }
}

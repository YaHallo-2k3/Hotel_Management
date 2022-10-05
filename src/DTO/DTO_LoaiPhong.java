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
public class DTO_LoaiPhong {

    public String maPhong;
    public String tenPhong;
    public int giaGio;
    public int giaNgay;
    public int soGiuong;
    public int soNguoi;

    public DTO_LoaiPhong() {
    }

    public DTO_LoaiPhong(String maPhong, String tenPhong, int giaGio, int giaNgay, int soGiuong, int soNguoi) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.giaGio = giaGio;
        this.giaNgay = giaNgay;
        this.soGiuong = soGiuong;
        this.soNguoi = soNguoi;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public int getGiaGio() {
        return giaGio;
    }

    public void setGiaGio(int giaGio) {
        this.giaGio = giaGio;
    }

    public int getGiaNgay() {
        return giaNgay;
    }

    public void setGiaNgay(int giaNgay) {
        this.giaNgay = giaNgay;
    }

    public int getSoGiuong() {
        return soGiuong;
    }

    public void setSoGiuong(int soGiuong) {
        this.soGiuong = soGiuong;
    }

    public int getSoNguoi() {
        return soNguoi;
    }

    public void setSoNguoi(int soNguoi) {
        this.soNguoi = soNguoi;
    }
}

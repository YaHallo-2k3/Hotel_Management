/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.BLL_Phong;
import BLL.BLL_SoDoPhong;
import BLL.BLL_SoTang;
import DTO.DTO_Phong;
import DTO.DTO_SoTang;
import DTO.DTO_ThuePhong;
import HELPER.HELPER_ChuyenDoi;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

/**
 *
 * @author CherryCe
 */
public class GUI_pnl_ChiTietPhong extends javax.swing.JPanel {

    boolean isShowHidden = false;
    boolean isDonPhong = false;
    boolean isKhachRaNgoai = false;
    public static int indexPosition;

    /**
     * Creates new form GUI_pnlChiTietPhong
     */
    public GUI_pnl_ChiTietPhong() {
        initComponents();
        load();
        lblDonPhong.setVisible(false);
        lblRaNgoai.setVisible(false);
        isHidden();

    }

    public void load() {
        ArrayList<DTO_Phong> arrayPhong = BLL_SoDoPhong.selectPhong(GUI_pnl_SoDoPhong.index);
        BLL_SoDoPhong.loadPhong(arrayPhong, lblSoPhong, lblLoaiPhong, lblSetTrangThai);
        ArrayList<DTO_ThuePhong> arrayThuePhong = BLL_SoDoPhong.selectThuePhong(lblSoPhong.getText());
        BLL_SoDoPhong.loadThuePhong(arrayThuePhong, lblNgayDen, lblThangDen, lblGioPhutDen, lblNgayDi, lblThangDi, lblGioPhutDi, lblSetDatCoc);
        if (lblSetTrangThai.getText().equals("Phòng Trống")) {
            lblIconTrangThai.setIcon(new ImageIcon(getClass().getResource("/IMG/bed (3).png")));
            sdoChiTietPhong.setBackground(new Color(97, 177, 90));
            lblTongThoiGian.setVisible(false);
            lblNgayDefault.setVisible(true);
            lblNgayDefault.setText(HELPER_ChuyenDoi.getTimeNow("dd-MM-yyyy"));
            lblTongTien.setVisible(false);
            lblDatCoc.setVisible(false);
            lblConLai.setVisible(false);
            lblSetTongTien.setText(null);
            lblSetDatCoc.setText(null);
            lblSetConLai.setText(null);
            mniKhachRaNgoai.setVisible(false);
            mniChuyenPhong.setVisible(false);
            mniHuyPhong.setVisible(false);
            mniThanhToanNhom.setVisible(false);
        } else {
            if (lblSetTrangThai.getText().equals("Có Khách")) {
                sdoChiTietPhong.setBackground(new Color(255, 142, 113));
            } else if (lblSetTrangThai.getText().equals("Đặt Trước")) {
                sdoChiTietPhong.setBackground(new Color(102, 153, 255));
            } else if (lblSetTrangThai.getText().equals("Trả Phòng")) {
                sdoChiTietPhong.setBackground(new Color(255, 153, 0));
            }

            lblIconTrangThai.setIcon(new ImageIcon(getClass().getResource("/IMG/hotel-sign (2).png")));
            lblTongThoiGian.setVisible(true);
            lblNgayDefault.setVisible(false);
            lblTongTien.setVisible(true);
            lblDatCoc.setVisible(true);
            lblConLai.setVisible(true);
            lblSetTongTien.setText(null);
            lblSetConLai.setText(null);
            tongThoiGian();
        }
    }

    public void tongThoiGian() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Date d1 = null;
        Date d2 = null;

        String dateStart = lblGioPhutDen.getText();
        String dateStop = lblGioPhutDi.getText();

        try {
            String ngayDen = HELPER_ChuyenDoi.convertDate("dd-MM", "yyyy-MM-dd", lblNgayDen.getText() + "-" + lblThangDen.getText() + "-" + HELPER_ChuyenDoi.getTimeNow("yy"));
            String ngayDi = HELPER_ChuyenDoi.convertDate("dd-MM", "yyyy-MM-dd", lblNgayDi.getText() + "-" + lblThangDi.getText() + "-" + HELPER_ChuyenDoi.getTimeNow("yy"));
            java.sql.Date date1 = java.sql.Date.valueOf(ngayDen);
            java.sql.Date date2 = java.sql.Date.valueOf(ngayDi);
            c1.setTime(date1);
            c2.setTime(date2);
            d1 = (Date) format.parse(dateStart);
            d2 = (Date) format.parse(dateStop);
        } catch (Exception e) {
            e.printStackTrace();
        }

        long noDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
        long diff = (d2.getTime() - d1.getTime()) / 1000;
        long diffHours = diff / (60 * 60);
        long diffMinutes = (diff % (60 * 60)) / 60;

        lblTongThoiGian.setText(String.valueOf(noDay + "d " + diffHours + "h " + diffMinutes + "m"));
    }

    public void isHidden() {
        lblNgayDen.setVisible(false);
        lblNgayDi.setVisible(false);
        lblGioPhutDen.setVisible(false);
        lblGioPhutDi.setVisible(false);
        lblThangDen.setVisible(false);
        lblThangDi.setVisible(false);
        lblNgayDen.setVisible(false);
        spt_1.setVisible(false);
        spt_2.setVisible(false);
    }

    public void isShow() {
        lblNgayDen.setVisible(true);
        lblNgayDi.setVisible(true);
        lblGioPhutDen.setVisible(true);
        lblGioPhutDi.setVisible(true);
        lblThangDen.setVisible(true);
        lblThangDi.setVisible(true);
        lblNgayDen.setVisible(true);
        spt_1.setVisible(true);
        spt_2.setVisible(true);
    }

    public void showPopUp(MouseEvent evt) {
        popMenu.show(this, evt.getX(), evt.getY());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popMenu = new javax.swing.JPopupMenu();
        mniThuePhong = new javax.swing.JMenuItem();
        mniDonPhong = new javax.swing.JMenuItem();
        mniKhachRaNgoai = new javax.swing.JMenuItem();
        mniDatPhong = new javax.swing.JMenuItem();
        mniThanhToanNhom = new javax.swing.JMenuItem();
        mniChuyenPhong = new javax.swing.JMenuItem();
        mniHuyPhong = new javax.swing.JMenuItem();
        sdoChiTietPhong = new HELPER.PanelShadow();
        lblGioPhutDi = new javax.swing.JLabel();
        spt_1 = new javax.swing.JSeparator();
        lblNgayDi = new javax.swing.JLabel();
        lblThangDi = new javax.swing.JLabel();
        lblSetDatCoc = new javax.swing.JLabel();
        lblDonPhong = new javax.swing.JLabel();
        lblDatCoc = new javax.swing.JLabel();
        spt_2 = new javax.swing.JSeparator();
        lblSetTongTien = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        lblSetConLai = new javax.swing.JLabel();
        lblGioPhutDen = new javax.swing.JLabel();
        lblLoaiPhong = new javax.swing.JLabel();
        lblConLai = new javax.swing.JLabel();
        lblThangDen = new javax.swing.JLabel();
        lblSetTrangThai = new javax.swing.JLabel();
        lblNgayDen = new javax.swing.JLabel();
        lblIconTrangThai = new javax.swing.JLabel();
        lblSoPhong = new javax.swing.JLabel();
        lblRaNgoai = new javax.swing.JLabel();
        lblTongThoiGian = new javax.swing.JLabel();
        lblNgayDefault = new javax.swing.JLabel();

        popMenu.setBackground(new java.awt.Color(255, 255, 255));
        popMenu.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        popMenu.setForeground(new java.awt.Color(62, 73, 95));
        popMenu.setComponentPopupMenu(popMenu);

        mniThuePhong.setBackground(new java.awt.Color(255, 255, 255));
        mniThuePhong.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        mniThuePhong.setForeground(new java.awt.Color(62, 73, 95));
        mniThuePhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/personal-profile.png"))); // NOI18N
        mniThuePhong.setText("Thuê Phòng");
        mniThuePhong.setMinimumSize(new java.awt.Dimension(150, 30));
        mniThuePhong.setOpaque(true);
        mniThuePhong.setPreferredSize(new java.awt.Dimension(150, 30));
        mniThuePhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mniThuePhongMouseClicked(evt);
            }
        });
        mniThuePhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniThuePhongActionPerformed(evt);
            }
        });
        popMenu.add(mniThuePhong);

        mniDonPhong.setBackground(new java.awt.Color(255, 255, 255));
        mniDonPhong.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        mniDonPhong.setForeground(new java.awt.Color(62, 73, 95));
        mniDonPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cleaning.png"))); // NOI18N
        mniDonPhong.setText("Dọn Phòng");
        mniDonPhong.setMinimumSize(new java.awt.Dimension(150, 30));
        mniDonPhong.setOpaque(true);
        mniDonPhong.setPreferredSize(new java.awt.Dimension(150, 30));
        mniDonPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDonPhongActionPerformed(evt);
            }
        });
        popMenu.add(mniDonPhong);

        mniKhachRaNgoai.setBackground(new java.awt.Color(255, 255, 255));
        mniKhachRaNgoai.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        mniKhachRaNgoai.setForeground(new java.awt.Color(62, 73, 95));
        mniKhachRaNgoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/logout (8).png"))); // NOI18N
        mniKhachRaNgoai.setText("Khách Ra Ngoài");
        mniKhachRaNgoai.setMinimumSize(new java.awt.Dimension(150, 30));
        mniKhachRaNgoai.setOpaque(true);
        mniKhachRaNgoai.setPreferredSize(new java.awt.Dimension(150, 30));
        mniKhachRaNgoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniKhachRaNgoaiActionPerformed(evt);
            }
        });
        popMenu.add(mniKhachRaNgoai);

        mniDatPhong.setBackground(new java.awt.Color(255, 255, 255));
        mniDatPhong.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        mniDatPhong.setForeground(new java.awt.Color(62, 73, 95));
        mniDatPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/calendar.png"))); // NOI18N
        mniDatPhong.setText("Đặt Phòng");
        mniDatPhong.setMinimumSize(new java.awt.Dimension(150, 30));
        mniDatPhong.setOpaque(true);
        mniDatPhong.setPreferredSize(new java.awt.Dimension(150, 30));
        popMenu.add(mniDatPhong);

        mniThanhToanNhom.setBackground(new java.awt.Color(255, 255, 255));
        mniThanhToanNhom.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        mniThanhToanNhom.setForeground(new java.awt.Color(62, 73, 95));
        mniThanhToanNhom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/multiple-users-silhouette.png"))); // NOI18N
        mniThanhToanNhom.setText("Thanh Toán Nhóm");
        mniThanhToanNhom.setMinimumSize(new java.awt.Dimension(150, 30));
        mniThanhToanNhom.setOpaque(true);
        mniThanhToanNhom.setPreferredSize(new java.awt.Dimension(150, 30));
        popMenu.add(mniThanhToanNhom);

        mniChuyenPhong.setBackground(new java.awt.Color(255, 255, 255));
        mniChuyenPhong.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        mniChuyenPhong.setForeground(new java.awt.Color(62, 73, 95));
        mniChuyenPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/exchange (5).png"))); // NOI18N
        mniChuyenPhong.setText("Chuyển Phòng");
        mniChuyenPhong.setMinimumSize(new java.awt.Dimension(150, 30));
        mniChuyenPhong.setOpaque(true);
        mniChuyenPhong.setPreferredSize(new java.awt.Dimension(150, 30));
        popMenu.add(mniChuyenPhong);

        mniHuyPhong.setBackground(new java.awt.Color(255, 255, 255));
        mniHuyPhong.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        mniHuyPhong.setForeground(new java.awt.Color(62, 73, 95));
        mniHuyPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/delete (1).png"))); // NOI18N
        mniHuyPhong.setText("Hủy Phòng");
        mniHuyPhong.setMinimumSize(new java.awt.Dimension(150, 30));
        mniHuyPhong.setOpaque(true);
        mniHuyPhong.setPreferredSize(new java.awt.Dimension(150, 30));
        popMenu.add(mniHuyPhong);

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(220, 180));
        setPreferredSize(new java.awt.Dimension(220, 180));

        sdoChiTietPhong.setBackground(new java.awt.Color(97, 177, 90));
        sdoChiTietPhong.setComponentPopupMenu(popMenu);
        sdoChiTietPhong.setMinimumSize(new java.awt.Dimension(220, 180));
        sdoChiTietPhong.setPreferredSize(new java.awt.Dimension(220, 180));
        sdoChiTietPhong.setShadowOpacity(0.3F);
        sdoChiTietPhong.setShadowSize(3);
        sdoChiTietPhong.setShadowType(HELPER.ShadowType.BOT_RIGHT);
        sdoChiTietPhong.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                sdoChiTietPhongMouseMoved(evt);
            }
        });
        sdoChiTietPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sdoChiTietPhongMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sdoChiTietPhongMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sdoChiTietPhongMouseReleased(evt);
            }
        });
        sdoChiTietPhong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblGioPhutDi.setBackground(new java.awt.Color(255, 255, 255));
        lblGioPhutDi.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblGioPhutDi.setForeground(new java.awt.Color(255, 255, 255));
        lblGioPhutDi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGioPhutDi.setText("19:09");
        sdoChiTietPhong.add(lblGioPhutDi, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 40, 20));
        sdoChiTietPhong.add(spt_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 20, 10));

        lblNgayDi.setBackground(new java.awt.Color(255, 255, 255));
        lblNgayDi.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblNgayDi.setForeground(new java.awt.Color(255, 255, 255));
        lblNgayDi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNgayDi.setText("16");
        lblNgayDi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sdoChiTietPhong.add(lblNgayDi, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 20, 20));

        lblThangDi.setBackground(new java.awt.Color(255, 255, 255));
        lblThangDi.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblThangDi.setForeground(new java.awt.Color(255, 255, 255));
        lblThangDi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThangDi.setText("9");
        lblThangDi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sdoChiTietPhong.add(lblThangDi, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 20, 30));

        lblSetDatCoc.setBackground(new java.awt.Color(255, 255, 255));
        lblSetDatCoc.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblSetDatCoc.setForeground(new java.awt.Color(255, 255, 255));
        lblSetDatCoc.setText("200K");
        sdoChiTietPhong.add(lblSetDatCoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 40, 30));

        lblDonPhong.setBackground(new java.awt.Color(255, 255, 255));
        lblDonPhong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDonPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/mop (1).png"))); // NOI18N
        lblDonPhong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sdoChiTietPhong.add(lblDonPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 30, 20));

        lblDatCoc.setBackground(new java.awt.Color(255, 255, 255));
        lblDatCoc.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        lblDatCoc.setForeground(new java.awt.Color(230, 230, 230));
        lblDatCoc.setText("Đặt Cọc");
        sdoChiTietPhong.add(lblDatCoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, 30));
        sdoChiTietPhong.add(spt_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 20, 10));

        lblSetTongTien.setBackground(new java.awt.Color(255, 255, 255));
        lblSetTongTien.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblSetTongTien.setForeground(new java.awt.Color(255, 255, 255));
        lblSetTongTien.setText("1,400K");
        sdoChiTietPhong.add(lblSetTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 50, 30));

        lblTongTien.setBackground(new java.awt.Color(255, 255, 255));
        lblTongTien.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(230, 230, 230));
        lblTongTien.setText("Tổng Tiền");
        sdoChiTietPhong.add(lblTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 30));

        lblSetConLai.setBackground(new java.awt.Color(255, 255, 255));
        lblSetConLai.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblSetConLai.setForeground(new java.awt.Color(255, 255, 255));
        lblSetConLai.setText("1,200k");
        sdoChiTietPhong.add(lblSetConLai, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 50, 30));

        lblGioPhutDen.setBackground(new java.awt.Color(255, 255, 255));
        lblGioPhutDen.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblGioPhutDen.setForeground(new java.awt.Color(255, 255, 255));
        lblGioPhutDen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGioPhutDen.setText("19:09");
        sdoChiTietPhong.add(lblGioPhutDen, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 40, 20));

        lblLoaiPhong.setBackground(new java.awt.Color(255, 255, 255));
        lblLoaiPhong.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        lblLoaiPhong.setForeground(new java.awt.Color(230, 230, 230));
        lblLoaiPhong.setText("Phòng Đơn");
        sdoChiTietPhong.add(lblLoaiPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 20));

        lblConLai.setBackground(new java.awt.Color(255, 255, 255));
        lblConLai.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        lblConLai.setForeground(new java.awt.Color(230, 230, 230));
        lblConLai.setText("Còn Lại");
        sdoChiTietPhong.add(lblConLai, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, 30));

        lblThangDen.setBackground(new java.awt.Color(255, 255, 255));
        lblThangDen.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblThangDen.setForeground(new java.awt.Color(255, 255, 255));
        lblThangDen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThangDen.setText("9");
        lblThangDen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sdoChiTietPhong.add(lblThangDen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 20, 30));

        lblSetTrangThai.setBackground(new java.awt.Color(255, 255, 255));
        lblSetTrangThai.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        lblSetTrangThai.setForeground(new java.awt.Color(230, 230, 230));
        lblSetTrangThai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSetTrangThai.setText("Có Khách");
        sdoChiTietPhong.add(lblSetTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 70, 20));

        lblNgayDen.setBackground(new java.awt.Color(255, 255, 255));
        lblNgayDen.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblNgayDen.setForeground(new java.awt.Color(255, 255, 255));
        lblNgayDen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNgayDen.setText("16");
        lblNgayDen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sdoChiTietPhong.add(lblNgayDen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 20, 20));

        lblIconTrangThai.setBackground(new java.awt.Color(255, 255, 255));
        lblIconTrangThai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/hotel-sign (2).png"))); // NOI18N
        sdoChiTietPhong.add(lblIconTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 30, 20));

        lblSoPhong.setBackground(new java.awt.Color(255, 255, 255));
        lblSoPhong.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        lblSoPhong.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong.setText("101");
        sdoChiTietPhong.add(lblSoPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 20));

        lblRaNgoai.setBackground(new java.awt.Color(255, 255, 255));
        lblRaNgoai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRaNgoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/logout (4).png"))); // NOI18N
        lblRaNgoai.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sdoChiTietPhong.add(lblRaNgoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 30, 20));

        lblTongThoiGian.setBackground(new java.awt.Color(255, 255, 255));
        lblTongThoiGian.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblTongThoiGian.setForeground(new java.awt.Color(62, 73, 95));
        lblTongThoiGian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongThoiGian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/circle (1).png"))); // NOI18N
        lblTongThoiGian.setText("8d 6h 30m");
        lblTongThoiGian.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblTongThoiGian.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblTongThoiGianMouseMoved(evt);
            }
        });
        lblTongThoiGian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTongThoiGianMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblTongThoiGianMouseExited(evt);
            }
        });
        sdoChiTietPhong.add(lblTongThoiGian, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 80, 70));

        lblNgayDefault.setBackground(new java.awt.Color(255, 255, 255));
        lblNgayDefault.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        lblNgayDefault.setForeground(new java.awt.Color(255, 255, 255));
        lblNgayDefault.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNgayDefault.setText("22-09-2022");
        sdoChiTietPhong.add(lblNgayDefault, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sdoChiTietPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sdoChiTietPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sdoChiTietPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sdoChiTietPhongMouseClicked
        // TODO add your handling code here:
        indexPosition = GUI_pnl_SoDoPhong.pnlFormChinh.getComponentZOrder(sdoChiTietPhong);
        if (evt.getClickCount() == 2) {
            new GUI_dal_ThongTinPhong(null, true).setVisible(true);
        }
    }//GEN-LAST:event_sdoChiTietPhongMouseClicked

    private void lblTongThoiGianMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTongThoiGianMouseExited
        // TODO add your handling code here:
        lblTongThoiGian.setForeground(new Color(62, 73, 95));
        sdoChiTietPhong.setBorder(null);
    }//GEN-LAST:event_lblTongThoiGianMouseExited

    private void lblTongThoiGianMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTongThoiGianMouseMoved
        // TODO add your handling code here:
        lblTongThoiGian.setForeground(new Color(255, 102, 102));
        sdoChiTietPhong.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(33, 150, 243)));
    }//GEN-LAST:event_lblTongThoiGianMouseMoved

    private void lblTongThoiGianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTongThoiGianMouseClicked
        // TODO add your handling code here:
        if (!isShowHidden) {
            isShow();
            isShowHidden = true;
        } else {
            isHidden();
            isShowHidden = false;
        }
    }//GEN-LAST:event_lblTongThoiGianMouseClicked

    private void sdoChiTietPhongMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sdoChiTietPhongMouseMoved
        // TODO add your handling code here:
        sdoChiTietPhong.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(33, 150, 243)));
    }//GEN-LAST:event_sdoChiTietPhongMouseMoved

    private void sdoChiTietPhongMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sdoChiTietPhongMouseExited
        // TODO add your handling code here:
        sdoChiTietPhong.setBorder(null);
    }//GEN-LAST:event_sdoChiTietPhongMouseExited

    private void sdoChiTietPhongMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sdoChiTietPhongMouseReleased
        // TODO add your handling code here:
        if (evt.isPopupTrigger()) {
            showPopUp(evt);
        }
    }//GEN-LAST:event_sdoChiTietPhongMouseReleased

    private void mniThuePhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mniThuePhongMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_mniThuePhongMouseClicked

    private void mniThuePhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniThuePhongActionPerformed
        // TODO add your handling code here:  
        indexPosition = GUI_pnl_SoDoPhong.pnlFormChinh.getComponentZOrder(sdoChiTietPhong);
        new GUI_dal_ThongTinPhong(null, true).setVisible(true);
    }//GEN-LAST:event_mniThuePhongActionPerformed

    private void mniDonPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDonPhongActionPerformed
        // TODO add your handling code here:
        if (!isDonPhong) {
            lblDonPhong.setVisible(true);
            isDonPhong = true;
        } else {
            lblDonPhong.setVisible(false);
            isDonPhong = false;
        }
    }//GEN-LAST:event_mniDonPhongActionPerformed

    private void mniKhachRaNgoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniKhachRaNgoaiActionPerformed
        // TODO add your handling code here:
        if (!isKhachRaNgoai) {
            lblRaNgoai.setVisible(true);
            isKhachRaNgoai = true;
        } else {
            lblRaNgoai.setVisible(false);
            isKhachRaNgoai = false;
        }
    }//GEN-LAST:event_mniKhachRaNgoaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel lblConLai;
    public javax.swing.JLabel lblDatCoc;
    public javax.swing.JLabel lblDonPhong;
    public javax.swing.JLabel lblGioPhutDen;
    public javax.swing.JLabel lblGioPhutDi;
    public javax.swing.JLabel lblIconTrangThai;
    public static javax.swing.JLabel lblLoaiPhong;
    public javax.swing.JLabel lblNgayDefault;
    public javax.swing.JLabel lblNgayDen;
    public javax.swing.JLabel lblNgayDi;
    public javax.swing.JLabel lblRaNgoai;
    public javax.swing.JLabel lblSetConLai;
    public javax.swing.JLabel lblSetDatCoc;
    public javax.swing.JLabel lblSetTongTien;
    public javax.swing.JLabel lblSetTrangThai;
    public static javax.swing.JLabel lblSoPhong;
    public javax.swing.JLabel lblThangDen;
    public javax.swing.JLabel lblThangDi;
    public javax.swing.JLabel lblTongThoiGian;
    public javax.swing.JLabel lblTongTien;
    public javax.swing.JMenuItem mniChuyenPhong;
    public javax.swing.JMenuItem mniDatPhong;
    public javax.swing.JMenuItem mniDonPhong;
    public javax.swing.JMenuItem mniHuyPhong;
    public javax.swing.JMenuItem mniKhachRaNgoai;
    public javax.swing.JMenuItem mniThanhToanNhom;
    public javax.swing.JMenuItem mniThuePhong;
    public javax.swing.JPopupMenu popMenu;
    public HELPER.PanelShadow sdoChiTietPhong;
    public javax.swing.JSeparator spt_1;
    public javax.swing.JSeparator spt_2;
    // End of variables declaration//GEN-END:variables
}

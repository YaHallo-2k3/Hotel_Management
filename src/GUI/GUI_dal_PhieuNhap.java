/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.BLL_ChiTietNhapKho;
import BLL.BLL_NhapKho;
import BLL.BLL_NhanVien;
import BLL.BLL_SanPham;
import DAL.DAL_ChiTietNhapKho;
import DAL.DAL_ThuePhong;
import DTO.DTO_ChiTietNhapKho;
import DTO.DTO_NhapKho;
import DTO.DTO_SanPham;
import HELPER.HELPER_ChuyenDoi;
import HELPER.HELPER_SetMa;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author CherryCe
 */
public class GUI_dal_PhieuNhap extends javax.swing.JDialog {

    public int row;
    public int column;
    public boolean isAddEdit;
    

    /**
     * Creates new form GUI_dalThongTinPhong
     */
    public GUI_dal_PhieuNhap(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        load();
        loadSanPham();
        loadChiTietNhapKho();
    }

    public String setMaPhieuNhap() {
        String maPhieuNhap = "PN";
        try {
            maPhieuNhap = maPhieuNhap + HELPER_ChuyenDoi.getTimeNow("yyMMdd");
            ResultSet rs = DAL_ChiTietNhapKho.count(HELPER_ChuyenDoi.getTimeNow("yyMMdd"));
            int rowCount = 0;
            while (rs.next()) {
                rowCount = rs.getInt(1);
                if (rowCount > 99) {
                    maPhieuNhap = maPhieuNhap + (rowCount + 1);
                } else if (rowCount > 9) {
                    maPhieuNhap = maPhieuNhap + "0" + (rowCount + 1);
                } else {
                    maPhieuNhap = maPhieuNhap + "00" + (rowCount + 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maPhieuNhap;
    }

    public void addChiTietNhapKho(int row, int column) {
        DTO_ChiTietNhapKho chiTietNhapKho = new DTO_ChiTietNhapKho(HELPER_SetMa.setMaCount("NK", DAL_ChiTietNhapKho.count()), lblSetSoPhieu.getText(), tblDichVu.getValueAt(row, 0).toString(), HELPER_ChuyenDoi.getSoInt(tblDichVu.getValueAt(row, 2).toString()), HELPER_ChuyenDoi.getSoInt(tblDichVu.getValueAt(row, 3).toString()));
        BLL_ChiTietNhapKho.add(chiTietNhapKho);
    }

    public void deleteChiTietNhapKho(int row) {
        BLL_ChiTietNhapKho.delete(lblSetSoPhieu.getText(), tblKhoDichVu.getValueAt(row, 0).toString());
    }

    public void loadSanPham() {
        ArrayList<DTO_SanPham> array = BLL_SanPham.select();
        new BLL_SanPham().loadSanPham(array, tblDichVu);
    }

    public void loadChiTietNhapKho() {
        ArrayList<DTO_ChiTietNhapKho> array = BLL_ChiTietNhapKho.select(lblSetSoPhieu.getText());
        new BLL_ChiTietNhapKho().load(array, tblKhoDichVu);
    }

    public void addNhapKho() {
        DTO_NhapKho nhapKho = new DTO_NhapKho(lblSetSoPhieu.getText(), lblSetNhanVien.getText(), HELPER_ChuyenDoi.getNgayDate("dd-MM-yyyy HH:mm", lblSetNgayTao.getText()), txtGhiChu.getText());
        BLL_NhapKho.add(nhapKho);
    }

    public void editNhapKho() {
        DTO_NhapKho nhapKho = new DTO_NhapKho(lblSetSoPhieu.getText(), lblSetNhanVien.getText(), HELPER_ChuyenDoi.getNgayDate("dd-MM-yyyy HH:mm", lblSetNgayTao.getText()), txtGhiChu.getText());
        BLL_NhapKho.edit(nhapKho);
    }

    public void load() {
        lblSetSoPhieu.setText(HELPER_SetMa.setMaDateTime("PN", DAL_ChiTietNhapKho.count(HELPER_ChuyenDoi.getTimeNow("yyMMdd"))));
        lblSetNhanVien.setText(BLL_NhanVien.nhanVienOnline());
        lblSetNgayTao.setText(HELPER_ChuyenDoi.getTimeNow("dd-MM-yyyy HH:mm"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sdoThongTinPhong = new HELPER.PanelShadow();
        lblSetSoPhieu = new javax.swing.JLabel();
        lblMaPhieu = new javax.swing.JLabel();
        lblSetNhanVien = new javax.swing.JLabel();
        lblNhanVien = new javax.swing.JLabel();
        lblGhiChu = new javax.swing.JLabel();
        lblNgayTao = new javax.swing.JLabel();
        lblPhieuNhap = new javax.swing.JLabel();
        lblSetNgayTao = new javax.swing.JLabel();
        lblDoUong = new javax.swing.JLabel();
        lblDiChuyen = new javax.swing.JLabel();
        lblAll = new javax.swing.JLabel();
        lblThucAn = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextField();
        lblExit = new javax.swing.JLabel();
        sdoDichVu = new HELPER.PanelShadow();
        scrDichVu = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();
        sdoKhoDichVu = new HELPER.PanelShadow();
        scrKhoDichVu = new javax.swing.JScrollPane();
        tblKhoDichVu = new javax.swing.JTable();
        sdoChucNang = new HELPER.PanelShadow();
        lblSetDaThanhToan = new javax.swing.JLabel();
        lblSetTongTien = new javax.swing.JLabel();
        lblDaThanhToan = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        lblThoat = new javax.swing.JLabel();
        lblCapNhat = new javax.swing.JLabel();
        lblInPhieu = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(860, 610));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sdoThongTinPhong.setBackground(new java.awt.Color(255, 255, 255));
        sdoThongTinPhong.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(33, 150, 243)));
        sdoThongTinPhong.setMinimumSize(new java.awt.Dimension(560, 280));
        sdoThongTinPhong.setPreferredSize(new java.awt.Dimension(560, 280));
        sdoThongTinPhong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSetSoPhieu.setBackground(new java.awt.Color(255, 255, 255));
        lblSetSoPhieu.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        lblSetSoPhieu.setForeground(new java.awt.Color(62, 73, 95));
        lblSetSoPhieu.setText("220912001");
        sdoThongTinPhong.add(lblSetSoPhieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, 20));

        lblMaPhieu.setBackground(new java.awt.Color(255, 255, 255));
        lblMaPhieu.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblMaPhieu.setForeground(new java.awt.Color(153, 153, 153));
        lblMaPhieu.setText("Mã Phiếu");
        sdoThongTinPhong.add(lblMaPhieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 60, 20));

        lblSetNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        lblSetNhanVien.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        lblSetNhanVien.setForeground(new java.awt.Color(62, 73, 95));
        lblSetNhanVien.setText("CherryCe");
        sdoThongTinPhong.add(lblSetNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, 20));

        lblNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        lblNhanVien.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblNhanVien.setForeground(new java.awt.Color(153, 153, 153));
        lblNhanVien.setText("Nhân Viên");
        sdoThongTinPhong.add(lblNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, 20));

        lblGhiChu.setBackground(new java.awt.Color(255, 255, 255));
        lblGhiChu.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblGhiChu.setForeground(new java.awt.Color(153, 153, 153));
        lblGhiChu.setText("Ghi Chú");
        sdoThongTinPhong.add(lblGhiChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        lblNgayTao.setBackground(new java.awt.Color(255, 255, 255));
        lblNgayTao.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblNgayTao.setForeground(new java.awt.Color(153, 153, 153));
        lblNgayTao.setText("Ngày Tạo");
        sdoThongTinPhong.add(lblNgayTao, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, -1, 20));

        lblPhieuNhap.setBackground(new java.awt.Color(255, 255, 255));
        lblPhieuNhap.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        lblPhieuNhap.setForeground(new java.awt.Color(62, 73, 95));
        lblPhieuNhap.setText("PHIẾU NHẬP");
        sdoThongTinPhong.add(lblPhieuNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        lblSetNgayTao.setBackground(new java.awt.Color(255, 255, 255));
        lblSetNgayTao.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        lblSetNgayTao.setForeground(new java.awt.Color(62, 73, 95));
        lblSetNgayTao.setText("16/09/22 22:08");
        sdoThongTinPhong.add(lblSetNgayTao, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, -1, 20));

        lblDoUong.setBackground(new java.awt.Color(255, 102, 102));
        lblDoUong.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblDoUong.setForeground(new java.awt.Color(255, 255, 255));
        lblDoUong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDoUong.setText("Đồ Uống");
        lblDoUong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblDoUong.setOpaque(true);
        sdoThongTinPhong.add(lblDoUong, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 60, 30));

        lblDiChuyen.setBackground(new java.awt.Color(255, 102, 102));
        lblDiChuyen.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblDiChuyen.setForeground(new java.awt.Color(255, 255, 255));
        lblDiChuyen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDiChuyen.setText("Di Chuyển");
        lblDiChuyen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblDiChuyen.setOpaque(true);
        sdoThongTinPhong.add(lblDiChuyen, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, 80, 30));

        lblAll.setBackground(new java.awt.Color(255, 102, 102));
        lblAll.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblAll.setForeground(new java.awt.Color(255, 255, 255));
        lblAll.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAll.setText("ALL");
        lblAll.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblAll.setOpaque(true);
        sdoThongTinPhong.add(lblAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 40, 30));

        lblThucAn.setBackground(new java.awt.Color(255, 102, 102));
        lblThucAn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblThucAn.setForeground(new java.awt.Color(255, 255, 255));
        lblThucAn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThucAn.setText("Thức Ăn");
        lblThucAn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblThucAn.setOpaque(true);
        sdoThongTinPhong.add(lblThucAn, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 60, 30));

        txtGhiChu.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        txtGhiChu.setForeground(new java.awt.Color(62, 73, 95));
        txtGhiChu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtGhiChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGhiChuActionPerformed(evt);
            }
        });
        sdoThongTinPhong.add(txtGhiChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 390, 20));

        lblExit.setBackground(new java.awt.Color(255, 255, 255));
        lblExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/close (1).png"))); // NOI18N
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });
        sdoThongTinPhong.add(lblExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 30, 30));

        getContentPane().add(sdoThongTinPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 130));

        sdoDichVu.setBackground(new java.awt.Color(255, 255, 255));
        sdoDichVu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(33, 150, 243)));
        sdoDichVu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDichVu.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Hàng", "Tên Hàng", "Số Lượng", "Giá Nhập", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDichVu.setRowHeight(30);
        tblDichVu.setShowHorizontalLines(false);
        tblDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDichVuMouseClicked(evt);
            }
        });
        scrDichVu.setViewportView(tblDichVu);
        if (tblDichVu.getColumnModel().getColumnCount() > 0) {
            tblDichVu.getColumnModel().getColumn(4).setMaxWidth(40);
        }

        sdoDichVu.add(scrDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 350, 390));

        getContentPane().add(sdoDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 390, 430));

        sdoKhoDichVu.setBackground(new java.awt.Color(255, 255, 255));
        sdoKhoDichVu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(33, 150, 243)));
        sdoKhoDichVu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblKhoDichVu.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        tblKhoDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hàng", "Tên Hàng", "Số Lượng", "Đơn Giá", "Thành Tiền", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhoDichVu.setRowHeight(30);
        tblKhoDichVu.setShowHorizontalLines(false);
        tblKhoDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhoDichVuMouseClicked(evt);
            }
        });
        scrKhoDichVu.setViewportView(tblKhoDichVu);
        if (tblKhoDichVu.getColumnModel().getColumnCount() > 0) {
            tblKhoDichVu.getColumnModel().getColumn(5).setMaxWidth(40);
        }

        sdoKhoDichVu.add(scrKhoDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 430, 390));

        getContentPane().add(sdoKhoDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 470, 430));

        sdoChucNang.setBackground(new java.awt.Color(255, 255, 255));
        sdoChucNang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(33, 150, 243)));
        sdoChucNang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSetDaThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        lblSetDaThanhToan.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        lblSetDaThanhToan.setForeground(new java.awt.Color(97, 177, 90));
        lblSetDaThanhToan.setText("220912001");
        sdoChucNang.add(lblSetDaThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, 30));

        lblSetTongTien.setBackground(new java.awt.Color(255, 255, 255));
        lblSetTongTien.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        lblSetTongTien.setForeground(new java.awt.Color(97, 177, 90));
        lblSetTongTien.setText("220912001");
        sdoChucNang.add(lblSetTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, 30));

        lblDaThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        lblDaThanhToan.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblDaThanhToan.setForeground(new java.awt.Color(153, 153, 153));
        lblDaThanhToan.setText("Đã Thanh Toán");
        sdoChucNang.add(lblDaThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, 30));

        lblTongTien.setBackground(new java.awt.Color(255, 255, 255));
        lblTongTien.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(153, 153, 153));
        lblTongTien.setText("Tổng Tiền");
        sdoChucNang.add(lblTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        lblThoat.setBackground(new java.awt.Color(255, 255, 255));
        lblThoat.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblThoat.setForeground(new java.awt.Color(33, 150, 243));
        lblThoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/logout (6).png"))); // NOI18N
        lblThoat.setText("Thoát");
        lblThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThoatMouseClicked(evt);
            }
        });
        sdoChucNang.add(lblThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 80, 30));

        lblCapNhat.setBackground(new java.awt.Color(255, 255, 255));
        lblCapNhat.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblCapNhat.setForeground(new java.awt.Color(33, 150, 243));
        lblCapNhat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/upgrade (3).png"))); // NOI18N
        lblCapNhat.setText("Cập Nhật");
        lblCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCapNhatMouseClicked(evt);
            }
        });
        sdoChucNang.add(lblCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 110, 30));

        lblInPhieu.setBackground(new java.awt.Color(255, 255, 255));
        lblInPhieu.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblInPhieu.setForeground(new java.awt.Color(33, 150, 243));
        lblInPhieu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInPhieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/bill (3).png"))); // NOI18N
        lblInPhieu.setText("In Phiếu");
        sdoChucNang.add(lblInPhieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 110, 30));

        getContentPane().add(sdoChucNang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 860, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtGhiChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGhiChuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhiChuActionPerformed

    private void lblThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_lblThoatMouseClicked

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_lblExitMouseClicked

    private void tblDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDichVuMouseClicked
        // TODO add your handling code here:
        row = tblDichVu.getSelectedRow();
        column = tblDichVu.getSelectedColumn();
        if (tblDichVu.getValueAt(row, column) == null) {
            addChiTietNhapKho(row, column);
            loadChiTietNhapKho();
        }
    }//GEN-LAST:event_tblDichVuMouseClicked

    private void tblKhoDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhoDichVuMouseClicked
        // TODO add your handling code here:
        row = tblKhoDichVu.getSelectedRow();
        column = tblKhoDichVu.getSelectedColumn();
        if (tblKhoDichVu.getValueAt(row, column) == null) {
            deleteChiTietNhapKho(row);
            loadChiTietNhapKho();
        }
    }//GEN-LAST:event_tblKhoDichVuMouseClicked

    private void lblCapNhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCapNhatMouseClicked
        // TODO add your handling code here:
        addNhapKho();
    }//GEN-LAST:event_lblCapNhatMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_dal_PhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_dal_PhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_dal_PhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_dal_PhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUI_dal_PhieuNhap dialog = new GUI_dal_PhieuNhap(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAll;
    private javax.swing.JLabel lblCapNhat;
    private javax.swing.JLabel lblDaThanhToan;
    private javax.swing.JLabel lblDiChuyen;
    private javax.swing.JLabel lblDoUong;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblGhiChu;
    private javax.swing.JLabel lblInPhieu;
    private javax.swing.JLabel lblMaPhieu;
    private javax.swing.JLabel lblNgayTao;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblPhieuNhap;
    private javax.swing.JLabel lblSetDaThanhToan;
    private javax.swing.JLabel lblSetNgayTao;
    private javax.swing.JLabel lblSetNhanVien;
    private javax.swing.JLabel lblSetSoPhieu;
    private javax.swing.JLabel lblSetTongTien;
    private javax.swing.JLabel lblThoat;
    private javax.swing.JLabel lblThucAn;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JScrollPane scrDichVu;
    private javax.swing.JScrollPane scrKhoDichVu;
    private HELPER.PanelShadow sdoChucNang;
    private HELPER.PanelShadow sdoDichVu;
    private HELPER.PanelShadow sdoKhoDichVu;
    private HELPER.PanelShadow sdoThongTinPhong;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTable tblKhoDichVu;
    private javax.swing.JTextField txtGhiChu;
    // End of variables declaration//GEN-END:variables
}

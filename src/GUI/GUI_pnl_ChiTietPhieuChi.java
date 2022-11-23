/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.BLL_PhieuChi;
import BLL.BLL_ThuNgan;
import BLL.BLL_ThuePhong;
import DTO.DTO_PhieuChi;
import DTO.DTO_Phong;
import DTO.DTO_ThuePhong;
import HELPER.HELPER_ChuyenDoi;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;

/**
 *
 * @author CherryCe
 */
public class GUI_pnl_ChiTietPhieuChi extends javax.swing.JPanel {

    public static int indexPosition;
    public static boolean isPhieuChi = false;

    /**
     * Creates new form GUI_pnlChiTietPhong
     */
    public GUI_pnl_ChiTietPhieuChi() {
        initComponents();
        load();
    }

    public void load() {
        ArrayList<DTO_PhieuChi> array = BLL_PhieuChi.search(GUI_pnl_QuanLiChiPhi.tuNgay, GUI_pnl_QuanLiChiPhi.denNgay, GUI_pnl_QuanLiChiPhi.index);
        BLL_PhieuChi.load(array, lblMaPhieu, lblSetMucChi, lblTongTien, lblLoaiTien, txtGhiChu, lblSetNgayTao, lblNhanVien);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sdoChiTietPhieuChi = new HELPER.PanelShadow();
        lblLoaiTien = new javax.swing.JLabel();
        lblNhanVien = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        lblMaPhieu = new javax.swing.JLabel();
        lblSetNgayTao = new javax.swing.JLabel();
        lblMucChi = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextField();
        lblNgayTao = new javax.swing.JLabel();
        lblSetMucChi = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(260, 170));
        setPreferredSize(new java.awt.Dimension(260, 170));

        sdoChiTietPhieuChi.setBackground(new java.awt.Color(255, 255, 255));
        sdoChiTietPhieuChi.setMinimumSize(new java.awt.Dimension(260, 170));
        sdoChiTietPhieuChi.setPreferredSize(new java.awt.Dimension(260, 170));
        sdoChiTietPhieuChi.setShadowOpacity(0.3F);
        sdoChiTietPhieuChi.setShadowSize(4);
        sdoChiTietPhieuChi.setShadowType(HELPER.ShadowType.BOT_RIGHT);
        sdoChiTietPhieuChi.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                sdoChiTietPhieuChiMouseMoved(evt);
            }
        });
        sdoChiTietPhieuChi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sdoChiTietPhieuChiMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sdoChiTietPhieuChiMouseExited(evt);
            }
        });
        sdoChiTietPhieuChi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLoaiTien.setBackground(new java.awt.Color(255, 255, 255));
        lblLoaiTien.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblLoaiTien.setForeground(new java.awt.Color(62, 73, 95));
        lblLoaiTien.setText("Tiền Mặt");
        sdoChiTietPhieuChi.add(lblLoaiTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 70, 20));

        lblNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        lblNhanVien.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblNhanVien.setForeground(new java.awt.Color(62, 73, 95));
        lblNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNhanVien.setText("CherryCe");
        lblNhanVien.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sdoChiTietPhieuChi.add(lblNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 80, 20));

        lblTongTien.setBackground(new java.awt.Color(255, 255, 255));
        lblTongTien.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(255, 102, 102));
        lblTongTien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTongTien.setText("525,000");
        sdoChiTietPhieuChi.add(lblTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 80, -1));

        lblMaPhieu.setBackground(new java.awt.Color(255, 255, 255));
        lblMaPhieu.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblMaPhieu.setForeground(new java.awt.Color(62, 73, 95));
        lblMaPhieu.setText("MC220922001");
        sdoChiTietPhieuChi.add(lblMaPhieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 90, 20));

        lblSetNgayTao.setBackground(new java.awt.Color(255, 255, 255));
        lblSetNgayTao.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblSetNgayTao.setForeground(new java.awt.Color(62, 73, 95));
        lblSetNgayTao.setText("22-09-22 22:22");
        sdoChiTietPhieuChi.add(lblSetNgayTao, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 90, 20));

        lblMucChi.setBackground(new java.awt.Color(255, 255, 255));
        lblMucChi.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        lblMucChi.setForeground(new java.awt.Color(153, 153, 153));
        lblMucChi.setText("Mục Chi");
        sdoChiTietPhieuChi.add(lblMucChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 50, 20));

        txtGhiChu.setEditable(false);
        txtGhiChu.setBackground(new java.awt.Color(255, 255, 255));
        txtGhiChu.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        txtGhiChu.setForeground(new java.awt.Color(62, 73, 95));
        txtGhiChu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        sdoChiTietPhieuChi.add(txtGhiChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 230, 20));

        lblNgayTao.setBackground(new java.awt.Color(255, 255, 255));
        lblNgayTao.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        lblNgayTao.setForeground(new java.awt.Color(153, 153, 153));
        lblNgayTao.setText("Ngày Tạo");
        sdoChiTietPhieuChi.add(lblNgayTao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 20));

        lblSetMucChi.setBackground(new java.awt.Color(255, 255, 255));
        lblSetMucChi.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblSetMucChi.setForeground(new java.awt.Color(62, 73, 95));
        lblSetMucChi.setText("22/09/22");
        sdoChiTietPhieuChi.add(lblSetMucChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 170, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sdoChiTietPhieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sdoChiTietPhieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sdoChiTietPhieuChiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sdoChiTietPhieuChiMouseClicked
        // TODO add your handling code here:
        indexPosition = GUI_pnl_QuanLiChiPhi.pnlFormChinh.getComponentZOrder(sdoChiTietPhieuChi);
        if (evt.getClickCount() == 2) {
            isPhieuChi = true;
            new GUI_dal_PhieuChi(null, true).setVisible(true);
        }
    }//GEN-LAST:event_sdoChiTietPhieuChiMouseClicked

    private void sdoChiTietPhieuChiMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sdoChiTietPhieuChiMouseMoved
        // TODO add your handling code here:
        sdoChiTietPhieuChi.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(33, 150, 243)));
    }//GEN-LAST:event_sdoChiTietPhieuChiMouseMoved

    private void sdoChiTietPhieuChiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sdoChiTietPhieuChiMouseExited
        // TODO add your handling code here:
        sdoChiTietPhieuChi.setBorder(null);
    }//GEN-LAST:event_sdoChiTietPhieuChiMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel lblLoaiTien;
    private javax.swing.JLabel lblMaPhieu;
    public javax.swing.JLabel lblMucChi;
    public javax.swing.JLabel lblNgayTao;
    public javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblSetMucChi;
    private javax.swing.JLabel lblSetNgayTao;
    private javax.swing.JLabel lblTongTien;
    public HELPER.PanelShadow sdoChiTietPhieuChi;
    private javax.swing.JTextField txtGhiChu;
    // End of variables declaration//GEN-END:variables
}

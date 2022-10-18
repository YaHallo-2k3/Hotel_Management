/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.GUI_pnl_ChiTietPhong;
import java.awt.GridLayout;

/**
 *
 * @author CherryCe
 */
public class GUI_pnl_QuanLiChiPhi extends javax.swing.JPanel {

    public static int index;

    /**
     * Creates new form GUI_pnlSoDoPhong
     */
    public GUI_pnl_QuanLiChiPhi() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        scrFormChinh = new javax.swing.JScrollPane();
        pnlFormChinh = new javax.swing.JPanel();
        sdoChucNang = new HELPER.PanelShadow();
        lblSetTongTien = new javax.swing.JLabel();
        lblTimKiem = new javax.swing.JLabel();
        dateTuNgay = new com.toedter.calendar.JDateChooser();
        dateDenNgay = new com.toedter.calendar.JDateChooser();
        lblTongTien = new javax.swing.JLabel();
        lblDenNgay = new javax.swing.JLabel();
        lblTuNgay = new javax.swing.JLabel();
        lblHangMucChi = new javax.swing.JLabel();
        lblThemPhieu = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1150, 730));
        setPreferredSize(new java.awt.Dimension(1150, 730));

        pnlFormChinh.setForeground(new java.awt.Color(255, 255, 255));
        pnlFormChinh.setLayout(new java.awt.GridLayout(3, 4, 20, 20));
        scrFormChinh.setViewportView(pnlFormChinh);

        sdoChucNang.setBackground(new java.awt.Color(255, 255, 255));
        sdoChucNang.setMinimumSize(new java.awt.Dimension(1150, 110));
        sdoChucNang.setPreferredSize(new java.awt.Dimension(1150, 110));
        sdoChucNang.setShadowOpacity(0.4F);
        sdoChucNang.setShadowSize(9);
        sdoChucNang.setShadowType(HELPER.ShadowType.BOT);
        sdoChucNang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSetTongTien.setBackground(new java.awt.Color(255, 255, 255));
        lblSetTongTien.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblSetTongTien.setForeground(new java.awt.Color(255, 102, 102));
        lblSetTongTien.setText("1,200K");
        sdoChucNang.add(lblSetTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 70, 20));

        lblTimKiem.setBackground(new java.awt.Color(255, 255, 255));
        lblTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/magnifier (1).png"))); // NOI18N
        sdoChucNang.add(lblTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 30, 30));

        dateTuNgay.setBackground(new java.awt.Color(255, 255, 255));
        dateTuNgay.setForeground(new java.awt.Color(62, 73, 95));
        dateTuNgay.setDateFormatString("dd-MM-yyyy");
        sdoChucNang.add(dateTuNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 100, 20));

        dateDenNgay.setBackground(new java.awt.Color(255, 255, 255));
        dateDenNgay.setForeground(new java.awt.Color(62, 73, 95));
        dateDenNgay.setDateFormatString("dd-MM-yyyy");
        sdoChucNang.add(dateDenNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 100, 20));

        lblTongTien.setBackground(new java.awt.Color(255, 255, 255));
        lblTongTien.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(153, 153, 153));
        lblTongTien.setText("Tổng Tiền");
        sdoChucNang.add(lblTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, 20));

        lblDenNgay.setBackground(new java.awt.Color(255, 255, 255));
        lblDenNgay.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblDenNgay.setForeground(new java.awt.Color(153, 153, 153));
        lblDenNgay.setText("Đến Ngày");
        sdoChucNang.add(lblDenNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, 20));

        lblTuNgay.setBackground(new java.awt.Color(255, 255, 255));
        lblTuNgay.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblTuNgay.setForeground(new java.awt.Color(153, 153, 153));
        lblTuNgay.setText("Từ Ngày");
        sdoChucNang.add(lblTuNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 20));

        lblHangMucChi.setBackground(new java.awt.Color(255, 255, 255));
        lblHangMucChi.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblHangMucChi.setForeground(new java.awt.Color(33, 150, 243));
        lblHangMucChi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/store.png"))); // NOI18N
        lblHangMucChi.setText("Hạng Mục Chi");
        lblHangMucChi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHangMucChiMouseClicked(evt);
            }
        });
        sdoChucNang.add(lblHangMucChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 40, 130, 30));

        lblThemPhieu.setBackground(new java.awt.Color(255, 255, 255));
        lblThemPhieu.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblThemPhieu.setForeground(new java.awt.Color(33, 150, 243));
        lblThemPhieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/add (2).png"))); // NOI18N
        lblThemPhieu.setText("Tạo Phiếu");
        lblThemPhieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThemPhieuMouseClicked(evt);
            }
        });
        sdoChucNang.add(lblThemPhieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 40, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sdoChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(scrFormChinh, javax.swing.GroupLayout.PREFERRED_SIZE, 1150, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sdoChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrFormChinh, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblHangMucChiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHangMucChiMouseClicked
        // TODO add your handling code here:
        new GUI_dal_HangMucChi(null, true).setVisible(true);
    }//GEN-LAST:event_lblHangMucChiMouseClicked

    private void lblThemPhieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemPhieuMouseClicked
        // TODO add your handling code here:
         new GUI_dal_PhieuChi(null, true).setVisible(true);
    }//GEN-LAST:event_lblThemPhieuMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateDenNgay;
    private com.toedter.calendar.JDateChooser dateTuNgay;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDenNgay;
    private javax.swing.JLabel lblHangMucChi;
    private javax.swing.JLabel lblSetTongTien;
    private javax.swing.JLabel lblThemPhieu;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTuNgay;
    private javax.swing.JPanel pnlFormChinh;
    private javax.swing.JScrollPane scrFormChinh;
    private HELPER.PanelShadow sdoChucNang;
    // End of variables declaration//GEN-END:variables
}

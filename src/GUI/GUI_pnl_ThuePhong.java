/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.BLL_ThuePhong;
import GUI.GUI_pnl_ChiTietPhong;
import java.awt.GridLayout;

/**
 *
 * @author CherryCe
 */
public class GUI_pnl_ThuePhong extends javax.swing.JPanel {

    public static int index;

    /**
     * Creates new form GUI_pnlThuePhong
     */
    public GUI_pnl_ThuePhong() {
        initComponents();
        load();
    }
    
    public void load() {
        if (BLL_ThuePhong.countThuePhong()% 4 == 0) {
            pnlFormChinh.setLayout(new GridLayout(BLL_ThuePhong.countThuePhong()/ 4, 4, 20, 20));
        } else {
            pnlFormChinh.setLayout(new GridLayout(BLL_ThuePhong.countThuePhong()/ 4 + 1, 4, 20, 20));
        }
        for (int i = 1; i <= BLL_ThuePhong.countThuePhong(); i++) {
            index = i;
            pnlFormChinh.add(new GUI_pnl_ChiTietThuePhong().sdoChiTietThuePhong);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrFormChinh = new javax.swing.JScrollPane();
        pnlFormChinh = new javax.swing.JPanel();
        sdoChucNang = new HELPER.PanelShadow();
        lblsetDaTra = new javax.swing.JLabel();
        lblTimKiem = new javax.swing.JLabel();
        lblGioPhutTuNgay = new javax.swing.JLabel();
        lblGioPhutDenNgay = new javax.swing.JLabel();
        dateTuNgay = new com.toedter.calendar.JDateChooser();
        dateDenNgay = new com.toedter.calendar.JDateChooser();
        lblTongTien = new javax.swing.JLabel();
        lblDenNgay = new javax.swing.JLabel();
        lblTuNgay = new javax.swing.JLabel();
        lblTongCOng = new javax.swing.JLabel();
        lblTienPhong = new javax.swing.JLabel();
        lblDichVu = new javax.swing.JLabel();
        lblDaTra = new javax.swing.JLabel();
        lblSetTongTien1 = new javax.swing.JLabel();
        lblSetTienPhong = new javax.swing.JLabel();
        lblSetDichVu = new javax.swing.JLabel();
        lblSetTongCong = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1150, 730));
        setPreferredSize(new java.awt.Dimension(1150, 730));

        scrFormChinh.setBackground(new java.awt.Color(255, 255, 255));
        scrFormChinh.setBorder(null);

        pnlFormChinh.setMinimumSize(new java.awt.Dimension(1150, 620));
        pnlFormChinh.setPreferredSize(new java.awt.Dimension(1150, 620));
        pnlFormChinh.setLayout(new java.awt.GridLayout(1, 0));
        scrFormChinh.setViewportView(pnlFormChinh);

        sdoChucNang.setBackground(new java.awt.Color(255, 255, 255));
        sdoChucNang.setMinimumSize(new java.awt.Dimension(1150, 110));
        sdoChucNang.setPreferredSize(new java.awt.Dimension(1150, 110));
        sdoChucNang.setShadowOpacity(0.4F);
        sdoChucNang.setShadowSize(9);
        sdoChucNang.setShadowType(HELPER.ShadowType.BOT);
        sdoChucNang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblsetDaTra.setBackground(new java.awt.Color(255, 255, 255));
        lblsetDaTra.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblsetDaTra.setForeground(new java.awt.Color(97, 177, 90));
        lblsetDaTra.setText("1,200K");
        sdoChucNang.add(lblsetDaTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 50, 90, 20));

        lblTimKiem.setBackground(new java.awt.Color(255, 255, 255));
        lblTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/magnifier (1).png"))); // NOI18N
        sdoChucNang.add(lblTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 30, 30));

        lblGioPhutTuNgay.setBackground(new java.awt.Color(255, 255, 255));
        lblGioPhutTuNgay.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        lblGioPhutTuNgay.setForeground(new java.awt.Color(62, 73, 95));
        lblGioPhutTuNgay.setText("00:00");
        lblGioPhutTuNgay.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        sdoChucNang.add(lblGioPhutTuNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 40, 20));

        lblGioPhutDenNgay.setBackground(new java.awt.Color(255, 255, 255));
        lblGioPhutDenNgay.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        lblGioPhutDenNgay.setForeground(new java.awt.Color(62, 73, 95));
        lblGioPhutDenNgay.setText("00:00");
        lblGioPhutDenNgay.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        sdoChucNang.add(lblGioPhutDenNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 40, 20));

        dateTuNgay.setBackground(new java.awt.Color(255, 255, 255));
        dateTuNgay.setForeground(new java.awt.Color(62, 73, 95));
        dateTuNgay.setDateFormatString("dd-MM-yyyy");
        sdoChucNang.add(dateTuNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 100, 20));

        dateDenNgay.setBackground(new java.awt.Color(255, 255, 255));
        dateDenNgay.setForeground(new java.awt.Color(62, 73, 95));
        dateDenNgay.setDateFormatString("dd-MM-yyyy");
        sdoChucNang.add(dateDenNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 100, 20));

        lblTongTien.setBackground(new java.awt.Color(255, 255, 255));
        lblTongTien.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(153, 153, 153));
        lblTongTien.setText("Còn Lại");
        sdoChucNang.add(lblTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 20, -1, 20));

        lblDenNgay.setBackground(new java.awt.Color(255, 255, 255));
        lblDenNgay.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblDenNgay.setForeground(new java.awt.Color(153, 153, 153));
        lblDenNgay.setText("Đến Ngày");
        sdoChucNang.add(lblDenNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, 20));

        lblTuNgay.setBackground(new java.awt.Color(255, 255, 255));
        lblTuNgay.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblTuNgay.setForeground(new java.awt.Color(153, 153, 153));
        lblTuNgay.setText("Từ Ngày");
        sdoChucNang.add(lblTuNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 20));

        lblTongCOng.setBackground(new java.awt.Color(255, 255, 255));
        lblTongCOng.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblTongCOng.setForeground(new java.awt.Color(153, 153, 153));
        lblTongCOng.setText("Tổng Cộng");
        sdoChucNang.add(lblTongCOng, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, -1, 20));

        lblTienPhong.setBackground(new java.awt.Color(255, 255, 255));
        lblTienPhong.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblTienPhong.setForeground(new java.awt.Color(153, 153, 153));
        lblTienPhong.setText("Tiền Phòng");
        sdoChucNang.add(lblTienPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, -1, 20));

        lblDichVu.setBackground(new java.awt.Color(255, 255, 255));
        lblDichVu.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblDichVu.setForeground(new java.awt.Color(153, 153, 153));
        lblDichVu.setText("Dịch Vụ");
        sdoChucNang.add(lblDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, -1, 20));

        lblDaTra.setBackground(new java.awt.Color(255, 255, 255));
        lblDaTra.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblDaTra.setForeground(new java.awt.Color(153, 153, 153));
        lblDaTra.setText("Đã Trả");
        sdoChucNang.add(lblDaTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, -1, 20));

        lblSetTongTien1.setBackground(new java.awt.Color(255, 255, 255));
        lblSetTongTien1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblSetTongTien1.setForeground(new java.awt.Color(97, 177, 90));
        lblSetTongTien1.setText("1,200K");
        sdoChucNang.add(lblSetTongTien1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 50, 90, 20));

        lblSetTienPhong.setBackground(new java.awt.Color(255, 255, 255));
        lblSetTienPhong.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblSetTienPhong.setForeground(new java.awt.Color(97, 177, 90));
        lblSetTienPhong.setText("1,200,000");
        sdoChucNang.add(lblSetTienPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 90, 20));

        lblSetDichVu.setBackground(new java.awt.Color(255, 255, 255));
        lblSetDichVu.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblSetDichVu.setForeground(new java.awt.Color(97, 177, 90));
        lblSetDichVu.setText("1,200K");
        sdoChucNang.add(lblSetDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 90, 20));

        lblSetTongCong.setBackground(new java.awt.Color(255, 255, 255));
        lblSetTongCong.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblSetTongCong.setForeground(new java.awt.Color(255, 102, 102));
        lblSetTongCong.setText("1,200K");
        sdoChucNang.add(lblSetTongCong, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 50, 90, 20));

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateDenNgay;
    private com.toedter.calendar.JDateChooser dateTuNgay;
    private javax.swing.JLabel lblDaTra;
    private javax.swing.JLabel lblDenNgay;
    private javax.swing.JLabel lblDichVu;
    private javax.swing.JLabel lblGioPhutDenNgay;
    private javax.swing.JLabel lblGioPhutTuNgay;
    private javax.swing.JLabel lblSetDichVu;
    private javax.swing.JLabel lblSetTienPhong;
    private javax.swing.JLabel lblSetTongCong;
    private javax.swing.JLabel lblSetTongTien1;
    private javax.swing.JLabel lblTienPhong;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JLabel lblTongCOng;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTuNgay;
    private javax.swing.JLabel lblsetDaTra;
    private javax.swing.JPanel pnlFormChinh;
    private javax.swing.JScrollPane scrFormChinh;
    private HELPER.PanelShadow sdoChucNang;
    // End of variables declaration//GEN-END:variables
}

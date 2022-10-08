/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.BLL_ThuNgan;
import GUI.GUI_pnl_ChiTietPhong;
import java.awt.GridLayout;

/**
 *
 * @author CherryCe
 */
public class GUI_pnl_ThuNgan extends javax.swing.JPanel {

    public static int index;

    /**
     * Creates new form GUI_pnlSoDoPhong
     */
    public GUI_pnl_ThuNgan() {
        initComponents();
        for (int i = 1; i <= BLL_ThuNgan.countThuePhong(); i++) {
            index = i;
            pnlFormChinh.add(new GUI_pnl_ChiTietThuNgan().sdoChiTietThuNgan);
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

        jPanel2 = new javax.swing.JPanel();
        scrFormChinh = new javax.swing.JScrollPane();
        pnlFormChinh = new javax.swing.JPanel();
        sdoChucNang = new HELPER.PanelShadow();
        lblSetTongTien = new javax.swing.JLabel();
        lblTimKiem = new javax.swing.JLabel();
        lblGioPhutVao = new javax.swing.JLabel();
        lblGioPhutRa = new javax.swing.JLabel();
        cboNhanVien = new javax.swing.JComboBox<>();
        dateTuNgay = new com.toedter.calendar.JDateChooser();
        dateDenNgay = new com.toedter.calendar.JDateChooser();
        lblNhanVien = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        lblDenNgay = new javax.swing.JLabel();
        lblTuNgay = new javax.swing.JLabel();
        lblGiaoCa = new javax.swing.JLabel();

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
        sdoChucNang.add(lblSetTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, 70, 20));

        lblTimKiem.setBackground(new java.awt.Color(255, 255, 255));
        lblTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/magnifier (1).png"))); // NOI18N
        sdoChucNang.add(lblTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 30, 30));

        lblGioPhutVao.setBackground(new java.awt.Color(255, 255, 255));
        lblGioPhutVao.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        lblGioPhutVao.setForeground(new java.awt.Color(62, 73, 95));
        lblGioPhutVao.setText("00:00");
        lblGioPhutVao.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        sdoChucNang.add(lblGioPhutVao, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 40, 20));

        lblGioPhutRa.setBackground(new java.awt.Color(255, 255, 255));
        lblGioPhutRa.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        lblGioPhutRa.setForeground(new java.awt.Color(62, 73, 95));
        lblGioPhutRa.setText("00:00");
        lblGioPhutRa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        sdoChucNang.add(lblGioPhutRa, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 40, 20));

        cboNhanVien.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        cboNhanVien.setForeground(new java.awt.Color(62, 73, 95));
        cboNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboNhanVien.setBorder(null);
        sdoChucNang.add(cboNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 100, 20));

        dateTuNgay.setBackground(new java.awt.Color(255, 255, 255));
        dateTuNgay.setForeground(new java.awt.Color(62, 73, 95));
        dateTuNgay.setDateFormatString("dd-MM-yyyy");
        sdoChucNang.add(dateTuNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 100, 20));

        dateDenNgay.setBackground(new java.awt.Color(255, 255, 255));
        dateDenNgay.setForeground(new java.awt.Color(62, 73, 95));
        dateDenNgay.setDateFormatString("dd-MM-yyyy");
        sdoChucNang.add(dateDenNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 100, 20));

        lblNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        lblNhanVien.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblNhanVien.setForeground(new java.awt.Color(153, 153, 153));
        lblNhanVien.setText("Nhân Viên");
        sdoChucNang.add(lblNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, 20));

        lblTongTien.setBackground(new java.awt.Color(255, 255, 255));
        lblTongTien.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(153, 153, 153));
        lblTongTien.setText("Tổng Tiền");
        sdoChucNang.add(lblTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, 20));

        lblDenNgay.setBackground(new java.awt.Color(255, 255, 255));
        lblDenNgay.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblDenNgay.setForeground(new java.awt.Color(153, 153, 153));
        lblDenNgay.setText("Đến Ngày");
        sdoChucNang.add(lblDenNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, 20));

        lblTuNgay.setBackground(new java.awt.Color(255, 255, 255));
        lblTuNgay.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblTuNgay.setForeground(new java.awt.Color(153, 153, 153));
        lblTuNgay.setText("Từ Ngày");
        sdoChucNang.add(lblTuNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 20));

        lblGiaoCa.setBackground(new java.awt.Color(255, 255, 255));
        lblGiaoCa.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblGiaoCa.setForeground(new java.awt.Color(33, 150, 243));
        lblGiaoCa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/exchange (3).png"))); // NOI18N
        lblGiaoCa.setText("Giao Ca");
        lblGiaoCa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblGiaoCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGiaoCaMouseClicked(evt);
            }
        });
        sdoChucNang.add(lblGiaoCa, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 40, 90, 30));

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

    private void lblGiaoCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGiaoCaMouseClicked
        // TODO add your handling code here:
        new GUI_dal_ThongTinGiaoCa(null, true).setVisible(true);
    }//GEN-LAST:event_lblGiaoCaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboNhanVien;
    private com.toedter.calendar.JDateChooser dateDenNgay;
    private com.toedter.calendar.JDateChooser dateTuNgay;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDenNgay;
    private javax.swing.JLabel lblGiaoCa;
    private javax.swing.JLabel lblGioPhutRa;
    private javax.swing.JLabel lblGioPhutVao;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblSetTongTien;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTuNgay;
    private javax.swing.JPanel pnlFormChinh;
    private javax.swing.JScrollPane scrFormChinh;
    private HELPER.PanelShadow sdoChucNang;
    // End of variables declaration//GEN-END:variables
}

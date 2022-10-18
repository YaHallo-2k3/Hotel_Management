/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.BLL_SoDoPhong;
import DAL.DAL_SoDoPhong;
import GUI.GUI_pnl_ChiTietPhong;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Calendar;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author CherryCe
 */
public class GUI_pnl_SoDoPhong extends javax.swing.JPanel {

    public static int index;

    /**
     * Creates new form GUI_pnlSoDoPhong
     */
    public GUI_pnl_SoDoPhong() {
        initComponents();
        load();
    }

    public void load() {
        if (BLL_SoDoPhong.countPhong() % 5 == 0) {
            pnlFormChinh.setLayout(new GridLayout(BLL_SoDoPhong.countPhong() / 5, 5, 10, 7));
        } else {
            pnlFormChinh.setLayout(new GridLayout(BLL_SoDoPhong.countPhong() / 5 + 1, 5, 10, 7));
        }
        for (int i = 1; i <= BLL_SoDoPhong.countPhong(); i++) {
            index = i;
            pnlFormChinh.add(new GUI_pnl_ChiTietPhong().sdoChiTietPhong);
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

        sdoChuThich = new HELPER.PanelShadow();
        spt_1 = new javax.swing.JSeparator();
        spt_2 = new javax.swing.JSeparator();
        cboTang = new javax.swing.JComboBox<>();
        dateNgay = new com.toedter.calendar.JDateChooser();
        lblSetDatTruoc = new javax.swing.JLabel();
        lblSetPhongTrong = new javax.swing.JLabel();
        lblSetTraPhong = new javax.swing.JLabel();
        lblSetCoKhach = new javax.swing.JLabel();
        lblDatPhong = new javax.swing.JLabel();
        lblTang = new javax.swing.JLabel();
        lblDonPhong = new javax.swing.JLabel();
        lblRaNgoai = new javax.swing.JLabel();
        lblPhongTrong = new javax.swing.JLabel();
        lblNgay = new javax.swing.JLabel();
        lblCoKhach = new javax.swing.JLabel();
        scrFormChinh = new javax.swing.JScrollPane();
        pnlFormChinh = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1150, 730));
        setPreferredSize(new java.awt.Dimension(1150, 730));

        sdoChuThich.setBackground(new java.awt.Color(255, 255, 255));
        sdoChuThich.setMinimumSize(new java.awt.Dimension(1150, 110));
        sdoChuThich.setPreferredSize(new java.awt.Dimension(1150, 110));
        sdoChuThich.setShadowOpacity(0.4F);
        sdoChuThich.setShadowSize(9);
        sdoChuThich.setShadowType(HELPER.ShadowType.BOT);
        sdoChuThich.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        spt_1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        sdoChuThich.add(spt_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 10, 60));

        spt_2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        sdoChuThich.add(spt_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, 10, 60));

        cboTang.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        cboTang.setForeground(new java.awt.Color(62, 73, 95));
        cboTang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTang.setToolTipText("");
        cboTang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        sdoChuThich.add(cboTang, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 80, 20));

        dateNgay.setBackground(new java.awt.Color(255, 255, 255));
        dateNgay.setForeground(new java.awt.Color(62, 73, 95));
        dateNgay.setToolTipText("");
        dateNgay.setDateFormatString("dd-MM-yyyy");
        sdoChuThich.add(dateNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 100, 20));

        lblSetDatTruoc.setBackground(new java.awt.Color(102, 153, 255));
        lblSetDatTruoc.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblSetDatTruoc.setForeground(new java.awt.Color(255, 255, 255));
        lblSetDatTruoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSetDatTruoc.setText("Đặt Trước");
        lblSetDatTruoc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblSetDatTruoc.setOpaque(true);
        sdoChuThich.add(lblSetDatTruoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 50, 110, 20));

        lblSetPhongTrong.setBackground(new java.awt.Color(97, 177, 90));
        lblSetPhongTrong.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblSetPhongTrong.setForeground(new java.awt.Color(255, 255, 255));
        lblSetPhongTrong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSetPhongTrong.setText("Phòng Trống");
        lblSetPhongTrong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblSetPhongTrong.setOpaque(true);
        sdoChuThich.add(lblSetPhongTrong, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, 110, 20));

        lblSetTraPhong.setBackground(new java.awt.Color(240, 165, 0));
        lblSetTraPhong.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblSetTraPhong.setForeground(new java.awt.Color(255, 255, 255));
        lblSetTraPhong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSetTraPhong.setText("Trả Phòng");
        lblSetTraPhong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblSetTraPhong.setOpaque(true);
        sdoChuThich.add(lblSetTraPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 10, 110, 20));

        lblSetCoKhach.setBackground(new java.awt.Color(255, 142, 113));
        lblSetCoKhach.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblSetCoKhach.setForeground(new java.awt.Color(255, 255, 255));
        lblSetCoKhach.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSetCoKhach.setText("Có Khách");
        lblSetCoKhach.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblSetCoKhach.setOpaque(true);
        lblSetCoKhach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSetCoKhachMouseClicked(evt);
            }
        });
        sdoChuThich.add(lblSetCoKhach, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 110, 20));

        lblDatPhong.setBackground(new java.awt.Color(255, 255, 255));
        lblDatPhong.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblDatPhong.setForeground(new java.awt.Color(62, 73, 95));
        lblDatPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/add.png"))); // NOI18N
        lblDatPhong.setText("Đặt Phòng");
        lblDatPhong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblDatPhong.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        sdoChuThich.add(lblDatPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, -1, -1));

        lblTang.setBackground(new java.awt.Color(255, 255, 255));
        lblTang.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblTang.setForeground(new java.awt.Color(153, 153, 153));
        lblTang.setText("Tầng");
        sdoChuThich.add(lblTang, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 40, -1));

        lblDonPhong.setBackground(new java.awt.Color(255, 255, 255));
        lblDonPhong.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblDonPhong.setForeground(new java.awt.Color(62, 73, 95));
        lblDonPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/mop.png"))); // NOI18N
        lblDonPhong.setText("Dọn Phòng");
        lblDonPhong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblDonPhong.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        sdoChuThich.add(lblDonPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, -1, -1));

        lblRaNgoai.setBackground(new java.awt.Color(255, 255, 255));
        lblRaNgoai.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblRaNgoai.setForeground(new java.awt.Color(62, 73, 95));
        lblRaNgoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/logout (1).png"))); // NOI18N
        lblRaNgoai.setText("Khách Ra Ngoài");
        lblRaNgoai.setFocusable(false);
        lblRaNgoai.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblRaNgoai.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        sdoChuThich.add(lblRaNgoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, -1));

        lblPhongTrong.setBackground(new java.awt.Color(255, 255, 255));
        lblPhongTrong.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblPhongTrong.setForeground(new java.awt.Color(62, 73, 95));
        lblPhongTrong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/beds.png"))); // NOI18N
        lblPhongTrong.setText("Phòng Trống");
        lblPhongTrong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblPhongTrong.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        sdoChuThich.add(lblPhongTrong, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        lblNgay.setBackground(new java.awt.Color(255, 255, 255));
        lblNgay.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblNgay.setForeground(new java.awt.Color(153, 153, 153));
        lblNgay.setText("Ngày");
        sdoChuThich.add(lblNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 20));

        lblCoKhach.setBackground(new java.awt.Color(255, 255, 255));
        lblCoKhach.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblCoKhach.setForeground(new java.awt.Color(62, 73, 95));
        lblCoKhach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/hotel-sign (1).png"))); // NOI18N
        lblCoKhach.setText("Có Khách");
        lblCoKhach.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblCoKhach.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        sdoChuThich.add(lblCoKhach, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        scrFormChinh.setBackground(new java.awt.Color(255, 255, 255));

        pnlFormChinh.setBackground(new java.awt.Color(255, 255, 255));
        pnlFormChinh.setLayout(new java.awt.GridLayout(9, 5, 7, 10));
        scrFormChinh.setViewportView(pnlFormChinh);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sdoChuThich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(scrFormChinh, javax.swing.GroupLayout.PREFERRED_SIZE, 1150, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sdoChuThich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrFormChinh, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblSetCoKhachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSetCoKhachMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_lblSetCoKhachMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboTang;
    private com.toedter.calendar.JDateChooser dateNgay;
    private javax.swing.JLabel lblCoKhach;
    private javax.swing.JLabel lblDatPhong;
    private javax.swing.JLabel lblDonPhong;
    private javax.swing.JLabel lblNgay;
    private javax.swing.JLabel lblPhongTrong;
    private javax.swing.JLabel lblRaNgoai;
    private javax.swing.JLabel lblSetCoKhach;
    private javax.swing.JLabel lblSetDatTruoc;
    private javax.swing.JLabel lblSetPhongTrong;
    private javax.swing.JLabel lblSetTraPhong;
    private javax.swing.JLabel lblTang;
    public static javax.swing.JPanel pnlFormChinh;
    public static javax.swing.JScrollPane scrFormChinh;
    public static HELPER.PanelShadow sdoChuThich;
    private javax.swing.JSeparator spt_1;
    private javax.swing.JSeparator spt_2;
    // End of variables declaration//GEN-END:variables
}

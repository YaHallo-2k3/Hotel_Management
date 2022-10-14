/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author CherryCe
 */
public class GUI_dal_HangTonKho extends javax.swing.JDialog {

    /**
     * Creates new form GUI_dalThongTinPhong
     */
    public GUI_dal_HangTonKho(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
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
        lblDenNgay = new javax.swing.JLabel();
        lblTuNgay = new javax.swing.JLabel();
        lblTienBan = new javax.swing.JLabel();
        lblTenHang = new javax.swing.JLabel();
        lblHangTonKho = new javax.swing.JLabel();
        lblSetTienBan = new javax.swing.JLabel();
        txtTenHang = new javax.swing.JTextField();
        dateTuNgay = new com.toedter.calendar.JDateChooser();
        dateTuNgay1 = new com.toedter.calendar.JDateChooser();
        lblMaHang = new javax.swing.JLabel();
        txtMaHang = new javax.swing.JTextField();
        lblTienNhap = new javax.swing.JLabel();
        lblSetTienNhap = new javax.swing.JLabel();
        lblTimKiem = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();
        sdoHangTon = new HELPER.PanelShadow();
        scrHangTon = new javax.swing.JScrollPane();
        tblHangTon = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(770, 490));
        setUndecorated(true);

        sdoThongTinPhong.setBackground(new java.awt.Color(255, 255, 255));
        sdoThongTinPhong.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(33, 150, 243)));
        sdoThongTinPhong.setMinimumSize(new java.awt.Dimension(560, 280));
        sdoThongTinPhong.setPreferredSize(new java.awt.Dimension(560, 280));
        sdoThongTinPhong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDenNgay.setBackground(new java.awt.Color(255, 255, 255));
        lblDenNgay.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblDenNgay.setForeground(new java.awt.Color(153, 153, 153));
        lblDenNgay.setText("Đến Ngày");
        sdoThongTinPhong.add(lblDenNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));

        lblTuNgay.setBackground(new java.awt.Color(255, 255, 255));
        lblTuNgay.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblTuNgay.setForeground(new java.awt.Color(153, 153, 153));
        lblTuNgay.setText("Từ Ngày");
        sdoThongTinPhong.add(lblTuNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        lblTienBan.setBackground(new java.awt.Color(255, 255, 255));
        lblTienBan.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblTienBan.setForeground(new java.awt.Color(153, 153, 153));
        lblTienBan.setText("Tiền Bán");
        sdoThongTinPhong.add(lblTienBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, -1, 20));

        lblTenHang.setBackground(new java.awt.Color(255, 255, 255));
        lblTenHang.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblTenHang.setForeground(new java.awt.Color(153, 153, 153));
        lblTenHang.setText("Tên Hàng");
        sdoThongTinPhong.add(lblTenHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, 20));

        lblHangTonKho.setBackground(new java.awt.Color(255, 255, 255));
        lblHangTonKho.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        lblHangTonKho.setForeground(new java.awt.Color(62, 73, 95));
        lblHangTonKho.setText("HÀNG TỒN KHO");
        sdoThongTinPhong.add(lblHangTonKho, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        lblSetTienBan.setBackground(new java.awt.Color(255, 255, 255));
        lblSetTienBan.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        lblSetTienBan.setForeground(new java.awt.Color(62, 73, 95));
        lblSetTienBan.setText("00");
        sdoThongTinPhong.add(lblSetTienBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 70, 20));

        txtTenHang.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        txtTenHang.setForeground(new java.awt.Color(62, 73, 95));
        txtTenHang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtTenHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenHangActionPerformed(evt);
            }
        });
        sdoThongTinPhong.add(txtTenHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 70, 20));

        dateTuNgay.setBackground(new java.awt.Color(255, 255, 255));
        dateTuNgay.setForeground(new java.awt.Color(62, 73, 95));
        dateTuNgay.setDateFormatString("dd-MM-yyyy");
        sdoThongTinPhong.add(dateTuNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 100, 20));

        dateTuNgay1.setBackground(new java.awt.Color(255, 255, 255));
        dateTuNgay1.setForeground(new java.awt.Color(62, 73, 95));
        dateTuNgay1.setDateFormatString("dd-MM-yyyy");
        sdoThongTinPhong.add(dateTuNgay1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 100, 20));

        lblMaHang.setBackground(new java.awt.Color(255, 255, 255));
        lblMaHang.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblMaHang.setForeground(new java.awt.Color(153, 153, 153));
        lblMaHang.setText("Mã Hàng");
        sdoThongTinPhong.add(lblMaHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, 20));

        txtMaHang.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        txtMaHang.setForeground(new java.awt.Color(62, 73, 95));
        txtMaHang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtMaHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHangActionPerformed(evt);
            }
        });
        sdoThongTinPhong.add(txtMaHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 70, 20));

        lblTienNhap.setBackground(new java.awt.Color(255, 255, 255));
        lblTienNhap.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblTienNhap.setForeground(new java.awt.Color(153, 153, 153));
        lblTienNhap.setText("Tiền Nhập");
        sdoThongTinPhong.add(lblTienNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, -1, 20));

        lblSetTienNhap.setBackground(new java.awt.Color(255, 255, 255));
        lblSetTienNhap.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        lblSetTienNhap.setForeground(new java.awt.Color(62, 73, 95));
        lblSetTienNhap.setText("0");
        sdoThongTinPhong.add(lblSetTienNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 70, 20));

        lblTimKiem.setBackground(new java.awt.Color(255, 255, 255));
        lblTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/magnifier (1).png"))); // NOI18N
        sdoThongTinPhong.add(lblTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 30, 30));

        lblExit.setBackground(new java.awt.Color(255, 255, 255));
        lblExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/close (1).png"))); // NOI18N
        sdoThongTinPhong.add(lblExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 30, 30));

        sdoHangTon.setBackground(new java.awt.Color(255, 255, 255));
        sdoHangTon.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(33, 150, 243)));
        sdoHangTon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblHangTon.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        tblHangTon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hàng", "Tên Hàng", "Đơn Vị", "Lượng Nhập", "Giá Nhập", "Lượng Bán", "Giá Bán", "Tồn Kho"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHangTon.setRowHeight(30);
        tblHangTon.setShowHorizontalLines(false);
        scrHangTon.setViewportView(tblHangTon);

        sdoHangTon.add(scrHangTon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 730, 330));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sdoThongTinPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(sdoHangTon, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sdoThongTinPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(sdoHangTon, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenHangActionPerformed

    private void txtMaHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHangActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_dal_HangTonKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_dal_HangTonKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_dal_HangTonKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_dal_HangTonKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                GUI_dal_HangTonKho dialog = new GUI_dal_HangTonKho(new javax.swing.JFrame(), true);
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
    private com.toedter.calendar.JDateChooser dateTuNgay;
    private com.toedter.calendar.JDateChooser dateTuNgay1;
    private javax.swing.JLabel lblDenNgay;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblHangTonKho;
    private javax.swing.JLabel lblMaHang;
    private javax.swing.JLabel lblSetTienBan;
    private javax.swing.JLabel lblSetTienNhap;
    private javax.swing.JLabel lblTenHang;
    private javax.swing.JLabel lblTienBan;
    private javax.swing.JLabel lblTienNhap;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JLabel lblTuNgay;
    private javax.swing.JScrollPane scrHangTon;
    private HELPER.PanelShadow sdoHangTon;
    private HELPER.PanelShadow sdoThongTinPhong;
    private javax.swing.JTable tblHangTon;
    private javax.swing.JTextField txtMaHang;
    private javax.swing.JTextField txtTenHang;
    // End of variables declaration//GEN-END:variables
}

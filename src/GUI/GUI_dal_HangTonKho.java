/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.BLL_TonKho;
import HELPER.HELPER_ChuyenDoi;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author CherryCe
 */
public class GUI_dal_HangTonKho extends javax.swing.JDialog {

    public String tuNgay;
    public String denNgay;

    /**
     * Creates new form GUI_dalThongTinPhong
     */
    public GUI_dal_HangTonKho(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        load();
        loadTonKho();
//        loadTongTien();
    }

    public void load() {
        String dateTimeTuNgay = HELPER_ChuyenDoi.getTimeNow("dd-MM-yyyy HH:mm");
        String dateTimeDenNgay = HELPER_ChuyenDoi.getTimeNow("dd-MM-yyyy HH:mm");
        dateTuNgay.setDate(HELPER_ChuyenDoi.getNgayDate("dd-MM-yyyy", dateTimeTuNgay));
        dateDenNgay.setDate(HELPER_ChuyenDoi.getNgayDate("dd-MM-yyyy", dateTimeDenNgay));
        tuNgay = HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd", dateTuNgay.getDate());
        denNgay = HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd", dateDenNgay.getDate());
    }

    public void loadTonKho() {
        BLL_TonKho.selectSanPham();
        BLL_TonKho.selectNhapKho(tuNgay, denNgay);
        BLL_TonKho.selectDichVu(tuNgay, denNgay);
        BLL_TonKho.selectTonDauKi(tuNgay);
        BLL_TonKho.selectTonKho();
        BLL_TonKho.load(tblHangTon);
    }

    public void loadTongTien() {
        int tongTienNhap = 0;
        int tongTienBan = 0;
        for (int i = 0; i < tblHangTon.getRowCount(); i++) {
            tongTienNhap += HELPER_ChuyenDoi.getSoInt(tblHangTon.getValueAt(i, 5).toString());
            tongTienBan += HELPER_ChuyenDoi.getSoInt(tblHangTon.getValueAt(i, 7).toString());
        }
        lblSetTienNhap.setText(tongTienNhap + "K");
        lblSetTienBan.setText(tongTienBan + "K");
    }

    public void search() {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tblHangTon.getModel());
        tblHangTon.setRowSorter(rowSorter);
        if (txtTimKiem.getText().length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + txtTimKiem.getText()));
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

        sdoThongTinPhong = new LIB.PanelShadow();
        lblDenNgay = new javax.swing.JLabel();
        lblTuNgay = new javax.swing.JLabel();
        lblTienBan = new javax.swing.JLabel();
        lblHangTonKho = new javax.swing.JLabel();
        lblSetTienBan = new javax.swing.JLabel();
        dateDenNgay = new com.toedter.calendar.JDateChooser();
        dateTuNgay = new com.toedter.calendar.JDateChooser();
        lblMaTenHang = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        lblTienNhap = new javax.swing.JLabel();
        lblSetTienNhap = new javax.swing.JLabel();
        lblTimKiem = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();
        sdoHangTon = new LIB.PanelShadow();
        scrHangTon = new javax.swing.JScrollPane();
        tblHangTon = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(820, 490));
        setUndecorated(true);

        sdoThongTinPhong.setBackground(new java.awt.Color(255, 255, 255));
        sdoThongTinPhong.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(33, 150, 243)));
        sdoThongTinPhong.setMinimumSize(new java.awt.Dimension(820, 130));
        sdoThongTinPhong.setPreferredSize(new java.awt.Dimension(820, 130));
        sdoThongTinPhong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDenNgay.setBackground(new java.awt.Color(255, 255, 255));
        lblDenNgay.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblDenNgay.setForeground(new java.awt.Color(153, 153, 153));
        lblDenNgay.setText("Đến Ngày");
        sdoThongTinPhong.add(lblDenNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));

        lblTuNgay.setBackground(new java.awt.Color(255, 255, 255));
        lblTuNgay.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblTuNgay.setForeground(new java.awt.Color(153, 153, 153));
        lblTuNgay.setText("Từ Ngày");
        sdoThongTinPhong.add(lblTuNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        lblTienBan.setBackground(new java.awt.Color(255, 255, 255));
        lblTienBan.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblTienBan.setForeground(new java.awt.Color(153, 153, 153));
        lblTienBan.setText("Tiền Bán");
        sdoThongTinPhong.add(lblTienBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, -1, 20));

        lblHangTonKho.setBackground(new java.awt.Color(255, 255, 255));
        lblHangTonKho.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        lblHangTonKho.setForeground(new java.awt.Color(62, 73, 95));
        lblHangTonKho.setText("HÀNG TỒN KHO");
        sdoThongTinPhong.add(lblHangTonKho, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        lblSetTienBan.setBackground(new java.awt.Color(255, 255, 255));
        lblSetTienBan.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        lblSetTienBan.setForeground(new java.awt.Color(255, 102, 102));
        lblSetTienBan.setText("0");
        sdoThongTinPhong.add(lblSetTienBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, 90, 20));

        dateDenNgay.setBackground(new java.awt.Color(255, 255, 255));
        dateDenNgay.setForeground(new java.awt.Color(62, 73, 95));
        dateDenNgay.setDateFormatString("dd-MM-yyyy");
        dateDenNgay.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateDenNgayPropertyChange(evt);
            }
        });
        sdoThongTinPhong.add(dateDenNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 100, 20));

        dateTuNgay.setBackground(new java.awt.Color(255, 255, 255));
        dateTuNgay.setForeground(new java.awt.Color(62, 73, 95));
        dateTuNgay.setDateFormatString("dd-MM-yyyy");
        dateTuNgay.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateTuNgayPropertyChange(evt);
            }
        });
        sdoThongTinPhong.add(dateTuNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 100, 20));

        lblMaTenHang.setBackground(new java.awt.Color(255, 255, 255));
        lblMaTenHang.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblMaTenHang.setForeground(new java.awt.Color(153, 153, 153));
        lblMaTenHang.setText("Mã / Tên Hàng");
        sdoThongTinPhong.add(lblMaTenHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, 20));

        txtTimKiem.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        txtTimKiem.setForeground(new java.awt.Color(62, 73, 95));
        txtTimKiem.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });
        sdoThongTinPhong.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 100, 20));

        lblTienNhap.setBackground(new java.awt.Color(255, 255, 255));
        lblTienNhap.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblTienNhap.setForeground(new java.awt.Color(153, 153, 153));
        lblTienNhap.setText("Tiền Nhập");
        sdoThongTinPhong.add(lblTienNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, -1, 20));

        lblSetTienNhap.setBackground(new java.awt.Color(255, 255, 255));
        lblSetTienNhap.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        lblSetTienNhap.setForeground(new java.awt.Color(97, 177, 90));
        lblSetTienNhap.setText("0");
        sdoThongTinPhong.add(lblSetTienNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 90, 20));

        lblTimKiem.setBackground(new java.awt.Color(255, 255, 255));
        lblTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/magnifier (1).png"))); // NOI18N
        lblTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTimKiemMouseClicked(evt);
            }
        });
        sdoThongTinPhong.add(lblTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 30, 30));

        lblExit.setBackground(new java.awt.Color(255, 255, 255));
        lblExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/close (1).png"))); // NOI18N
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });
        sdoThongTinPhong.add(lblExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 30, 30));

        sdoHangTon.setBackground(new java.awt.Color(255, 255, 255));
        sdoHangTon.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(33, 150, 243)));
        sdoHangTon.setMinimumSize(new java.awt.Dimension(820, 360));
        sdoHangTon.setPreferredSize(new java.awt.Dimension(820, 360));
        sdoHangTon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrHangTon.setBackground(new java.awt.Color(255, 255, 255));
        scrHangTon.setBorder(null);

        tblHangTon.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        tblHangTon.setForeground(new java.awt.Color(62, 73, 95));
        tblHangTon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hàng", "Tên Hàng", "Đơn Vị", "Tồn Đầu Kì", "Lượng Nhập", "Giá Nhập", "Lượng Bán", "Giá Bán", "Tồn Kho"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHangTon.setName(""); // NOI18N
        tblHangTon.setRowHeight(30);
        tblHangTon.setShowHorizontalLines(false);
        scrHangTon.setViewportView(tblHangTon);

        sdoHangTon.add(scrHangTon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 780, 320));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sdoThongTinPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(sdoHangTon, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sdoThongTinPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(sdoHangTon, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_lblExitMouseClicked

    private void lblTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTimKiemMouseClicked
        // TODO add your handling code here:
        tuNgay = HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd", dateTuNgay.getDate());
        denNgay = HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd", dateDenNgay.getDate());
        loadTonKho();
        loadTongTien();
    }//GEN-LAST:event_lblTimKiemMouseClicked

    private void dateTuNgayPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateTuNgayPropertyChange
        // TODO add your handling code here:
        if (dateTuNgay.getDate() != null && dateDenNgay.getDate() != null) {
            dateDenNgay.setMinSelectableDate(dateTuNgay.getDate());;
        }
    }//GEN-LAST:event_dateTuNgayPropertyChange

    private void dateDenNgayPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateDenNgayPropertyChange
        // TODO add your handling code here:
        if (dateDenNgay.getDate() != null && dateTuNgay.getDate() != null) {
            dateTuNgay.setMaxSelectableDate(dateDenNgay.getDate());;
        }
    }//GEN-LAST:event_dateDenNgayPropertyChange

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txtTimKiemKeyReleased

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
    private com.toedter.calendar.JDateChooser dateDenNgay;
    private com.toedter.calendar.JDateChooser dateTuNgay;
    private javax.swing.JLabel lblDenNgay;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblHangTonKho;
    private javax.swing.JLabel lblMaTenHang;
    private javax.swing.JLabel lblSetTienBan;
    private javax.swing.JLabel lblSetTienNhap;
    private javax.swing.JLabel lblTienBan;
    private javax.swing.JLabel lblTienNhap;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JLabel lblTuNgay;
    private javax.swing.JScrollPane scrHangTon;
    private LIB.PanelShadow sdoHangTon;
    private LIB.PanelShadow sdoThongTinPhong;
    private javax.swing.JTable tblHangTon;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}

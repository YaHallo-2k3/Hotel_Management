/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.BLL_TaiKhoan;
import DTO.DTO_TaiKhoan;
import java.util.ArrayList;

/**
 *
 * @author CherryCe
 */
public class GUI_dal_TaiKhoan extends javax.swing.JDialog {

    public String maNhanVien = GUI_pnl_NhanVien.maNhanVien;
    public boolean isAddEdit;

    /**
     * Creates new form GUI_dalThongTinPhong
     */
    public GUI_dal_TaiKhoan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        load();
    }

    public void add() {
        DTO_TaiKhoan taiKhoan = new DTO_TaiKhoan(maNhanVien, txtTaiKhoan.getText(), String.valueOf(psdMatKhau.getPassword()), String.valueOf(cboBaoMat.getSelectedItem()), txtTraLoi.getText());
        BLL_TaiKhoan.add(taiKhoan);
    }

    public void edit() {
        DTO_TaiKhoan taiKhoan = new DTO_TaiKhoan(maNhanVien, txtTaiKhoan.getText(), String.valueOf(psdMatKhau.getPassword()), String.valueOf(cboBaoMat.getSelectedItem()), txtTraLoi.getText());
        BLL_TaiKhoan.edit(taiKhoan);
    }

    public void load() {
        ArrayList<DTO_TaiKhoan> array = BLL_TaiKhoan.select(maNhanVien);
        BLL_TaiKhoan.load(array, txtTaiKhoan, psdMatKhau, cboBaoMat, txtTraLoi);

        if (txtTaiKhoan.getText().isEmpty()) {
            isAddEdit = false;
        } else {
            isAddEdit = true;
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

        sdoChucNang = new HELPER.PanelShadow();
        lblThoat = new javax.swing.JLabel();
        lblCapNhat = new javax.swing.JLabel();
        sdoTaiKhoan = new HELPER.PanelShadow();
        lblIconMatKhau = new javax.swing.JLabel();
        lblIconTaiKhoan = new javax.swing.JLabel();
        lblTaiKhoan = new javax.swing.JLabel();
        txtTaiKhoan = new javax.swing.JTextField();
        lblExit = new javax.swing.JLabel();
        cboBaoMat = new javax.swing.JComboBox<>();
        txtTraLoi = new javax.swing.JTextField();
        lblIconBaoMat = new javax.swing.JLabel();
        lblIconTraLoi = new javax.swing.JLabel();
        psdMatKhau = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(360, 400));
        setUndecorated(true);

        sdoChucNang.setBackground(new java.awt.Color(255, 255, 255));
        sdoChucNang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(33, 150, 243)));
        sdoChucNang.setMinimumSize(new java.awt.Dimension(560, 280));
        sdoChucNang.setPreferredSize(new java.awt.Dimension(560, 280));
        sdoChucNang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        sdoChucNang.add(lblThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 80, 40));

        lblCapNhat.setBackground(new java.awt.Color(255, 255, 255));
        lblCapNhat.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblCapNhat.setForeground(new java.awt.Color(33, 150, 243));
        lblCapNhat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cart (3).png"))); // NOI18N
        lblCapNhat.setText("Cập Nhật");
        lblCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCapNhatMouseClicked(evt);
            }
        });
        sdoChucNang.add(lblCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 100, 40));

        sdoTaiKhoan.setBackground(new java.awt.Color(255, 255, 255));
        sdoTaiKhoan.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(33, 150, 243)));
        sdoTaiKhoan.setMinimumSize(new java.awt.Dimension(560, 280));
        sdoTaiKhoan.setPreferredSize(new java.awt.Dimension(560, 280));
        sdoTaiKhoan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIconMatKhau.setBackground(new java.awt.Color(255, 255, 255));
        lblIconMatKhau.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblIconMatKhau.setForeground(new java.awt.Color(153, 153, 153));
        lblIconMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/padlock.png"))); // NOI18N
        sdoTaiKhoan.add(lblIconMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 30, 30));

        lblIconTaiKhoan.setBackground(new java.awt.Color(255, 255, 255));
        lblIconTaiKhoan.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblIconTaiKhoan.setForeground(new java.awt.Color(153, 153, 153));
        lblIconTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/profile-user.png"))); // NOI18N
        sdoTaiKhoan.add(lblIconTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 30, 30));

        lblTaiKhoan.setBackground(new java.awt.Color(255, 255, 255));
        lblTaiKhoan.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        lblTaiKhoan.setForeground(new java.awt.Color(62, 73, 95));
        lblTaiKhoan.setText("TÀI KHOẢN");
        sdoTaiKhoan.add(lblTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 40));

        txtTaiKhoan.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        txtTaiKhoan.setForeground(new java.awt.Color(62, 73, 95));
        txtTaiKhoan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTaiKhoanActionPerformed(evt);
            }
        });
        sdoTaiKhoan.add(txtTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 250, 30));

        lblExit.setBackground(new java.awt.Color(255, 255, 255));
        lblExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/close (1).png"))); // NOI18N
        sdoTaiKhoan.add(lblExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 30, 30));

        cboBaoMat.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        cboBaoMat.setForeground(new java.awt.Color(62, 73, 95));
        cboBaoMat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboBaoMat.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        sdoTaiKhoan.add(cboBaoMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 250, 30));

        txtTraLoi.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        txtTraLoi.setForeground(new java.awt.Color(62, 73, 95));
        txtTraLoi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtTraLoi.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtTraLoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTraLoiActionPerformed(evt);
            }
        });
        sdoTaiKhoan.add(txtTraLoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 250, 30));

        lblIconBaoMat.setBackground(new java.awt.Color(255, 255, 255));
        lblIconBaoMat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconBaoMat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/iconfinder-securityprotectlockshield04-4021479_113137.png"))); // NOI18N
        sdoTaiKhoan.add(lblIconBaoMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        lblIconTraLoi.setBackground(new java.awt.Color(255, 255, 255));
        lblIconTraLoi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconTraLoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/conversation.png"))); // NOI18N
        sdoTaiKhoan.add(lblIconTraLoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, 30));

        psdMatKhau.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        psdMatKhau.setForeground(new java.awt.Color(62, 73, 95));
        psdMatKhau.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(62, 73, 95)));
        sdoTaiKhoan.add(psdMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 138, 250, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sdoTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(sdoChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sdoTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(sdoChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTaiKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTaiKhoanActionPerformed

    private void lblThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_lblThoatMouseClicked

    private void txtTraLoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTraLoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTraLoiActionPerformed

    private void lblCapNhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCapNhatMouseClicked
        // TODO add your handling code here:
        if (!isAddEdit) {
            add();
        } else {
            edit();
        }
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
            java.util.logging.Logger.getLogger(GUI_dal_TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_dal_TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_dal_TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_dal_TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                GUI_dal_TaiKhoan dialog = new GUI_dal_TaiKhoan(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cboBaoMat;
    private javax.swing.JLabel lblCapNhat;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblIconBaoMat;
    private javax.swing.JLabel lblIconMatKhau;
    private javax.swing.JLabel lblIconTaiKhoan;
    private javax.swing.JLabel lblIconTraLoi;
    private javax.swing.JLabel lblTaiKhoan;
    private javax.swing.JLabel lblThoat;
    private javax.swing.JPasswordField psdMatKhau;
    private HELPER.PanelShadow sdoChucNang;
    private HELPER.PanelShadow sdoTaiKhoan;
    private javax.swing.JTextField txtTaiKhoan;
    private javax.swing.JTextField txtTraLoi;
    // End of variables declaration//GEN-END:variables
}

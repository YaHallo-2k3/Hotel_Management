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
public class GUI_pnl_Image extends javax.swing.JPanel {

    /**
     * Creates new form GUI_pnlSoDoPhong
     */
    public GUI_pnl_Image() {
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

        pnlImage = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1150, 730));
        setPreferredSize(new java.awt.Dimension(1150, 730));

        pnlImage.setBackground(new java.awt.Color(255, 255, 255));
        pnlImage.setMinimumSize(new java.awt.Dimension(1150, 730));
        pnlImage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblImage.setBackground(new java.awt.Color(255, 255, 255));
        lblImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\CherryCe\\Pictures\\Rimuru.jpg")); // NOI18N
        pnlImage.add(lblImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 730));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblImage;
    public javax.swing.JPanel pnlImage;
    // End of variables declaration//GEN-END:variables
}

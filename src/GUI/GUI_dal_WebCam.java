/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import HELPER.HELPER_SetIcon;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author CherryCe
 */
public class GUI_dal_WebCam extends javax.swing.JDialog {

    public static Webcam webcam;
    public static boolean check = false;
    public static boolean isOpen = false;
    public static boolean isClose;
    public static int count;
    public static String path = "src/WEBCAM";

    /**
     * Creates new form GUI_dal_WebCam
     */
    public GUI_dal_WebCam(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        check();

    }

    public void check() {
        if (!isOpen) {
            load();
            new videoFeed().start();
            new photoFeed().start();
        } else {
            load();
            lblXoa.setVisible(true);
            lblShowWebCam.setIcon(HELPER_SetIcon.resizeImage(GUI_dal_ThongTinPhong.hinhAnh, lblShowWebCam));
        }
        isClose = false;
    }

    public void load() {
        webcam = Webcam.getWebcamByName("e2eSoft iVCam 0");
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        webcam.open();
        File file = new File(path);
        count = file.list().length;
        lblXoa.setVisible(false);
        lblLuu.setVisible(false);
    }

    public class videoFeed extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    if (isClose) {
                        return;
                    } else {
                        if (check) {
                            return;
                        } else {
                            Image img = webcam.getImage();
                            lblShowWebCam.setIcon(new ImageIcon(img));
                        }
                    }
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class photoFeed extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    if (isClose) {
                        return;
                    } else {
                        int countThread = new File(path).list().length;
                        Thread.sleep(1000);
                        if (countThread != count) {
                            check = true;
                            FileInputStream fis = new FileInputStream(getLastModified(path));
                            ByteArrayOutputStream bos = new ByteArrayOutputStream();
                            byte[] buf = new byte[1024];
                            for (int readnum; (readnum = fis.read(buf)) != -1;) {
                                bos.write(buf, 0, readnum);
                            }
                            GUI_dal_ThongTinPhong.hinhAnh = bos.toByteArray();
                            lblShowWebCam.setIcon(HELPER_SetIcon.resizeImage(GUI_dal_ThongTinPhong.hinhAnh, lblShowWebCam));
                            lblXoa.setVisible(true);
                            lblLuu.setVisible(true);
                            return;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static File getLastModified(String directoryFilePath) {
        File directory = new File(directoryFilePath);
        File[] files = directory.listFiles(File::isFile);
        long lastModifiedTime = Long.MIN_VALUE;
        File chosenFile = null;
        if (files != null) {
            for (File file : files) {
                if (file.lastModified() > lastModifiedTime) {
                    chosenFile = file;
                    lastModifiedTime = file.lastModified();
                }
            }
        }
        return chosenFile;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlWebCam = new javax.swing.JPanel();
        lblThoat = new javax.swing.JLabel();
        lblLuu = new javax.swing.JLabel();
        lblShowWebCam = new javax.swing.JLabel();
        lblXoa = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(680, 570));
        setUndecorated(true);

        pnlWebCam.setBackground(new java.awt.Color(255, 255, 255));
        pnlWebCam.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(33, 150, 243)));
        pnlWebCam.setMinimumSize(new java.awt.Dimension(680, 570));
        pnlWebCam.setPreferredSize(new java.awt.Dimension(680, 570));
        pnlWebCam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblThoat.setBackground(new java.awt.Color(255, 255, 255));
        lblThoat.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblThoat.setForeground(new java.awt.Color(33, 150, 243));
        lblThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cross-button.png"))); // NOI18N
        lblThoat.setText("Thoát");
        lblThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThoatMouseClicked(evt);
            }
        });
        pnlWebCam.add(lblThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 520, 80, 40));

        lblLuu.setBackground(new java.awt.Color(255, 255, 255));
        lblLuu.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblLuu.setForeground(new java.awt.Color(33, 150, 243));
        lblLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/save (1).png"))); // NOI18N
        lblLuu.setText("Lưu");
        lblLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLuuMouseClicked(evt);
            }
        });
        pnlWebCam.add(lblLuu, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 520, 60, 40));

        lblShowWebCam.setOpaque(true);
        pnlWebCam.add(lblShowWebCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 640, 480));

        lblXoa.setBackground(new java.awt.Color(255, 255, 255));
        lblXoa.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblXoa.setForeground(new java.awt.Color(33, 150, 243));
        lblXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/trash (1).png"))); // NOI18N
        lblXoa.setText("Xóa");
        lblXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblXoaMouseClicked(evt);
            }
        });
        pnlWebCam.add(lblXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 520, 60, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlWebCam, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlWebCam, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLuuMouseClicked
        // TODO add your handling code here:
        GUI_dal_ThongTinPhong.lblImage.setIcon(HELPER_SetIcon.resizeImage(GUI_dal_ThongTinPhong.hinhAnh, GUI_dal_ThongTinPhong.lblImage));
        isClose = true;
        webcam.close();
        dispose();
    }//GEN-LAST:event_lblLuuMouseClicked

    private void lblXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXoaMouseClicked
        // TODO add your handling code here:
        check = false;
        GUI_dal_ThongTinPhong.hinhAnh = null;
        lblXoa.setVisible(false);
        lblLuu.setVisible(false);
        File file = new File(String.valueOf(getLastModified(path)));
        file.delete();
        count = new File(path).list().length;
        new videoFeed().start();
        new photoFeed().start();
    }//GEN-LAST:event_lblXoaMouseClicked

    private void lblThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseClicked
        // TODO add your handling code here:
        isClose = true;
        webcam.close();
        dispose();
    }//GEN-LAST:event_lblThoatMouseClicked

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
            java.util.logging.Logger.getLogger(GUI_dal_WebCam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_dal_WebCam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_dal_WebCam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_dal_WebCam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUI_dal_WebCam dialog = new GUI_dal_WebCam(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel lblLuu;
    private javax.swing.JLabel lblShowWebCam;
    private javax.swing.JLabel lblThoat;
    private javax.swing.JLabel lblXoa;
    private javax.swing.JPanel pnlWebCam;
    // End of variables declaration//GEN-END:variables
}

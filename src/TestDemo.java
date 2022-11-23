
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author CherryCe
 */
public class TestDemo extends javax.swing.JFrame {

    public int rowIndex;
    public int columnIndex;
    public String setPrice = "";
    public String url = String.valueOf(new ImageIcon(getClass().getResource("/DOCUMENT/SingleRoom_Day_Rate.xlsx"))).replaceAll("file:/", "");
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public String xlFiflePath;
    
    /**
     * Creates new form TestDemo
     */
    public TestDemo() {
        initComponents();
        setLocationRelativeTo(null);

        readExcel();

        System.out.println(url);
    }

    public void readExcel() {
        rowIndex = -1;
        columnIndex = -1;
        try {
            FileInputStream file = new FileInputStream(new File("C:\\Users\\CherryCe\\Documents\\NetBeansProjects\\Hotel_Management\\src\\DOCUMENT\\SingleRoom_Day_Rate.xlsx"));
            Workbook workbook = new XSSFWorkbook(file);
            DataFormatter dataFormatter = new DataFormatter();
            Iterator<Sheet> sheets = workbook.sheetIterator();
            while (sheets.hasNext()) {
                Sheet sh = sheets.next();
                Iterator<Row> iterator = sh.iterator();
                while (iterator.hasNext()) {
                    Row row = iterator.next();
                    Iterator<Cell> cellIterator = row.iterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        String cellValue = dataFormatter.formatCellValue(cell);
                        columnIndex++;
                        if (columnIndex > 24) {
                            columnIndex = 0;
                            rowIndex++;
                        }
                        if (rowIndex == -1) {
                            tblGiaPhong.getColumnModel().getColumn(columnIndex).setHeaderValue(cellValue);
                        }
                        if (rowIndex != -1) {
                            tblGiaPhong.setValueAt(cellValue, rowIndex, columnIndex);
                        }
                    }
                }
            }
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeExcel() {
        try {
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet("Sheet");
            Row rowCol = sheet.createRow(0);

            for (int i = 0; i < tblGiaPhong.getColumnCount(); i++) {
                Cell cell = rowCol.createCell(i);
                cell.setCellValue(tblGiaPhong.getColumnName(i));
            }

            for (int j = 0; j < tblGiaPhong.getRowCount(); j++) {
                Row row = sheet.createRow(j + 1);
                for (int k = 0; k < tblGiaPhong.getColumnCount(); k++) {
                    Cell cell = row.createCell(k);
                    if (tblGiaPhong.getValueAt(j, k) != null) {
                        cell.setCellValue(tblGiaPhong.getValueAt(j, k).toString());
                    }
                }
            }
            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\CherryCe\\Downloads\\DoubleRoom_Hour_Rate.xlsx"));
            wb.write(out);
            wb.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
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

        scrGiaPhong = new javax.swing.JScrollPane();
        tblGiaPhong = new javax.swing.JTable()
        {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int columnIndex
            ) {
                Component component = super.prepareRenderer(renderer, rowIndex, columnIndex);
                Object value = getModel().getValueAt(rowIndex, columnIndex);
                tblGiaPhong.getTableHeader().setBackground(new Color(61, 132, 184));
                tblGiaPhong.getTableHeader().setForeground(new Color(255, 255, 255));
                tblGiaPhong.getTableHeader().setOpaque(false);
                if (setPrice == ""){
                    if (columnIndex == 0) {
                        component.setBackground(new Color(77, 169, 108));
                        component.setForeground(new Color(255, 255, 255));
                    }else if (rowIndex >= 0 && rowIndex <=4 && columnIndex >= 0 && columnIndex <= 5 - rowIndex){
                        component.setBackground(new Color(255, 199, 206));
                        component.setForeground(new Color(0, 0, 0));
                    }else if (rowIndex >= 14 && rowIndex <= 17 && columnIndex >= 1 && columnIndex <= 13){
                        component.setBackground(new Color(255, 153, 102));
                        component.setForeground(new Color(0, 0, 0));
                    }else if (rowIndex >= 0 && rowIndex <= 23 && columnIndex >= 14 && columnIndex <= 18){
                        component.setBackground(new Color(240, 240, 240));
                        component.setForeground(new Color(0, 0, 0));
                    }else{
                        component.setForeground(new Color(0, 0, 0));
                        component.setBackground(new Color(255, 255, 102));
                    }
                }
                return component;
            }
        }
        ;
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        scrGiaPhong.setBackground(new java.awt.Color(255, 255, 255));
        scrGiaPhong.setBorder(null);

        tblGiaPhong.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        tblGiaPhong.setForeground(new java.awt.Color(62, 73, 95));
        tblGiaPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, "", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGiaPhong.setRowHeight(30);
        tblGiaPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGiaPhongMouseClicked(evt);
            }
        });
        scrGiaPhong.setViewportView(tblGiaPhong);

        jButton1.setText("Read");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Write");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(scrGiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 1130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jButton1)
                        .addGap(35, 35, 35)
                        .addComponent(jButton2)))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(scrGiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        readExcel();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        writeExcel();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblGiaPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGiaPhongMouseClicked
        // TODO add your handling code here:
        int row = tblGiaPhong.getSelectedRow();
        int volumn = tblGiaPhong.getSelectedColumn();
        System.out.println(tblGiaPhong.getValueAt(row, volumn).toString());
    }//GEN-LAST:event_tblGiaPhongMouseClicked

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
            java.util.logging.Logger.getLogger(TestDemo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestDemo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestDemo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestDemo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestDemo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane scrGiaPhong;
    private javax.swing.JTable tblGiaPhong;
    // End of variables declaration//GEN-END:variables
}

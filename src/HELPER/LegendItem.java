package HELPER;

public class LegendItem extends javax.swing.JPanel {

    public LegendItem(ModelLegend data) {
        initComponents();
        setOpaque(false);
        lblColor.setBackground(data.getColor());
        lblName.setText(data.getName());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLegendItem = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblColor = new HELPER.LabelColor();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(100, 50));

        pnlLegendItem.setBackground(new java.awt.Color(255, 255, 255));
        pnlLegendItem.setMinimumSize(new java.awt.Dimension(100, 50));
        pnlLegendItem.setPreferredSize(new java.awt.Dimension(100, 50));
        pnlLegendItem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblName.setBackground(new java.awt.Color(255, 255, 255));
        lblName.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(62, 73, 95));
        lblName.setText("Name");
        pnlLegendItem.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 40, 30));
        pnlLegendItem.add(lblColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLegendItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLegendItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private HELPER.LabelColor lblColor;
    private javax.swing.JLabel lblName;
    private javax.swing.JPanel pnlLegendItem;
    // End of variables declaration//GEN-END:variables
}

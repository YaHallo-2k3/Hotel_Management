
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class Test2 extends JTable {

    @Override

    public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int columnIndex) {

        Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);
        Object value = getModel().getValueAt(rowIndex, columnIndex);
        if (rowIndex == 0) {
            componenet.setBackground(new Color(61, 132, 184));
            componenet.setForeground(new Color(255, 255, 255));
        } else if (columnIndex == 0) {
            componenet.setBackground(new Color(74, 169, 108));
            componenet.setForeground(new Color(255, 255, 255));
        } else if (rowIndex <=12 && columnIndex <=12) {
            componenet.setBackground(new Color(255, 199, 206));
            componenet.setForeground(new Color(0, 0, 0));
        } else {
            componenet.setBackground(new Color(246, 246, 246));
            componenet.setForeground(new Color(0, 0, 0));
        }
        return componenet;
    }

    public static void main(String[] args) {

    }
}

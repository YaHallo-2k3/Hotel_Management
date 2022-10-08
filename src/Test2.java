
import HELPER.HELPER_ChuyenDoi;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class Test2 {

    public static void main(String[] args) {
        try {
            System.out.println(HELPER_ChuyenDoi.getNgayString("yyyy-MM-dd HH:mm", null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

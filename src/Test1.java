
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class Test1 {

    public static void main(String[] args) throws ParseException {
        DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateAsString = "25/12/2010";
        Date date = (Date) sourceFormat.parse(dateAsString);
        System.out.println(date);

        DateFormat dateFormat = new SimpleDateFormat(
                "EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        dateFormat.parse("Tue Jul 13 00:00:00 CEST 2011");
        System.out.println(dateFormat.format(new Date()));
    }
}

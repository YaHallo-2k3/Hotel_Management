
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import java.time.Duration;

public class Test1 {

    public static void main(String[] args) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        LocalDateTime dateTime1 = LocalDateTime.parse("25-11-2013 21:34", formatter);
        LocalDateTime dateTime2 = LocalDateTime.parse("25-11-2013 22:47", formatter);

        long diffInDay = Duration.between(dateTime1, dateTime2).toDays();
        long diffInMilli = Duration.between(dateTime1, dateTime2).toHours() - diffInDay * 24;
        long diffInMinutes = (Duration.between(dateTime1, dateTime2).toMinutes()-diffInDay*60*24)%60;
        System.out.println(diffInMilli);
        System.out.println(diffInMinutes);
        System.out.println(diffInDay);
    }
}

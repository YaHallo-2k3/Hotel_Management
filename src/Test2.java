
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

        String dateStart = "09:33:00";

        String dateStop = "10:36:00";

        // Custom date format

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        Date d1 = null;

        Date d2 = null;

        try {

            d1 = format.parse(dateStart);

            d2 = format.parse(dateStop);

        } catch (ParseException e) {

        }

        // Get msec from each, and subtract.

        long diff = (d2.getTime() - d1.getTime())/1000;

        long diffHours = diff / (60 * 60);
        
        long diffMinutes = (diff % (60 * 60)) / 60;


        System.out.println("Số phút: " + diffMinutes + " minutes.");

        System.out.println("Số giờ: " + diffHours + " hours.");
        


    }

}
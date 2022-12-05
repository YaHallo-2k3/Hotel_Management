
import HELPER.HELPER_ChuyenDoi;
import java.awt.*;
import java.text.ParseException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;

public class Test2{

    public static void main(String[] args) {
        try {
            System.out.println(HELPER_ChuyenDoi.convertDate("dd-MM-yy HH:mm", "HH", "12-03-2022"));
        } catch (ParseException ex) {
            Logger.getLogger(Test2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

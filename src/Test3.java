
import static GUI.GUI_pnl_GiaPhong.doubleRoom_Day_Rate;
import static GUI.GUI_pnl_GiaPhong.doubleRoom_Hour_Rate;
import static GUI.GUI_pnl_GiaPhong.quadraRoom_Day_Rate;
import static GUI.GUI_pnl_GiaPhong.quadraRoom_Hour_Rate;
import static GUI.GUI_pnl_GiaPhong.singleRoom_Day_Rate;
import static GUI.GUI_pnl_GiaPhong.singleRoom_Hour_Rate;
import static GUI.GUI_pnl_GiaPhong.tripleRoom_Day_Rate;
import static GUI.GUI_pnl_GiaPhong.tripleRoom_Hour_Rate;
import HELPER.HELPER_ChuyenDoi;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saliya
 */
public class Test3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\CherryCe\\Documents\\NetBeansProjects\\Hotel_Management\\build\\classes\\DOCUMENT\\SingleRoom_Hour_Rate.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            System.out.println(HELPER_ChuyenDoi.getSoInt(String.valueOf(sheet.getRow(1).getCell(0))));
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
}

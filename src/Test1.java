
import HELPER.HELPER_ChuyenDoi;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test1 {

    public static FileInputStream file;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static String xlFilePath;

    public static void readingSpecificCell(int sheetNumber, int row, int col) {
        try {
            xlFilePath = "C:\\Users\\CherryCe\\Downloads\\SingleRoom_Hour_Rate.xlsx";
            file = new FileInputStream(xlFilePath);
            workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheetAt(sheetNumber);
            System.out.println(HELPER_ChuyenDoi.getSoInt(String.valueOf(sheet.getRow(row).getCell(col))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        useExistingWorkBook("C:\\Users\\CherryCe\\Downloads\\SingleRoom_Day_Rate.xlsx");
        readingSpecificCell(0, 11, 23);
    }
}

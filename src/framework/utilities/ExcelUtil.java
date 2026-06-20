package framework.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    public static Object[][] getExcelData(String filePath,String sheetName) throws IOException{
        FileInputStream file =new FileInputStream(filePath);
        XSSFWorkbook workbook=new XSSFWorkbook(file);
        XSSFSheet sheet= workbook.getSheet(sheetName);
        int rowCount=sheet.getPhysicalNumberOfRows();
        int colCount=sheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] data=new Object[rowCount-1][colCount];
        DataFormatter formatter=new DataFormatter();

        for(int i=1;i<rowCount;i++)
        {
            for (int j=0;j<colCount;j++)
            {
                data[i-1][j]=formatter.formatCellValue(sheet.getRow(i).getCell(j));
            }
        }
        workbook.close();
        file.close();

        return data;

    }




}

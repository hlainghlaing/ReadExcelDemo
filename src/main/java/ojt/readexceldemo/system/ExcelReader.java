package ojt.readexceldemo.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Repository;

@Repository
public class ExcelReader {

    public List<List<Object>> readExcel() throws IOException {
        File file = new File("D:\\ExcelTemplates\\Book1.xlsx");
        FileInputStream fis = null;
        List<List<Object>> rows = new ArrayList<>();
        XSSFWorkbook wb = null;
        try {
            fis = new FileInputStream(file);
            wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<Row> itr = sheet.rowIterator();
            while (itr.hasNext()) {
                List<Object> cells = new ArrayList<>();
                Row row = itr.next();
                Iterator<Cell> celliterator = row.cellIterator();
                while (celliterator.hasNext()) {
                    Cell cell = celliterator.next();
                    switch (cell.getCellType()) {
                    case STRING:
                        cells.add(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        cells.add(cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        cells.add(cell.getBooleanCellValue());
                        break;
                    case FORMULA:
                        cells.add(cell.getCellFormula());
                        break;
                    default:
                        break;
                    }
                }
                rows.add(cells);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
            if (wb != null) {
                wb.close();
            }
        }
        return rows;
    }
}

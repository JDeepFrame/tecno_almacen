package utils;
    
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.JTable;
import javax.swing.table.TableModel;
import java.io.FileOutputStream;

public class ExcelUtil {
    
    public static void exportToExcel(JTable table, String path) throws Exception {

        TableModel model = table.getModel();
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("Datos");

        int cols = model.getColumnCount();
        int rows = model.getRowCount();

        Row header = sheet.createRow(0);
        for (int c = 0; c < cols; c++) {
            Cell cell = header.createCell(c);
            cell.setCellValue(model.getColumnName(c));
        }

        for (int r = 0; r < rows; r++) {
            Row row = sheet.createRow(r + 1);
            for (int c = 0; c < cols; c++) {
                Object value = model.getValueAt(r, c);
                row.createCell(c).setCellValue(value == null ? "" : value.toString());
            }
        }

        for (int c = 0; c < cols; c++) {
            sheet.autoSizeColumn(c);
        }

        FileOutputStream out = new FileOutputStream(path);
        wb.write(out);
        out.close();
        wb.close();
    }    
}
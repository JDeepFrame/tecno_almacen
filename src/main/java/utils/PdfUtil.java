package utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JTable;
import javax.swing.table.TableModel;
import java.io.FileOutputStream;

public class PdfUtil {
    
    public static void exportToPDF(JTable table, String path) throws Exception {

        Document doc = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(doc, new FileOutputStream(path));

        doc.open();

        TableModel model = table.getModel();
        int cols = model.getColumnCount();

        PdfPTable pdfTable = new PdfPTable(cols);
        pdfTable.setWidthPercentage(100);

        for (int c = 0; c < cols; c++) {
            pdfTable.addCell(new Phrase(model.getColumnName(c)));
        }

        for (int r = 0; r < model.getRowCount(); r++) {
            for (int c = 0; c < cols; c++) {
                Object value = model.getValueAt(r, c);
                pdfTable.addCell(value == null ? "" : value.toString());
            }
        }

        doc.add(pdfTable);
        doc.close();
    }    
}
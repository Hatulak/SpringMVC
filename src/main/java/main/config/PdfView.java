package main.config;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import main.model.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class PdfView extends AbstractITextPdfView {


    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Student> students = (List<Student>) model.get("students");
        document.add(new Paragraph("Students list"));

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[]{3.0f, 2.0f, 2.0f, 2.0f});
        table.setSpacingBefore(10);

        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);

        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setPadding(5);

        // write table header
        cell.setPhrase(new Phrase("Index", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Surname", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Age", font));
        table.addCell(cell);

        // write table row data
        students.forEach(student -> {
            table.addCell(student.getIndex().toString());
            table.addCell(student.getName());
            table.addCell(student.getSurname());
            table.addCell(student.getAge().toString());
        });

        document.add(table);
    }
}

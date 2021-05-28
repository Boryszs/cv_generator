package com.cvgenerator.cvgenerator;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

public class CvGeneratorApplication {
    private static final Font TIMES_ROMAN_22 = new Font(Font.FontFamily.TIMES_ROMAN, 22, Font.NORMAL);
    private static final Font TIMES_ROMAN_18 = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.NORMAL);
    private static final Font TIMES_ROMAN_14 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL);

    public static void main(String[] args) {

        Document doc = new Document(PageSize.A4, 0, 0, 0, 0);
        try {
            PdfWriter.getInstance(doc, new FileOutputStream("TableColumnSpan.pdf"));
            doc.open();
            Image image = Image.getInstance("https://images.squarespace-cdn.com/content/v1/54ce0590e4b0d647bfae208e/1435606919690-PNOSFNJ89XAW1317IVOD/ke17ZwdGBToddI8pDm48kLR2rgEg1jPu1GtjV4K1vZ97gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0scl71iiVnMuLeEyTFSXT3qwhEKW1IfUKL5GUNLdDa9MjuPXcXiDenG_NSvE-2lGCg/cv_shot_edward");
            image.setAlignment(Element.ALIGN_CENTER);
            image.setWidthPercentage(60);
            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cell1 = new PdfPCell(new Phrase("Cell 1"));
            cell1.setBorder(Rectangle.NO_BORDER);
            cell1.addElement(image);
            Paragraph paragraph = new Paragraph("");
            for (int i = 0; i < 2; i++) {
                paragraph.add(new Paragraph(""));
            }
            cell1.addElement(paragraph);

            paragraph = new Paragraph("Adres:", TIMES_ROMAN_18);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            cell1.addElement(paragraph);

            paragraph = new Paragraph("Tarnow", TIMES_ROMAN_14);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            cell1.addElement(paragraph);

            paragraph = new Paragraph("Telefon:", TIMES_ROMAN_18);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            cell1.addElement(paragraph);

            paragraph = new Paragraph("123456789", TIMES_ROMAN_14);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            cell1.addElement(paragraph);

            paragraph = new Paragraph("E-mail:", TIMES_ROMAN_18);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            cell1.addElement(paragraph);

            paragraph = new Paragraph("email ;)", TIMES_ROMAN_14);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            cell1.addElement(paragraph);

            paragraph = new Paragraph("Jezyki", TIMES_ROMAN_22);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            cell1.addElement(paragraph);
            paragraph = new Paragraph("");
            paragraph.add(new Paragraph(" "));

            cell1.addElement(paragraph);

            LineSeparator sep = new LineSeparator();
            sep.setPercentage(100);
            cell1.addElement(sep);

            paragraph = new Paragraph("");
            paragraph.add(new Paragraph("Polish - Native"));
            paragraph.add(new Paragraph("English - B1"));
            cell1.addElement(paragraph);

            paragraph = new Paragraph("Zainteresowania", TIMES_ROMAN_22);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            cell1.addElement(paragraph);

            paragraph = new Paragraph("");
            paragraph.add(new Paragraph(" "));
            cell1.addElement(paragraph);
            sep = new LineSeparator();
            sep.setPercentage(100);
            cell1.addElement(sep);

            paragraph = new Paragraph("");
            paragraph.add(new Paragraph("Box"));
            paragraph.add(new Paragraph("Matematic"));
            paragraph.add(new Paragraph("Physic"));
            cell1.addElement(paragraph);

            cell1.setPadding(20);
            cell1.setColspan(2);
            cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell1.setFixedHeight(842);
            table.addCell(cell1);

            Paragraph preface = new Paragraph();
            preface.add(new Paragraph("Imie naziwsko", TIMES_ROMAN_22));
            preface.setAlignment(Element.ALIGN_LEFT);

            PdfPCell cell2 = new PdfPCell();
            cell2.setPadding(10);
            cell2.setBorder(Rectangle.NO_BORDER);
            cell2.addElement(preface);
            cell2.setColspan(3);
            cell2.setFixedHeight(842);
            table.addCell(cell2);
            table.completeRow();
            doc.add(table);

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            doc.close();
        }
    }
}


package com.cvgenerator.cvgenerator;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

public class CvGeneratorApplication {

    static BaseFont TIME_ROMAN;

    static {
        try {
            TIME_ROMAN = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1250, BaseFont.EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static final Font TIMES_ROMAN_22 = new Font(TIME_ROMAN, 22, Font.BOLD);
    private static final Font TIMES_ROMAN_18 = new Font(TIME_ROMAN, 18, Font.BOLD);
    private static final Font TIMES_ROMAN_14 = new Font(TIME_ROMAN, 14, Font.BOLD);
    private static final Font TIMES_ROMAN_12 = new Font(TIME_ROMAN, 12, Font.NORMAL);

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

            paragraph = new Paragraph("Adres:", TIMES_ROMAN_14);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            cell1.addElement(paragraph);

            paragraph = new Paragraph("Tarnow", TIMES_ROMAN_12);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            cell1.addElement(paragraph);

            paragraph = new Paragraph("Telefon:", TIMES_ROMAN_14);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            cell1.addElement(paragraph);

            paragraph = new Paragraph("123456789", TIMES_ROMAN_12);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            cell1.addElement(paragraph);

            paragraph = new Paragraph("E-mail:", TIMES_ROMAN_14);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            cell1.addElement(paragraph);

            paragraph = new Paragraph("email ;)", TIMES_ROMAN_12);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            cell1.addElement(paragraph);

            paragraph = new Paragraph("Jezyki", TIMES_ROMAN_18);
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

            paragraph = new Paragraph("Zainteresowania", TIMES_ROMAN_18);
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
            cell2.setPaddingTop(30);
            cell2.setPaddingLeft(12);
            cell2.setPaddingRight(12);
            cell2.setBorder(Rectangle.NO_BORDER);
            cell2.addElement(preface);

            paragraph = new Paragraph("");
            for (int i = 0; i < 1; i++) {
                paragraph.add(new Paragraph(""));
            }
            cell2.addElement(paragraph);


            paragraph = new Paragraph();
            paragraph.add(new Paragraph("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" , TIMES_ROMAN_12));
            paragraph.setAlignment(Element.ALIGN_LEFT);
            cell2.addElement(paragraph);

            paragraph = new Paragraph("Edukacja", TIMES_ROMAN_22);
            cell2.addElement(paragraph);

            paragraph = new Paragraph("");
            paragraph.add(new Paragraph(" "));
            cell2.addElement(paragraph);
            sep = new LineSeparator();
            sep.setPercentage(100);
            cell2.addElement(sep);


            paragraph = new Paragraph("Umiejętności", TIMES_ROMAN_22);
            cell2.addElement(paragraph);

            paragraph = new Paragraph("");
            paragraph.add(new Paragraph(" "));
            cell2.addElement(paragraph);
            sep = new LineSeparator();
            sep.setPercentage(100);
            cell2.addElement(sep);

            paragraph = new Paragraph("Kariera", TIMES_ROMAN_22);
            cell2.addElement(paragraph);

            paragraph = new Paragraph("");
            paragraph.add(new Paragraph(" "));
            cell2.addElement(paragraph);
            sep = new LineSeparator();
            sep.setPercentage(100);
            cell2.addElement(sep);


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


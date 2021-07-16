package com.cvgenerator.cvgenerator.service.impl;

import com.cvgenerator.cvgenerator.dto.request.CareerDto;
import com.cvgenerator.cvgenerator.dto.request.EducationDto;
import com.cvgenerator.cvgenerator.dto.request.LanguageDto;
import com.cvgenerator.cvgenerator.model.*;
import com.cvgenerator.cvgenerator.model.enums.ColorStyle;
import com.cvgenerator.cvgenerator.service.PdfGenerate;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class PdfGenerateImpl implements PdfGenerate {


    static BaseFont TIME_ROMAN;

    static {
        try {
            TIME_ROMAN = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1250, BaseFont.EMBEDDED);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    private final Font TIMES_ROMAN_22 = new Font(TIME_ROMAN, 22, Font.BOLD);
    private final Font TIMES_ROMAN_18 = new Font(TIME_ROMAN, 18, Font.BOLD);
    private final Font TIMES_ROMAN_14 = new Font(TIME_ROMAN, 14, Font.BOLD);
    private final Font TIMES_ROMAN_12 = new Font(TIME_ROMAN, 12, Font.NORMAL);
    private final Font TIMES_ROMAN_12_BOLD = new Font(TIME_ROMAN, 12, Font.BOLD);

    private BaseColor colorFont;
    private BaseColor colorBackground;
    private Font TIMES_ROMAN_22_L;
    private Font TIMES_ROMAN_18_L;
    private Font TIMES_ROMAN_14_L;
    private Font TIMES_ROMAN_12_L;
    private Font TIMES_ROMAN_12_BOLD_L;


    public InputStream generate(User user, MultipartFile img) {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        if (user.getColorStyle().equals(ColorStyle.BLUE_WHITE)) {
            colorFont = BaseColor.WHITE;
            colorBackground = new BaseColor(31, 48, 84);
        }

        if (user.getColorStyle().equals(ColorStyle.GRAY_WHITE)) {
            colorFont = BaseColor.BLACK;
            colorBackground = new BaseColor(179, 179, 179);
        }

        if (user.getColorStyle().equals(ColorStyle.DARK_WHITE)) {
            colorFont = BaseColor.WHITE;
            colorBackground = new BaseColor(23, 23, 23);
        }

        TIMES_ROMAN_22_L = new Font(TIME_ROMAN, 22, Font.BOLD, this.colorFont);
        TIMES_ROMAN_18_L = new Font(TIME_ROMAN, 18, Font.BOLD, this.colorFont);
        TIMES_ROMAN_14_L = new Font(TIME_ROMAN, 14, Font.BOLD, this.colorFont);
        TIMES_ROMAN_12_L = new Font(TIME_ROMAN, 12, Font.NORMAL, this.colorFont);
        TIMES_ROMAN_12_BOLD_L = new Font(TIME_ROMAN, 12, Font.BOLD, this.colorFont);
        Document document = new Document(PageSize.A4, 0, 0, 0, 0);

        document.addTitle("curriculum vitae");
        document.addCreator("CV GENERATOR");
        document.addAuthor("CV GENERATOR");

        try {
            PdfWriter.getInstance(document, out);
            document.open();
            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cell1 = new PdfPCell(new Phrase());
            cell1.setBorder(Rectangle.NO_BORDER);
            if (img != null) {
                Image image = Image.getInstance(img.getBytes());
                image.setAlignment(Element.ALIGN_CENTER);
                image.setWidthPercentage(60);
                cell1.addElement(image);
            }
            Paragraph paragraph = new Paragraph("");
            for (int i = 0; i < 2; i++) {
                paragraph.add(new Paragraph(""));
            }
            cell1.addElement(paragraph);

            paragraph = new Paragraph("Adres:", TIMES_ROMAN_14_L);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            cell1.addElement(paragraph);

            paragraph = new Paragraph(user.getAddress(), TIMES_ROMAN_12_L);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            cell1.addElement(paragraph);

            paragraph = new Paragraph("Telefon:", TIMES_ROMAN_14_L);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            cell1.addElement(paragraph);

            paragraph = new Paragraph(user.getTelephone(), TIMES_ROMAN_12_L);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            cell1.addElement(paragraph);

            paragraph = new Paragraph("E-mail:", TIMES_ROMAN_14_L);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            cell1.addElement(paragraph);

            paragraph = new Paragraph(user.getEmail(), TIMES_ROMAN_12_L);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            cell1.addElement(paragraph);

            if(user.getMedias().size() != 0){
                for(Media m:user.getMedias()) {
                    paragraph = new Paragraph(m.getName()+":", TIMES_ROMAN_14_L);
                    paragraph.setAlignment(Element.ALIGN_LEFT);
                    cell1.addElement(paragraph);
                    Anchor anchor = new Anchor(m.getLink().replace("http://","").replace("https://","").replace("https://www","").replace("http:// www.","").replace("www.",""),TIMES_ROMAN_12_L);
                    anchor.setReference(m.getLink());
                    anchor.setFont(TIMES_ROMAN_14_L);
                    paragraph = new Paragraph("", TIMES_ROMAN_12_L);
                    paragraph.add(anchor);
                    paragraph.setAlignment(Element.ALIGN_LEFT);
                    cell1.addElement(paragraph);
                }
            }

            LineSeparator sep = new LineSeparator();

            if (user.getLanguages().size() != 0) {
                paragraph = new Paragraph("Języki", TIMES_ROMAN_18_L);
                paragraph.setAlignment(Element.ALIGN_LEFT);
                cell1.addElement(paragraph);
                paragraph = new Paragraph("");
                paragraph.add(new Paragraph(" "));

                cell1.addElement(paragraph);


                sep.setPercentage(100);
                sep.setLineColor(colorFont);
                cell1.addElement(sep);

                paragraph = new Paragraph("");
                for (LanguageDto languageDto : user.getLanguages()) {
                    paragraph.add(new Paragraph(languageDto.getName() + " - " + languageDto.getLevel(), TIMES_ROMAN_12_L));
                }
                cell1.addElement(paragraph);
            }

            if(user.getCourses().size() != 0){
                paragraph = new Paragraph("Kursy", TIMES_ROMAN_18_L);
                paragraph.setAlignment(Element.ALIGN_LEFT);
                cell1.addElement(paragraph);

                paragraph = new Paragraph("");
                paragraph.add(new Paragraph(" "));
                cell1.addElement(paragraph);
                sep = new LineSeparator();
                sep.setPercentage(100);
                sep.setLineColor(colorFont);
                cell1.addElement(sep);


                paragraph = new Paragraph("");
                for (Course course:user.getCourses()) {
                    paragraph.add(new Paragraph(course.getName(), TIMES_ROMAN_12_L));
                }
                cell1.addElement(paragraph);
            }

            if (user.getInterests().size() != 0) {
                paragraph = new Paragraph("Zainteresowania", TIMES_ROMAN_18_L);
                paragraph.setAlignment(Element.ALIGN_LEFT);
                cell1.addElement(paragraph);

                paragraph = new Paragraph("");
                paragraph.add(new Paragraph(" "));
                cell1.addElement(paragraph);
                sep = new LineSeparator();
                sep.setPercentage(100);
                sep.setLineColor(colorFont);
                cell1.addElement(sep);


                paragraph = new Paragraph("");
                for (Interest interest : user.getInterests()) {
                    paragraph.add(new Paragraph(interest.getName(), TIMES_ROMAN_12_L));
                }
                cell1.addElement(paragraph);
            }

            cell1.setPadding(20);
            cell1.setColspan(2);
            cell1.setBackgroundColor(colorBackground);
            cell1.setFixedHeight(842);
            table.addCell(cell1);

            cell1.setBorderColor(BaseColor.BLACK);
            Paragraph preface = new Paragraph();
            preface.add(new Paragraph(user.getName() + " " + user.getSurname(), TIMES_ROMAN_22));
            preface.setAlignment(Element.ALIGN_LEFT);

            PdfPCell cell2 = new PdfPCell();
            cell2.setPaddingTop(30);
            cell2.setPaddingLeft(12);
            cell2.setPaddingRight(12);
            cell2.setBorder(Rectangle.NO_BORDER);
            cell2.addElement(preface);

            paragraph = new Paragraph("");

            cell2.addElement(paragraph);


            paragraph = new Paragraph();
            paragraph.add(new Paragraph(user.getAbout(), TIMES_ROMAN_12));
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
            cell2.addElement(paragraph);

            if (user.getEducations().size() != 0) {
                paragraph = new Paragraph("Edukacja", TIMES_ROMAN_22);
                cell2.addElement(paragraph);

                paragraph = new Paragraph("");
                paragraph.add(new Paragraph(" "));
                cell2.addElement(paragraph);
                sep = new LineSeparator();
                sep.setPercentage(100);
                cell2.addElement(sep);

                for (EducationDto education : user.getEducations()) {
                    paragraph = new Paragraph("");
                    paragraph.add(new Paragraph(education.getFrom() + " - " + education.getTo(), TIMES_ROMAN_12));
                    paragraph.setAlignment(Element.ALIGN_RIGHT);
                    cell2.addElement(paragraph);
                    paragraph = new Paragraph("");
                    paragraph.add(new Paragraph(education.getSchoolName(), TIMES_ROMAN_12_BOLD));
                    paragraph.add(new Paragraph("Kierunek:", TIMES_ROMAN_12_BOLD));
                    paragraph.add(new Paragraph(education.getName(), TIMES_ROMAN_12));
                    cell2.addElement(paragraph);
                }
            }

            if (user.getSkills().size() != 0) {
                paragraph = new Paragraph("Umiejętności", TIMES_ROMAN_22);
                cell2.addElement(paragraph);
                paragraph = new Paragraph("");
                cell2.addElement(paragraph);

                paragraph = new Paragraph("");
                paragraph.add(new Paragraph(" "));
                cell2.addElement(paragraph);
                sep = new LineSeparator();
                sep.setPercentage(100);
                cell2.addElement(sep);
                List list = new List();

                for (Skills skills : user.getSkills()) {
                    list.add(new ListItem(skills.getName(), TIMES_ROMAN_12));
                }
                cell2.addElement(list);
            }

            if (user.getCareers().size() != 0) {
                paragraph = new Paragraph("Kariera", TIMES_ROMAN_22);
                cell2.addElement(paragraph);

                paragraph = new Paragraph("");
                paragraph.add(new Paragraph(""));
                cell2.addElement(paragraph);

                sep = new LineSeparator();
                sep.setPercentage(100);
                cell2.addElement(sep);
                for (CareerDto career : user.getCareers()) {
                    paragraph = new Paragraph("");
                    paragraph.add(new Paragraph(career.getFrom() + " - " + career.getTo(), TIMES_ROMAN_12));
                    paragraph.setAlignment(Element.ALIGN_RIGHT);
                    cell2.addElement(paragraph);
                    paragraph = new Paragraph("");
                    paragraph.add(new Paragraph(career.getCompany(), TIMES_ROMAN_12_BOLD));
                    paragraph.add(new Paragraph("Stanowisko:", TIMES_ROMAN_12_BOLD));
                    paragraph.add(new Paragraph(career.getJobTitle(), TIMES_ROMAN_12));
                    paragraph.add(new Paragraph(career.getAbout(), TIMES_ROMAN_12));
                    cell2.addElement(paragraph);
                }
            }
            cell2.setColspan(3);
            cell2.setFixedHeight(842);
            table.addCell(cell2);
            table.completeRow();
            document.add(table);
            document.close();

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }
}

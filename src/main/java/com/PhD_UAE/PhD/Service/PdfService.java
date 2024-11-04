package com.PhD_UAE.PhD.Service;

import com.PhD_UAE.PhD.Dto.*;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.property.UnitValue;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

@Service
public class PdfService {

    public ByteArrayOutputStream generatePdf(List<Object[]> data) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try (PdfWriter writer = new PdfWriter(out)) {
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);
            InputStream imageStream = getClass().getResourceAsStream("/static/images/logosaadi.png");
            if (imageStream != null) {
                ImageData imageData = ImageDataFactory.create(imageStream.readAllBytes());
                Image image = new Image(imageData);
                image.scaleToFit(200, 100);
                document.add(image);
            }

            // Add a title with color and center alignment
            Paragraph title = new Paragraph("PV")
                    .setBold()
                    .setFontSize(20)
                    .setFontColor(new DeviceRgb(0, 128, 255)) // Blue color
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(title);
            document.add(new Paragraph(" ")); // Add some space

            // Loop through the data and add it to the document
            for (Object[] row : data) {
                UserDTO user = (UserDTO) row[0]; // Candidate details
                SujetDTO sujet = (SujetDTO) row[1];
                StructureRechercheDTO structure = (StructureRechercheDTO) row[2];
                EtablissmentDTO etab = (EtablissmentDTO) row[3];
                EntretienDTO entretien = (EntretienDTO) row[4];
                UserDTO professor = (UserDTO) row[5]; // Professor details

                // Add professor information at the top
                document.add(new Paragraph("Professeur: " + professor.getNom() + " " + professor.getPrenom())
                        .setTextAlignment(TextAlignment.LEFT));
                document.add(new Paragraph("Professeur Email: " + professor.getEmail())
                        .setTextAlignment(TextAlignment.LEFT));
                document.add(new Paragraph("Etablissement: " + etab.getNomEtablissement() + ", " + etab.getAdresseEtablissement() + ", " + etab.getVille())
                        .setTextAlignment(TextAlignment.LEFT));
                document.add(new Paragraph("Structure: " + structure.getNom() + " (" + structure.getTypeStructure() + ")")
                        .setTextAlignment(TextAlignment.LEFT));
                document.add(new Paragraph(" ")); // Add some space before the table

                // Create a table for candidate information
                Table table = new Table(2); // Two columns
                table.setWidth(UnitValue.createPercentValue(100)); // Set table width to 100% of the page
                table.setHorizontalAlignment(HorizontalAlignment.CENTER); // Center the table

                table.setTextAlignment(TextAlignment.CENTER); // Center table contents
                table.addHeaderCell(new Cell().add(new Paragraph("Information")
                                .setBold()
                                .setTextAlignment(TextAlignment.CENTER))
                        .setBackgroundColor(ColorConstants.LIGHT_GRAY));
                table.addHeaderCell(new Cell().add(new Paragraph("Details")
                                .setBold()
                                .setTextAlignment(TextAlignment.CENTER))
                        .setBackgroundColor(ColorConstants.LIGHT_GRAY));

// Add candidate information to the table
                table.addCell(new Cell().add(new Paragraph("Candidat")).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().add(new Paragraph(user.getNom() + " " + user.getPrenom())).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().add(new Paragraph("Email")).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().add(new Paragraph(user.getEmail())).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().add(new Paragraph("Sujet Title")).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().add(new Paragraph(sujet.getTitre())).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().add(new Paragraph("Entretien ID")).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().add(new Paragraph(entretien.getIdEntretien().toString())).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().add(new Paragraph("Date")).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().add(new Paragraph(entretien.getDate().toString())).setTextAlignment(TextAlignment.CENTER)); // Format as needed
                table.addCell(new Cell().add(new Paragraph("Resultat")).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().add(new Paragraph(entretien.getResultat().toString())).setTextAlignment(TextAlignment.CENTER));
                document.add(table);
                document.add(new Paragraph(" ")); // Add some space between entries


            }

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return out;
    }
}

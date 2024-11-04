package com.PhD_UAE.PhD.Controller;
import com.PhD_UAE.PhD.Repository.EntretienRepository;
import com.PhD_UAE.PhD.Service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.util.List;

@CrossOrigin
@RequestMapping("phd/Professeur")
@RestController
public class PdfController {

    private final PdfService pdfService;

    public PdfController(PdfService pdfService) {
        this.pdfService = pdfService;
    }
@Autowired
private EntretienRepository entretienRepository;
    @GetMapping("/generate-pdf")
    public ResponseEntity<byte[]> generatePdf(@RequestParam Long professorId, @RequestParam Long identretien) {
        List<Object[]> data = entretienRepository.findDoctorantInfoByProfessorId(professorId, identretien);
        ByteArrayOutputStream pdfStream = pdfService.generatePdf(data);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=doctorant_info.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfStream.toByteArray());
    }

}

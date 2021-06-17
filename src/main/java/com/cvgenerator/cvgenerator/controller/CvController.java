package com.cvgenerator.cvgenerator.controller;

import com.cvgenerator.cvgenerator.dto.request.UserDataDto;
import com.cvgenerator.cvgenerator.model.User;
import com.cvgenerator.cvgenerator.service.PdfGenerate;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@RestController
@CrossOrigin
@RequestMapping(value = "/cv")
@Log
public class CvController {


    private final PdfGenerate pdfGenerate;
    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    public CvController(PdfGenerate pdfGenerate) {
        this.pdfGenerate = pdfGenerate;
    }

    @GetMapping
    public ResponseEntity<?> createPDF(HttpServletResponse response, @RequestPart ("user") UserDataDto userDataDto, @RequestPart ("file") MultipartFile file) throws IOException {
        log.info("GENERATE PDF");
        User user = mapper.map(userDataDto,User.class); // map to model user

        String name =  user.getName()+"_"+user.getSurname()+"_CV.pdf";  // name of pdf file
        response.setContentType("application/pdf"); // set type contet type
        response.setHeader("Content-Disposition", "attachment; filename=" + name);
        response.setHeader("filename",name); // set filename
        InputStream inputStream = pdfGenerate.generate(user,file);  // generare pdf
        ByteArrayResource resource = new ByteArrayResource(inputStream.readAllBytes()); // get bytes on pdf.
        return new ResponseEntity<>(resource, HttpStatus.OK);   // response.
    }

}

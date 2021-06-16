package com.cvgenerator.cvgenerator.controller;

import com.cvgenerator.cvgenerator.dto.request.UserDataDto;
import com.cvgenerator.cvgenerator.model.User;
import com.cvgenerator.cvgenerator.service.PdfGenerate;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @GetMapping
    public ResponseEntity<Void> createPDF(@RequestBody UserDataDto userDataDto) {
        log.info("GENERATE PDF");
        User user = mapper.map(userDataDto,User.class);
        pdfGenerate.generate(user,user.getColorStyle());
        return new ResponseEntity(HttpStatus.OK);
    }

}

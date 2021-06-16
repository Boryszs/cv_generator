package com.cvgenerator.cvgenerator.controller;

import com.cvgenerator.cvgenerator.dto.response.StyleDto;
import com.cvgenerator.cvgenerator.model.enums.ColorStyle;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping(value = "/style")
@Log
public class StyleController {

    @GetMapping
    public ResponseEntity<List<StyleDto>> getAllBook() {
        log.info("GET ALL STYLE");
        List<StyleDto> colors = Arrays.stream(ColorStyle.values()).map(i -> new StyleDto(i.name(),i.getUrl())).collect(Collectors.toList());
        return new ResponseEntity(colors, HttpStatus.OK);
    }
}

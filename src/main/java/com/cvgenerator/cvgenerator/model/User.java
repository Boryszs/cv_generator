package com.cvgenerator.cvgenerator.model;

import com.cvgenerator.cvgenerator.dto.request.CareerDto;
import com.cvgenerator.cvgenerator.dto.request.EducationDto;
import com.cvgenerator.cvgenerator.dto.request.LanguageDto;
import com.cvgenerator.cvgenerator.model.enums.ColorStyle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String name;
    private String surname;
    private String about;
    private List<EducationDto> educations;
    private List<String> skills;
    private List<CareerDto> careers;
    private String address;
    private String telephone;
    private String email;
    private List<LanguageDto> languages;
    private List<String> interests;
    private ColorStyle colorStyle;
}

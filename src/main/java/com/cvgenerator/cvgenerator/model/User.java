package com.cvgenerator.cvgenerator.model;

import com.cvgenerator.cvgenerator.dto.request.*;
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
    private List<Skills> skills;
    private List<CareerDto> careers;
    private String address;
    private String telephone;
    private String email;
    private List<LanguageDto> languages;
    private List<Interest> interests;
    private List<Course> courses;
    private List<Media> medias;
    private ColorStyle colorStyle;
}

package com.cvgenerator.cvgenerator.dto.request;

import com.cvgenerator.cvgenerator.model.enums.ColorStyle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDataDto implements Serializable {
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

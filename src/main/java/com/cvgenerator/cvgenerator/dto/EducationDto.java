package com.cvgenerator.cvgenerator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EducationDto {
    private String from;
    private String to;
    private String name;
    private String schoolName;
}

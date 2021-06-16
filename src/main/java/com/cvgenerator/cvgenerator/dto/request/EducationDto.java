package com.cvgenerator.cvgenerator.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EducationDto implements Serializable {
    private String from;
    private String to;
    private String name;
    private String schoolName;
}

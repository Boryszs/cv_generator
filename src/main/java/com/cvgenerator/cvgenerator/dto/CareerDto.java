package com.cvgenerator.cvgenerator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CareerDto {
    private String from;
    private String to;
    private String jobTitle;
    private String about;
}

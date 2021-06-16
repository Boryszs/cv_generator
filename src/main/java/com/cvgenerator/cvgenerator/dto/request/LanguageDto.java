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
public class LanguageDto implements Serializable {
    private String name;
    private String level;
}

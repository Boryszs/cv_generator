package com.cvgenerator.cvgenerator.service;

import com.cvgenerator.cvgenerator.model.User;
import com.cvgenerator.cvgenerator.model.enums.ColorStyle;

public interface PdfGenerate {
    public void generate(User user, ColorStyle color);
}

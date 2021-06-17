package com.cvgenerator.cvgenerator.service;

import com.cvgenerator.cvgenerator.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface PdfGenerate {
    InputStream generate(User user, MultipartFile image);
}

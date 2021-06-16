package com.cvgenerator.cvgenerator.model.enums;

public enum ColorStyle {
    GRAY_WHITE(new String("url")),
    BLUE_WHITE(new String("url")),
    DARK_WHITE(new String("url"));

    private String url;

    public String getUrl() {
        return url;
    }

    ColorStyle(String url) {
        this.url = url;
    }
}

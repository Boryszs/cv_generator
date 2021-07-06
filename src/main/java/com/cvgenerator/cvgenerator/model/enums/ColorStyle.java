package com.cvgenerator.cvgenerator.model.enums;

public enum ColorStyle {
    GRAY_WHITE(new String("https://user-images.githubusercontent.com/62262900/123865716-8f3f2280-d92c-11eb-834c-b74c19f07c21.jpg")),
    BLUE_WHITE(new String("https://user-images.githubusercontent.com/62262900/123865917-c31a4800-d92c-11eb-8032-674e952afec8.jpg")),
    DARK_WHITE(new String("https://user-images.githubusercontent.com/62262900/123865713-8ea68c00-d92c-11eb-9e99-cefbc11bef79.jpg"));

    private String url;

    public String getUrl() {
        return url;
    }

    ColorStyle(String url) {
        this.url = url;
    }
}

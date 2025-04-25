package com.cms.platform.backend.utils;

public class SEOHelper {

    public static String generateSeoTitle(String title) {
        return title.length() > 60 ? title.substring(0, 60) : title;
    }

    public static String generateSeoDescription(String description) {
        return description.length() > 160 ? description.substring(0, 160) : description;
    }
}

package com.example.nttungg.bookstore.utils;

public class StringUtils {
    private StringUtils() {
    }

    public static boolean isNullOrBlank(String s) {
        return s == null || s.isEmpty();
    }

    public static String removeAllWhiteSpace(String s) {
        if (s == null) return null;
        return s.replaceAll("\\s+","");
    }
}
